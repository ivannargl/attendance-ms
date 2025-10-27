# 🎓 academic-ms

Microservicio de gestión académica (Universidades, Divisiones, Configuración institucional).  
Forma parte del ecosistema **Attendance-App / Roster** desarrollado con **Spring Boot 3.5.6** y **Java 21**.

---

## 🧩 Descripción general

Este microservicio maneja la información académica del sistema, incluyendo:
- Universidades y divisiones
- Configuración global por institución
- Integración con la base de datos **PostgreSQL (Neon / Vercel)**

---

## ⚙️ Tecnologías principales

| Componente | Versión | Descripción |
|-------------|----------|--------------|
| Java | 21 | Lenguaje principal |
| Spring Boot | 3.5.6 | Framework de backend |
| PostgreSQL | 17 | Base de datos (Neon) |
| Maven | 4.0 | Gestión de dependencias |
| HikariCP | - | Pool de conexiones |
| Hibernate ORM | 6.6.29.Final | ORM para JPA |

---

## 🚀 Ejecución local

### 1️⃣ Requisitos previos
- JDK 21 instalado  
- Maven configurado (`mvn -v`)  
- Variables de entorno definidas globalmente en Windows

### 2️⃣ Variables de entorno requeridas

Estas variables deben estar configuradas en tu sistema operativo:

| Variable | Descripción | Ejemplo |
|-----------|-------------|----------|
| `ACADEMIC_DB_URL` | URL JDBC de la base de datos Neon | `jdbc:postgresql://ep-polished-surf-ads7flz9-pooler.c-2.us-east-1.aws.neon.tech/neondb?sslmode=require` |
| `ACADEMIC_DB_USER` | Usuario de la base de datos | `neondb_owner` |
| `ACADEMIC_DB_PASSWORD` | Contraseña de la base de datos | `npg_TRZlYic9d0SA` |
| `ACADEMIC_SERVER_PORT` | Puerto de ejecución del microservicio | `8082` |

> 💡 Puedes configurarlas permanentemente con PowerShell (modo administrador):  
> ```bash
> setx ACADEMIC_DB_URL "jdbc:postgresql://..."
> setx ACADEMIC_DB_USER "neondb_owner"
> setx ACADEMIC_DB_PASSWORD "..."
> setx ACADEMIC_SERVER_PORT "8082"
> ```

Para verificar:
```bash
echo $env:ACADEMIC_DB_URL
