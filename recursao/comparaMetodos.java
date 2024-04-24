import java.util.Scanner;
import java.util.Date;

public class ComparaMetodos{
    public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);
        MeuVetor v;
        System.out.println("digite o tamanho do vetor, 0 encerra: ");
        int tamanho = scanner.nextInt();
        long ini, fim;
        while (tamanho >0){
            v = new MeuVetor(tamanho);

            // v.preencheVetor();
            // //System.out.println("vetor para o bubble: " + v);
            // ini = new Date().getTime();
            // v.bubbleSort();
            // fim = new Date().getTime();
            // //System.out.println("vetor ordenado pelo Bubble: " + v);
            // System.out.println("bubble demorou: " + (fim-ini) + "ms ");
            // // declara vetor, começa o tempo, sort, encerra tempo, printa v e tempo
            
            //quicksort
            v.resetVetor();
            v.preencheVetor();
            
            System.out.println(v);
            //ini = new Date().getTime();
            v.quicksort(0, tamanho-1);
            //fim = new Date().getTime();
            //System.out.println("vetor ordenado pelo Quick: \n" + v);
            //System.out.println("Quick Demorou: " + (fim-ini) + "ms");

            // ini = new Date().getTime();
            // v.quicksort(0, tamanho-1);
            // fim = new Date().getTime();
            // System.out.println("Quick Demorou: " + (fim-ini) + "ms");

            System.out.println("digite o tamanho, 0 encerra: ");
            tamanho = scanner.nextInt();
        }
        scanner.close();
    }
}