# 🔔 Device Configuration Notification API

Spring Boot REST API that triggers JSON notifications when a device configuration changes (`config_changed = true`).

---

## 🚀 Features

- Detects device configuration changes
- Triggers notification when `config_changed = true`
- Returns JSON response
- Uses H2 in-memory database (no setup required)

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database

---
## 📂 Project Structure

```text
TriggerNotificationApi/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/calsoft/api/
│   │   │       ├── controller/
│   │   │       │   └── DeviceNotificationController.java
│   │   │       ├── service/
│   │   │       │   └── DeviceNotificationService.java
│   │   │       ├── repository/
│   │   │       │   └── DeviceRepository.java
│   │   │       ├── model/
│   │   │       │   └── Device.java
│   │   │       └── TriggerNotificationApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
├── pom.xml
└── README.md
```
---

## ▶️ Run
mvn spring-boot:run

---

**Method:** GET  
**URL:** http://localhost:8080/api/deviceConfigNotification

---

## 📸 Output

<img width="834" height="520" alt="image" src="https://github.com/user-attachments/assets/65307d18-7350-4c6a-9d31-c4734bc49892" />


---
