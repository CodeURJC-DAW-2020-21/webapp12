#!/bin/bash
docker=$( cd "$(dirname "${BASH_SOURCE[0]}")"; pwd -P )
backend="$docker/../Backend"
frontend="$docker/../Frontend"
cd "$forntend"
npm install
ng ng build --prod --base-href="/new/"
cd "$backend"
sudo docker login -u dawpractica21 -p horo.com21
sudo docker build -t dawpractica21/springboot:spring -f ../Docker/Dockerfile .
sudo docker push dawpractica21/springboot:spring
cd "$docker"
sudo docker-compose up --build