package org.karamon.poo.genericos;

import org.karamon.poo.interfaces.modelo.Cliente;
import org.karamon.poo.interfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Karamon", "Cherif"));

        Cliente[] clientesArreglo = {new Cliente("Luci", "Martinez"),
                new Cliente("Karamon", "Cherif")};

        Integer[] enterosArreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Cliente> clienteList = fromArrayToList(clientesArreglo);
        List<Integer> enterosList = fromArrayToList(enterosArreglo);

        clienteList.forEach(System.out::println);
        enterosList.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Karamon", "Pepe", "Luci", "Bea", "John"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumList = fromArrayToList(new ClientePremium[]{new ClientePremium("Paco", "Fernández")});

        imprimirClientes(clientes);
        imprimirClientes(clienteList);
        imprimirClientes(clientePremiumList);

        System.out.println("Máximo de 1,9 y 4 es: " + max(1, 9, 4));
        System.out.println("Máximo de 3.9, 11.6, 7.78 es: " + max(3.9D, 11.6D, 7.78D));
        System.out.println("Máximo de zanahoria, arándanos, manzana es: " + max("zanahoria", "arándanos", "manzana"));

    }

    private static <T> List<T> fromArrayToList(T[] clientes) {
        return Arrays.asList(clientes);
    }


    private static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] clientes) {
        return Arrays.asList(clientes);
    }

    private static <T extends Number> List<T> fromArrayToList(T[] clientes) {
        return Arrays.asList(clientes);
    }

    private static <T, G> List<T> fromArrayToList(T[] clientes, G[] genericos) {
        for (G generico : genericos) {
            System.out.println(generico);
        }
        return Arrays.asList(clientes);
    }

    private static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    private static <T extends Comparable<T>> T max(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
