# REST API PROJECT FOR ECOMMERCE INCLUDING SPRING SECURITY

## tech stack:

- java 17+
- spring boot
- spring security
- postgresql
- jwt authentication
- maven

## installation and setup

### clone the repo

```sh
git clone https://github.com/dariganarmanova/spring-boot-ecommerce-rest-api.git
```

### configure the database

#### go to src/main/resources/application.properties

```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### build and run the application

```
mvn clean install
mvn spring-boot:run
```

### the api endpoints

| Method | Endpoint              | Description                                                                                                              |
| ------ | --------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| `GET`  | `/getProducts`        | Get all products                                                                                                         |
| `POST` | `/products`           | Can only be accessed by admin and the products can be created by admin                                                   |
| `POST` | `/api/register`       | Create the user, register with token and role based                                                                      |
| `POST` | `/api/authentication` | Authenticate with JWT token                                                                                              |
| `POST` | `/cart/{id}`          | Put the product into the user's cart with the product id provided, in the body the quantity has to be sent by the client |
| `POST` | `/createOrder/{id}`   | Create the order with the cart's id provided, in the body the client has to pass the quantity                            |
