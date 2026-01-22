# Student Management System

A simple Spring Boot REST API for managing student records. This project performs full CRUD operations using Spring Data JPA and H2 in-memory database.

## 🚀 Technologies Used

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## 📁 Project Structure 

student/

└── src/main/java/com/example/student 

├── StudentApplication.java

├── controller/StudentController.java

├── model/Student.java

├── repository/StudentRepository.java

└── service/StudentService.java

└── src/main/resources

└── application.properties


## ⚙️ Setup Instructions

1. Install JDK 25 and IntelliJ IDEA
2. Clone this repository or create project using Spring Initializr
3. Add dependencies: Spring Web, Spring Data JPA, H2 Database
4. Run the application using IntelliJ or `mvn spring-boot:run`

## 🔗 API Endpoints

| Method | Endpoint              | Description         |
|--------|-----------------------|---------------------|
| GET    | `/students`           | Get all students    |
| POST   | `/students`           | Add new student     |
| PUT    | `/students/{id}`      | Update student      |
| DELETE | `/students/{id}`      | Delete student      |

## 🧪 Sample JSON for POST/PUT

json

{

  "name": "Meharin",
  
  "email": "meharin@gmail.com",
  
  "department": "ICT"
  
}


## 🛠 Database Configuration
H2 in-memory database is used. Access H2 console at:                                                                                    
http://localhost:8080/h2-console

## ✅ Status
✔ Project runs successfully
✔ API tested via Postman
✔ Data persists in H2 memory during runtime



