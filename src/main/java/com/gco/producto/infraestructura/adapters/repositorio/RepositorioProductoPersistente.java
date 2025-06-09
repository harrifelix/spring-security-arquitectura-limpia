package com.gco.producto.infraestructura.adapters.repositorio;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import com.gco.producto.infraestructura.adapters.builder.ProductoBuilder;
import com.gco.producto.infraestructura.adapters.entidad.ProductoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioProductoPersistente implements RepositorioProductoGateway {

    private static final String ID = "id";
    private static final String CODIGO = "codigo";
    private static final String NOMBRE = "nombre";
    private static final String CATEGORIA = "categoria";
    private static final String PRODUCTO_FIND_BY_ALL = "Producto.findAll";
    private static final String PRODUCTO_FIND_BY_NOMBRE = "Producto.findByNombre";
    private static final String PRODUCTO_FIND_BY_CATEGORIA = "Producto.findByCategoria";
    private static final String PRODUCTO_FIND_BY_CODIGO = "Producto.findByCodigo";
    private static final String PRODUCTO_FIND_BY_ID = "Producto.findById";
    private final EntityManager entityManager;

    public RepositorioProductoPersistente(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public int agregar(Producto producto) {
        ProductoEntity movimientoEntity = ProductoBuilder.convertirToEntity(producto);

        entityManager.persist(movimientoEntity);
        entityManager.flush();
        movimientoEntity.setId(movimientoEntity.getId());
        return movimientoEntity.getId();
    }

    @Override
    public void actualizar(Producto producto) {
        ProductoEntity movimientoEntity = ProductoBuilder.convertirToEntity(producto);
        entityManager.merge(movimientoEntity);
        entityManager.flush();
    }

    @Override
    public void eliminar(String id) {

        ProductoEntity movimientoEntity =  obtenerPrestamoEntityById(id);
        entityManager.remove(movimientoEntity);
        entityManager.flush();
    }

    @Override
    public Producto obtenerById(String id) {
        ProductoEntity movimientoEntity =  obtenerPrestamoEntityById(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Producto(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechacreacion());
    }

    @Override
    public Producto obtenerByNombre(String id) {
        ProductoEntity movimientoEntity = (ProductoEntity) obtenerProductoByNombre(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Producto(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechacreacion());
    }

    @Override
    public Producto obtenerByCodigo(String id) {
        ProductoEntity movimientoEntity = (ProductoEntity) obtenerProductoByCodigo(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Producto(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechacreacion());
    }

    @Override
    public Producto obtenerByCategoria(String id) {
        ProductoEntity movimientoEntity = (ProductoEntity) obtenerProductoByCategoria(id);

        if (movimientoEntity == null) {
            return null;
        }

        return new Producto(
                movimientoEntity.getId(), movimientoEntity.getNombre()
                , movimientoEntity.getDescripcion(), movimientoEntity.getPrecio(),movimientoEntity.getStock()
                ,movimientoEntity.getCategoria(),movimientoEntity.getCodigo(),movimientoEntity.getFechacreacion());
    }

    @Override
    public List<Producto> getAll() {
        List<ProductoEntity> productoEntity =  obtenerTodos();
        List<Producto> listProducto=new ArrayList<Producto>();
        if (productoEntity == null) {
            return null;
        }
        for (ProductoEntity p:productoEntity
        ) {
            Producto producto= new Producto(
                    p.getId(), p.getNombre()
                    , p.getDescripcion(), p.getPrecio(),p.getStock()
                    ,p.getCategoria(),p.getCodigo(),p.getFechacreacion());
            listProducto.add(producto);
        }
        return  listProducto;
    }

    /**
     * METODOS PRIVADOS
     */

    private ProductoEntity obtenerPrestamoEntityById(String id) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_ID);
        int ids = Integer.parseInt(id);
        try {
            query.setParameter(ID, ids);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (ProductoEntity) resultList.get(0) : null;
    }

    private ProductoEntity obtenerProductoByNombre(String isbn) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_NOMBRE);
        query.setParameter(NOMBRE, isbn);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (ProductoEntity) resultList.get(0) : null;
    }

    private ProductoEntity obtenerProductoByCodigo(String isbn) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_CODIGO);
        query.setParameter(CODIGO, isbn);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (ProductoEntity) resultList.get(0) : null;
    }

    private ProductoEntity obtenerProductoByCategoria(String isbn) {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_CATEGORIA);
        query.setParameter(CATEGORIA, isbn);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (ProductoEntity) resultList.get(0) : null;
    }

    private List<ProductoEntity> obtenerTodos() {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_ALL);
        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (List<ProductoEntity>) resultList: null;
    }
}
