
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
				<img src="${personajes[i].image}" />
				<div class="body-card">
						<h2>${personajes[i].name}</h2>
						<span>${personajes[i].status} - ${personajes[i].species}</span>
						<span>Gender: ${personajes[i].gender}</span>
						<span>Location: ${personajes[i].location.name}</span>
						<span>Origin: ${personajes[i].origin.name}</span>
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