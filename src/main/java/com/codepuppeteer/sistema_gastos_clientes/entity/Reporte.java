package com.codepuppeteer.sistema_gastos_clientes.entity;

import com.codepuppeteer.sistema_gastos_clientes.enums.TipoReporte;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "contador_id")
    private Usuario contador;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_reporte", nullable = false)
    private TipoReporte tipoReporte;

    @Column(name = "periodo_inicio", nullable = false)
    private LocalDate periodoInicio;

    @Column(name = "periodo_fin", nullable = false)
    private LocalDate periodoFin;

    @Column(columnDefinition = "json")
    private String contenido;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;

    @Column(name = "fecha_generacion")
    private LocalDateTime fechaGeneracion = LocalDateTime.now();
}
