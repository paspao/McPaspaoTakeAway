McPaspao Take Away
==================
[![Build Status](https://travis-ci.org/paspao/McPaspaoTakeAway.svg?branch=master)](https://travis-ci.org/paspao/McPaspaoTakeAway)

*Enable Docker 19.x experimental features*

Build
-----

```bash
docker buildx build --target=order-service -t paspaola/order-service:0.0.1 --load . &&\
docker buildx build --target=kitchen-service -t paspaola/kitchen-service:0.0.1 --load . &&\
docker buildx build --target=delivery-service -t paspaola/delivery-service:0.0.1 --load . &&\
docker buildx build --target=kong-mcpaspao -t paspaola/kong-mcpaspao:0.0.1 --load . 
```

Run
---

    docker app render -s advertised.addr="your docker host ip" mcpaspao.dockerapp| docker-compose -f - up
    
Stop
----

    docker app render mcpaspao.dockerapp| docker-compose -f - down

Example
-------


* Order Services http://localhost:8090/swagger-ui.html
* Kitchen Services http://localhost:8080/swagger-ui.html
* Delivery Services http://localhost:8070/swagger-ui.html


```bash
curl -X POST "http://localhost:8000/kitchen-service/kitchen/add?hamburgerType=KOBE&quantity=2" -H "accept: application/json"|jq -C && \
 \
curl -X GET "http://localhost:8000/kitchen-service/kitchen/status" -H "accept: application/json"|jq -C && \
 \
printf "\n--START--\n" && \
curl -X POST "http://localhost:8000/order-service/order/create" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"addressDTO\": { \"number\": \"string\", \"street\": \"string\" }, \"cookingType\": \"BLOOD\", \"hamburgerList\": [ { \"hamburgerType\": \"KOBE\", \"quantity\": 2 } ], \"price\": 10}" |jq -C && \
printf "\n---------\n" && \
 \
curl -X GET "http://localhost:8000/order-service/order/view" -H "accept: application/json"|jq -C  && sleep 5 && \
printf "\n---------\n" && \
curl -X GET "http://localhost:8000/order-service/order/view" -H "accept: application/json"|jq -C && sleep 5 && \
printf "\n---------\n" && \
curl -X GET "http://localhost:8000/order-service/order/view" -H "accept: application/json"|jq -C && sleep 5 && \
printf "\n---------\n" && \
curl -X GET "http://localhost:8000/order-service/order/view" -H "accept: application/json"|jq -C && \
printf "\n---------\n" && \
 \
curl -X GET "http://localhost:8000/delivery-service/delivery/status" -H "accept: application/json"|jq -C && \
printf "\n--END--\n"
```
