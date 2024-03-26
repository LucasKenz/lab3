import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Random;

public class MeuVetor {
    private double [] v;
    private int ultimaPos;

    public MeuVetor (int capacidade){
        v = new double[capacidade];
        ultimaPos = -1; 
    }

    //metedos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }

    public double[] getV(){
        return v;
    }

    public void setUltimaPos(int pos){
        if(pos >= 0 && pos < v.length){
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length-1; 
        }
    }

    public boolean estaCheio(){ 
       return ultimaPos == v.length -1;
    }

    public boolean estaVazio(){ 
        return ultimaPos == -1;
        // estar vazio quer dizer a ultima posição é -1
    }

    //redimensionar vetor não pertence a nínguem e so a classe, colocar private encapsular
    private void redimensiona(int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        //redimensionamos com o novacapacidade
            //perceba que a única coisa diferente entre os códigos de adiciona e remove é o tamanho
            // fazer a cópia
            for (int i = 0; i <=ultimaPos; i++){
                temp[i] = v[i];
            }
            v = temp;
    }
    
    public void adiciona (double e){
        // o adiciona recebe inteiro e deve mudar, para double?
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = e;
    }

    public double remove(){
        if (estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length>=10 && ultimaPos <= v.length/4){
            redimensiona(v.length/2);
        } 
        return aux;
    }

    @Override
    public String toString(){
        String s = "";
        if (estaVazio()){
            s = s + "esta vezio";
        }
        else {
            for (int i=0; i<=ultimaPos; i++){
                s = s + String.format("%.0f ", v[i]);
            }
        }
        return s + "\n";
    }
    public void bubbleSort(){
        //int cont=0;
        for (int i = 1; i < v.length; i ++){
            // conforme o i aumenta reduzo o número de comparações, que é o laço seguinte, já que é o length - i, quando i = 1, faço 0-1, 1-2, 2-3, 3-4, quando o i = 2 faço 0-1, 1-2, 2-3...
            for (int j = 0; j< v.length-i; j++){
                //cont++;
                if (v[j] > v[j+1]){
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] =aux;
                }
                // System.out.println("Passo bubble: " + i + ": " + Arrays.toString(v));
            }
        }
        //return cont;
    }
    public void selectionSort(){
        for (int i = 0; i < v.length-1; i++){
            int menor = i;
            for (int j = i+1; j < v.length; j++){
                if (v[j] > v[menor]){
                    // troquei o sinal de < para > para desordenar, colocar em decrescente e depois reordenar
                    menor = j;
                }
            }
            double aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
            System.out.println("Passo select: " + (i + 1) + ": " + Arrays.toString(v));
        }
    }
    public void insertionSort(){
        for (int i = 1; i < v.length; i++){
            double aux = v[i];
            int j = i-1;
            while (j>=0 && v[j] > aux){
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = aux;
            System.out.println("Passo insert:"  + i + ": " + Arrays.toString(v));
        }
    }
    public void preencheVetor () {
        Random r = new Random();
        for (int i = 0; i < v.length; i++){
            //adiciona(Math.random()); // lembrar que como da valores de 0-1, doubles, e tentamos atribuir isso a um int, da erro
            // vamos retarurar código
            // programar aprendendo genetics
            // mudamos todos os ints para double

            adiciona(r.nextInt(v.length*10) +1);
            // perceba que estou ligando com o tamanho do vetor randomico
        }
    }
    public Retorno buscaSimples (double e){
        Retorno r = new Retorno();
        if (estaVazio()) return r;
        // não preciso de um else por que o return ja sai do método
        for (int i = 0; i<=ultimaPos; i++) {
            r.incrementaCont();
           // poderia usar também o < v.length, existe uma diferença 
            if (v[i] == e){
                r.setAchou(true);
                 return r; 
            }
        }
        return r;
        
    }
    // public boolean buscaSimples (int e){
    //     if (estaVazio()) return false;
    //     // não preciso de um else por que o return ja sai do método
    //     for (int i = 0; i<=ultimaPos; i++) {
    //        // poderia usar também o < v.length, existe uma diferença 
    //         if (v[i] == e) return true; 
    //         
    //        }
    //        return false;
    // }
    // assim estaria certo, atentar para o return que tem que estar fora do {} do for

    public Retorno buscaBinaria (double e){
        Retorno r = new Retorno();
        if (estaVazio()) return r;
        int inicio = 0;
        int fim = ultimaPos;
        while (inicio <= fim){
            r.incrementaCont(2);
            int meio = (inicio + fim)/2;
            if (v[meio] == e) {
                r.setAchou(true);
                return r;
                // até aqui fizemos o mesmo da busca simples
                // agora como temos dois ifs, vai fazer a busca mais vezes, vamos usar a sobrecarga no incrementaCont
            }
            if (v[meio] < e) inicio = meio + 1;
            else fim = meio - 1;
        }
        return r;
        // busca binária so funciona se o vetor tiver ordenado
        // esse return r armazena em r o valor de r, e o return r; retorna o valor de r, feita sempre que um vertor novo é criado, somente deixando na pilha de execução o que é necessário e liberando, não é estático
    }

    //inserir elemento em determinada posição **
    public void inserePos(double e, int pos){
        if (estaCheio()) redimensiona(v.length*2);
        if (estaVazio() || pos == ultimaPos + 1){
            adiciona(e);
            return;
        }
        if (pos < 0 || pos > ultimaPos + 1) return;
        for (int i = ultimaPos; i >= pos; i--){
            // explique o for
            // o for começa da ultima posição, e vai até a posição que eu quero inserir, e vai decrementando
            v[i+1] = v[i]; 
            // vai deslocando os elementos para a direita, para abrir espaço para o novo elemento
        }
        v[pos] = e;
        ultimaPos++;
    }

    // Verificar quantas vezes um elemento aparece no vetor
    public int contaElemento(double e){
        int cont = 0;
        for (int i = 0; i <= ultimaPos; i++){
            if (v[i] == e) cont++;
        }
        return cont;
    }

    // Remover um elemento de uma determinada posição **
    public double removePos(int pos){
        if (estaVazio() || pos < 0 || pos > ultimaPos) return 0;
        double aux = v[pos];
        for (int i = pos; i < ultimaPos; i++){
            v[i] = v[i+1];
            // vai da posição que eu quero remover até a ultima posição, e vai deslocando os elementos para a esquerda
        }
        ultimaPos--;
        if (v.length >= 10 && ultimaPos <= v.length/4){
            redimensiona(v.length/2);
        }
        return aux;
    }

    //Remover a primeira ocorrência de um determinado elemento
    public boolean removeElemento(double e){
        if (estaVazio()) return false;
        int pos = -1;
        for (int i = 0; i <= ultimaPos; i++){
            if (v[i] == e){
                pos = i;
                break;
            }
        }
        if (pos == -1) return false;
        // for (int i = pos; i < ultimaPos; i++){
        //     v[i] = v[i+1];
        // }
        // ultimaPos--;
        // if (v.length >= 10 && ultimaPos <= v.length/4){
        //     redimensiona(v.length/2);
        // }
        return true;
    }

    //Remover todas as ocorrências de um determinado elemento **
    public boolean removeElementoTodas(double e){
        if (estaVazio()) return false;
        int cont = 0;
        for (int i = 0; i <= ultimaPos; i++){
            if (v[i] == e){
                cont++;
            }
        }
        if (cont == 0) return false;
        double[] temp = new double[v.length - cont];
        int j = 0;
        for (int i = 0; i <= ultimaPos; i++){
            if (v[i] != e){
                temp[j++] = v[i];
            }
        }
        v = temp;
        ultimaPos = j - 1;
        return true;
    }

    //Criar uma nova instância da classe, com as posições de ocorrência de um determinado elemento
    public MeuVetor posicoesElemento(double e){
        MeuVetor posicoes = new MeuVetor(v.length);
        for (int i = 0; i <= ultimaPos; i++){
            if (v[i] == e){
                posicoes.adiciona(i);
            }
        }
        return posicoes;
    }

    // 7. Devolver o índice da primeira ocorrência de um determinado elemento
    public int indiceElemento(double e){
        if (estaVazio()) return -1;
        for (int i = 0; i <= ultimaPos; i++){
            if (v[i] == e){
                return i;
            }
        }
        return -1;
    }    
       
}

