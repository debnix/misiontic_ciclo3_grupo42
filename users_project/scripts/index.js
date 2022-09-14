
async function get_users (url) {
  // Enviar petición
  const resp = await fetch(url, {
    method: 'GET'
  })
  const users = await resp.json();
  return users;
}

function show_users (users) {
  // Referenciar tabla
  const table = document.getElementById("table")
  let tbody = "<tbody>"
  // Iterar users
  for (let i = 0; i < users.length; i++) {
    const arrayDate = users[i].fecha_nacimiento.split("T")
    tbody += `
      <tr>
        <td>
          <img src="${users[i].foto}" />
        </td>
        <td>${users[i].nombre}</td>
        <td>${users[i].apellido}</td>
        <td>${users[i].email}</td>
        <td>${arrayDate[0]}</td>
        <td>
          <button class="btn btn-warning">Actualizar</button>
          <button class="btn btn-danger">Eliminar</button>
        </td>
      </tr>
    `
  }
  tbody += "</tbody>"
  table.innerHTML += tbody
}

async function main () {
  const url = "http://localhost:8080/personas"
  const users = await get_users(url)
  show_users(users)
}

main()