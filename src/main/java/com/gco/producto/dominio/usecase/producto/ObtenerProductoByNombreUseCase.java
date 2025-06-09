package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByNombreUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ObtenerProductoByNombreUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioProductoGateway.obtenerByNombre(isbn);
    }
}
