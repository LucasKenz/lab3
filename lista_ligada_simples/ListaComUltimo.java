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
    
}
