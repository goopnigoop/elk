start:
	mvn clean install
	docker-compose up -d --build

clean:
	mvn clean

stop:
	docker-compose down
	docker system prune --volumes --force

build:
	mvn clean package

sonar:
	mvn verify sonar:sonar

restart: stop clean start
