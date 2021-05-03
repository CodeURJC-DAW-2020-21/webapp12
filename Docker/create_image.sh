#!/bin/bash
docker=$( cd "$(dirname "${BASH_SOURCE[0]}")"; pwd -P )
cd "$docker/../Frontend"
pwd -P
sudo npm install
sudo ng build --prod --base-href="/new/"
cd "$docker/../Backend"
pwd -P
sudo docker login -u dawpractica21 -p horo.com21
sudo docker build -t dawpractica21/springboot:springboot -f ../Docker/Dockerfile .
sudo docker push dawpractica21/springboot:springboot
cd "$docker"
pwd -P
sudo docker-compose up --build