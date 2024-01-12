# Smart Irrigation System
This project was realized as part of the Cloud of Things module at the Higher School of Communication of Tunis, dedicated to create an intelligent watering system.

Created by:
- [Oussema Louhichi]
- [Yosr Abid]

# Description

This project consists on developping and deploying a PWA application to monitor plants irrigation trought IoT inetgration. The application allows real-time vizualisation of the humidity level, the Soil moisture and the temperature in order to keep the plants alive as much as possible with less water waste. 
The irrigation system to be built automatically controls the irrigation cycles by predicting the pump status depending on the plants need thanks to a Machine Learning model.

# Technologies

- Wildfly 30.0.0 final
- JDK 21.0.1
- Mosquitto broker
- MongoDB 
- Node-red

# IoT components:

- ESP8266
- DHT22 sensor
- Moisture sensor
- LED


# Installation guide
- Clone the repository.
- Build and Run Dockerfile using the commands:
  `docker build -t cot:latest .`
  `docker run -p 8765:8765 -d cot`
- Upload iot.ino to ESP8266 board.
- Build the code into a single.war file with Intellij using the command `maven clean install`
- Place signle.war file in wildfly/standalone/deployments folder.
- Run wildfly using `standalone.bat` in the bin folder.
- Test the dashboard in localhost:8080 

# Deployment Machine
The Application is also hosted on a virtual machine accessible at https://smartirrigation.me
With our school mail, we can get a 100$ voucher inside of Microsoft Azure. With this voucher, we can create a virtual machine capable of hosting the middleware, the mosquitto broker and the database. The virtual machine have the following characteristics:
- Ram: 4GB
- vCPUS: 2
- Ressource disk size: 8GB

# Cerfitication and grading
We have enabled HTTPS with letsencrypt TLS certificate with HSTS enabled as well, ensuring only secure connections are allowed to the middleware.
Enabling TLS1.3 only on wildfly helps to generate A grading on SSLabs.
