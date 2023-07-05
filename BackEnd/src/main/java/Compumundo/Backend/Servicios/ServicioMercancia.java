package Compumundo.Backend.Servicios;

import Compumundo.Backend.DTO.MercanciaDTO;
import Compumundo.Backend.Entidades.Mercancia;
import Compumundo.Backend.Mapas.MercanciaMapa;
import Compumundo.Backend.Repositorios.RepositorioMercancia;
import Compumundo.Backend.Validadores.MercanciaValidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioMercancia implements ServicioBaseDTO<Mercancia,MercanciaDTO>{

    @Autowired
    private RepositorioMercancia repositorioMercancia;
    @Autowired
    private MercanciaMapa mercanciaMapa;

    @Autowired
    private MercanciaValidaciones mercanciaValidaciones;

    @Override
    @Transactional(readOnly = true)
    public List <MercanciaDTO> buscarTodos() throws Exception{
        try{
            List<MercanciaDTO>mercancias=mercanciaMapa.mapearMercancias(repositorioMercancia.findAll());

            return mercancias;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional(readOnly=true)
    public MercanciaDTO buscarPorId(Integer id) throws Exception {
        try{
            Optional<Mercancia>mercaciaOpcional=repositorioMercancia.findById(id);
            if(mercaciaOpcional.isPresent()){
                return mercaciaOpcional.get();


            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public MercanciaDTO registrar(Mercancia datosARegistrar) throws Exception {
        try {


            MercanciaDTO mercanciaGuardada = mercanciaMapa.mapearMercancia(repositorioMercancia.save(datosARegistrar));
            return mercanciaGuardada;
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }


    @Override
    public MercanciaDTO actualizar(Integer id, Mercancia datosNuevos) throws Exception {
       try{
           Optional<MercanciaDTO>mercanciaOpcional =repositorioMercancia.findById(id);
           if(mercanciaOpcional.isPresent()){
               MercanciaDTO mercanciaExistente=mercanciaOpcional.get();
               mercanciaExistente.setNombre(datosNuevos.getNombre());
               mercanciaExistente.setDescripcion(datosNuevos.getDescripcion());
               mercanciaExistente.setFecha_entrada(datosNuevos.getFecha_entrada());
               mercanciaExistente.setMotivo_devolucion(datosNuevos.getMotivo_devolucion());
               mercanciaExistente.setVolumen(datosNuevos.getVolumen());
               MercanciaDTO mercanciaActualizada=repositorioMercancia.save(mercanciaExistente);
                       return mercanciaActualizada;
           }else{
               throw new Exception("Mercancia no encontrada");
           }
       }catch(Exception error){
           throw new Exception(error.getMessage());
       }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{

            Optional<MercanciaDTO>mercanciaOpcional =repositorioMercancia.findById(id);
            if(mercanciaOpcional.isPresent()){
                repositorioMercancia.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
