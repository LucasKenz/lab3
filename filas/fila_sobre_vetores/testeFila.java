import java.util.Random;

public class testeFila {
    public static void main(String[] args) {
        Random r = new Random();
        Fila f = new Fila();
        do{
            if (r.nextBoolean()){
                if (!f.estaCheia()){
                    f.enfileira(r.nextInt(10));
                }
            }
            else{
                if (!f.estaVazia()){
                    System.out.println(f.desinfileira() + " saiu");
                }

            }
            System.out.println(f);
            System.out.println(f.toStringVetor());
        } while (!f.estaVazia());

    }

}
