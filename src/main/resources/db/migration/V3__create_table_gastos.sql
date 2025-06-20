CREATE TABLE gastos (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        fecha DATE NOT NULL,
                        monto DECIMAL(10,2) NOT NULL,
                        descripcion TEXT,
                        categoria VARCHAR(100),
                        archivo_url VARCHAR(255),
                        cliente_id BIGINT,
                        usuario_id BIGINT,
                        FOREIGN KEY (cliente_id) REFERENCES clientes(id),
                        FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
