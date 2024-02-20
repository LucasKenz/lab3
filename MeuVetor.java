public class MeuVetor {
    //classe modelo
    int [] v;
    // [] v; indica um veto de inteiro
    int ultimaPos;
    // perceba que não estão encapsulados e portanto qualquer um pode mexer neles
    //toda casa que eu contruo segundo um modelo segue o padrão de classe e objeto, que veio da classe
    // se criamos uma tabela usúario com nome e idade, a cad alinha temos uma instância. instancia serve tanto para BD quanto para programação
    // ao definirmos um métodos, temos os modificadores de acesso, tipo de retorno (int, void), e o nome de chamada (conjunto de parametros ou vazio)
    //contrutor pe outra história, não tem tipo, é sempre public e o nome dele é sempre o da classe
    // por tanto contrutor é diferente de método construtor
    
    // se escolhermos o valor -1 para mostrar que o vetor estará vazio
    public MeuVetor (int capacidade){
        // vamos falar que isntanciara o vetor
        v = new int[capacidade];
        ultimaPos = -1; //representando que não temos elementos no vetor
    }
}
