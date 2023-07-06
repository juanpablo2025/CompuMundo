package Compumundo.Backend.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="mercancia")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "fecha de entrada", nullable = false, length = 50)
    private String fecha_entrada;

    @Column(name = "motivo devolucion", nullable = false, length = 100)
    private String motivo_devolucion;

    @Column(name = "volumen", nullable = false, length = 50)
    private Double volumen;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bodega bodega;

    @Transient/*se utiliza para indicarle a JPA que un atributo de una Entidad no debe de ser persistente*/
    private String mensajeError;


    public Mercancia() {
    }

    public Mercancia(Integer id, String nombre, String descripcion, String fecha_entrada, String motivo_devolucion, Double volumen, Bodega bodega) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_entrada = fecha_entrada;
        this.motivo_devolucion = motivo_devolucion;
        this.volumen = volumen;
        this.bodega = bodega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getMotivo_devolucion() {
        return motivo_devolucion;
    }

    public void setMotivo_devolucion(String motivo_devolucion) {
        this.motivo_devolucion = motivo_devolucion;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
