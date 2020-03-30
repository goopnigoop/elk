# **This project demonstrates:**
## As an application simple CRUD application to save files metadata

Already added:
- [x] zuul (gateway)
- [x] elk stack (logs)
- [x] prometheus (metrics)
- [x] grafana (UI for metrics)
- [x] hystrix (circuit breaker)
- [x] ribbon (load balancing)
- [x] eureka (service keeper)
- [x] flyway (db versioning)
- [x] jwt auth (stateless impl, no session)
- [x] sleuth (log messages get tracing ids, through microservice and microservices)
- [x] zipkin (stashing log messages + UI to see tracing)

1. ELK stack (filebeat -> logstash -> elasticsearch -> kibana)
   
   to open kibana:
   `localhost:5601`
   
   do not forget to index search fields
   
2. prometheus + grafana

   to open grafana:
   `localhost:3000`

    dashboard used for grafana:
     `https://grafana.com/grafana/dashboards/4701`
     
3. Added auth entrypoint and user admin:admin

    to get jwt token: `localhost:8755/auth`
 
     post: 
     
     `{
      	"username":"admin",
      	"password":"admin"
      }
      `
4. Added flyway for auth service, users are saved to PostgreSQL
    
    to run multiple replicas:
    `docker-compose up --scale metadata=3 -d --build`
    
    to build simple service without other dependencies
    `docker-compose up -d --no-deps --build metadata`

5. added zipkin to trace logs

   to open `zipkin`:
   `http://localhost:9411/zipkin`
   
6. added config cloud server to store configs for services

   to open `config cloud`:
   `http://localhost:8888`




