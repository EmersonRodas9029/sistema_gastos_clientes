package com.codepuppeteer.sistema_gastos_clientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "presupuestos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cliente_id", "categoria_id", "mes", "anio"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "monto_presupuestado", nullable = false, precision = 10, scale = 2)
    @DecimalMin("0.01")
    private BigDecimal montoPresupuestado;

    @Column(nullable = false)
    @Min(1)
    @Max(12)
    private Integer mes;

    @Column(nullable = false)
    @Min(2020)
    @Max(2050)
    private Integer anio;

    private Boolean activo = true;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PreUpdate
    public void actualizarFechaModificacion() {
        fechaModificacion = LocalDateTime.now();
    }
}
