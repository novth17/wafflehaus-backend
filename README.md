# 🍽️ Waffle Ordering Backend

## 📌 Overview

This is a **Spring Boot** backend for a **waffle restaurant food ordering system** in Belgium. It supports **user authentication, menu management, order placement, order tracking, and optional payment integration**. Built with **Spring Boot, PostgreSQL/MariaDB, and JWT authentication**.

## 🚀 Features

- **User Authentication:** Register/Login using JWT
- **Menu Management:** Admins can add/edit/remove waffles, toppings, and drinks
- **Order Placement:** Customers can place orders with customizations
- **Order Tracking:** Order statuses: *Placed → In Progress → Ready → Delivered*
- **Payment Integration (Optional):** Supports Stripe/PayPal integration
- **Google Maps API (Optional):** Show restaurant location for pickup orders

## 🏗️ Tech Stack

- **Backend:** Spring Boot, Spring Security, JPA
- **Database:** PostgreSQL/MariaDB - To be decided
- **Authentication:** JWT (JSON Web Tokens)
- **API Documentation:** Swagger
- **Deployment:** (Heroku / AWS - To be decided)

## 📜 Database Schema

### 1️⃣ Users Table

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15),
    address TEXT,
    role VARCHAR(50) CHECK (role IN ('CUSTOMER', 'ADMIN')) DEFAULT 'CUSTOMER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 2️⃣ Menu Items Table

```sql
CREATE TABLE menu_items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    category VARCHAR(100) CHECK (category IN ('WAFFLE', 'TOPPING', 'DRINK')),
    available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 3️⃣ Orders Table

```sql
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    total_price DECIMAL(10,2) NOT NULL,
    status VARCHAR(50) CHECK (status IN ('PLACED', 'IN_PROGRESS', 'READY', 'DELIVERED', 'CANCELLED')) DEFAULT 'PLACED',
    payment_status VARCHAR(50) CHECK (payment_status IN ('PENDING', 'PAID', 'FAILED')) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 📡 API Endpoints

### 🔑 Authentication

| Method | Endpoint             | Description                          |
| ------ | -------------------- | ------------------------------------ |
| POST   | `/api/auth/register` | Register a new user                  |
| POST   | `/api/auth/login`    | Authenticate user & return JWT token |

### 🍽️ Menu Management

| Method | Endpoint         | Description               |
| ------ | ---------------- | ------------------------- |
| GET    | `/api/menu`      | Get all menu items        |
| POST   | `/api/menu`      | Add new menu item (Admin) |
| PUT    | `/api/menu/{id}` | Update menu item (Admin)  |
| DELETE | `/api/menu/{id}` | Delete menu item (Admin)  |

### 🛍️ Orders

| Method | Endpoint                  | Description                 |
| ------ | ------------------------- | --------------------------- |
| POST   | `/api/orders`             | Place an order              |
| GET    | `/api/orders/{id}`        | Get order details           |
| PUT    | `/api/orders/{id}/status` | Update order status (Admin) |

## 🚀 Setup & Installation

### 1️⃣ Clone the Repository

```sh
git clone git@github.com:novth17/WaffleHaus-Backend.git](https://github.com/novth17/WaffleHaus-Backend.git)
cd waffle-ordering-backend
```

### 2️⃣ Configure Database

- Create a **PostgreSQL/MariaDB** database
- Update ``

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/waffle_db
spring.datasource.username=your_user
spring.datasource.password=your_password
```

### 3️⃣ Run the Application

```sh
mvn spring-boot:run
```

### 4️⃣ Test the APIs

- Open `http://localhost:8080/swagger-ui.html` to explore API docs

## 📌 Future Enhancements

✅ Real-time Order Tracking (WebSockets) ✅ Google Maps API Integration ✅ Full Payment Gateway Support ✅ Mobile App Integration

## 📝 License

This project is open-source under the **MIT License**.

---

🚀 **Developed with ❤️ for a Waffle Restaurant in Belgium!** 🇧🇪 🧇

