
async function get_users (url) {
  // Enviar petición
  const resp = await fetch(url, {
    method: 'GET'
  })
  const users = await resp.json();
  return users;
}

async function main () {
  const url = "http://localhost:8080/personas"
  const users = await get_users(url)
  console.log(users)
}

main()