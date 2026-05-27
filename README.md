# Marcelo_Salcedo_examen_bdd
# Examen - Fundamentos de Bases de Datos

## API REST de Gestión de Vuelos

### Tecnologías utilizadas
- Java 17
- Spring Boot 3.1.5
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Postman

### Endpoints disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/vuelos` | Crear un nuevo vuelo |
| GET | `/api/vuelos` | Listar todos los vuelos |
| GET | `/api/vuelos/{id}` | Buscar vuelo por ID |
| PUT | `/api/vuelos/{id}` | Actualizar vuelo |
| DELETE | `/api/vuelos/{id}` | Eliminar vuelo |
| GET | `/api/vuelos/precio?precio=` | Buscar vuelos por precio menor a |
| GET | `/api/vuelos/asientos?asientos=` | Buscar vuelos por asientos disponibles |
| GET | `/api/vuelos/origen/{origen}` | Buscar vuelos por origen |
| GET | `/api/vuelos/destino/{destino}` | Buscar vuelos por destino |
| GET | `/api/vuelos/codigo/{codigo}` | Buscar vuelo por código |

### Video explicativo

[Enlace al video explicativo](https://youtu.be/tu_enlace_aqui)

### Estructura del proyecto
src/main/java/com/krakedev/examen/vuelos/
├── controllers/
│ └── VueloController.java
├── entities/
│ └── Vuelo.java
├── repositories/
│ └── VueloRepository.java
└── services/
│ └── ServicioVuelo.java
└── ExamenVuelosApplication.java

### Cómo ejecutar

1. Crear base de datos PostgreSQL: `examen_vuelos`
2. Configurar credenciales en `application.properties`
3. Ejecutar `mvn spring-boot:run`
4. Importar la colección de Postman

ENLACE DEL VIDEO

https://drive.google.com/file/d/1U0nZynTuAb8dCcaZUWsAqBadtlGvSlHc/view?usp=sharing


---

## 📋 Checklist Final para la Parte 3

| # | Tarea | 
|---|-------|
| 1 | Ejecutar `ALTER TABLE` en PostgreSQL |
| 2 | Agregar `destino` en `Vuelo.java` |
| 3 | Agregar getter y setter | 
| 4 | Actualizar constructor | 
| 5 | Actualizar `toString()` | 
| 6 | Agregar `findByDestino()` en Repository | 
| 7 | Actualizar método `actualizar()` en Service | 
| 8 | Agregar `buscarPorDestino()` en Service | 
| 9 | Agregar endpoint `GET /destino/{destino}` en Controller | 
| 10 | Actualizar JSON en Postman | 
| 11 | Probar POST con destino | 
| 12 | Probar GET por destino |
| 13 | Verificar en pgAdmin | 
| 14 | Actualizar README.md | 


