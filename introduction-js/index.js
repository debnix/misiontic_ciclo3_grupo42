// Referenciar div
const div = document.getElementById('app')
// Adicionar html al elemento
div.innerHTML = "<h2>Hola mundo desde js</h2>"

div.innerHTML += "<h3>Grupo 42</h3>"
div.innerHTML += `
  <ul>
    <li>item</li>
  </ul>
`

// Usuarios
const usuarios = [
  { nombre: "Valeria", apellido: "Sanchez" },
  { nombre: "Cristian", apellido: "Martinez" },
  { nombre: "Andres", apellido: "Quintero" },
  { nombre: "Wilmar", apellido: "Muñoz" },
  { nombre: "Dario", apellido: "Peña" },
  { nombre: "Sara", apellido: "Quintana" },
  { nombre: "Juan", apellido: "hernandez" }
]

// Referenciar tabla
const tabla = document.getElementById('tabla')
tabla.innerHTML += `<tbody>`
// Iterar usuarios
for (let i = 0; i < usuarios.length; i++) {
  // Adicionar info a la tabla
  tabla.innerHTML += `
  <tr>
    <td>${usuarios[i].nombre}</td>
    <td>${usuarios[i].apellido}</td>
  </tr>
  `
}
tabla.innerHTML += `</tbody>`
