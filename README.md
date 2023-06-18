# GymV2
Este es el repositorio del aplicativo GymV2 desarrollado por Jony Edward Jaimes Silva como parte de la tercera nota del curso de Programación Web.

## Descripción

GymV2 es una aplicación que permite administrar rutinas de entrenamiento para usuarios bajo la supervisión de entrenadores. Los usuarios pueden ser asignados a diferentes rutinas y seguir su progreso a medida que avanzan en su entrenamiento. Los entrenadores tienen la capacidad de crear, editar y asignar rutinas a los usuarios.

## Captura de pantalla de la estructura de la base de datos

![Estructura de la base de datos](https://github.com/JonnyJaimes/GymV2/assets/44138519/0b070d6a-d2b6-4a45-b81c-a01a20901d76)

## Endpoints

A continuación se muestran los endpoints disponibles en la API junto con una breve descripción de su función y los ejemplos de los JSON que se deben usar en cada caso. Puedes utilizar una herramienta como Postman para realizar las solicitudes a estos endpoints.

### Entrenador 
## Asignar rutina a un usuario

Para asignar una rutina a un usuario, se puede utilizar el siguiente endpoint:

- Endpoint: `POST /api/entrenadores/rutinas/1/usuarios/1`

Este endpoint permite a un entrenador asignar una rutina específica (identificada por el ID "1") a un usuario específico (identificado por el ID "1").

A continuación se muestra un ejemplo del JSON que se debe enviar en la solicitud:

```json
{
  "entrenador": {
    "id": 1,
    "email": "pele@yahoo.com",
    "password": "1234",
    "username": "spiderman"
  },
  "rutina": {
    "id": 1
  },
  "usuario": {
    "id": 1
  }
}
- `GET /api/entrenadores`: Obtiene la lista de todos los entrenadores registrados.
- `GET /api/entrenadores/{id}`: Obtiene los detalles de un entrenador específico identificado por su ID.
- `POST /api/entrenadores`: Crea un nuevo entrenador. Se debe enviar un JSON con los datos del entrenador.
- `PUT /api/entrenadores/{id}`: Actualiza los datos de un entrenador existente identificado por su ID. Se debe enviar un JSON con los datos actualizados del entrenador.
- `DELETE /api/entrenadores/{id}`: Elimina un entrenador específico identificado por su ID.

### Rutina

- `GET /api/rutinas`: Obtiene la lista de todas las rutinas registradas.
- `GET /api/rutinas/{id}`: Obtiene los detalles de una rutina específica identificada por su ID.
- `POST /api/rutinas`: Crea una nueva rutina. Se debe enviar un JSON con los datos de la rutina.
- `PUT /api/rutinas/{id}`: Actualiza los datos de una rutina existente identificada por su ID. Se debe enviar un JSON con los datos actualizados de la rutina.
- `DELETE /api/rutinas/{id}`: Elimina una rutina específica identificada por su ID.

### Usuario

- `GET /api/usuarios`: Obtiene la lista de todos los usuarios registrados.
- `GET /api/usuarios/{id}`: Obtiene los detalles de un usuario específico identificado por su ID.
- `POST /api/usuarios`: Crea un nuevo usuario. Se debe enviar un JSON con los datos del usuario.
- `PUT /api/usuarios/{id}`: Actualiza los datos de un usuario existente identificado por su ID. Se debe enviar un JSON con los datos actualizados del usuario.
- `DELETE /api/usuarios/{id}`: Elimina un usuario específico identificado por su ID.

## Cómo ejecutar la aplicación

Sigue estos pasos para ejecutar la aplicación en tu entorno local:

1. Clona este repositorio: `git clone https://github.com/JonnyJaimes/GymV2.git`
2. Abre el proyecto en tu IDE preferido.
3. Configura las conexiones de base de datos en el archivo `application.properties` según tu entorno.
4. Ejecuta la aplicación.

¡Y eso es todo! Ahora puedes utilizar la API de GymV2 para administrar entrenadores, rutinas y usuarios.

## Autor

- Jony Edward Jaimes Silva
- Código: 1151733

Si tienes alguna pregunta o necesitas ayuda adicional, no dudes en contactarme.

Espero que esta información sea útil para crear el README.md de tu aplicación GymV2. ¡Buena suerte con tu proyecto!
