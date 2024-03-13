import java.util.Random;
public class TesteLista {
    public static void main(String[] args) {
        Random r = new Random();
        Lista lista = new Lista();
        System.out.println(lista);
        for (int i = 1; i<=10; i++){
            lista.InsereInicio(r.nextInt(10)); //pega a lista insere no inicio com valores de 0-9
            System.out.println(lista);
        }
    }
}
