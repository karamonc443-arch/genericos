package org.karamon.poo.interfaces.vista;

import org.karamon.poo.interfaces.modelo.Producto;
import org.karamon.poo.interfaces.repositorio.CompletoRepositorio;
import org.karamon.poo.interfaces.repositorio.Direccion;
import org.karamon.poo.interfaces.repositorio.listas.ProductoListRepositorio;

import java.util.List;

public class RepositorioProducto {
    public static void main(String[] args) {
        CompletoRepositorio<Producto> productoListRepositorio = new ProductoListRepositorio();
        productoListRepositorio.crear(new Producto("Mesa", 180D));
        productoListRepositorio.crear(new Producto("Silla", 20.0));
        productoListRepositorio.crear(new Producto("Lámpara", 40D));
        productoListRepositorio.crear(new Producto("NoteBook", 3500D));
        System.out.println("===================== PRODUCTOS REGISTRADOS =====================");
        List<Producto> productos = productoListRepositorio.listar();
        productos.forEach(System.out::println);

        List<Producto> paginable = productoListRepositorio.listar(1, 3);
        System.out.println("=========================== PAGINABLE ===========================");
        paginable.forEach(System.out::println);
        System.out.println("=========================== ORDENABLE ===========================");
        List<Producto> ordenar = productoListRepositorio.listar("descripcion", Direccion.ASC);
        ordenar.forEach(System.out::println);
        System.out.println("=========================== EDITAR ===========================");
        Producto editarProducto = new Producto("NoteBook", 3250D);
        editarProducto.setId(2);
        productoListRepositorio.editar(editarProducto);
        Producto editado = productoListRepositorio.porId(2);
        System.out.println(editado);
        System.out.println("=========================== ELIMINAR PRODUCTO ===========================");
        productoListRepositorio.eliminar(2);
        productos.forEach(System.out::println);
        System.out.println("Total de registros: " + productoListRepositorio.total());


    }
}
