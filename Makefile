start:
	mvn clean install
	docker-compose up -d --build

clean:
	mvn clean

stop:
	docker-compose down
	docker system prune --volumes --force

restart: stop clean start

