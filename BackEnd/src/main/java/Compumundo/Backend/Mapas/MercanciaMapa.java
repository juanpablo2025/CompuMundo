package Compumundo.Backend.Mapas;

import Compumundo.Backend.DTO.MercanciaDTO;
import Compumundo.Backend.Entidades.Mercancia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MercanciaMapa {

    @Mappings({

            @Mapping(source="nombre", target = "nombre"),
            @Mapping(source="descripcion",target="descripcion"),
            @Mapping(source="fecha_entrada",target="fechaEntrada"),
            @Mapping(source="motivo_devolucion",target="motivo"),
            @Mapping(source="volumen",target="volumen")







    })
    public MercanciaDTO mapearMercancia(Mercancia mercancia);
    public List<MercanciaDTO> mapearMercancias(List<Mercancia> mercancias);




}
