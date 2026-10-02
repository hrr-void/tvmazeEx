# TVMaze API

API REST para consultar shows de [TVMaze](https://www.tvmaze.com/api) y registrar comentarios.

## Ejecutar

Se requiere Java 17 y MongoDB. Configura la conexión de application.yml mediante la variable de entorno `spring.data.mongodb.uri` y ejecuta:

```powershell
mvn spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

## Endpoints

### Buscar shows

```http
GET /shows/search?query=girls
```

```powershell
curl.exe "http://localhost:8080/shows/search?query=girls"
```

Retorna una lista con información resumida de cada show y sus comentarios.

### Consultar detalle de un show

```http
GET /shows/{showId}
```

```powershell
curl.exe "http://localhost:8080/shows/1"
```

Retorna la información completa del show y sus comentarios.

### Crear comentario

```http
POST /comments
Content-Type: application/json
```

```json
{
  "showId": 1,
  "comment": "Buena serie",
  "rating": 5
}
```

```powershell
curl.exe -X POST "http://localhost:8080/comments" `
  -H "Content-Type: application/json" `
  -d '{"showId":1,"comment":"Buena serie","rating":5}'
```

El `rating` debe estar entre `0` y `5`. El show debe existir en TVMaze.
