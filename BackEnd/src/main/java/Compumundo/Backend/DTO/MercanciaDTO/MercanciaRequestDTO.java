package Compumundo.Backend.DTO.MercanciaDTO;

import Compumundo.Backend.Entidades.Bodega;

public class MercanciaRequestDTO {

    private int id;
    private String nombre;
    private String descripcion;
    private String fechaEntrada;
    private String motivo;
    private Double volumen;
    private int idbodega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public int getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(int idbodega) {
        this.idbodega = idbodega;
    }
}
