package Compumundo.Backend.Servicios;

import Compumundo.Backend.Entidades.Bodega;
import Compumundo.Backend.Repositorios.RepositorioBodega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioBodega implements ServicioBase<Bodega>{

    @Autowired
    protected RepositorioBodega repositorioBodega;

    @Override

    public List<Bodega> buscarTodos() throws Exception {
        try{

            List<Bodega>bodegas =repositorioBodega.findAll();
            return bodegas;
            }catch(Exception error){
                throw new Exception(error.getMessage());
            }

        }


    @Override
    public Bodega buscarPorId(Integer id) throws Exception {
        try{
            Optional<Bodega>bodegaOpcional =repositorioBodega.findById(id);
            if(bodegaOpcional.isPresent()){
                return bodegaOpcional.get();
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Bodega registrar(Bodega datosARegistrar) throws Exception {
        try{
            Bodega bodegaGuardado=repositorioBodega.save(datosARegistrar);
            return bodegaGuardado;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Bodega actualizar(Integer id, Bodega datosNuevos) throws Exception {
        return null;
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
