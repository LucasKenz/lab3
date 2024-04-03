public class TestePilha {
    public static void main(String[] args) {
        Pilha<Carta> p = new Pilha<>();
        // operador diamante + () que indica construtor
        System.out.println(p);
        System.out.println("-----------------------");
        p.push(new Carta(2, "ouros"));
        System.out.println(p);
        System.out.println("-----------------------");
        p.push(new Carta(3, "paus"));
        System.out.println(p);
        System.out.println("-----------------------");
        p.push(new Carta(7, "espadas"));
        System.out.println(p);
        System.out.println("-----------------------");
        p.push(new Carta(9, "copas"));
        System.out.println(p);
        System.out.println("-----------------------");
        System.out.println(p.pop() + " saiu do monte");
        System.out.println(p);
        System.out.println("-----------------------"); // mostra a carta que saiu do topo7
        System.out.println(p.consultaTopo() + " está no topo agora");
        System.out.println("tamanho da lista: " + p.getTamanho() + " cartas");
    }
}
