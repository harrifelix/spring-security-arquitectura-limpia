package com.gco.producto.dominio.usecase.producto;


import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;

@Component
public class ActualizarProductoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ActualizarProductoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public void ejecutar(Producto producto) {
        this.repositorioProductoGateway.actualizar(producto);
    }
}
