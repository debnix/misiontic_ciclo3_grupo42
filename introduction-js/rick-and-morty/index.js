
async function obtener_personajes (url_api) {
  // Enviar petición Get
  const resp = await fetch(url_api, {
    method: 'GET' //, 'POST', 'PUT', 'DELETE'
  })
  const data = await resp.json()
  console.log(data.results)
}


function main () {
  const url = "https://rickandmortyapi.com/api/character"
  obtener_personajes(url)
}

main()