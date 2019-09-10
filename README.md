McPaspao Take Away
==================

Build
-----

```bash
docker build --target=order-service -t paspaola/order-service:0.0.1 . &&\
docker build --target=kitchen-service -t paspaola/kitchen-service:0.0.1 . &&\
docker build --target=delivery-service -t paspaola/delivery-service:0.0.1 .
```