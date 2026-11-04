const API_BASE_URL = window.API_BASE_URL.replace(/\/$/, "");
const listElement = document.getElementById("disco-list");
const form = document.getElementById("disco-form");
const message = document.getElementById("form-message");

async function request(path = "", options = {}) {
    const response = await fetch(`${API_BASE_URL}/api/discos${path}`, {
        ...options,
        headers: { "Content-Type": "application/json", ...(options.headers || {}) }
    });

    if (!response.ok) {
        let detail = `Error ${response.status}`;
        try {
            const body = await response.json();
            detail = body.message || detail;
        } catch (_) {}
        throw new Error(detail);
    }

    if (response.status === 204) return null;
    return response.json();
}

function escapeHtml(value) {
    return String(value ?? "").replace(/[&<>"']/g, character => ({
        "&": "&amp;", "<": "&lt;", ">": "&gt;", '"': "&quot;", "'": "&#039;"
    })[character]);
}

function renderDiscos(discos) {
    document.getElementById("total-count").textContent = discos.length;
    document.getElementById("list-caption").textContent =
        discos.length === 1 ? "1 álbum en tu colección" : `${discos.length} álbumes en tu colección`;

    if (!discos.length) {
        listElement.innerHTML = '<div class="empty-state"><span>♫</span><strong>Tu colección empieza aquí</strong><p>Añade tu primer disco con el formulario de arriba.</p></div>';
        return;
    }

    listElement.innerHTML = discos.map(disco => `
        <article class="disco-card">
            <div class="album-art" aria-hidden="true">♫</div>
            <div class="disco-info">
                <h4>${escapeHtml(disco.titulo)}</h4>
                <p>${escapeHtml(disco.artista)}</p>
                <span>${disco.lanzamiento ? escapeHtml(disco.lanzamiento) : "Año no indicado"}</span>
            </div>
            <button class="delete-button" type="button" data-id="${disco.id}" aria-label="Eliminar ${escapeHtml(disco.titulo)}" title="Eliminar disco">×</button>
        </article>
    `).join("");
}

async function loadDiscos() {
    listElement.innerHTML = '<div class="empty-state">Cargando colección…</div>';
    try {
        const discos = await request();
        renderDiscos(discos);
    } catch (error) {
        listElement.innerHTML = `<div class="error-state"><strong>No se ha podido cargar la biblioteca.</strong><p>${escapeHtml(error.message)}</p><p>Comprueba que el backend está encendido y que config.js tiene su URL correcta.</p></div>`;
        document.getElementById("list-caption").textContent = "Sin conexión";
    }
}

form.addEventListener("submit", async event => {
    event.preventDefault();
    message.textContent = "";
    const submitButton = form.querySelector('button[type="submit"]');
    submitButton.disabled = true;

    const lanzamientoValue = form.elements.lanzamiento.value;
    const disco = {
        titulo: form.elements.titulo.value.trim(),
        artista: form.elements.artista.value.trim(),
        lanzamiento: lanzamientoValue ? Number(lanzamientoValue) : null
    };

    try {
        await request("", { method: "POST", body: JSON.stringify(disco) });
        form.reset();
        message.textContent = "Disco guardado correctamente.";
        await loadDiscos();
    } catch (error) {
        message.textContent = error.message || "No se ha podido guardar el disco.";
    } finally {
        submitButton.disabled = false;
    }
});

listElement.addEventListener("click", async event => {
    const button = event.target.closest(".delete-button");
    if (!button) return;
    if (!confirm("¿Quieres eliminar este disco de tu colección?")) return;

    button.disabled = true;
    try {
        await request(`/${button.dataset.id}`, { method: "DELETE" });
        await loadDiscos();
    } catch (error) {
        alert(error.message);
        button.disabled = false;
    }
});

document.getElementById("refresh-button").addEventListener("click", loadDiscos);
loadDiscos();
