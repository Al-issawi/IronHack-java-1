const form = document.getElementById("weatherForm");
const message = document.getElementById("message");
const card = document.getElementById("weatherCard");
const keyInput = document.getElementById("apiKeyInput");
const cityInput = document.getElementById("cityInput");
const unitsSelect = document.getElementById("unitsSelect");
const langSelect = document.getElementById("langSelect");

document.getElementById("toggleKey").addEventListener("click", () => {
  const show = keyInput.type === "password";
  keyInput.type = show ? "text" : "password";
  document.getElementById("toggleKey").textContent = show ? "Ocultar" : "Mostrar";
});

function showMessage(text, type = "") {
  message.className = "message " + type;
  message.textContent = text;
}
function temperature(value, units) {
  const suffix = units === "metric" ? "°C" : units === "imperial" ? "°F" : "K";
  return Math.round(value) + suffix;
}

form.addEventListener("submit", async (event) => {
  event.preventDefault();
  const city = cityInput.value.trim();
  const apiKey = keyInput.value.trim();
  const units = unitsSelect.value;
  const lang = langSelect.value;

  if (!city || !apiKey) {
    showMessage("Escribe una ciudad y tu API key para continuar.", "error");
    return;
  }

  // La API key se usa en memoria y no se guarda en localStorage ni en el repositorio.
  const params = new URLSearchParams({
    q: city,
    appid: apiKey,
    units,
    lang
  });
  const url = "https://api.openweathermap.org/data/2.5/weather?" + params.toString();

  showMessage("Consultando OpenWeatherMap…");
  card.classList.add("hidden");

  try {
    const response = await fetch(url);
    const data = await response.json();

    if (!response.ok) {
      if (response.status === 401) throw new Error("API key no válida o todavía no activada. Comprueba tu clave en OpenWeatherMap.");
      if (response.status === 404) throw new Error("No se ha encontrado esa ciudad. Revisa el nombre e inténtalo otra vez.");
      throw new Error(data.message || "No se ha podido consultar el tiempo.");
    }

    console.log("Respuesta completa de OpenWeatherMap:", data);
    console.log("Temperatura:", data.main.temp);
    console.log("Descripción:", data.weather[0].description);

    document.getElementById("place").textContent = data.name + (data.sys?.country ? ", " + data.sys.country : "");
    document.getElementById("date").textContent = new Date().toLocaleString("es-ES", { dateStyle: "full", timeStyle: "short" });
    document.getElementById("temperature").textContent = temperature(data.main.temp, units);
    document.getElementById("description").textContent = data.weather[0].description;
    document.getElementById("weatherIcon").src = "https://openweathermap.org/img/wn/" + data.weather[0].icon + "@2x.png";
    document.getElementById("weatherIcon").alt = data.weather[0].description;
    document.getElementById("feelsLike").textContent = temperature(data.main.feels_like, units);
    document.getElementById("humidity").textContent = data.main.humidity + "%";
    document.getElementById("wind").textContent = data.wind.speed + (units === "imperial" ? " mph" : " m/s");
    document.getElementById("clouds").textContent = data.clouds.all + "%";
    document.getElementById("pressure").textContent = data.main.pressure + " hPa";
    document.getElementById("visibility").textContent = data.visibility != null ? (data.visibility / 1000).toFixed(1) + " km" : "—";
    document.getElementById("updated").textContent = "Datos recibidos de la API · " + new Date().toLocaleTimeString("es-ES");

    card.classList.remove("hidden");
    showMessage("Conexión correcta. Datos recibidos desde OpenWeatherMap.", "success");
  } catch (error) {
    console.error("Error en la petición del tiempo:", error);
    showMessage(error.message || "Error de conexión. Comprueba tu conexión a internet.", "error");
  }
});