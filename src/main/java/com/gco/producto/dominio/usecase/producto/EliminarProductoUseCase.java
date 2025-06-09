package com.gco.producto.dominio.usecase.producto;


import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;

@Component
public class EliminarProductoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public EliminarProductoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public void ejecutar(String id) {
        this.repositorioProductoGateway.eliminar(id);
    }
}
