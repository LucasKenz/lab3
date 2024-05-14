import java.util.Random;

public class TesteArvores {
    public static void main (String[] args){
        Arvore abb = new Arvore();
        Random r = new Random();
        for (int i=1; i<=12; i++){
            int n = r.nextInt(10);
            System.out.print(n + " ");
            abb.insere(n);
        }
        System.out.println("\na arvore:\n" + abb.ToStringEmOrdem());
    }
}
