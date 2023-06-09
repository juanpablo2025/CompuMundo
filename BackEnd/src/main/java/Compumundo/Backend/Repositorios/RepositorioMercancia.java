package Compumundo.Backend.Repositorios;

import Compumundo.Backend.Entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Mercancia,Integer>{

}

