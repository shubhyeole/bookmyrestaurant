
# 🍽️ Restaurant Management Web Application

## 📌 Overview
A full-stack **Java-based web application** developed to automate and simplify restaurant management operations. This application enables **Admins** to manage food menus, chefs, and table bookings, while **Users** can book tables online through a user-friendly interface.

> **Note:** This project was developed as a part of self-learning to apply real-time backend development skills in **Java Servlets, JDBC, and MySQL** using **MVC architecture**.

---

## 🚀 Features
### 🔑 Admin Features
- Perform **CRUD operations** on:
  - Food Menu Items
  - Chefs
  - Table Bookings
- Manage operations through an intuitive admin dashboard.

### 🧑‍💻 User Features
- View available tables and slots.
- Book tables online via reservation form.

### ⚙️ Technical Highlights
- **MVC architecture** with clear separation: Controller, Service, DAO, Model
- **Input validation** on both frontend and backend
- **Secure database operations** using JDBC with Prepared Statements
- Organized, layered structure for clean code and maintainability

---

## 🏗️ Technologies Used
| Area      | Technologies                      |
|-----------|-----------------------------------|
| Backend   | Java Servlets, JDBC                |
| Database  | MySQL                              |
| Frontend  | HTML, CSS, JavaScript, Bootstrap   |

---

## 🗂️ Project Structure
```
src/main/java/com/bookmyrestaurant
├── controller        (Handles HTTP requests - Servlets)
├── service           (Business logic layer)
├── dao               (Database access - JDBC)
├── model             (POJOs / Entities)
├── validation        (Validation utilities)
├── fileio            (File utilities)
├── start             (Configuration / Initialization)
```

---

## 🔥 Architecture Flow
```
Browser (User / Admin)
       ↓
Controller (Servlet)
       ↓
Service Layer (Business Logic)
       ↓
DAO Layer (JDBC / MySQL)
       ↓
Database (MySQL)
```

---

## 📥 How to Run Locally
1. Clone this repository:
```bash
git clone https://github.com/your-username/bookmyrestaurant.git
```
2. Open the project in **Eclipse / IntelliJ IDEA**.
3. Set up **MySQL database** and configure connection details in the DAO layer.
4. Deploy the project on **Apache Tomcat**.
5. Access the application via:
```
http://localhost:8080/bookmyrestaurant
```

---

## 📸 Screenshots (Optional)
> Add screenshots of Admin Panel, Table Booking Page for better presentation.

---

## 🎯 What I Learned
- Real-world application of **Java Web Development** (Servlets, JDBC)
- Structuring enterprise applications using **MVC and layered architecture**
- Importance of clean code separation for scalability and maintainability
- Security measures like **Prepared Statements** to prevent SQL Injection
- Session management using **HttpSession**

---

## 📈 Future Enhancements
- Migrate to **Spring Boot** with **Spring Data JPA**
- Implement **authentication and role-based authorization**
- Add **email notifications** for bookings
- Expand reporting features (e.g., monthly bookings reports)

---

## 🤝 Contributing
Contributions are welcome! Feel free to fork this project and suggest improvements.

---

## 📄 License
This project is intended for **educational purposes only.**
