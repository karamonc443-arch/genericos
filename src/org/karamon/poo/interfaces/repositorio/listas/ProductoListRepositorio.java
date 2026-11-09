package org.karamon.poo.interfaces.repositorio.listas;

import org.karamon.poo.interfaces.modelo.Producto;
import org.karamon.poo.interfaces.repositorio.AbstractaListRepositorio;
import org.karamon.poo.interfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    private static int ordenar(String campo, Producto producto1, Producto producto2) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = producto1.getId().compareTo(producto2.getId());
            case "descripcion" -> resultado = producto1.getDescripcion().compareTo(producto2.getDescripcion());
            case "precio" -> resultado = producto1.getPrecio().compareTo(producto2.getPrecio());
        }
        return resultado;
    }

    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.getDataSource());
        listaOrdenada.sort((producto1, producto2) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, producto1, producto2);

            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, producto2, producto1);
            }
            return resultado;
        });
        return listaOrdenada;
    }
}
