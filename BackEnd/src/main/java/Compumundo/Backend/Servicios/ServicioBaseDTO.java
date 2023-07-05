package Compumundo.Backend.Servicios;

import java.util.List;

public interface ServicioBaseBDTO<E,DTO> {
    List<DTO> buscarTodos() throws Exception;
    DTO buscarPorId(Integer Id) throws Exception;
}
