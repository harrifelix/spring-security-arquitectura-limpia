package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ObtenerProductoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public Producto ejecutar(String id) {
        return this.repositorioProductoGateway.obtenerById(id);
    }
}
