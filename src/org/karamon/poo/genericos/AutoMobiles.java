package org.karamon.poo.genericos;

import org.karamon.poo.genericos.clasegenerica.Animal;
import org.karamon.poo.genericos.clasegenerica.Automovil;
import org.karamon.poo.genericos.clasegenerica.Camion;
import org.karamon.poo.genericos.clasegenerica.Maquinaria;

public class AutoMobiles {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.addObjeto(new Animal("Peregrino", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Grillo", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Trunquen", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Topo calma", "Caballo"));
        transporteCaballos.addObjeto(new Animal("Longo toma", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transporteMaquinas = new Camion<>(3);
        transporteMaquinas.addObjeto(new Maquinaria("Bulldozer"));
        transporteMaquinas.addObjeto(new Maquinaria("Grúa Horquilla"));
        transporteMaquinas.addObjeto(new Maquinaria("Perforadora"));
        imprimirCamion(transporteMaquinas);

        Camion<Automovil> transporteAutos = new Camion<>(3);
        transporteAutos.addObjeto(new Automovil("Toyota"));
        transporteAutos.addObjeto(new Automovil("Mitsubishi"));
        transporteAutos.addObjeto(new Automovil("Chevrolet"));
        imprimirCamion(transporteAutos);

    }

    private static <T> void imprimirCamion(Camion<T> camion) {
        for (T generico : camion) {
            if (generico instanceof Animal) {
                System.out.println(((Animal) generico).getNombre() + " tipo: " + ((Animal) generico).getTipo());
            } else if (generico instanceof Automovil) {
                System.out.println(((Automovil) generico).getMarca());
            } else if (generico instanceof Maquinaria) {
                System.out.println(" tipo: " + ((Maquinaria) generico).getTipo());
            }
        }
    }
}
