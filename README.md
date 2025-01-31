## Rest API project for ecommerce with spring security (jwt authentication) 

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
| `GET`  | `/getProducts`        | Get all products (can be accessed by admin only)                                                                                                         |
| `POST` | `/products`           | Can only be accessed by admin and the products can be created by admin.                                                   |
| `POST` | `/api/register`       | Create the user, register with token and role based.                                                                      |
| `POST` | `/api/authentication` | Authenticate with JWT token.                                                                                              |
| `POST` | `/cart/{id}`          | Put the product into the user's cart with the product id provided, in the body the quantity has to be sent by the client. |
| `POST` | `/createOrder/{id}`   | Create the order with the cart's id provided, in the body the client has to pass the quantity.                           |

### test with postman
<img width="1470" alt="Screenshot 2025-01-31 at 1 20 15 PM" src="https://github.com/user-attachments/assets/40d1f016-6f04-44eb-a74d-e24053f6a32c" />

<img width="1470" alt="Screenshot 2025-01-31 at 1 19 50 PM" src="https://github.com/user-attachments/assets/ac769540-99f9-4743-8016-471556fbf692" />

<img width="1470" alt="Screenshot 2025-01-31 at 1 21 42 PM" src="https://github.com/user-attachments/assets/c23765cf-ba88-4134-afa8-688b73657882" />

<img width="1470" alt="Screenshot 2025-01-31 at 1 22 06 PM" src="https://github.com/user-attachments/assets/de347ad5-7ce2-4455-bade-0149684f3a5f" />

<img width="1470" alt="Screenshot 2025-01-31 at 1 23 29 PM" src="https://github.com/user-attachments/assets/19e330e2-c54a-4c6b-9673-92ffbbdd98fe" />

<img width="1470" alt="Screenshot 2025-01-31 at 1 24 56 PM" src="https://github.com/user-attachments/assets/48c4f63a-538b-4579-b595-cde0ceafb453" />

