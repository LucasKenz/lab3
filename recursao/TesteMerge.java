import java.util.Scanner;

public class TesteMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MeuVetor v;
        System.out.println("Digite o tamanho do vetor, 0 encerra: ");
        int tamanho = scanner.nextInt();
        while (tamanho > 0) {
            v = new MeuVetor(tamanho);

            // Preenchendo e exibindo o vetor antes da ordenação
            v.resetVetor();
            v.preencheVetor();
            System.out.println("Vetor antes da ordenacao:");
            System.out.println(v);

            // Ordenando usando mergeSort
            v.mergeSort();

            // Exibindo o vetor após a ordenação
            System.out.println("Vetor apos a ordenacao:");
            System.out.println(v);

            System.out.println("Digite o tamanho, 0 encerra: ");
            tamanho = scanner.nextInt();
        }
        scanner.close();
    }
}