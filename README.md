## **This project demonstrates:**

1. ELK stack (filebeat -> logstash -> elasticsearch -> kibana)
   
   to open kibana:
   
   `localhost:5601`
   
2. prometheus + grafana

   to open grafana:
   
   `localhost:3000`

as an application simple CRUD application to save files metadata

 dashboard used for grafana:
 `https://grafana.com/grafana/dashboards/4701`

to run multiple replicas:

`docker-compose up --scale metadata=3 -d --build`

to build simple service without other dependencies

`docker-compose up -d --no-deps --build metadata`