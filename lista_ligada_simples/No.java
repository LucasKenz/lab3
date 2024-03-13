public class No{
    private int info; //declarando atributos
    private No proximo;
    public No(int info){ //construtor, joga info para dentro e aponta para null, sempre que construirmos um No, ex:recebe 6: [6][-> null]
        setInfo(info); // diz que info recebe ela mesma, mas não quero isso quero que receba a variável local, do parenteses, usamos o this
        proximo = null; // por clareza

    }
    public int getInfo(){
        return info;
    }
    public No getProximo(){
        // como é uma referencia temos que dar return em proximo
        return proximo;
    }
    public void setInfo(int info){
        this.info = info; // denovo minha variavel info recebe o valor da variavel local info
    }
    public void setProximo(No proximo){
        this.proximo = proximo; // veja que até aqui não temos lista, somente uma caixinha []
    }
    @Override
    public String toString(){
        // lembrando é uma sobrescrita
        return "|" + info + "|->";
    }// no pronto
}
