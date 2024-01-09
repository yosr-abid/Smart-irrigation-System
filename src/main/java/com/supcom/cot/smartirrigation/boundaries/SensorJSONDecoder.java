package com.supcom.cot.smartirrigation.boundaries;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import java.io.StringReader;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import com.supcom.cot.smartirrigation.entities.Sensor;

public class SensorJSONDecoder implements Decoder.Text<Sensor>{

    @Override
    public Sensor decode(String jsonMessage) throws DecodeException {

        JsonObject jsonObject = Json
                .createReader(new StringReader(jsonMessage)).readObject();
        String id=jsonObject.getString("id");
        Double moistureValue=jsonObject.isNull("moistureValue") ? null : jsonObject.getJsonNumber("moistureValue").doubleValue();
        Double humidityValue=jsonObject.isNull("humidityValue") ? null : jsonObject.getJsonNumber("humidityValue").doubleValue();
        Double tempValue=jsonObject.isNull("tempValue") ? null : jsonObject.getJsonNumber("tempValue").doubleValue();
        Double longitude=jsonObject.isNull("longitude") ? null : jsonObject.getJsonNumber("longitude").doubleValue();
        Double latitude=jsonObject.isNull("latitude") ? null : jsonObject.getJsonNumber("latitude").doubleValue();

        Sensor sensor = new Sensor(id, moistureValue, tempValue, humidityValue, longitude, latitude);
        return sensor;

    }

    @Override
    public boolean willDecode(String jsonMessage) {
        try {
            // Check if incoming message is valid JSON
            Json.createReader(new StringReader(jsonMessage)).readObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
