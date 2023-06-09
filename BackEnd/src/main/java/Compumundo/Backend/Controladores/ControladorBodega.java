package Compumundo.Backend.Controladores;

import Compumundo.Backend.DTO.BodegaDTO.BodegaDTO;
import Compumundo.Backend.DTO.BodegaDTO.ErrorDTO;
import Compumundo.Backend.DTO.MercanciaDTO.MercanciaDTO;
import Compumundo.Backend.Entidades.Bodega;
import Compumundo.Backend.Entidades.Mercancia;
import Compumundo.Backend.Servicios.ServicioBodega;

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
@RequestMapping("api/v1/bodega")
@Tag(name="Servicio bodegas",description =  "Crud bodegas")
public class ControladorBodega {
    @Autowired
    protected ServicioBodega servicioBodega;
    @PostMapping
    @Operation(summary ="Registrar bodegas en la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode="201",description = "La bodega fue creada conrrectamente"),
            @ApiResponse(responseCode="400",description = "Error al crear la bodega")
    })
    public ResponseEntity<Bodega> registrar(@RequestBody Bodega datosAGuardar){
        try{
            Bodega BodegaRegistrada = servicioBodega.registrar(datosAGuardar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(BodegaRegistrada);
        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Bodega>>buscarTodos(){
        try{
            List<Bodega> bodegas= servicioBodega.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bodegas);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Bodega>buscarPorId(@PathVariable Integer id ) {
        try {
            Bodega bodegaEncontrada = servicioBodega.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bodegaEncontrada);

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        }
    }
    @PutMapping
    @Operation(summary = "Actualizar Bodega")
    public ResponseEntity<BodegaDTO> actualizar(@PathVariable Integer id, @RequestBody Bodega datosNuevos ){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicioBodega.actualizar(id, datosNuevos));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una mercancia de la Base de datos")
    public  ResponseEntity<Bodega> eliminar(@PathVariable Integer id){
        try{
            servicioBodega.eliminar(id);
            return ResponseEntity
                    .status(HttpStatus.OK).build();
        }  catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
