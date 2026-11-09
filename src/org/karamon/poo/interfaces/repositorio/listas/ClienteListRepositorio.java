package org.karamon.poo.interfaces.repositorio.listas;

import org.karamon.poo.interfaces.modelo.Cliente;
import org.karamon.poo.interfaces.repositorio.AbstractaListRepositorio;
import org.karamon.poo.interfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {


    private static int ordenar(String campo, Cliente cliente1, Cliente cliente2) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = cliente1.getId().compareTo(cliente2.getId());
            case "nombre" -> resultado = cliente1.getNombre().compareTo(cliente2.getNombre());
            case "apellido" -> resultado = cliente1.getApellido().compareTo(cliente2.getApellido());
        }
        return resultado;
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente editarCliente = this.porId(cliente.getId());
        editarCliente.setNombre(cliente.getNombre());
        editarCliente.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.getDataSource());
        listaOrdenada.sort((cliente1, cliente2) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, cliente1, cliente2);

            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, cliente2, cliente1);
            }
            return resultado;
        });
        return listaOrdenada;
    }

}

