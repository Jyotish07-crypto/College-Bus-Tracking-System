# 🚌 College Bus Tracking System

A backend application for managing college transportation, students, drivers, buses, routes, trips, and live bus location tracking.

The system is designed to help colleges manage their transportation services efficiently while providing a foundation for real-time bus tracking.

## 🚀 Project Overview

The College Bus Tracking System is developed using Spring Boot and PostgreSQL. It provides a structured backend for managing college buses, assigning students to buses, managing drivers, creating routes, scheduling trips, and storing GPS location data.

The application follows a layered architecture to maintain separation of concerns between controllers, services, repositories, DTOs, and entities.

## 🛠️ Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **REST APIs**
- **Postman** (API testing)

## ✨ Features

- User management
- Student management
- Driver management
- Bus management
- Route management
- Route stop management
- Student bus assignment management
- Trip management
- Bus GPS location tracking
- RESTful API architecture
- Database relationship management using JPA
- DTO-based request and response handling

## 🏗️ Project Architecture

The application follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Service Implementation
    ↓
Repository
    ↓
Database
```

### Layers

| Layer | Responsibility |
|---|---|
| Controller | Handles HTTP requests and responses |
| Service | Defines business operations |
| Service Implementation | Implements business logic |
| Repository | Performs database operations |
| Entity | Represents database tables |
| DTO | Transfers data between client and server |

## 📂 Project Structure

```text
src/main/java/com/college/bus_tracking
│
├── controller
│   └── UserController.java
│
├── dto
│   ├── request
│       ├── CreateUserRequest.java
│       ├── CreateStudentRequest.java
│       ├── CreateDriverRequest.java
│       ├── CreateRouteRequest.java
│       ├── CreateRouteStopRequest.java
│       ├── CreateBusRequest.java
│       ├── CreateStudentBusAssignmentRequest.java
│       ├── CreateTripRequest.java
│       └── CreateBusLocationRequest.java 
│
├── entity
│   ├── User.java
│   ├── Student.java
│   ├── Driver.java
│   ├── Route.java
│   ├── RouteStop.java
│   ├── Bus.java
│   ├── StudentBusAssignment.java
│   ├── Trip.java
│   └── BusLocation.java
│
├── repository
│   └── UserRepository.java
│
├── service
│   ├── UserService.java
│   └── impl
│       └── UserServiceImpl.java
│
└── CollegeBusTrackingApplication.java
```

## 🗄️ Database Design

The application contains the following entities:

### 1. User
Stores user account information.

- User ID
- Name
- Email
- Password
- Role
- Active status

### 2. Student
Stores student-specific information.

- Student ID
- User reference
- Roll number
- Department
- Semester
- Phone

### 3. Driver
Stores driver-specific information.

- Driver ID
- User reference
- License number
- Phone

### 4. Route
Stores bus route information.

- Route ID
- Route name
- Start point
- End point
- Active status

### 5. RouteStop
Stores stops associated with a route.

- Stop ID
- Route reference
- Stop name
- Latitude
- Longitude
- Stop sequence

### 6. Bus
Stores bus information.

- Bus ID
- Route reference
- Bus number
- Registration number
- Capacity
- Status

### 7. StudentBusAssignment
Connects students with buses and maintains assignment history.

- Assignment ID
- Student reference
- Bus reference
- Start date
- End date
- Active status

### 8. Trip
Represents a journey performed by a bus.

- Trip ID
- Bus reference
- Driver reference
- Route reference
- Start time
- End time
- Trip status

### 9. BusLocation
Stores GPS coordinates of buses during trips.

- Location ID
- Trip reference
- Latitude
- Longitude
- Speed
- Recorded timestamp

## 🔗 Entity Relationships

```text
User
 ├── Student
 └── Driver

Route
 ├── RouteStop
 ├── Bus
 └── Trip

Student
 └── StudentBusAssignment

Bus
 ├── StudentBusAssignment
 └── Trip

Driver
 └── Trip

Trip
 └── BusLocation
```

## 📡 API Endpoints

### User APIs

Base URL:

```text
http://localhost:8080/api/v1/users
```

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/users` | Create a user |
| GET | `/api/v1/users` | Get all users |
| GET | `/api/v1/users/{userId}` | Get user by ID |
| PUT | `/api/v1/users/{userId}` | Update user |
| DELETE | `/api/v1/users/{userId}` | Delete user |

### Create User

**Request:**

```http
POST /api/v1/users
Content-Type: application/json
```

```json
{
  "name": "Jyotish",
  "email": "jyotish@gmail.com",
  "password": "123456",
  "role": "STUDENT"
}
```

**Response:**

```json
{
  "userId": 1,
  "name": "Jyotish",
  "email": "jyotish@gmail.com",
  "role": "STUDENT",
  "isActive": true
}
```

## ⚙️ Installation and Setup

### Prerequisites

- Java 21 or later
- Maven
- PostgreSQL
- IntelliJ IDEA / Eclipse / VS Code

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/College-Bus-Tracking-System.git
```

### 2. Navigate to the project

```bash
cd College-Bus-Tracking-System
```

### 3. Configure MySQL

Create a database:

```sql
CREATE DATABASE college_bus_tracking;
```

### 4. Configure application properties

Update `src/main/resources/application.properties`:

```properties
spring.application.name=CollegeBusTracking

spring.datasource.url=jdbc:postgresql://localhost:5432/college_bus_tracking
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 5. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main application class from your IDE.

The application will start at:

```text
http://localhost:8080
```

## 🧪 API Testing

REST APIs can be tested using Postman.

1. Start the Spring Boot application.
2. Open Postman.
3. Create a new HTTP request.
4. Use the API endpoint.
5. Select the appropriate HTTP method.
6. Add JSON request data where required.
7. Send the request and inspect the response.

## 🔮 Future Enhancements

- Spring Security authentication and authorization
- Password encryption using BCrypt
- JWT-based authentication
- Student and driver dashboards
- Real-time bus location tracking
- GPS integration
- Live bus location updates
- Estimated arrival time calculation
- Notifications for students and parents
- Admin dashboard
- Route optimization
- Trip scheduling and management
- Frontend integration using React

## 👨‍💻 Developer

**Jyotish Kathariya**

Bachelor of Computer Applications (BCA)

## 📄 License

This project is developed for educational and academic purposes.
