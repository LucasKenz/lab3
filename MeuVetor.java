import java.util.Arrays;
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
        for (int i = 1; i < v.length; i ++){
            // conforme o i aumenta reduzo o número de comparações, que é o laço seguinte, já que é o length - i, quando i = 1, faço 0-1, 1-2, 2-3, 3-4, quando o i = 2 faço 0-1, 1-2, 2-3...
            for (int j = 0; j< v.length-i; j++){
                if (v[j] > v[j+1]){
                    // se eu trocar o sinal para <, a ordenação vai ficar em ordem decrescente
                    // j faz o controle do índice

                    // imaginar que a=5, b=3, como trocar os valores?
                    //nomeio um variavel aux = a
                    //a = b
                    // b = aux
                    // desse jeito formamos uma cópia , custa memória
                    // ou
                    // a = a+b = 8
                    // b = a-b = 5
                    // a = a-b = 3
                    // esse é outro jeito, custo processamento
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] =aux;
                }
                System.out.println("Passo bubble: " + i + ": " + Arrays.toString(v));
            }
        }
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

}

