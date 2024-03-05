public class TesteRandomico {
    public static void main(String[] args){
        MeuVetor v1 = new MeuVetor(6);
        v1.preencheVetor();
        System.out.println("vetor gerado: \n" + v1);
        v1.bubbleSort();
        System.out.println("vetor ordenado pelo buuble: \n" + v1);
    }
}
