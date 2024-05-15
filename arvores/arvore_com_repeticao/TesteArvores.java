import java.util.Random;

public class TesteArvores {
    public static void main (String[] args){
        Arvore abb = new Arvore();
        Random r = new Random();
        int total = r.nextInt(200) + 50;
        System.out.println("total: " + total);
        for (int i=1; i<=total; i++){
            int n = r.nextInt(total);
            System.out.print(n + " ");
            abb.insere(n);
        }
        System.out.println("\na arvore:\n" + abb.ToStringEmOrdem());
        System.out.println("Numero de nos: " + abb.numeroNos());
        System.out.println("altura da arvore: " + abb.altura());
    }
}
