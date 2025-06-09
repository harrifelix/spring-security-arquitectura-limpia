package com.gco.producto.infraestructura;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.gco.producto.aplicacion.comando.*;
import com.gco.producto.testdatabuilder.*;


/**
 * PRUEBAS DE INTEGRACION
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorProductoTest {

    public static final String NOMBRE_PRODUCTO = "ARROZ";
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllProductos() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/producto")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getByNombre() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/producto/byNombre/{nombre}","ARROZ")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
         .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(NOMBRE_PRODUCTO));
    }

    @Test
    public void getById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/producto/byId/{id}","1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(NOMBRE_PRODUCTO));
    }

    @Test
    public void getByCodigo() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/producto/byCodigo/{codigo}","X")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(NOMBRE_PRODUCTO));
    }

    @Test
    public void getByCategoria() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/producto/byCategoria/{categoria}","X")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(NOMBRE_PRODUCTO));
    }
}
