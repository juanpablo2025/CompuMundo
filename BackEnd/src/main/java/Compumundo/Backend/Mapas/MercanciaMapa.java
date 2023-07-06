package Compumundo.Backend.Mapas;

import Compumundo.Backend.DTO.MercanciaDTO.MercanciaDTO;
import Compumundo.Backend.DTO.MercanciaDTO.MercanciaRequestDTO;
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
            @Mapping(source="volumen",target="volumen"),


            @Mapping(source="bodega",target = "bodega")





    })
    public MercanciaDTO mapearMercancia(Mercancia mercancia);
    public List<MercanciaDTO> mapearMercancias(List<Mercancia> mercancias);





    public MercanciaRequestDTO mercanciaPeticionDTO(Mercancia mercancia);
    public List<MercanciaRequestDTO>mercanciaPeticionesDTO(List<Mercancia>mercancias);

    Mercancia mercanciaEntidadRequest(MercanciaRequestDTO mercanciaRequestDTO);
    List<Mercancia> mercanciasEntidadesRequest(List<MercanciaRequestDTO> mercanciaRequestDTOS);



}
