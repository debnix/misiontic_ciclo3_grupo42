
/**
 * VARIABLES
 */

const numero = 5
let mensaje = "Hola mundo"
mensaje = "Hola mundo desde misión tic"
var suma = 5 + 10
let arreglo = [5, 10, 20, 40, 50]

for (let i = 0; i < arreglo.length; i++) {
  let e = arreglo[i]
  //Imprimir en consola
  console.log(e)
}

//Objeto

let persona = {
  nombre: "Andrea",
  apellido: "Medina",
  edad: 28,
  telefono: "3123456789"
}
console.log(persona)
//Acceder a valores del objeto
let nombre = persona.nombre
console.log("nombre: " + nombre)
let apellido = persona["apellido"]
console.log("apellido: " + apellido)


/**
 * Funciones
 */
function saludar () {
  console.log("Hola mundo desde una función")
}

saludar()

function multiplicar (n1, n2) {
  return n1 * n2
}

let result = multiplicar(5, 10)
console.log("Resultado: " + result)

function mostrar_info (persona) {
  //Obtener los valores del objeto
  let values = Object.values(persona)
  console.log(values)
  for (let i = 0; i < values.length; i++) {
    console.log(values[i])
  }
}