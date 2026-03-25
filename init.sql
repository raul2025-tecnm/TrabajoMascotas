-- Script de inicialización de la base de datos de Veterinaria

CREATE TABLE mascotas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    edad INT,
    propietario VARCHAR(100) NOT NULL
);

-- CREATE (Insertar datos de prueba)
INSERT INTO mascotas (nombre, especie, raza, edad, propietario) VALUES ('Firulais', 'Perro', 'Labrador', 3, 'Juan Perez');
INSERT INTO mascotas (nombre, especie, raza, edad, propietario) VALUES ('Misi', 'Gato', 'Siamés', 2, 'Maria Lopez');
