package com.gco.producto.infraestructura.entrypoints;

import com.gco.producto.aplicacion.manejadores.producto.ManejadorCrearProducto;
import com.gco.producto.aplicacion.manejadores.movimiento.*;
import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.web.bind.annotation.*;
import com.gco.producto.aplicacion.manejadores.producto.*;

import java.util.Date;
import java.util.List;
import com.gco.producto.aplicacion.comando.*;
import org.springframework.http.ResponseEntity;
import com.gco.producto.infraestructura.entrypoints.enums.*;


@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ControladorProducto {
    private final ManejadorObtenerProductos
            manejadorObtenerProductosa;

    private final ManejadorObtenerProductoById
            manejadorObtenerProductoById;

    private final ManejadorCrearProducto manejadorCrearProducto;

    private final ManejadorEliminarProducto manejadorEliminarProducto;

    private final ManejadorActualizarProducto manejadorActualizarProducto;

    private final ManejadorObtenerProductoByCategoria manejadorObtenerByCategoriaProducto;


    private final ManejadorObtenerProductoByCodigo manejadorObtenerByCodigoProducto;


    private final ManejadorObtenerProductoByNombre manejadorObtenerByNombreProducto;

    private final ManejadorCrearMovimiento manejadorCrearMovimiento;

    public static final String FEHCA_CON_FORMATO = "dd-MM-yyyy";
    public static final String TIME_ZONE = "America/Bogota";

    public ControladorProducto(ManejadorObtenerProductos
                                       manejadorObtenerProductosa, ManejadorCrearProducto manejadorCrearProducto
            , ManejadorEliminarProducto manejadorEliminarProducto
            , ManejadorActualizarProducto manejadorActualizarProducto
            , ManejadorObtenerProductoByCategoria manejadorObtenerByCategoriaProducto
            , ManejadorObtenerProductoByCodigo manejadorObtenerByCodigoProducto
            , ManejadorObtenerProductoByNombre manejadorObtenerByNombreProducto
    , ManejadorObtenerProductoById
                                       manejadorObtenerProductoById
    ,ManejadorCrearMovimiento manejadorCrearMovimiento) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorObtenerProductosa = manejadorObtenerProductosa;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
        this.manejadorActualizarProducto = manejadorActualizarProducto;
        this.manejadorObtenerByCategoriaProducto = manejadorObtenerByCategoriaProducto;
        this.manejadorObtenerByCodigoProducto = manejadorObtenerByCodigoProducto;
        this.manejadorObtenerByNombreProducto = manejadorObtenerByNombreProducto;
        this.manejadorObtenerProductoById = manejadorObtenerProductoById;
        this.manejadorCrearMovimiento=manejadorCrearMovimiento;
    }

    @GetMapping()
    public List<Producto> obtenerProductoPrestadoById() {
        return this.manejadorObtenerProductosa.ejecutar ();
    }

    @GetMapping("byNombre/{nombre}")
    public Producto getByNombre(@PathVariable(name = "nombre") String nombre) {
        return this.manejadorObtenerByNombreProducto.ejecutar(nombre);
    }

    @GetMapping("byId/{id}")
    public Producto getById(@PathVariable(name = "id") String id) {
        return this.manejadorObtenerProductoById.ejecutar(id);
    }

    @GetMapping("byCategoria/{categoria}")
    public Producto getByCategoria(@PathVariable(name = "categoria") String categoria) {
        return this.manejadorObtenerByCategoriaProducto.ejecutar(categoria);
    }

    @GetMapping("byCodigo/{codigo}")
    public Producto getByCodigo(@PathVariable(name = "codigo") String codigo) {
        return this.manejadorObtenerByCodigoProducto.ejecutar(codigo);
    }

    @DeleteMapping("{id}")
    public void Eliminar(@PathVariable(name = "id") String id) {

        Producto producto= this.manejadorObtenerProductoById.ejecutar(id);
        this.manejadorEliminarProducto.ejecutar(id);

        agregarMovimiento(0,producto.getId(), TipoMovimientoEnum.SALIDA
                ,producto.getDescripcion() , 1,producto.getFechacreacion());
    }

    @PutMapping()
    public void actualizar(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorActualizarProducto.ejecutar(comandoProducto);
    }

    @PostMapping
    public ResponseEntity agregar(@RequestBody ComandoProducto comandoProducto) {

        this.agregarProducto(comandoProducto.getId(), comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getPrecio()
                , comandoProducto.getStock()
                , comandoProducto.getCategoria()
                , comandoProducto.getCodigo()
                , comandoProducto.getFechaCreacion());

        //Si todo va Ok  se retorna el body con su datos
        return ResponseEntity.ok(comandoProducto);
    }

    private void agregarProducto(int id, String nombre, String descripcion, double precio, int stock, String categoría, String codigo, Date fechaCreacion) {
        ComandoProducto comandoProducto = new ComandoProducto(id
                , nombre, descripcion, precio, stock, categoría, codigo, fechaCreacion);
        int idProducto=this.manejadorCrearProducto.ejecutar(comandoProducto);

        agregarMovimiento(0,idProducto, TipoMovimientoEnum.ENTRADA
        ,descripcion , 1, fechaCreacion);
    }

  private void agregarMovimiento( int id,int idProducto, TipoMovimientoEnum tipo, String descripcion, int cantidad, Date fechaCreación) {
        ComandoMovimiento comandoMovimiento = new ComandoMovimiento(id,idProducto,tipo,cantidad,fechaCreación,descripcion);
        this.manejadorCrearMovimiento.ejecutar(comandoMovimiento);

    }
}
