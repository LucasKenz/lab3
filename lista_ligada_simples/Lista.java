public class Lista {
    private No primeiro;
    // nasce vazia e com construtor padrão que zera todos os atributos
    public boolean estaVazia(){
        // se o primeiro estiver nulo esta vazia se estiver com alguem não esta vazia
        return primeiro==null; // tem um if embutido, escondido
        
    } 
    //vamos usa ro principio do menor privilégio
    public No getProximo(){
        return primeiro;
    }
    public void InsereInicio(int i){
        // int i para inserir o int na lista
        // vamos embrulhar e colocar na caixinha
        No novo = new No(i); // peguei o valor i que chegou e coloquei na caixinha
        if (!estaVazia()){
            // se a lista estiver vazia o que chegou vai ser o primeiro
            novo.setProximo(primeiro);;
        }
        primeiro = novo;
            // se não, for false, faz dar a mão para o antigo
            // temos um exemplo de composição de classes, pemite reutilização de código
            //tenho uma classe nó que sabe trabalhar seus atributos, posso deligar a classe nó para fazer o trabalho dela, ela é responsável por se manipular
          
            // lembrando que novo é um No(recebe i)
        
             // tiramos do if

    }
    @Override
    public String toString(){
        String s = "lista: ";
        if (estaVazia()){
            s += "vazia";
        }
        else{
            // se não estiver vazia vou nomear um ponteiro auxiliar para guardar o endereço do nó
            No temp = primeiro; // instanciamos um temp para receber o valor de primeiro
            while(temp != null){
                s += temp;
                temp = temp.getProximo(); // enquanto o temp for diferente de proximo.., vou buscando o conteúdo na forma de string por isso o toString() no Override que sobrecarga o estaVazio
            }
            s += " \\ "; //concatena a string com \\ isso exibe somente uma \, se quiser exibir duas teria que ser \\\\, a cada 2 imprime 1 \
        }
        return s + "\n"; // pula linha
    }
}
