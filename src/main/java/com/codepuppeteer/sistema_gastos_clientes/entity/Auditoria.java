package com.codepuppeteer.sistema_gastos_clientes.entity;

import com.codepuppeteer.sistema_gastos_clientes.enums.AccionAuditoria;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "tabla_afectada", nullable = false, length = 50)
    private String tablaAfectada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccionAuditoria accion;

    @Column(name = "registro_id")
    private Long registroId;

    @Column(columnDefinition = "json")
    private String datosAnteriores;

    @Column(columnDefinition = "json")
    private String datosNuevos;

    @Column(name = "session_id", length = 255)
    private String sessionId;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_evento")
    private LocalDateTime fechaEvento = LocalDateTime.now();
}
