# 🔐 RevPassword Manager

A secure console-based Java application that allows users to safely store, generate, and manage passwords for their online accounts. The system focuses on security using master password protection, encryption, and account recovery mechanisms.

---

## 📌 Application Overview

**RevPassword Manager** is a password vault system that enables users to securely manage credentials through a master account. Users can generate strong passwords, store encrypted credentials, and manage their vault efficiently.

The application emphasizes:

* 🔒 Security & encryption
* 🧩 Modular layered architecture
* 👤 User account management
* 🔑 Password vault protection

---

## 🚀 Core Features

### 👤 User Management

* Create a secure user account
* Login with master password
* Update profile information (name & email)
* Change or recover password using security questions

### 🔐 Password Vault

* Add new password entries
* Update existing passwords
* Delete stored credentials
* List all saved accounts
* View password details (with re-authentication)
* Search passwords by account name

### 🔑 Security Features

* Password encryption
* Master password protection
* Security questions for account recovery
* Verification codes for sensitive operations
* Expiring verification system

### ⚙️ Utilities

* Strong random password generator
* Input validation
* Secure data handling

---

## 🛠️ Technologies Used

* **Java (Core Java, OOP)**
* **JDBC**
* **MySQL Database**
* **Layered Architecture (DAO / Service / UI)**
* **Git & GitHub**

---

## 🧱 Application Architecture

The application follows a modular layered architecture:

```
UI Layer (Console Interface)
        ↓
Service Layer (Business Logic)
        ↓
DAO Layer (Database Access)
        ↓
Database (MySQL)
```

This structure improves maintainability, scalability, and testability.

---

## 🗂️ Project Structure

```
RevPasswordManager/
│
├── dao/          # Database operations
├── model/        # Entity classes
├── service/      # Business logic
├── ui/           # Console interface
├── util/         # Encryption & utilities
├── validation/   # Input validation
├── tester/       # Test classes
└── README.md
```

---

## 🗺️ ER Diagram

The following ER diagram represents the database schema of the application:

![ER Diagram](ER_DIAGRAM.png)

---

## ⚙️ Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/Varun2003-tech/RevPasswordManager.git
```

### 2. Open in IDE

Import the project into:

* Eclipse / IntelliJ / VS Code

### 3. Configure Database

Create a MySQL database and update credentials in:

```
util/DBConnection.java
```

### 4. Run the Application

Run the main class:

```
MainMenu.java
```

---

## ▶️ Usage

1. Register a new account
2. Login securely
3. Add and manage passwords
4. Generate strong passwords
5. Recover account using security questions

---

## 🧪 Testing

Test classes are available in the `tester/` package to validate core functionality.

---

## ✅ Definition of Done

* Working console application
* Secure password management
* ER diagram included
* Modular architecture implemented
* Code shared for evaluation

---

## 🤝 Contribution

Contributions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Submit a pull request

---

## 📜 License

This project is developed for educational and learning purposes.

---

## 👨‍💻 Author

**Varun Valluri**

GitHub: [https://github.com/Varun2003-tech](https://github.com/Varun2003-tech)
