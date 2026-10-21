# API REST de Videojuegos

API REST básica desarrollada con Java y Spring Boot que administra un catálogo de videojuegos. Los datos se guardan en memoria, por lo que se reinician al detener la aplicación.

Proyecto de la Actividad colaborativa #1 de la Unidad 1.

## Tecnologías

- Java 21
- Spring Boot 4.1.1
- Maven
- Spring Web, Validation y DevTools

## Cómo ejecutarlo

1. Clonar el repositorio:

```bash
   git clone https://github.com/quechecho/Api-Reset-.git
```

2. Ejecutar la aplicación, con cualquiera de estas dos opciones:

   **Opción A: desde VS Code o un IDE**
   - Abrir la carpeta `API-REST` en el IDE.
   - Abrir el archivo `src/main/java/com/lenguaje/de/programcion/III/API/REST/ApiRestApplication.java`.
   - Pulsar el botón **Run Java** que aparece sobre el método `main`.

   **Opción B: desde la terminal**

```bash
   cd Api-Reset-/API-REST
```

- Windows: `.\mvnw.cmd spring-boot:run`

3. La API queda disponible en `http://localhost:2080`.

Requisito: tener instalado Java 21 o superior.

## Endpoints

| Método | Ruta                     | Descripción                             | Respuesta                      |
| ------ | ------------------------ | --------------------------------------- | ------------------------------ |
| GET    | `/api/juegos`            | Lista todos los juegos                  | 200 OK                         |
| GET    | `/api/juegos?genero=RPG` | Filtra juegos por género (RequestParam) | 200 OK                         |
| GET    | `/api/juegos/{id}`       | Busca un juego por id (PathVariable)    | 200 OK / 404 Not Found         |
| POST   | `/api/juegos`            | Crea un juego nuevo (RequestBody + DTO) | 201 Created / 400 Bad Request  |
| DELETE | `/api/juegos/{id}`       | Elimina un juego por id                 | 204 No Content / 404 Not Found |

### Ejemplo de POST

```json
{
  "titulo": "Hollow Knight",
  "genero": "Metroidvania",
  "plataforma": "PC",
  "anio": 2017
}
```

## Estructura del proyecto

- `model`: clase `Juego`
- `dto`: record `JuegoRequest` con validaciones
- `service`: `JuegoService` con la lista en memoria
- `controller`: `JuegoController` con los endpoints

## Integrante
