CREATE TABLE clientes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          dui VARCHAR(10) NOT NULL,
                          nit VARCHAR(20) NOT NULL,
                          empresa VARCHAR(255),
                          telefono VARCHAR(20),
                          correo VARCHAR(255) NOT NULL,
                          fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
