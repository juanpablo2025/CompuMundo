package Compumundo.Backend.Repositorios;

import Compumundo.Backend.Entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMercancia extends JpaRepository<Mercancia,Integer>{

}

