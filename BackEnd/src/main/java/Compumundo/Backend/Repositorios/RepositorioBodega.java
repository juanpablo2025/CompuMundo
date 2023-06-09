package Compumundo.Backend.Repositorios;

import Compumundo.Backend.Entidades.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioBodega extends JpaRepository<Bodega,Integer> {
}
