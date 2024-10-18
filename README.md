# Fishing Store Backend

Welcome to the **Fishing Store Backend**! This project is a RESTful API designed for an online fishing store, allowing users to manage their accounts, browse products, and place orders. Built with **Java Spring Boot** and connected to a **MySQL** database, this API is robust, secure, and easy to integrate with any frontend application.

![Fishing Store Logo](https://github.com/user-attachments/assets/a85224aa-2fca-4eac-b317-05e27338472d)



## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- User registration and authentication
- Password reset functionality
- Product management
- Shopping cart system
- Order placement and management
- Admin panel for user management

## Technologies

- **Java** 21
- **Spring Boot** 6
- **MySQL** for database management
- **Spring Security** for authentication and authorization
- **Maven** for dependency management

## Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL Server

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Claudiu1503/FishingStore---Backend.git
   cd FishingStore---Backend
   ```

2. Install dependencies:
   ```bash
   mvn install
   ```

3. Configure your MySQL database:
   - Create a database named `fishingstore`.
   - Update the `application.properties` file with your database credentials.

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

Here are some important API endpoints:

| Method | Endpoint                  | Description                           |
|--------|---------------------------|---------------------------------------|
| POST   | /api/auth/register        | Register a new user                   |
| POST   | /api/auth/login           | Log in an existing user               |
| GET    | /api/products             | Retrieve all products                 |
| GET    | /api/products/{id}        | Retrieve a specific product           |
| POST   | /api/cart/add             | Add a product to the shopping cart    |
| POST   | /api/orders/place         | Place a new order                     |

## Usage

### Authentication

To use protected endpoints, you must authenticate with your credentials. Use the `login` endpoint to obtain a token.

### Example Request

```bash
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{"email": "user@example.com", "password": "yourpassword"}'
```

### Example Response

```json
{
    "token": "your-jwt-token"
}
```

## Contributing

We welcome contributions! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

For any questions or issues, please open an issue in this repository.
