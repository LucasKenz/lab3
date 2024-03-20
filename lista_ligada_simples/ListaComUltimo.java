public class ListaComUltimo extends Lista {
    private No ultimo;
    // construtor padrão
    public No getUltimo(){
        return ultimo;
    }
    @Override
    public void InsereInicio(int i){
        // criar novo nó
        No novo = new No(i);
        //teste se minha lista estiver vazia ajusta o ultimo, ultimo = nono No, se não precisa fazer a lisgação
        if (estaVazia()){
            ultimo = novo;
        }
        else{

            novo.setProximo(super.getProximo());
        }
        super.setPrimeiro(novo);
    }
    @Override
    public void insereFim(int i){
        No novo = new No(i);
        if (estaVazia()){
            super.setPrimeiro(novo); //fazer ligação com o novo
        }
        else{
            ultimo.setProximo(novo); // proximo do ultimo ja registrado vai ser o novo
            // para inserir no fim não podemos perder o fluxo, temos que falar que o ultimo grupo agora não último, e o novo é o ultimo
        }
        ultimo = novo;

    }
    
    // @Override
    // //removeFim
    // public int removeFim(){
    //     if (estaVazia()){
    //         System.out.println("Lista vazia");
    //     }
    //     else if (super.getProximo() == ultimo){
    //         super.setPrimeiro(null);
    //         ultimo = null;
    //     }
    //     else{
    //         No temp = super.getProximo();
    //         while(temp.getProximo() != ultimo){
    //             temp = temp.getProximo();
    //         }
    //         temp.setProximo(null);
    //         ultimo = temp;
    //     }
    //     return temp;
    // }
    
    // era assim:
    // public void insereFim (int i){
    //     No novo = new No(i);
    //     if (estaVazia()){
    //         // se ela estiver vazia quer dizer que o primeiro a ser inserido é o próximo, então o 1° recebe o No (novo)
    //         primeiro = novo;
    //         // e se não for o primeiro?
    //         // nomearemos um auxiliar para armazenar até chegar em um elemento cujo próximo é null

    //     }
    //     else {
    //         No temp = primeiro;
    //         while(temp.getProximo() != null){
    //             temp = temp.getProximo(); // aqui vemos a representação de pegar um valor até o proximo ser diferente de null
    //             // enquanto isso temp assumirá o tamanho desse próximo
    //         }
    //         temp.setProximo(novo);
    //         // o problema é que quanto maior a lista mais demorado é para achar um pecinha
    //     }
    // }

}
