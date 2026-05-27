
-- PARTE 1: PostgreSQL Básico y Manipulación de Datos


-- CREAR BASE DE DATOS
CREATE DATABASE examen_vuelos;

-- CREAR TABLA vuelos

CREATE TABLE vuelos (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    origen VARCHAR(50) NOT NULL,
    destino VARCHAR(50) NOT NULL,
    fecha_salida TIMESTAMP NOT NULL,
    asientos_totales INTEGER NOT NULL CHECK (asientos_totales > 0),
    asientos_disponibles INTEGER NOT NULL CHECK (asientos_disponibles >= 0),
    precio_boleto DECIMAL(10,2) NOT NULL CHECK (precio_boleto > 0)
);

--INSERTAR 20 REGISTROS (Generados con IA)

INSERT INTO vuelos (codigo, origen, destino, fecha_salida, asientos_totales, asientos_disponibles, precio_boleto) VALUES
('AA-101', 'Bogotá', 'Medellín', '2025-06-01 08:00:00', 150, 45, 250.00),
('AA-102', 'Medellín', 'Bogotá', '2025-06-01 10:30:00', 150, 120, 230.00),
('LA-201', 'Bogotá', 'Cali', '2025-06-01 14:00:00', 120, 8, 180.00),
('LA-202', 'Cali', 'Bogotá', '2025-06-01 16:30:00', 120, 95, 175.00),
('AV-301', 'Bogotá', 'Cartagena', '2025-06-02 06:00:00', 180, 3, 350.00),
('AV-302', 'Cartagena', 'Bogotá', '2025-06-02 09:00:00', 180, 60, 340.00),
('AA-103', 'Bogotá', 'Santa Marta', '2025-06-02 11:00:00', 130, 0, 320.00),
('LA-203', 'Santa Marta', 'Bogotá', '2025-06-02 14:00:00', 130, 55, 310.00),
('AV-303', 'Bogotá', 'Buenos Aires', '2025-06-03 23:00:00', 200, 150, 850.00),
('AA-104', 'Buenos Aires', 'Bogotá', '2025-06-04 06:00:00', 200, 180, 820.00),
('LA-204', 'Bogotá', 'Lima', '2025-06-03 07:00:00', 160, 4, 450.00),
('AV-304', 'Lima', 'Bogotá', '2025-06-03 11:00:00', 160, 90, 430.00),
('AA-105', 'Bogotá', 'Miami', '2025-06-04 09:00:00', 220, 25, 1200.00),
('LA-205', 'Miami', 'Bogotá', '2025-06-04 14:00:00', 220, 110, 1150.00),
('AV-305', 'Bogotá', 'Madrid', '2025-06-05 22:00:00', 280, 200, 1800.00),
('AA-106', 'Madrid', 'Bogotá', '2025-06-06 08:00:00', 280, 250, 1750.00),
('LA-206', 'Bogotá', 'Ciudad de México', '2025-06-05 10:00:00', 190, 2, 950.00),
('AV-306', 'Ciudad de México', 'Bogotá', '2025-06-05 15:00:00', 190, 85, 920.00),
('AA-107', 'Bogotá', 'Quito', '2025-06-06 07:00:00', 100, 0, 280.00),
('LA-207', 'Quito', 'Bogotá', '2025-06-06 10:00:00', 100, 40, 270.00);

--CONSULTAS 
-- 1. Alerta de Vuelo Lleno
SELECT * FROM vuelos WHERE asientos_disponibles < 5;

-- 2. Incremento de Tarifas
UPDATE vuelos SET precio_boleto = precio_boleto * 1.15 WHERE id = 1;

-- 3. Depuración de Rutas Canceladas
DELETE FROM vuelos WHERE asientos_disponibles = 0;
