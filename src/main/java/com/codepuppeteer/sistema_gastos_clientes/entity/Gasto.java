package com.codepuppeteer.sistema_gastos_clientes.entity;

import com.codepuppeteer.sistema_gastos_clientes.enums.MetodoPago;
import com.codepuppeteer.sistema_gastos_clientes.enums.Frecuencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "gastos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(nullable = false, precision = 10, scale = 2)
    @DecimalMin("0.01")
    private BigDecimal monto;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago = MetodoPago.EFECTIVO;

    private Boolean esRecurrente = false;

    @Enumerated(EnumType.STRING)
    private Frecuencia frecuencia;

    private String adjunto;

    private Boolean activo = true;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PreUpdate
    public void actualizarFechaModificacion() {
        fechaModificacion = LocalDateTime.now();
    }
}
