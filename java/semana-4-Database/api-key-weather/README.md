# API Key Lab — OpenWeatherMap

Pequeña web para practicar autenticación mediante API key, parámetros de URL, Fetch API, JSON y manipulación del DOM.

## 1. Conseguir una API key
1. Crea una cuenta en [OpenWeatherMap](https://home.openweathermap.org/users/sign_up).
2. Entra en [API keys](https://home.openweathermap.org/api_keys).
3. Copia tu clave. La activación puede tardar un poco.

**Seguridad:** no publiques tu API key en GitHub, no la escribas directamente en `app.js` y no la compartas en capturas. Esta práctica pide la clave en un campo del navegador y la utiliza solo durante la sesión. Para una aplicación pública, las claves deben protegerse detrás de un backend.

## 2. Ejecutar
1. Abre `index.html` con VS Code + Live Server.
2. Introduce tu API key.
3. Escribe una ciudad (por ejemplo, Barcelona).
4. Elige unidades e idioma y pulsa **Consultar tiempo**.

No necesitas ejecutar MySQL ni Spring Boot para este ejercicio.

## 3. Parámetros utilizados

La petición se construye con `URLSearchParams`:

```text
https://api.openweathermap.org/data/2.5/weather?q=Barcelona&appid=TU_API_KEY&units=metric&lang=es
```

- `q`: ciudad.
- `appid`: tu API key.
- `units=metric`: temperatura en Celsius.
- `lang=es`: descripción en español.

## 4. Datos JSON que se muestran

- `data.name`: nombre de la ciudad.
- `data.main.temp`: temperatura.
- `data.main.feels_like`: sensación térmica.
- `data.main.humidity`: humedad.
- `data.weather[0].description`: descripción del tiempo.
- `data.weather[0].icon`: código para cargar el icono.
- `data.wind.speed`: velocidad del viento.
- `data.clouds.all`: nubosidad.

## 5. Prueba rápida con Postman / Thunder Client

Método: `GET`

URL:

```text
https://api.openweathermap.org/data/2.5/weather?q=Barcelona&appid=TU_API_KEY&units=metric&lang=es
```

Sustituye `TU_API_KEY` por tu clave privada. Una respuesta correcta devuelve JSON con `cod: 200`.

## 6. Documentación
- [Current Weather Data](https://openweathermap.org/current)
- [Cómo empezar y usar una API key](https://openweathermap.org/appid)
- [Crear / consultar API keys](https://home.openweathermap.org/api_keys)
