
const URL_API = "http://localhost:8080/personas"
const UPDATE_FLAG = {
  update: false,
  id: null
}

function get_data_form (evt) {
  // Indicar al evento que no recargue página
  evt.preventDefault()
  let persona = {
    nombre: evt.target.nombre.value,
    apellido: evt.target.apellido.value,
    email: evt.target.email.value,
    fecha_nacimiento: evt.target.fecha_nacimiento.value,
    foto: evt.target.foto.value
  }
  if (UPDATE_FLAG.update) {
    persona.id = UPDATE_FLAG.id
    update(persona)
  } else {
    create(persona)
  }
  clear_input(evt.target)
}

function clear_input (form) {
  form.nombre.value = ""
  form.apellido.value = ""
  form.email.value = ""
  form.fecha_nacimiento.value = ""
  form.foto.value = ""
}

async function create (persona) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(persona)
  })
  const text = await resp.text()
  alert(text)
}

async function update (persona) {
  persona.nombre = persona.nombre
  persona.apellido = persona.apellido
  console.table(persona)
  const resp = await fetch(URL_API, {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(persona)
  })
  const text = await resp.text()
  alert(text)
  window.location.href = "index.html"
}

function get_params_url () {
  const params = window.location.search
  if (params) {
    const url = new URLSearchParams(params)
    const persona = JSON.parse(url.get("persona"))
    console.table(persona)
    set_data_form(persona)
    document.getElementById("btn").innerText = "Actualizar"
    UPDATE_FLAG.update = true
    UPDATE_FLAG.id = persona.id
  }

}

function set_data_form (persona) {
  const arrayFecha = persona.fecha_nacimiento.split("T")
  console.log(arrayFecha)
  document.getElementById("input_nombre").setAttribute("value", persona.nombre)
  document.getElementById("input_apellido").setAttribute("value", persona.apellido)
  document.getElementById("input_email").setAttribute("value", persona.email)
  document.getElementById("input_fecha_nacimiento").setAttribute("value", arrayFecha[0])
  document.getElementById("input_foto").setAttribute("value", persona.foto)
}

get_params_url()
