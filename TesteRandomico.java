public class TesteRandomico {
    public static void main(String[] args){
        MeuVetor v1 = new MeuVetor(5);
        v1.preencheVetor();
        System.out.println("vetor gerado: \n" + v1);
        v1.bubbleSort();
        System.out.println("vetor ordenado pelo buuble: \n" + v1);
        v1.selectionSort();
        System.out.println("vetor ordenado pelo selection: \n" + v1);
        v1.insertionSort();
        System.out.println("vetor ordenado pelo insertion: \n" + v1);
    }
}
