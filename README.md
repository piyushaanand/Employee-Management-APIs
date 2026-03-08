# Employee Management System REST API

## 📌 Overview

The **Employee Management System REST API** is a backend application developed using **Spring Boot** that allows organizations to manage employee records efficiently.

This system provides RESTful APIs that allow administrators to perform **CRUD operations (Create, Read, Update, Delete)** on employee data.

The application also includes:

* Input validation
* Global exception handling
* Pagination
* Sorting
* Database integration using **Spring Data JPA**

---

## 🚀 Features

* Add new employees
* View all employees
* Get employee by ID
* Update employee information
* Delete employee records
* Pagination support
* Sorting support
* Input validation 
* Global exception handling

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* REST API
* Postman

---

## 📂 Project Structure

```
com.company.employee

controller
    EmployeeController

service
    EmployeeService
    EmployeeServiceImpl

repository
    EmployeeRepository

entity
    Employee

exception
    PostException
    GetException
    PutException
    DeleteException
    GlobalExceptionHandler
```

---

## 📊 Employee Entity

| Field       | Type   | Description        |
| ----------- | ------ | ------------------ |
| id          | Long   | Unique employee ID |
| name        | String | Employee name      |
| email       | String | Employee email     |
| department  | String | Department         |
| salary      | Double | Employee salary    |
| designation | String | Job role           |

### Example Employee JSON

```json
{
  "id": 101,
  "name": "Anita Sharma",
  "email": "anita.sharma@company.com",
  "department": "IT",
  "salary": 75000,
  "designation": "Software Developer"
}
```

---

# 🔗 API Endpoints

## 1️⃣ Create Employee

**POST /employees**

Request Body

```json
{
  "name": "Rahul Verma",
  "email": "rahul.verma@company.com",
  "department": "Finance",
  "salary": 65000,
  "designation": "Accountant"
}
```

---

## 2️⃣ Get All Employees

**GET /employees**

Example

```
GET /employees?page=0&size=5&sort=salary,desc
```

---

## 3️⃣ Get Employee by ID

**GET /employees/{id}**

Example

```
GET /employees/101
```

---

## 4️⃣ Update Employee

**PUT /employees/{id}**

Example Request

```json
{
  "name": "Rahul Verma",
  "email": "rahul.updated@company.com",
  "department": "Finance",
  "salary": 70000,
  "designation": "Senior Accountant"
}
```

---

## 5️⃣ Delete Employee

**DELETE /employees/{id}**

Example

```
DELETE /employees/101
```

---

# ✅ Input Validation

Validation is implemented using **Bean Validation annotations**.

Examples:

```java
@NotBlank
private String name;

@Email
private String email;

@Positive
private Double salary;
```

---

# ⚠️ Exception Handling

Global exception handling is implemented using `@ControllerAdvice`.

### Resource Not Found Example

```json
{
  "timestamp": "2026-03-06",
  "status": 404,
  "error": "Employee not found with id: 101"
}
```

### Validation Error Example

```json
{
  "timestamp": "2026-03-06",
  "status": 400,
  "errors": [
    "Email must be valid",
    "Salary must be greater than 0"
  ]
}
```

---

# ▶️ How to Run the Project

Clone the repository

```
git clone https://github.com/piyushaanand/Employee-Management-APIs.git
```

Navigate to the project folder

```
cd Employee-Management-APIs
```

Run the application

```
mvn spring-boot:run
```

Application will run on

```
http://localhost:8080
```

---

# 👨‍💻 Author

**Piyush Aanand**

GitHub:
https://github.com/piyushaanand
