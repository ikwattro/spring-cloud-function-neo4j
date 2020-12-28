# Spring Cloud Functions - Neo4j

Sample repository showing the usage of Neo4j together with Spring Cloud Functions.

Usage : 

```
curl localhost:8080 \
 -H "Content-Type: application/json" \
 -d '{"firstName":"john", "lastName": "joe"}' -i
```

Will automatically invoke the `hire()` function in the `Functions` class.

Adapt the application.properties for your Neo4j settings.