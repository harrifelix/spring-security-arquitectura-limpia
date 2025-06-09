package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ObtenerProductosUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ObtenerProductosUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public List<Producto> ejecutar() {
        return this.repositorioProductoGateway.getAll();
    }
}
