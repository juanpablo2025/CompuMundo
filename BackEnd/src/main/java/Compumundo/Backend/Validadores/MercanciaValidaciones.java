package Compumundo.Backend.Validadores;


import Compumundo.Backend.Entidades.Mercancia;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MercanciaValidaciones {

    public boolean vericarExisteMercancia(Optional<Mercancia>mercancia){
        return mercancia.isPresent();
    }
}
