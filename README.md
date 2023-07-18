# ChallengeALTEN

Challenge realizado para la empresa ALTEN Spain para el cliente INDATEX S.A (ZARA).

## Especificaciones del proyecto

- Java 1.8
- SpringBoot 2.7.5
- JPA
- Lombok
- H2
- Swagger 1.6.12 (springdoc-openapi)

## Clonar el repositorio

Para clonar el repositorio, puedes utilizar alguno de los siguientes comandos en base a tu preferencia:

### SSH
```
git clone git@github.com:manu-rnt/ChallengeALTEN.git
```

### HTTP
```
git clone https://github.com/manu-rnt/ChallengeALTEN.git
```

Una vez clonado el repositorio, debes abrir Eclipse o tu IDE favorito para manejar Java e importar el proyecto.

Si estás utilizando Eclipse, puedes importar el proyecto siguiendo estos pasos:

1. Ve a "File" -> "Import".
2. Selecciona "Maven" -> "Existing Maven Projects".
3. Haz clic en "Next".
4. Navega hasta la ubicación del proyecto clonado y selecciona la carpeta raíz del proyecto.
5. Haz clic en "Finish".

Una vez importado el proyecto, debes realizar el build.

Haz clic derecho en el proyecto "zara" y luego selecciona "Run As" -> "Maven build". Esto instalará las dependencias configuradas en el archivo POM.xml.

Se agregaron por defecto 4 objetos a la base de datos H2:

```json
[
  {
    "id": 1,
    "brandId": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "priceList": 1,
    "productId": 35455,
    "priority": 0,
    "price": 35.5,
    "currency": "EUR"
  },
  {
    "id": 2,
    "brandId": 1,
    "startDate": "2020-06-14T15:00:00",
    "endDate": "2020-06-14T18:30:00",
    "priceList": 2,
    "productId": 35455,
    "priority": 1,
    "price": 25.45,
    "currency": "EUR"
  },
  {
    "id": 3,
    "brandId": 1,
    "startDate": "2020-06-15T00:00:00",
    "endDate": "2020-06-15T11:00:00",
    "priceList": 3,
    "productId": 35455,
    "priority": 1,
    "price": 30.5,
    "currency": "EUR"
  },
  {
    "id": 4,
    "brandId": 1,
    "startDate": "2020-06-15T16:00:00",
    "endDate": "2020-12-31T23:59:59",
    "priceList": 4,
    "productId": 35455,
    "priority": 1,
    "price": 38.95,
    "currency": "EUR"
  }
]
```

Estos objetos ya fueron ingresados desde el archivo `data.sql`.

Si deseas ver las tablas en tiempo real, puedes acceder a [http://localhost:8081/h2-console/](http://localhost:8081/h2-console/) y completar los siguientes datos:

- Driver class: `org.h2.Driver`
- JDBC URL: `jdbc:h2:mem:zaraDesa`
- User Name: `sa`
- Password: (dejar en blanco)

Para realizar las pruebas correspondientes, puedes acceder a Swagger en [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html).

Utilizando el método GET de `/prices`, podrás obtener todos los objetos agregados de forma predeterminada.

Utilizando el método POST de `/prices`, podrás agregar nuevos objetos.

Además, utilizando el método GET de `/brand`, podrás ver las marcas ingresadas por defecto en la base de datos H2.

## Casos de prueba para el método POST de `/filter`

`/filter` es un controlador realizado para filtrar por 3 datos. El parámetro `applicationDate` corresponde a la columna "START_DATE" en la tabla PRICES.

### Caso de prueba 1: solicitud a las 10:00 a.m. del día 14 para el producto 35455 de la marca 1 (XYZ)
```json
{
  "applicationDate": "2020-06-14T10:00:00",
  "productId": 35455,
  "brandName": "XYZ"
}
```

### Caso de prueba 2: solicitud a las 4:00 p.m. del día 14 para el producto 35455 de la marca 1 (XYZ)
```json
{
  "applicationDate": "2020-06-14T16:00:00",
  "productId": 35455,
  "brandName": "XYZ"
}
```

### Caso de prueba 3: solicitud a las 9:00 p.m. del día 14 para el

 producto 35455 de la marca 1 (XYZ)
```json
{
  "applicationDate": "2020-06-14T21:00:00",
  "productId": 35455,
  "brandName": "XYZ"
}
```

### Caso de prueba 4: solicitud a las 10:00 a.m. del día 15 para el producto 35455 de la marca 1 (XYZ)
```json
{
  "applicationDate": "2020-06-15T10:00:00",
  "productId": 35455,
  "brandName": "XYZ"
}
```

### Caso de prueba 5: solicitud a las 9:00 p.m. del día 16 para el producto 35455 de la marca 1 (XYZ)
```json
{
  "applicationDate": "2020-06-16T21:00:00",
  "productId": 35455,
  "brandName": "XYZ"
}
```

¡Gracias por revisar mi challenge resuelto! Si tienes alguna pregunta o necesitas más información, no dudes en hacerla. ¡Buena suerte! :rocket:
