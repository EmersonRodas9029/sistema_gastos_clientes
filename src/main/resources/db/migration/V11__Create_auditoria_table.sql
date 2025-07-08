CREATE TABLE auditoria (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           usuario_id BIGINT,
                           tabla_afectada VARCHAR(50) NOT NULL,
                           accion ENUM('INSERT', 'UPDATE', 'DELETE', 'LOGIN', 'LOGOUT', 'LOGIN_FAILED') NOT NULL,
                           registro_id BIGINT,
                           datos_anteriores JSON,
                           datos_nuevos JSON,
                           session_id VARCHAR(255),
                           user_agent TEXT,
                           descripcion TEXT,
                           fecha_evento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE SET NULL
);
