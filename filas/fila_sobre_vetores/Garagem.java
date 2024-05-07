public class Garagem {
    public static void main (String[]args){
        FilaGenerica<Carro> garagem = new FilaGenerica<>();
        int i = 2012;
        while (!garagem.estaCheia()){
            garagem.enfileira(new Carro(i, "ABC" + i++));
            System.out.println(garagem);
        }
        while (!garagem.estaVazia()){
            System.out.println(garagem.desinfileira() + " foi embora"  + "\n");
            System.out.println(garagem) ;
        }
        
    }
}
