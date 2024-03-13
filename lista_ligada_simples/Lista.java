public class Lista {
    private No primeiro;
    // nasce vazia e com construtor padrão que zera todos os atributos
    public boolean estaVazia(){
        // se o primeiro estiver nulo esta vazia se estiver com alguem não esta vazia
        return primeiro==null; // tem um if embutido, escondido
    } 
}
