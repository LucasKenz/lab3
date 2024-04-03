public class TesteNo {
    public static void main(String[] args) {
        No<String> no1 = new No<String>("hello world");
 
        No<Integer> no2 = new No<>(5);
 
        Carta c1 = new Carta(2, "ouros");
        No<Carta> no3 = new No<Carta>(c1);
        System.out.println(no3);
 
        No<Carta> no4 = new No<Carta>(new Carta(3, "espadas"));
        System.out.println(no4);
    }
}