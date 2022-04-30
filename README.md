# travellerStorage
Main storage microservice for traveller

# Getting Started

### Reference Documentation

To compile the project you have to install 
* sudo apt-get install openjdk-17-jdk

To successfully start the application you need to run following commands:
* docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management
* docker run -d --name mongo    -p 27017:27017              mongo:5.0.8
* mvn clean install && mvn spring-boot:run

The application will start on port 8080.

At the moment, there are following endpoints are available:
* GET http://localhost:8080/v1/city - get list of all cities
* GET http://localhost:8080/v1/city/{countryCode} - get list of all cities by country code (try KZ for example)
* DELETE http://localhost:8080/v1/city?id={id} - remove city by id
* 
* GET http://localhost:8080/v1/country - get list of all countries
* DELETE http://localhost:8080/v1/country?id={id} - remove country by id

In order to add new cities and countries to the database, you have to run travellerStaticContentImporter application.
It will parse the data from the static files and transfer it via RabbitMQ.

### Guides

New docker image creation:
* mvn clean install
* DOCKER_BUILDKIT=1 docker build . -t traveller_storage:0.0.1
* docker images
* docker tag traveller_storage:0.0.1 sorokinandrey/traveller_storage:0.0.1
* docker login
* docker push sorokinandrey/traveller_storage:0.0.1

Run application:
* docker-compose up --build