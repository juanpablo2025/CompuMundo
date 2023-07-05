package Compumundo.Backend.Entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="bodega")
public class Bodega {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Integer id;


    @Column(name="espacio_disponible" )
    private Double espacioDisponible;

    @Column(name="espacio_total")
    private Double espacioTotal;

    @Column(name="Ubicacion" )
    private String Ubicacion;


    @OneToMany(mappedBy = "bodega")
    private List<Mercancia> mercancia;

    @Transient/*se utiliza para indicarle a JPA que un atributo de una Entidad no debe de ser persistente*/
    private String mensajeError;



    public Bodega() {
    }

    public Bodega(Integer id, Double espacioDisponible, Double espacioTotal, String ubicacion, List<Mercancia> mercancia) {
        this.id = id;
        this.espacioDisponible = espacioDisponible;
        this.espacioTotal = espacioTotal;
        Ubicacion = ubicacion;
        this.mercancia = mercancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(Double espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }

    public Double getEspacioTotal() {
        return espacioTotal;
    }

    public void setEspacioTotal(Double espacioTotal) {
        this.espacioTotal = espacioTotal;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public List<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(List<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}