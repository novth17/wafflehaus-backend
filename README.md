# 🍽️ Waffle Ordering Backend

## 📌 Overview

This is a **Spring Boot** backend for a **waffle restaurant food ordering system** in Belgium. It supports **user authentication, menu management, order placement, and order tracking**. Built with **Spring Boot, PostgreSQL, and JWT authentication**.

## 🚀 Features

- **User Authentication:** Register/Login using JWT
- **Menu Management:** Admins can add/delete menu items
- **Order Placement:** Customers can place waffle orders
- **Order Tracking:** Admins can update order statuses (e.g. READY, COMPLETED)

## 🏗️ Tech Stack

- **Backend:** Spring Boot, Spring Security, JPA
- **Database:** PostgreSQL
- **Authentication:** JWT (JSON Web Tokens)

## 📜 Database Schema

### Users Table

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

### Menu Items Table

```sql
CREATE TABLE menu_items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    category VARCHAR(100),
    image_url TEXT
);
```

### Orders & Order Items

```sql
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES users(id) ON DELETE CASCADE,
    total_price DECIMAL(10,2) NOT NULL,
    status VARCHAR(50) CHECK (status IN ('RECEIVED', 'PREPARING', 'READY', 'COMPLETED', 'CANCELLED')) DEFAULT 'RECEIVED',
    note TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(id) ON DELETE CASCADE,
    menu_item_id INT REFERENCES menu_items(id),
    quantity INT NOT NULL,
    price_at_order_time DECIMAL(10,2) NOT NULL
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
| DELETE | `/api/menu/{id}` | Delete menu item (Admin)  |

### 🛍️ Orders

| Method | Endpoint                  | Description                  |
| ------ | ------------------------- | ---------------------------- |
| POST   | `/api/orders`             | Place an order               |
| GET    | `/api/orders/my`          | View your order history      |
| GET    | `/api/orders`             | View all orders (Admin only) |
| PUT    | `/api/orders/{id}/status` | Update order status (Admin)  |

## 🚀 Setup & Installation

### 1️⃣ Clone the Repository

```sh
git clone https://github.com/novth17/wafflehaus-backend.git
cd wafflehaus-backend
```

### 2️⃣ Configure Database

- Create a **PostgreSQL** database
- Update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/waffle_db
spring.datasource.username=your_user
spring.datasource.password=your_password
```

### 3️⃣ Run the Application

```sh
mvn spring-boot:run
```

---

🚀 **Developed with ❤️ for a Waffle Restaurant in Belgium!** 🇧🇪 🧇
