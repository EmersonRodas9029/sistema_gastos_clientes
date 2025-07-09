package com.codepuppeteer.sistema_gastos_clientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import com.codepuppeteer.sistema_gastos_clientes.enums.Prioridad;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "metas_financieras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaFinanciera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    @DecimalMin("0.01")
    private BigDecimal montoObjetivo;

    @Column(precision = 10, scale = 2)
    @DecimalMin("0.00")
    private BigDecimal montoActual = BigDecimal.ZERO;

    private LocalDate fechaLimite;

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad = Prioridad.MEDIA;

    private Boolean activa = true;

    private Boolean completada = false;

    private LocalDate fechaCompletada;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PreUpdate
    public void actualizarFechaModificacion() {
        fechaModificacion = LocalDateTime.now();
    }

}
