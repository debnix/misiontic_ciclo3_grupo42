
function get_data_form (evt) {
  // Indicar al evento que no recargue página
  evt.preventDefault()
  let persona = {
    nombre: evt.target.nombre.value,
    apellido: evt.target.apellido.value,
    email: evt.target.email.value,
    fecha_nacimiento: evt.target.fecha_nacimiento.value
  }
  console.table(persona)
}