CREATE TABLE logs (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      accion VARCHAR(255),
                      fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      usuario_id BIGINT,
                      FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
