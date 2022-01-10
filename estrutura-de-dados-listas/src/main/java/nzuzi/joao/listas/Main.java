package nzuzi.joao.listas;

import nzuzi.joao.listas.lista.circulares.ListaCirculares;
import nzuzi.joao.listas.lista.duplamente.encadeada.ListaDuplamenteEncadeada;
import nzuzi.joao.listas.lista.encadeada.ListaEncadeada;

public class Main {

    public static void main(String[] args) {
        ListaEncadeada<String> nomes = new ListaEncadeada<String>();
        nomes.add("José");
        nomes.add("Joaquim");
        nomes.add("Maria");
        nomes.add("Marta");
        nomes.add("Natanael");

        System.out.println("Lista encadeada\n" +nomes);
        System.out.println(nomes.get(0));
        System.out.println(nomes.get(1));
        System.out.println(nomes.get(2));
        System.out.println(nomes.get(4));

        System.out.println(nomes.remove(3));
        System.out.println(nomes);

        System.out.println("\n===========================\n");

        ListaDuplamenteEncadeada<String> names = new ListaDuplamenteEncadeada<String>();
        names.add("Abreu");
        names.add("Amadeu");
        names.add("Armando");
        names.add("Arcanjo");
        names.add("André");

        System.out.println("Lista duplamente encadeada\n" +names);
        names.remove(2);
        names.add(2, "Adão");
        System.out.println(names);

        System.out.println("\n===========================\n");
        ListaCirculares<String> nombres = new ListaCirculares<String>();
        nombres.add("Juanito");
        System.out.println("Lista circular\n" +nombres);
        nombres.remove(0);
        nombres.add("Juan");
        System.out.println(nombres);
        nombres.add("Andrés");
        nombres.add("Gonzáles");
        nombres.add("Bartomeu");
        System.out.println(nombres);
    }

}
