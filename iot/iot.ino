#include <ESP8266WiFi.h>
#include <PubSubClient.h>
#include <DHT.h>
#define soil_moisture_pin A0
#define Led_pin  D3
//
// ici le WIFI 
const char* ssid = "Oussema";
const char* password = "oussema99";




const char* mqttServer = "smartirrigation.me";
const int mqttPort = 1883;
const char* mqttUser = "oussema";
const char* mqttPassword =  "Supcom_23";
String myString;
DHT dht(D1,DHT22);



WiFiClient espClient;
PubSubClient client(espClient);
 
void setup() {
 
  int state = 0;
  dht.begin();
  delay(2000);
  Serial.begin(115200);
  pinMode (soil_moisture_pin, INPUT); 
  pinMode(Led_pin, OUTPUT);
 
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.println("Connecting to WiFi..");
  }
  Serial.println("Connected to the WiFi network");
  
 
  client.setServer(mqttServer, mqttPort);
  client.setCallback(callback);
 
  while (!client.connected()) {
    Serial.println("Connecting to MQTT...");
 
    if (client.connect("ESP8266Client", mqttUser, mqttPassword )) {
 
      Serial.println("connected");  
 
    } else {
 
      Serial.print("failed with state ");
      Serial.print(client.state());
      delay(2000);
 
    }
  }
 
  client.publish("esp/test", "Hello from ESP8266");
  client.subscribe("esp/test");
 
}
 
void callback(char* topic, byte* payload, unsigned int length) {
 
  Serial.print("Message arrived in topic: ");
  Serial.println(topic);
 
  Serial.print("Message:");
  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
    if (i == 0) {
      state = (int)(payload[i]);
    }
  }
 
  Serial.println();
  Serial.println("-----------------------");
 
}
 
void loop() {
  myString="{'id':'test' ,'temprature' :  ";
  float temp=dht.readTemperature();
   myString =  myString + String(temp) + ",'humidity' :" ;
  float humidity=dht.readHumidity();
  myString =  myString + String(humidity) + ",'moisture' :" ;
  float moisture=analogRead(soil_moisture_pin);
  moisture=(moisture/10)-10.0;
  myString =  myString + String(moisture) + "}" ;
  
  Serial.print("Moisture : ");
  Serial.print(moisture);
  Serial.print("V   ");
  Serial.print("Temp : ");
  Serial.print(temp);
  Serial.print("°C   ");
  Serial.print("Humidity : ");
  Serial.print(humidity);
  Serial.print("% \n");
  Serial.print(myString);
  Serial.print("% \n");
  const char* charArray = myString.c_str();
  client.publish("Smartirrigation", charArray);
  client.subscribe("pump");
  Serial.print(state);
  digitalWrite(Led_pin, state);
  
  

  delay(30000);
  client.loop();
}
