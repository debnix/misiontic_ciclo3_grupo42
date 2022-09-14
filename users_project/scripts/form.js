
const URL_API = "http://localhost:8080/personas"

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
  console.table(persona)
  send_data(persona)
  clear_input(evt.target)
}

function clear_input (form) {
  form.nombre.value = ""
  form.apellido.value = ""
  form.email.value = ""
  form.fecha_nacimiento.value = ""
  form.foto.value = ""
}

async function send_data (persona) {
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
