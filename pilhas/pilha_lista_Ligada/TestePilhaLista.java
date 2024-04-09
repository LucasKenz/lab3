public class TestePilhaLista {
    // fazer vários pushs e pops e imprimir a lista no final
    public static void main(String[] args) {
        
        Pilha p = new Pilha();
        p.push(1);
        int oTopo = p.consultaTopo();
        System.out.println("Topo: " + oTopo);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        int tamanho = p.size();
        System.out.println("Tamanho: " + tamanho);
        System.out.println(p);
        p.pop();
        p.pop();
        System.out.println(p);
        int tamanhoFinal = p.size();
        System.out.println("Tamanho final: " + tamanhoFinal);
    }
}
