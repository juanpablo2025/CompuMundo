package Compumundo.Backend.Servicios;

import Compumundo.Backend.DTO.BodegaDTO.BodegaDTO;
import Compumundo.Backend.DTO.MercanciaDTO.MercanciaDTO;
import Compumundo.Backend.Entidades.Bodega;
import Compumundo.Backend.Entidades.Mercancia;
import Compumundo.Backend.Mapas.BodegaMapa;
import Compumundo.Backend.Repositorios.RepositorioBodega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioBodega implements ServicioBaseDTO<Bodega,BodegaDTO>{

    @Autowired
    private RepositorioBodega repositorioBodega;

    @Autowired
    private BodegaMapa bodegaMapa;

    @Override

    public List<BodegaDTO> buscarTodos() throws Exception {
        try{

            List<Bodega>bodegas =repositorioBodega.findAll();
            return bodegas;
            }catch(Exception error){
                throw new Exception(error.getMessage());
            }

        }


    @Override
    public BodegaDTO buscarPorId(Integer id) throws Exception {
        try{
            Optional<Bodega>bodegaOpcional =repositorioBodega.findById(id);
            if(bodegaOpcional.isPresent()){
                return bodegaOpcional.get();
            }else{
                throw new Exception("Bodega no encontrada");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Bodega registrar(Bodega datosARegistrar) throws Exception {
        try{


            Bodega bodegaGuardada=repositorioBodega.save(datosARegistrar);


            return bodegaGuardada;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public BodegaDTO actualizar(Integer id, Bodega datosNuevos) throws Exception {
        try {


            Optional<Bodega> bodegaOpcional = repositorioBodega.findById(id);
            BodegaDTO bodega = bodegaMapa.mapearBodega(datosNuevos);
            if (bodegaOpcional.isPresent()) {
                Bodega bodegaExistente = bodegaOpcional.get();
                mercanciaExistente.setNombre(datosNuevos.getNombre());
                mercanciaExistente.setDescripcion(datosNuevos.getDescripcion());
                mercanciaExistente.setFecha_entrada(datosNuevos.getFecha_entrada());
                mercanciaExistente.setMotivo_devolucion(datosNuevos.getMotivo_devolucion());
                mercanciaExistente.setVolumen(datosNuevos.getVolumen());

                return bodegaMapa.mapearBodega(repositorioBodega.save(datosNuevos));
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

            Optional<Bodega>acudienteOpcional =repositorioBodega.findById(id);
            if(acudienteOpcional.isPresent()){
                repositorioBodega.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
