package Compumundo.Backend.Controladores;


import Compumundo.Backend.DTO.MercanciaDTO.ErrorDTO;
import Compumundo.Backend.DTO.MercanciaDTO.MercanciaDTO;
import Compumundo.Backend.Entidades.Mercancia;
import Compumundo.Backend.Servicios.ServicioMercancia;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mercancia")
@Tag(name="Servicio mercancias",description =  "Crud mercancias")
public class ControladorMercancia {
    @Autowired
    protected ServicioMercancia servicioMercancia;
    @PostMapping
    @Operation(summary ="Registrar mercancia en la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode="201",description = "La mercania fue creada conrrectamente"),
            @ApiResponse(responseCode="400",description = "Error al crear la mercancia")
    })
    public ResponseEntity<MercanciaDTO>registrar(@RequestBody Mercancia datosAGuardar){
        try{
            MercanciaDTO mercanciaRegistrada = servicioMercancia.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(mercanciaRegistrada);
        }catch (Exception error){

            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setError(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO);
        }
    }

    @GetMapping
    public ResponseEntity<List<MercanciaDTO>>buscarTodos(){
        try{
            List<MercanciaDTO> mercancias= servicioMercancia.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancias);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<MercanciaDTO>buscarPorId(@PathVariable Integer id ) {
        try {
            MercanciaDTO mercanciaEncontrada = servicioMercancia.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaEncontrada);

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }

}
