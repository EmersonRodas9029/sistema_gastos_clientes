package com.codepuppeteer.sistema_gastos_clientes.entity;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoConfiguracion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "configuraciones", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cliente_id", "clave"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Configuracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String clave;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConfiguracion tipo = TipoConfiguracion.STRING;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PreUpdate
    public void actualizarFechaModificacion() {
        this.fechaModificacion = LocalDateTime.now();
    }
}
