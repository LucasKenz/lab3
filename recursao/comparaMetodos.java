import java.util.Scanner;
import java.util.Date;

public class ComparaMetodos{
    public static void main (Strings [] args){
        Scanner scanner = new Scanner (System.in);
        MeuVetor v;
        System.out.println("digite o tamanho do vetor, 0 encerra: ");
        int tamanho = scanner.nextInt();
        while (tamanho >0){
            v = new MeuVetor(tamanho);
            v.preencheVetor();
            System.out.println(v);
            long ini = new Date().getTime();
            v.bubbleSort();
            long fim = new Date().getTime();
            System.out.println("vetor ordenado pelo Bubble: \n" + v);
            System.out.println("bubble demorou: " + (fim-ini) + " ");
            // declara vetor, começa o tempo, sort, encerra tempo, printa v e tempo

            //quicksort
            v.preencheVetor();
            System.out.println(v);
            ini = new Date().getTime();
            v.quicksort(0, tamanho-1);
            fim = new Date().getTime();
            System.out.println("vetor ordenado pelo Quick: \n" + v);
            System.out.println("Quick Demorou: " + (fim-ini) + " ");

            System.out.println("digite o tamanho, 0 encerra: ");
            tamanho = scanner.nextInt();
        }
        scanner.close();
    }
}