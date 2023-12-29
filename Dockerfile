FROM jupyter/scipy-notebook

RUN pip install joblib
RUN pip install xgboost

USER root
RUN apt-get update && apt-get install -y jq

RUN mkdir model raw_data processed_data results


ENV RAW_DATA_DIR=/home/jovyan/raw_data
ENV PROCESSED_DATA_DIR=/home/jovyan/processed_data
ENV MODEL_DIR=/home/jovyan/model
ENV RESULTS_DIR=/home/jovyan/results
ENV RAW_DATA_FILE=TARP.csv


COPY ./Data/Raw_Data/TARP.csv ./raw_data/TARP.csv
COPY ./code/mlops/preprocessing.py ./preprocessing.py
COPY ./code/mlops/train.py ./train.py
COPY ./code/mlops/test.py ./test.py

FROM jupyter/scipy-notebook

RUN pip install joblib
RUN pip install xgboost

USER root
RUN apt-get update && apt-get install -y jq

RUN mkdir model raw_data processed_data results


ENV RAW_DATA_DIR=/home/jovyan/raw_data
ENV PROCESSED_DATA_DIR=/home/jovyan/processed_data
ENV MODEL_DIR=/home/jovyan/model
ENV RESULTS_DIR=/home/jovyan/results
ENV RAW_DATA_FILE=adult.csv


COPY ./Data/Raw_Data/TARP.csv ./raw_data/TARP.csv
COPY ./code/mlops/preprocessing.py ./preprocessing.py
COPY ./code/mlops/train.py ./train.py
COPY ./code/mlops/test.py ./test.py

COPY /home/jovyan/processed_data/train.csv ./Data/train.csv
COPY /home/jovyan/processed_data/test.csv ./Data/test.csv
COPY /home/jovyan/model/Xgboost_model.joblib  ./code/mlops/model.joblib
COPY /home/jovyan/results/train_metadata.json ./code/mlops/train_metadata.json
COPY /home/jovyan/results/test_metadata.json ./code/mlops/test_metadata.json
                           