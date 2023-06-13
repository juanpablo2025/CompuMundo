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

    @Column(name="ControlEntrada",nullable = false, length =50 )
    private String ControEntrada;

    @Column(name="ControlSalida",nullable = false, length =50 )
    private String ControlSalida;

    @Column(name="Ubicacion",nullable = false, length =50 )
    private String Ubicacion;


    @OneToMany(mappedBy = "bodega")
    private List<Mercancia> mercancia;


}