# employees rest api using quarkus

This project demonstrates how to create a simple REST api using:
- GraalVM (Java 8)
- RESTEasy
- json-b serialization
- Bean Validation (JSR 303) 
- JPA (Hibernate)
- [TODO] Basic authentication
- docker + docker-compose
- native image

## Setup

### GraalVM

Download https://www.graalvm.org/downloads/ and extract the package

Set the following environment variables

    export GRAALVM_HOME=<DIR_TO_GRAALVM>/graalvm-ce-1.0.0-rc15
    export JAVA_HOME=$GRAALVM_HOME
    export PATH=$JAVA_HOME/bin:$PATH

## Running

Start with hot deployment active (edit + save + reload):

    mvn compile quarkus:dev

Generate jar package:

    $ mvn clean package
    $ java -jar employee-api-1.0-SNAPSHOT-runner.jar
    ...
    INFO: Quarkus 0.13.1 started in 1.655s. Listening on: http://[::]:8080
    INFO: Installed features: [agroal, cdi, hibernate-orm, hibernate-validator, jdbc-mariadb, narayana-jta, resteasy, resteasy-jsonb]

Generate native image (it might take a few minutes):

    mvn package -Pnative

Check `target` directory:

    $ ls -lh target
    -rwxr-xr-x 1 bruno bruno  51M Apr 15 21:51 employee-api-1.0-SNAPSHOT-runner

Running native image:

    $ ./target/employee-api-1.0-SNAPSHOT-runner
    INFO  [io.quarkus] (main) Quarkus 0.13.2 started in 0.028s. Listening on: http://[::]:8080
    INFO  [io.quarkus] (main) Installed features: [agroal, cdi, hibernate-orm, hibernate-validator, jdbc-mariadb, narayana-jta, resteasy, resteasy-jsonb]

Impressive starting time: **0.028s**

## docker-compose

    $ mvn clean package -Pnative -Dnative-image.docker-build=true
    $ docker-compose up --build

## REST operations using curl

#### creating an employee

Request:

    curl -v -H "Content-Type: application/json" \
    -d '{ "firstName": "Bruno", "lastName": "Lellis", "dateOfBirth": "1985-06-24", "dateOfEmployment": "2015-09-01" }' \
    -X POST http://localhost:8080/api/v1/employees

Response:
- should return HTTP status code = 201
- should return the new employee with its id on response body

#### retrieving all employees

    curl -v http://localhost:8080/api/v1/employees

#### retrieving one employee

    curl -v http://localhost:8080/api/v1/employees/1

#### updating employee

    curl -v -H "Content-Type: application/json" \
    -d '{ "firstName": "Bruno", "middleInitial": "H", "lastName": "Lellis", "dateOfBirth": "1985-06-24", "dateOfEmployment": "2015-09-01" }' \
    -X PUT http://localhost:8080/api/v1/employees/1

#### ~~deleting~~ disabling employee

    curl -v -u matera:matera -X DELETE http://localhost:8080/api/v1/employees/1


## Troubleshooting

### Error: Basic header file missing 

For Debian based systems, run: `sudo apt-get install libz-dev`

For Fedora/RHEL systems, use instead: `sudo dnf install zlib-devel`


### Native: constructors are not called?
public EmployeeRepository() {
    ...
}


