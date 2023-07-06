package Compumundo.Backend.DTO.BodegaDTO;

import Compumundo.Backend.Entidades.Mercancia;

import java.util.List;

public class BodegaDTO {
 private int Id;

    private Double espacioDisponible;


    private Double espacioTotal;


    private String ubicacion;



    private List<Mercancia> mercancia;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(List<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }
}
