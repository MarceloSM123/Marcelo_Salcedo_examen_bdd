
-- PARTE 4: RELACIONES MUCHOS A MUCHOS

CREATE DATABASE examen_relaciones;


CREATE TABLE proyectos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dias_estimados INTEGER NOT NULL CHECK (dias_estimados > 0)
);

CREATE TABLE tecnologias (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    categoria VARCHAR(30) NOT NULL
);


-- TABLA DE ROMPIMIENTO


CREATE TABLE proyectos_tecnologias (
    id_proyecto INTEGER NOT NULL,
    id_tecnologia INTEGER NOT NULL,
    version_utilizada VARCHAR(20),
    PRIMARY KEY (id_proyecto, id_tecnologia),
    CONSTRAINT fk_proyecto FOREIGN KEY (id_proyecto) REFERENCES proyectos(id) ON DELETE CASCADE,
    CONSTRAINT fk_tecnologia FOREIGN KEY (id_tecnologia) REFERENCES tecnologias(id) ON DELETE CASCADE
);


INSERT INTO proyectos (nombre, dias_estimados) VALUES
('Sistema Bancario', 120),
('E-commerce App', 90),
('API de Reservas', 60),
('Dashboard Analytics', 45),
('CRM Empresarial', 150);

INSERT INTO tecnologias (nombre, categoria) VALUES
('Java', 'Backend'),
('Spring Boot', 'Backend'),
('PostgreSQL', 'Base de Datos'),
('React', 'Frontend'),
('Angular', 'Frontend'),
('Python', 'Backend'),
('MongoDB', 'Base de Datos'),
('Docker', 'DevOps');

INSERT INTO proyectos_tecnologias (id_proyecto, id_tecnologia, version_utilizada) VALUES
(1, 1, '17'),      
(1, 2, '3.1'),     
(1, 3, '15'),     
(2, 4, '18'),      
(2, 5, '15'),     
(2, 6, '3.10'),   
(3, 1, '11'),      