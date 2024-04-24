public class Rua {
    public static void main(String[] args) {
        Fila<Carro> f = new Fila<>();
        System.out.println(f);
        //começamos a declarar carros

        Carro c1 = new Carro(2012, "ABC-1234");
        f.enfileira(c1);
        System.out.println(f);

        Carro c2 = new Carro(2015, "DEF-5678");
        f.enfileira(c2);
        System.out.println(f);

        //instanciar um novo objeto e no mesmo instante enfileirar
        f.enfileira(new Carro(2018, "GHI-9101"));
        System.out.println(f);

        //vamos desinfileirar
        c1 = f.desinfileira();
        System.out.println(c1 == null? "Fila vazia": c1 + " saiu da fila"); // em ternários temos ações vinculadas a condição
            // se o que retornou da operação for uma fila vazia, null, retorna "Fila vazia", senão retorna o carro que saiu da fila
        System.out.println(f);
    }
}
