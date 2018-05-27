#!/bin/bash

HOST='localhost'

cd config
mvn spring-boot:run &
cd ../

sleep 30s

export HOST='localhost'

cd registry
mvn spring-boot:run &
cd ../

cd gateway
mvn spring-boot:run &
cd ../

cd post-service
mvn spring-boot:run &
cd ../

cd account-service
mvn spring-boot:run &
cd ../

cd auth-service
mvn spring-boot:run &
cd ../