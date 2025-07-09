package com.codepuppeteer.sistema_gastos_clientes.entity;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoCuenta;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas_bancarias", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cliente_id", "banco", "numero_cuenta"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotBlank
    @Column(nullable = false)
    private String banco;

    @NotBlank
    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false)
    private TipoCuenta tipoCuenta;

    @DecimalMin("0.00")
    @Column(name = "saldo_actual", precision = 10, scale = 2)
    private BigDecimal saldoActual = BigDecimal.ZERO;

    @Column(name = "fecha_actualizacion_saldo")
    private LocalDateTime fechaActualizacionSaldo = LocalDateTime.now();

    private Boolean activa = true;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PreUpdate
    public void actualizarFechaModificacion() {
        fechaModificacion = LocalDateTime.now();
    }
}
