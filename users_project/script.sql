
# Consultar base de datos
SHOW DATABASES;

# Crear base de datos
CREATE DATABASE utp_grupo_42;

# Consultar tablas de la BD
SHOW TABLES;

# Crear tabla
CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(250) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    foto TEXT NOT NULL
);

# Visualizar estructura de una tabla
DESCRIBE users;