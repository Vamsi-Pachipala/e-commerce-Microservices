# 🛒 Scalable E-commerce Backend System

A full-fledged backend system for an e-commerce platform, designed using a microservices architecture. This project simulates a real-world scalable application and includes key features like user management, product listing, order processing, inventory tracking, and secure payment flow.

---

## 🚀 Features

- 🧹 **Modular Microservices**: 
  - Product, Order, User, Inventory, Payment, and API Gateway
- 🔐 **Authentication & Authorization**:
  - Spring Security with JWT tokens
- ⚡ **Asynchronous Communication**:
  - Kafka-based messaging between Order and Inventory services
- 📂 **Caching**:
  - Redis for product data and session management
- 🛏 **Service Discovery**:
  - Eureka Server
- 🌐 **Routing**:
  - Spring Cloud Gateway
- 🐳 **Containerization**:
  - Docker & Docker Compose
- 🧪 **Unit & Integration Testing**:
  - JUnit, Mockito

---

## 💪 Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot, Spring Security, Spring Data JPA, Spring Cloud
- **Database**: MySQL
- **Messaging**: Apache Kafka
- **Caching**: Redis
- **API Gateway**: Spring Cloud Gateway
- **Discovery**: Eureka
- **Containerization**: Docker, Docker Compose

---

## 📦 Microservice Structure

```
ecommerce-backend/
├── api-gateway/
├── config-server/
├── discovery-server/
├── product-service/
├── order-service/
├── user-service/
├── inventory-service/
├── payment-service/
└── docker-compose.yml
```

---

## 📷 Sample APIs

```bash
# Register a new user
POST /api/user/register

# Authenticate and receive JWT
POST /api/user/login

# List all products
GET /api/products

# Place an order
POST /api/orders
```

---

## 🧪 Running Locally

1. **Clone the repository**
```bash
git clone https://github.com/Vamsi-Pachipala/scalable-ecommerce-backend.git
cd scalable-ecommerce-backend
```

2. **Start services using Docker Compose**
```bash
docker-compose up --build
```

3. Access services via:
- API Gateway: `http://localhost:8080`
- Eureka Dashboard: `http://localhost:8761`

---

## 📚 Future Enhancements

- Implement OAuth2 for SSO login
- Admin panel with role-based access
- Frontend integration (React/Vue/Angular)
- Payment gateway simulation

---

## 🙌 Acknowledgements

Inspired by real-world e-commerce architecture and cloud-ready backend systems.

---

## 📬 Contact

Created with 💻 by [Vamsi Pachipala](https://www.linkedin.com/in/vamsi-pachipala-98a338209/)
