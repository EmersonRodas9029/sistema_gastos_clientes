package com.codepuppeteer.sistema_gastos_clientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorias", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cliente_id", "nombre"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false)
    @NotBlank
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 7)
    private String color = "#3498db";

    private String icono = "category";

    @Column(precision = 10, scale = 2)
    private BigDecimal presupuestoMensual = BigDecimal.ZERO;

    private Boolean activa = true;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PreUpdate
    public void actualizarFechaModificacion() {
        fechaModificacion = LocalDateTime.now();
    }
}
