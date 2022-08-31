
// Obtener los usuarios de la apis rest
async function obtener_usuarios () {
  const uri_api = 'https://jsonplaceholder.typicode.com/users'
  //Realizar petición
  const resp = await fetch(uri_api)
  //console.log("resp-> ", resp)
  const json = await resp.json()
  //console.log("json->", json)
  return json
}

// Mostrar los usuarios en la tabla del html
function mostrar_usuarios (usuarios) {
  const tabla = document.getElementById('tabla')
  let tbody = ``
  // iterar los usuarios
  for (let i = 0; i < usuarios.length; i++) {
    tbody += `
      <tr>
        <td>${usuarios[i].id}</td>
        <td>${usuarios[i].name}</td>
        <td>${usuarios[i].username}</td>
        <td>${usuarios[i].email}</td>
        <td>${usuarios[i].address.street}</td>
        <td>${usuarios[i].website}</td>
        <td>${usuarios[i].phone}</td>
      </tr>
    `
  }
  tabla.innerHTML += tbody
}

async function main () {
  const usuarios = await obtener_usuarios()
  mostrar_usuarios(usuarios)
}

//Llamar funciones
main()