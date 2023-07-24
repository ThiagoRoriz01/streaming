package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main (String[] args) {
        Filme meuFilme = new Filme("SpiderVerse", 2023);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(6);
        meuFilme.avalia(7);
        meuFilme.avalia(8.1);
        System.out.println("Total de avaliações: " + meuFilme.getTotalAvaliacoes());
        System.out.println(meuFilme.pegaMedia());
        //meuFilme.somaAvaliacoes = 10;
        //meuFilme.totalAvaliacoes = 1;
        //System.out.println(meuFilme.pegaMedia());

        Serie mentalist = new Serie("The mentalist", 2008);
        mentalist.exibeFichaTecnica();
        mentalist.setTemporadas(7);
        mentalist.setEpisodioPorTemporada(24);
        mentalist.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar o  Mentalist: " + mentalist.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Facing the giants", 2010);
        outroFilme.setDuracaoEmMinutos(190);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(outroFilme);
        calculadora.inclui(meuFilme);
        calculadora.inclui(mentalist);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(mentalist);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoThi = new Filme("God's not dead", 2014);
        filmeDoThi.setDuracaoEmMinutos(200);
        //filmeDoThi.setNome("God's not dead");
        filmeDoThi.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(filmeDoThi);
        System.out.println("tamanho da lista " + listaDeFilmes.size());
        System.out.println("primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println("Lista inteira " + listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());

    }
}
