# Prueba Técnica número 2 
Para esta prueba, se pidió realizar una API REST utilizando Spring Boot como framework, con el lenguaje Java.
## 2 Versiones y tecnologías usadas
Para realizar la prueba utilicé:
- Java en su versión 21
- Gradle en versión 8.12.1
- Spring boot 3.4.3
- Mysql 8.0.41

## Endpoints
GET y POST
http://localhost:8080/api/learners
PUT,DELETE, GET by id
http://localhost:8080/api/learners/{id}
GET y POST
http://localhost:8080/api/lessons
PUT,DELETE, GET by id
http://localhost:8080/api/lessons/{id}

## Cosas importantes
Al ser una relación de 1 a muchos bidireccional, se crea una relación circular. Por ello, utilicé
@ManyToMany para crear una tabla intermedia manejada por JPA y obtener una mejor estructura.
Para recuperar y guardar los datos de manera adecuada, creé dos DTOs, uno para cada entidad base:
LearnersEntity y LessonsEntity.

## Iniciar la API
Para iniciar la API, es necesario llenar el archivo application.properties con los datos de una base de datos local. Donde vea la anotación {password},
debe borrar las llaves y la palabra dentro, y reemplazarla con los datos de su servidor local.

Una vez llenos los datos, se debe ejecutar el proyecto ya sea desde el IDE o de forma normal usando
```sh
./gradlew build
```
Saludos. 


