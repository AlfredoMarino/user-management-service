# user-management-service
Sprint-boot demo project using spring-data-mongodb and spring-security.
This is a simple REST API to perform CRUD operations on the Users and People entities.

![spring-boot-icon](resources/docs/spring-boot.png)
![mongodb-icon](resources/docs/mongodb.png)
![docker-icon](resources/docs/docker.png)

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
+ Git
+ Java
+ Docker
+ Maven

## Install

- Clone this repo
```sh 
git clone https://github.com/AlfredoMarino/my-booksql.git
```
- Install Java dependencies
```sh
cd my-booksql
mvn clean install
```

### Run with Docker

1. Build it

        docker build -t aamv/user-management-service:latest .
2. Create a docker network

        docker network create --driver bridge aamv-network
3. Mongodb container up

        docker run --name user-management-mongodb --network aamv-network -p 27017:27017 -v mongodata:/data/db -d mongo:latest
4. UMS container up

        docker run --name user-management-service --network aamv-network -p 5050:8080 -e MONGO_HOST=user-management-mongodb -e MONGO_PORT=27017 -e MONGO_DATABASE=aamvdb -d aamv/user-management-service:latest

## Usage

Register a new user

```bash
curl --location --request POST 'http://localhost:5050/v1/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "AAMV",
    "password": "aamvpass",
    "roles": ["ADMIN"]
}'
```

Log in with the new user

```bash
curl --location --request POST 'http://localhost:5050/v1/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{
  "username": "AAMV",
  "password": "aamvpass"
}'
```

take the received token (access_token) to use in the following requests

```bash
curl --location --request POST 'http://localhost:5050/v1/persons' \
--header 'Authorization: Bearer [access_token]' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Scarlett",
  "lastName": "Johansson",
  "birthdate": "1984-11-22",
  "aboutMe": "actress",
  "photo": ":3"
}'
```

## Contributing
Pull requests are welcome.

## License
[MIT](https://choosealicense.com/licenses/mit/)