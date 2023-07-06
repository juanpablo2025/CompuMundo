package Compumundo.Backend.Servicios;


import Compumundo.Backend.DTO.MercanciaDTO.MercanciaDTO;
import Compumundo.Backend.DTO.MercanciaDTO.MercanciaRequestDTO;
import Compumundo.Backend.Entidades.Bodega;
import Compumundo.Backend.Entidades.Mercancia;
import Compumundo.Backend.Mapas.MercanciaMapa;
import Compumundo.Backend.Repositorios.RepositorioBodega;
import Compumundo.Backend.Repositorios.RepositorioMercancia;
import Compumundo.Backend.Validadores.MercanciaValidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioMercancia implements ServicioBaseDTO<Mercancia, MercanciaDTO> {
    @Autowired
    private RepositorioMercancia repositorioMercancia;
    @Autowired
    private MercanciaMapa mercanciaMapa;

    @Autowired
    private RepositorioBodega repositorioBodega;

    @Autowired
    private MercanciaValidaciones mercanciaValidaciones;
    @Override
    public List <MercanciaDTO> buscarTodos() throws Exception{
        try{
            List<MercanciaDTO>mercancias=mercanciaMapa.mapearMercancias(repositorioMercancia.findAll());

            return mercancias;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override

    public MercanciaDTO buscarPorId(Integer id) throws Exception {
        try{
            Optional<Mercancia>mercaciaOpcional=repositorioMercancia.findById(id);
            if(mercaciaOpcional.isPresent()){
                return  mercanciaMapa.mapearMercancia(mercaciaOpcional.get());


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
            MercanciaDTO mercanciaGuardada = mercanciaMapa.mapearMercancia(datosARegistrar);
            System.out.println(mercanciaGuardada);
            Optional<Bodega>  bodega= repositorioBodega.findById(datosARegistrar.getId());
            if(bodega.isPresent()){
                Bodega bodegas = bodega.get();
                if(bodegas.getEspacioDisponible()+mercanciaGuardada.getVolumen()>bodegas.getEspacioTotal()){
                    throw new Exception("El volumen supera el espacio permitido");
                }else {
                    bodegas.setEspacioDisponible(bodegas.getEspacioDisponible() + mercanciaGuardada.getVolumen());
                    repositorioBodega.save(bodegas);
                    return mercanciaMapa.mapearMercancia(repositorioMercancia.save(datosARegistrar));
                }
            }else throw new Exception("La bodega no existe");

        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }


    @Override
    public MercanciaDTO actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        try {


            Optional<Mercancia> mercanciaOpcional = repositorioMercancia.findById(id);
            MercanciaDTO mercancia = mercanciaMapa.mapearMercancia(datosNuevos);
            if (mercanciaOpcional.isPresent()) {
                Mercancia mercanciaExistente = mercanciaOpcional.get();
                mercanciaExistente.setNombre(datosNuevos.getNombre());
                mercanciaExistente.setDescripcion(datosNuevos.getDescripcion());
                mercanciaExistente.setFecha_entrada(datosNuevos.getFecha_entrada());
                mercanciaExistente.setMotivo_devolucion(datosNuevos.getMotivo_devolucion());
                mercanciaExistente.setVolumen(datosNuevos.getVolumen());

                return mercanciaMapa.mapearMercancia(repositorioMercancia.save(datosNuevos));
            } else {
                throw new Exception("Mercancia no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }



    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{

            Optional<Mercancia> mercanciaOpcional =repositorioMercancia.findById(id);
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
