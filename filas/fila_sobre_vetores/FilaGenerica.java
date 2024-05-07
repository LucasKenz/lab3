public class FilaGenerica <E> {
    private E[] dados; // tipo genérico parametrizado
    private int primeiro;
    private int ultimo;
    private int tamanho;

    public static final int CAPACIDADE_MINIMA = 10; 

        // em java não podemos fazer instanciação de vetores de genéricos, por causa da confusão que pode ocorrer
        // o que fazer? podemos usar Reflect ( complexa )
        // Invés de E criaremos um vetor de object
    public FilaGenerica (int capacidade){
        if (capacidade > 10)
            dados = (E[]) new Object[capacidade];
        else
            dados = (E[]) new Object[CAPACIDADE_MINIMA];
        primeiro = 0;
        ultimo = dados.length -1;
        tamanho = 0;
    }
    public FilaGenerica (){
        this(CAPACIDADE_MINIMA);
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

    public void enfileira (E info){
        if(!estaCheia()) {
            ultimo = proxima(ultimo);
            dados[ultimo] = info;
            tamanho ++;
        }

    }
    public E desinfileira(){
        E info = null;
        if (!estaVazia()){
            info = dados[primeiro];
            primeiro = proxima(primeiro);
            tamanho --;
            return info;
        }
        return info;
    }

    public String toString () {
        if (estaVazia()) return "fila vazia";
        String s = "";
        int i = primeiro;
        while (i != proxima(ultimo)){
            s = s + dados[i] + "\n";
            i = proxima(i);
        }
        return s;
    }
}
