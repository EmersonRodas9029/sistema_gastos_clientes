package com.codepuppeteer.sistema_gastos_clientes.entity;

import com.codepuppeteer.sistema_gastos_clientes.enums.Frecuencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "gastos_recurrentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GastoRecurrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a cero")
    @Column(nullable = false)
    private BigDecimal monto;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Frecuencia frecuencia;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "dia_mes")
    private Integer diaMes;

    @Column(name = "dia_semana")
    private Integer diaSemana;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "ultimo_procesamiento")
    private LocalDate ultimoProcesamiento;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion = LocalDate.now();

    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDate fechaModificacion = LocalDate.now();

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = LocalDate.now();
    }
}
