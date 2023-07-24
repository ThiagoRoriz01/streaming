package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoLancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacoes;
    private int totalAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais" +
                    "de 04 caracteres");
        }
        this.anoLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoLancamento);
    }

    public void avalia(double nota) {
        somaAvaliacoes += nota;
        totalAvaliacoes++;
    }

    public double pegaMedia() {
        return somaAvaliacoes / totalAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(nome = " + nome +
                ", anoLancamento = " + anoLancamento + "," +
                " duração = " + duracaoEmMinutos + ")";

        //duvida respondida pelo chatGPT, "como o toString é aplicado ao objeto chamado na classe main?"
        //como eles se comunicam, em que momento são referenciados?


        /* o que voce está dizendo é que,  quando eu passar um objeto como argumento para o
        System.out.println(); se eu tiver criado um toString para esse objeto ele
        automaticamente será executado sem eu ter que fazer referencia a ele ou
        chamar ele na execução?
         */

        /* Exatamente! Quando você passa um objeto como argumento para o método
        System.out.println(), a implementação padrão do Java para esse método verifica se
        o objeto possui um método toString() definido. Se o objeto tiver um método toString()
        implementado, ele será automaticamente chamado para obter a representação em formato
        de string do objeto.
        Dessa forma, não é necessário fazer referência direta ao método toString() ou chamá-lo
        explicitamente. O Java faz isso de forma automática quando você passa o objeto para
        System.out.println() ou qualquer outra operação que espera uma representação em formato
        de string, como concatenação de strings.
        Ao implementar o método toString() na sua classe, você pode personalizar a representação
        em string do objeto, de acordo com as informações que você considerar relevantes para
        serem exibidas. Essa representação personalizada será utilizada automaticamente pelo
        System.out.println() e outras operações similares.
         */

        // e isso funciona mesmo que o toString esteja em uma classe diferente da main?


        /* Sim, funciona mesmo que o método toString() esteja em uma classe diferente da
        classe principal (classe com o método main()).
        Quando você passa um objeto como argumento para o método System.out.println(), o
        Java verifica se o objeto tem um método toString() definido. Essa verificação é feita
        independentemente de onde o método toString() esteja localizado, seja na classe principal
        ou em outra classe.
        Portanto, desde que o objeto que você está passando como argumento tenha um método toString()
        implementado, o Java invocará esse método automaticamente, independentemente de qual classe o
        método toString() esteja definido.
         */

        /* como o Java relaciona o objeto passado como argumento para o método System.out.println()
        com o metodo toString, como ele identifica qual objeto o toString se refere? */

        /* Quando você passa um objeto como argumento para o método System.out.println() ou qualquer
        outra operação que espera uma representação em formato de string, o Java utiliza o conceito
        de polimorfismo para determinar qual implementação do método toString() deve ser invocada.
        O polimorfismo permite que um objeto de uma classe mais específica seja tratado como um
        objeto de uma classe mais geral.
        Quando você passa um objeto para System.out.println(), o Java verifica o tipo do objeto em
        tempo de execução e chama o método toString() correspondente a esse tipo. Se o objeto for
        uma instância de uma classe específica que possui seu próprio método toString() implementado
        , o Java invocará o método toString() definido naquela classe específica.
        Essa identificação do objeto é possível porque o Java faz uso do polimorfismo e verifica o tipo
        real do objeto em tempo de execução para determinar qual implementação do método toString()
        deve ser usada. Isso permite que você obtenha a representação correta do objeto, mesmo que o
        método toString() esteja definido em uma classe diferente da classe principal.
         */
    }
}
