import java.util.Date;
import java.util.Scanner;
public class Ordenacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MeuVetor v1; // não instanciado so declarado, vamos alocar memoria e liberar

        System.out.print("digite um tamanho para o vetor, 0 encerra: ");
        int n = sc.nextInt();

        while (n > 0) {
            v1 = new MeuVetor(n); // alocamos um novo vetor que recebe um vetor de parametro capacidade digitado pelo usuário
            v1.preencheVetor(); // invocamos o v1 e falamos para ele se preencher

            //System.out.println("vetor gerado:\n" + v1);
            //int comparacoes = v1.bubbleSort();
            //System.out.println("vetor ordenado pelo bubble:\n" + v1); // por enquanto o while não acaba, aqui é o começo, próximo é o passo
            //System.out.println("tamanho = " + n + ", comparações = " + comparacoes);

            long inicio = new Date().getTime();
            v1.bubbleSort();
            long fim = new Date().getTime(); 
            System.out.println("Tamanho: "+ n + ", demorou " + (fim - inicio) + " s");

            System.out.println("digite um tamanho para o vetor, 0 encerra: ");
            n = sc.nextInt(); // o passo começa ao digitar outro valor
            // para n = 10, n**2 = 100 - 10 = 90/2 = 45
           

        }
        sc.close();
    }
}
