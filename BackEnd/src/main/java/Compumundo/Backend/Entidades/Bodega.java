package Compumundo.Backend.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name="bodega")
public class Bodega {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Integer id;

    @Column(name="ControlEntrada",nullable = false, length =50 )
    private String ControEntrada;

    @Column(name="ControlSalida",nullable = false, length =50 )
    private String ControlSalida;

    @Column(name="Ubicacion",nullable = false, length =50 )
    private String Ubicacion;

    public Bodega(Integer id, String controEntrada, String controlSalida, String ubicacion) {
        this.id = id;
        ControEntrada = controEntrada;
        ControlSalida = controlSalida;
        Ubicacion = ubicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getControEntrada() {
        return ControEntrada;
    }

    public void setControEntrada(String controEntrada) {
        ControEntrada = controEntrada;
    }

    public String getControlSalida() {
        return ControlSalida;
    }

    public void setControlSalida(String controlSalida) {
        ControlSalida = controlSalida;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }
}