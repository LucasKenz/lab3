import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt(); // precisamos do scanner pois não há entrada, os números para testes estarão num arquivo no site
        Fila entrada = new Fila(n);
        for (int i = 1; i <= n; i++){
            entrada.enfileira(i);
        }
        Fila descartados =  new Fila(n);
        while ( entrada.getTamanho() >= 2){
            // tirar da entrada e jogar na descartadas
            descartados.enfileira(entrada.desinfileira()); // tira da entrada e joga na descartado
            // temos que jogar a proxima na primeira
            entrada.enfileira(entrada.desinfileira());

            // a parte mais importante é o print ser igual ao que ta la, maiusculo, minusculo, espaços, dois pontos, virgula, tudo igual
        }
        System.out.println("Discarded cards: " + descartados);
        System.out.println("Remaining card: " + entrada);
        sc.close();
    }
}

class Fila {
    private int[] dados;
    private int primeiro;
    private int ultimo;
    private int tamanho;

    public static final int CAPACIDADE_MINIMA = 10; // é uma constante, tudo em caixa ata
    // static indica variável de classe não de instancia, como é cada fila que eu crio, cada fila tem tamanho único mas para essa classe a capacidade mínima sempre será 10
    // classe final = não pode ser herdade
    // metodo final = não pode ser sobrescrito

    public Fila (int capacidade){
        if (capacidade > 10)
            dados = new int[capacidade];
        else
            dados = new int[CAPACIDADE_MINIMA];
        primeiro = 0;
        ultimo = dados.length -1;
        tamanho = 0;
    }
    public Fila (){
        this(CAPACIDADE_MINIMA); // Esse construtor indica que se a de cima não for chamada, essa será chamada, com os valores de cima so que com capacidade minima
    }
    public int getTamanho() {
        return tamanho;
    }
    public boolean estaVazia(){
        return tamanho == 0;
    }
    public boolean estaCheia(){
        return tamanho == dados.length;
    }
    int proxima (int posicao){
        return (posicao + 1) % dados.length;
    }
    public void enfileira (int info){
        if(!estaCheia()) {
            // se não estiver cheia fazemos: ..., não usamos estavazia pois não estar cheia é diferente de estar vazia, pode estar pela metade
            ultimo = proxima(ultimo);
            dados[ultimo] = info;
            tamanho ++;
            //perceba que por ser void, não tenho conhecimento do ponteiro de primeira posição, isso fica por conta do sistema, não esta implementado, seria diferente se o retorno fosse boolean

        }
    }
    public int desinfileira(){
        int info = -1;
        if (!estaVazia()){
            info = dados[primeiro];
            primeiro = proxima(primeiro);
            tamanho --;
            return info;
        }
        return info;
        // começamos com info -1
        // se estiver vazia não faz o if, devolve -1
        // se tem aglo, entra no if, faz a alteração e devolve a info alterada
    }

    //to string = estrutura para processar os dados, vai varrer todos os dados da estrutura, percorre tudo
    @Override
    public String toString () {
        if (estaVazia()) return "fila vazia";
        String s = "";
        int i = primeiro;
        while (i != ultimo){
            // não podemos usar <+, pois não temos mais essa comparação, já foi usada em cima
            s = s + dados[i] + ", ";
            i = proxima(i);
            // nessa situação meu i != ultimo, está errada, pois ao chegar no ultimo apra a volta sem completar a volta, então preciso olhar para a frente do ultimo  
        }
        s += dados[i]; // por que queremos o último sem vírgula e sem espaço também
        return s;
    }
    public String toStringVetor(){
        if (estaVazia()) return "_ _ _ _ _ _ _ _ _ _";
        int i;
        String s = "";
        if (primeiro<= ultimo){
            for (i=0; i < primeiro; i++){
                s += "_ ";
            }
            for ( i = primeiro; i <= ultimo; i++){
                s += dados[i] + " ";
            }
            for (i=ultimo+1; i<dados.length; i++){
                s += "_ ";
            }
        }
        else {
            for (i=0; i<=ultimo; i++){
                s +=  dados[i] + " ";
            }
            for (i=ultimo+1; i<primeiro; i++){
                s += "_ ";
            }
            for (i=primeiro; i<dados.length; i++){
                s += dados[i] + " ";
            }

        }
        return s;
    }
}