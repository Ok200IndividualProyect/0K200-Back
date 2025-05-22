
This is a REST API built with Spring Boot for a developer, IT studient, or just someone Passionate about technology matchmaking app. 
It allows user registration, selection of technologies, and finding matches based on shared tech interests.



## 🚀 Technologies Used

- Java 17  
- Spring Boot  
- Spring Data JPA  
- H2 / PostgreSQL  
- Maven



## 📦 Main Endpoints

| Method | Route                         | Description                              |
|--------|------------------------------|------------------------------------------|
| POST   | `/api/v1/users`              | Register a new user                      |
| GET    | `/api/v1/technologies`       | Get all available technologies           |
| GET    | `/api/v1/users/{id}/matches` | Get user matches based on technologies   |

## 🛠 How to Use

1. Clone the repository:

```bash
git clone https://github.com/your-username/codecraft-backend.git
cd codecraft-backend

    Run the project using your IDE (IntelliJ / VS Code) or from the terminal:

./mvnw spring-boot:run

    Access the API at http://localhost:8080/api/v1/users.

🧪 Database

You can use:

    H2 (in-memory, ideal for testing)

    PostgreSQL (recommended for production)

Database config can be adjusted in application.properties.

🤝 Contributing

Contributions are welcome!
Feel free to open an issue or pull request with suggestions or improvements.

