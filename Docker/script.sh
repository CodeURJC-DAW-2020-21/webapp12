#!/bin/bash
parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")"; pwd -P )
pathcode="$parent_path/../Backend"
cd "$pathcode"
pwd -P
sudo docker login -u dawpractica21 -p horo.com21
sudo docker build -t dawpractica21/springboot:spring -f ../Docker/Dockerfile .
sudo docker push dawpractica21/springboot:spring
cd "$parent_path"
sudo docker-compose up --build