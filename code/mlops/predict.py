import asyncio
import pandas as pd
import numpy as np
from joblib import load
import json
import os
import websockets
import paho.mqtt.client as mqtt

MODEL_DIR = os.environ["MODEL_DIR"]

# Set path for the input (model)
model_file = 'Xgboost_model.joblib'
model_path = os.path.join(MODEL_DIR, model_file)
Xgboost_model = load(model_path)

scaler_file = 'scaler.joblib'
scaler_path = os.path.join(MODEL_DIR, scaler_file)
scaler = load(scaler_path)

# Define MQTT broker details
mqtt_broker_address = "smartirrigation.me"
mqtt_port = 1883
mqtt_topic = "pump"
mqtt_username = "oussema"
mqtt_password = "Supcom_23"

def preprocess_input(input_data):
    my_list = input_data.split(',')
    input_data = [float(value) for value in my_list]
    df = pd.DataFrame(input_data).transpose()
    input_data_scaled = scaler.transform(df)
    return input_data_scaled

async def predict(websocket, path):
    try:
        # Receive data from the WebSocket
        input_data_str = await websocket.recv()
        print(f"Received input data: {input_data_str}")

        # Preprocess the input and make predictions
        X = preprocess_input(input_data_str)
        model_predictions = Xgboost_model.predict(X)
        pump_status = model_predictions[0]

        

        # MQTT Publishing
        client = mqtt.Client(client_id="docimage")
        
        client.username_pw_set(mqtt_username, mqtt_password)
        client.connect(mqtt_broker_address, mqtt_port, 60)
        s=str(pump_status)
        client.publish(mqtt_topic, s)
        ch=str(pump_status)
        # Send the predictions back to the client
        await websocket.send(ch)

    except Exception as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    port = 8765  # Specify the port you want to listen on
    print(f"Listening on port {port}")
    asyncio.get_event_loop().run_until_complete(websockets.serve(predict, "0.0.0.0", port))
    asyncio.get_event_loop().run_forever()
