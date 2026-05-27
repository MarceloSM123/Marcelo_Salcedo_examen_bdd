
-- PARTE 1: PostgreSQL Básico y Manipulación de Datos


-- CREAR BASE DE DATOS
CREATE DATABASE examen_vuelos;

-- CREAR TABLA vuelos

CREATE TABLE vuelos (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    origen VARCHAR(50) NOT NULL,
    fecha_salida TIMESTAMP NOT NULL,
    asientos_totales INTEGER NOT NULL CHECK (asientos_totales > 0),
    asientos_disponibles INTEGER NOT NULL CHECK (asientos_disponibles >= 0),
    precio_boleto DECIMAL(10,2) NOT NULL CHECK (precio_boleto > 0)
);

-- se añade la columna destino
ALTER TABLE vuelos ADD COLUMN destino VARCHAR(100);


