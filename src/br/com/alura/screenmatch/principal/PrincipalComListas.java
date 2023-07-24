package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("SpiderVerse", 2023);
        meuFilme.avalia(8);
        Filme outroFilme = new Filme("Facing the giants", 2010);
        outroFilme.avalia(7);
        var filmeDoThi = new Filme("God's not dead", 2014);
        filmeDoThi.avalia(10);
        Serie mentalist = new Serie("The mentalist", 2008);

        List<Titulo> lista = new LinkedList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(filmeDoThi);
        lista.add(mentalist);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificcao() > 2) {
                System.out.println("Classificação " + (filme).getClassificcao());
            }
        }
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Denzel Washinton");
        buscaPorArtista.add("The Rock");
        buscaPorArtista.add("Robert Downey Jr");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação usando collections");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de títulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
