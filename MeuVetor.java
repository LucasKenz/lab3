public class MeuVetor {
    //classe modelo
    private int [] v;
    // [] v; indica um vetor de inteiro
    private int ultimaPos;
    // se escolhermos o valor -1 para mostrar que o vetor estará vazio
    public MeuVetor (int capacidade){
        // vamos falar que isntanciara o vetor
        v = new int[capacidade];
        ultimaPos = -1; //representando que não temos elementos no vetor
    }

    //métodos de acesso:
        // get para consulta
        // set para alterar
    public int getUltimaPos() {
        return ultimaPos;
        //retornamos o ultimaPos, para parar de chiar, sublinhado vermelho
    }
        //se escrevesse so um get e tab ele faz sozinho

    public int[] getV(){
        return v;
        //int[] fala que vai devolver um vetor, mas não pode devolver todo o vetro pois se fosse muito grande pesaria muito
            // no stack ficam variaveis primitivas 
            // no heap ficam variaveis alocadas dinamicamente e os codigos que sobem para memória
            // int i iria para o heap
            // no stack tem um endereço de memória, v1, é uma variável de referência, 
            // na hora do return v, estou devolvendo do stack, um endereço de referencia que aponta no heap, que por sua vez apont para um vetor
            // int [], essencialmente armazena o endereço de alguém e devolve essa referencia, no heap, stack -> heap -> vetor (que ta no heap)
        // o java é essencialmente ponteiros, o vetor é espaço contínuo para que a sequencia de numeros possa ser contada
    }

    //método modificador
    public void setUltimaPos(int pos){
        if(pos >= 0 && pos < v.length){
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length-1; // pega a length desconta 1 se cair no else, que no caso ocorre ao tentar setar o valor para 35
            // tenho que fazer valer para qualquer tamanho de vetor, logo length - 1 
        }
        // uso do this sempre ou para resolver ambiguidades

        // de 0 até tamanho -1 é um index do vetor, se meu vetor tem 10 posições, a ultima é 9
        // colocamos regras ed negócio no set 
    }
    // if(prop1 && prop2) se prop1 for false, não testa a prop2, porque sabe que vai dar falso,
    // if(prop1 || prop2) se prop 1 for verdadeira, não testa a prop2, se for false testa, || é OU

    // em C: if(p1 & p2), faz os testes nos dois independente do resultado
    // if(p1 | p2), faz também os testes independente do resultado.

    //quero adicionar um elemento novo ao meu vetor -> como?
    //preciso receber o valor do elemento que quero inserir
    //se o vetor ta na propria classe, não é parametro
    // vo manipular o próprio v,
    // vou usar o add(e) para manipular valor de v
    //temos que atualizar o valor da ultipa posição e jogar o carinha la dentro

    public boolean estaCheio(){
        //so precisa verificar se o vetor esta cheio ou não, v que está dentro dessa classe, como so faz checagem, não precisa ed parametro
       return ultimaPos == v.length -1;
       //mudamos pois vai retornar verdadeiro ou falso independente do resultado, então apenas retornamos o resultado booleano
    }
    public boolean adiciona (int e){
        // public ____ adiciona (int e){, podemos apenas colocar void e jogar para deus
            // mas vamos fazer a verificação para ver se o vetor está cheio
            // como cada classe tem uma e apenas função, precisamos checar o ultimaPos, se estiver na 9, ou length -1, estará cheio
            // antes de inserir fazer a verificação se está cheio ou não 
        if (estaCheio()){
            return false;
            // se estiver cheio é false  
        }
        //atualizar ultmaPos
        ultimaPos++;
        // atualiza o valor de v para receber o valor de e
        v[ultimaPos] = e;
        return true; //se não estiver cheio é true
    }
}
