# employees rest api using quarkus

This project demonstrates how to create a simple REST api using:
- GraalVM (Java 8)
- RESTeasy
- json-b serialization
- Bean Validation (JSR 303) 
- [TODO] JPA (Hibernate)
- [TODO] Basic authentication
- [TODO] docker + docker-compose
- [TODO] native library

## Setup

### GraalVM

Download https://www.graalvm.org/downloads/ and extract the package

Set the following environment variables

    export GRAALVM_HOME=<DIR_TO_GRAALVM>/graalvm-ce-1.0.0-rc15
    export JAVA_HOME=$GRAALVM_HOME
    export PATH=$JAVA_HOME/bin:$PATH


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


