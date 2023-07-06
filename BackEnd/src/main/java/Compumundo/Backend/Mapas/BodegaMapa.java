package Compumundo.Backend.Mapas;


import Compumundo.Backend.DTO.BodegaDTO.BodegaDTO;
import Compumundo.Backend.Entidades.Bodega;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BodegaMapa {

    @Mappings({

            @Mapping(source="espacioDisponible", target = "espacioDisponible"),
            @Mapping(source="espacioTotal",target="espacioTotal"),
            @Mapping(source="ubicacion",target="ubicacion"),
            @Mapping(source="mercancia",target="mercancia")

    })

    public BodegaDTO mapearBodega(Bodega bodega);
    public List<BodegaDTO>mapearBodegas(List<Bodega>bodegas);
}
