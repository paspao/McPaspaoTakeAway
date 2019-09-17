McPaspao Take Away
==================

*Enable Docker 19.x experimental features*

Build
-----

```bash
docker buildx build --target=order-service -t paspaola/order-service:0.0.1 . &&\
docker buildx build --target=kitchen-service -t paspaola/kitchen-service:0.0.1 . &&\
docker buildx build --target=delivery-service -t paspaola/delivery-service:0.0.1 .
```

Run
---

    docker-compose up
    
Stop
----

    docker-compose down

Example
-------

    curl -X POST "http://localhost:8080/kitchen/add?hamburgerType=KOBE&quantity=6" -H "accept: application/json"
    curl -X POST "http://localhost:8090/order/create" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"addressDTO\": { \"number\": \"string\", \"street\": \"string\" }, \"cookingType\": \"BLOOD\", \"hamburgerList\": [ { \"hamburgerType\": \"KOBE\", \"quantity\": 2 } ], \"price\": 10}"

