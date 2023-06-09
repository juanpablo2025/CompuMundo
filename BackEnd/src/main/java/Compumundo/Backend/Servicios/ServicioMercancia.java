package Compumundo.Backend.Servicios;

import Compumundo.Backend.Entidades.Mercancia;
import Compumundo.Backend.Repositorios.RepositorioMercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioMercancia implements ServicioBase<Mercancia>{

    @Autowired
    private RepositorioMercancia repositorioMercancia;


    @Override
    @Transactional(readOnly = true)
    public List <Mercancia> buscarTodos() throws Exception{
        try{
            List<Mercancia>mercancias=repositorioMercancia.findAll();
            return mercancias;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Mercancia registrar(Mercancia datosARegistrar) throws Exception {
        return null;
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
