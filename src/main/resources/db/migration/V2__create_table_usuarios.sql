CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          rol ENUM('CONTADOR','ASISTENTE','CLIENTE') NOT NULL,
                          cliente_id BIGINT,
                          activo BOOLEAN DEFAULT TRUE,
                          fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
