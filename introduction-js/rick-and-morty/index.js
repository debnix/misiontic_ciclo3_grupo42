
async function obtener_personajes (url_api) {
  // Enviar petición Get
  const resp = await fetch(url_api, {
    method: 'GET' //, 'POST', 'PUT', 'DELETE'
  })
  const data = await resp.json()
  //console.log(data.results)
  return data.results
}

function mostrar_personajes (personajes) {
  let cards = ''
  for (let i = 0; i < personajes.length; i++) {
    // template string
    cards += `
      <article class="card">
				<img src="https://rickandmortyapi.com/api/character/avatar/1.jpeg" />
				<div class="body-card">
						<h2>Rick Sanchez</h2>
						<span>Alive - Human</span>
						<span>Gender: Male</span>
						<span>Location: Earth</span>
						<span>Origin: Earth</span>
				</div>
			</article>
    `
  }
  // Adicionar las tarjetas al section
  document.getElementById('section-cards').innerHTML = cards
}


async function main () {
  const url = "https://rickandmortyapi.com/api/character"
  const personajes = await obtener_personajes(url)
  mostrar_personajes(personajes)
}

main()