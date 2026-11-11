// Si tu controlador usa otra ruta, cambia esta URL.
const API_URL = "http://localhost:8080/coches";
const $ = selector => document.querySelector(selector);
const ui = {
  apiDot: $("#apiDot"), apiStatus: $("#apiStatus"), total: $("#totalCars"),
  visible: $("#visibleCars"), connection: $("#connectionLabel"), updated: $("#lastUpdated"),
  feedback: $("#feedback"), grid: $("#carsGrid"), empty: $("#emptyState"),
  search: $("#searchInput"), sort: $("#sortSelect"), dialog: $("#carDialog"), dialogContent: $("#dialogContent")
};
let cars = [];

function valueOf(car, aliases) {
  const keys = Object.keys(car || {});
  for (const alias of aliases) {
    const key = keys.find(candidate => candidate.toLowerCase() === alias.toLowerCase());
    if (key && car[key] !== null && car[key] !== undefined && car[key] !== "") return car[key];
  }
}
function fields(car) {
  return {
    id: valueOf(car, ["id","cocheId","vehicleId"]),
    brand: valueOf(car, ["marca","brand","fabricante","manufacturer"]),
    model: valueOf(car, ["modelo","model","nombre","name"]),
    year: valueOf(car, ["año","ano","year","anio"]),
    price: valueOf(car, ["precio","price","coste","cost"]),
    color: valueOf(car, ["color","colour"]),
    fuel: valueOf(car, ["combustible","fuel","tipoCombustible","fuelType"]),
    km: valueOf(car, ["kilometros","kilómetros","km","mileage"]),
    power: valueOf(car, ["potencia","power","cv","horsepower"]),
    doors: valueOf(car, ["puertas","doors"]),
    transmission: valueOf(car, ["transmision","transmisión","transmission","cambio"])
  };
}
const text = (value, fallback = "No disponible") => value === undefined ? fallback : String(value);
const escapeHtml = value => String(value).replace(/[&<>"']/g, c => ({"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#39;"}[c]));
function price(value) {
  if (value === undefined) return "Precio no disponible";
  const number = Number(String(value).replace(",", ".").replace(/[^\d.-]/g, ""));
  return Number.isFinite(number) ? new Intl.NumberFormat("es-ES",{style:"currency",currency:"EUR",maximumFractionDigits:0}).format(number) : text(value);
}
function connection(online, label) {
  ui.apiDot.className = "status-dot " + (online ? "online" : "offline");
  ui.apiStatus.textContent = label;
  ui.connection.textContent = online ? "Online" : "Offline";
}
function carArt(index) {
  const colors = ["#c4f06b","#9bb7e3","#e3aa82","#b4a2de","#d0d5df"], color = colors[index % colors.length];
  return `<svg viewBox="0 0 320 150" aria-hidden="true"><ellipse cx="160" cy="124" rx="112" ry="10" fill="#080f18" opacity=".5"/><path d="M38 103l17-37q5-12 20-16l50-17q21-7 43-3l47 9q15 3 24 17l23 35 18 9-5 23H30l-3-16z" fill="${color}" stroke="#f1f5fb" stroke-opacity=".65" stroke-width="2"/><path d="M85 62l44-15q21-7 39-4l44 9q10 2 16 12l10 17H72z" fill="#26394e" stroke="#93a5ba" stroke-width="2"/><path d="M166 44l-2 37M210 52l18 29" stroke="#8698ae" stroke-width="2"/><path d="M31 102h258" stroke="#293648" stroke-width="4"/><circle cx="86" cy="115" r="20" fill="#0a111b" stroke="#69798e" stroke-width="5"/><circle cx="86" cy="115" r="8" fill="#cbd4df"/><circle cx="240" cy="115" r="20" fill="#0a111b" stroke="#69798e" stroke-width="5"/><circle cx="240" cy="115" r="8" fill="#cbd4df"/></svg>`;
}
function render() {
  const query = ui.search.value.trim().toLocaleLowerCase("es");
  let filtered = cars.filter(car => {
    const f = fields(car);
    return [f.brand,f.model,f.year,f.color,f.fuel,f.id].some(v => v !== undefined && String(v).toLocaleLowerCase("es").includes(query));
  });
  const sort = ui.sort.value;
  if (["brand","model"].includes(sort)) filtered.sort((a,b) => text(fields(a)[sort],"").localeCompare(text(fields(b)[sort],""),"es"));
  if (sort === "priceAsc" || sort === "priceDesc") filtered.sort((a,b) => ((Number(fields(a).price)||0)-(Number(fields(b).price)||0))*(sort==="priceAsc"?1:-1));
  ui.grid.replaceChildren();
  ui.visible.textContent = String(filtered.length);
  ui.empty.classList.toggle("hidden", filtered.length > 0);
  ui.grid.classList.toggle("hidden", filtered.length === 0);
  filtered.forEach((car,index) => {
    const f = fields(car), card = document.createElement("article");
    const chips = [f.year,f.fuel,f.km !== undefined ? `${f.km} km` : undefined].filter(v=>v!==undefined).map(v=>`<span class="chip">${escapeHtml(v)}</span>`).join("");
    card.className = "card"; card.tabIndex = 0; card.setAttribute("role","button");
    card.setAttribute("aria-label",`Ver detalles de ${text(f.brand,"coche")} ${text(f.model,"")}`);
    card.innerHTML = `<div class="visual"><span class="number">VEHÍCULO ${String(index+1).padStart(2,"0")}</span><span class="id">#${escapeHtml(text(f.id,"—"))}</span>${carArt(index)}</div><div class="content"><div class="car-brand">${escapeHtml(text(f.brand,"Marca no indicada"))}</div><h3 class="car-name">${escapeHtml(text(f.model,"Modelo sin nombre"))}</h3><div class="chips">${chips || '<span class="chip">Ver detalles</span>'}</div><div class="bottom"><strong class="price">${escapeHtml(price(f.price))}</strong><span class="view">Ver ficha ↗</span></div></div>`;
    card.addEventListener("click",()=>details(car));
    card.addEventListener("keydown",event=>{if(event.key==="Enter"||event.key===" "){event.preventDefault();details(car);}});
    ui.grid.append(card);
  });
}
function details(car) {
  const f=fields(car), items=[["ID",f.id],["Marca",f.brand],["Modelo",f.model],["Año",f.year],["Precio",f.price!==undefined?price(f.price):undefined],["Color",f.color],["Combustible",f.fuel],["Kilómetros",f.km],["Potencia",f.power],["Puertas",f.doors],["Transmisión",f.transmission]].filter(([,v])=>v!==undefined);
  ui.dialogContent.replaceChildren();
  const brand=document.createElement("p");brand.className="eyebrow";brand.textContent=text(f.brand,"DETALLES DEL VEHÍCULO");
  const title=document.createElement("h2");title.className="dialog-title";title.textContent=text(f.model,"Ficha del coche");
  const grid=document.createElement("div");grid.className="dialog-grid";
  items.forEach(([label,value])=>{const box=document.createElement("div");box.className="field";const caption=document.createElement("span");caption.textContent=label;const content=document.createElement("strong");content.textContent=String(value);box.append(caption,content);grid.append(box);});
  ui.dialogContent.append(brand,title,grid);ui.dialog.showModal();
}
async function loadCars() {
  ui.feedback.className="feedback";ui.feedback.textContent="Conectando con Spring Boot…";
  ui.grid.replaceChildren();ui.empty.classList.add("hidden");
  try {
    const response=await fetch(API_URL,{headers:{"Accept":"application/json"}});
    if(!response.ok)throw new Error(`El servidor respondió con ${response.status} ${response.statusText}`);
    const data=await response.json();
    const list=Array.isArray(data)?data:Array.isArray(data.content)?data.content:Array.isArray(data.coches)?data.coches:Array.isArray(data.data)?data.data:null;
    if(!list){console.log("Respuesta recibida de la API:",data);throw new Error("La API responde, pero no se ha encontrado un listado en el JSON.");}
    cars=list;console.log("Conexión correcta. Coches recibidos:",cars);if(cars.length)console.log("Ejemplo de coche:",cars[0]);
    ui.total.textContent=String(cars.length);ui.updated.textContent="Actualizado a las "+new Date().toLocaleTimeString("es-ES",{hour:"2-digit",minute:"2-digit"});
    connection(true,"API conectada");ui.feedback.className="feedback success";ui.feedback.textContent=cars.length?`${cars.length} vehículos cargados correctamente.`:"API conectada: todavía no hay coches.";render();
  } catch(error) {
    console.error("Error al conectar con la API de coches:",error);cars=[];ui.total.textContent="—";ui.visible.textContent="0";
    connection(false,"API sin conexión");ui.feedback.className="feedback error";
    ui.feedback.textContent=`${error.message}. Comprueba Spring Boot, la URL y la configuración CORS.`;
    ui.empty.classList.remove("hidden");ui.grid.classList.add("hidden");
  }
}
ui.search.addEventListener("input",render);ui.sort.addEventListener("change",render);
$("#refreshButton").addEventListener("click",loadCars);$("#emptyRetry").addEventListener("click",loadCars);
$("#clearButton").addEventListener("click",()=>{ui.search.value="";ui.sort.value="default";render();});
document.addEventListener("keydown",event=>{if((event.metaKey||event.ctrlKey)&&event.key.toLowerCase()==="k"){event.preventDefault();ui.search.focus();}});
loadCars();