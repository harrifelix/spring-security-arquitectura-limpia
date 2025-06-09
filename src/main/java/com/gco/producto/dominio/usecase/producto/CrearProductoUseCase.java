package com.gco.producto.dominio.usecase.producto;


import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;

@Component
public class CrearProductoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public CrearProductoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public int ejecutar(Producto producto) {
       return this.repositorioProductoGateway.agregar(producto);
    }

}
