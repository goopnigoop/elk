start-elk:
	docker-compose -f docker-compose-elk.yml up -d --build

start:
	mvn clean install
	docker-compose -f docker-compose.yml up -d --build

startnm:
	docker-compose -f docker-compose.yml up -d --build

clean:
	mvn clean
	docker system prune --volumes --force

stop:
	docker-compose down

build:
	mvn clean package

sonar:
	mvn verify sonar:sonar

restart: stop clean start
