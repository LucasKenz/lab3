public class Retorno {
    private double cont;
    private boolean achou;
    //construtor padrão = zera tudo
    public double getCont(){
        return cont;
    }
    public boolean getAchou(){
        return achou;
    }
    // lembrando que o construtor padrão é o que não tem parâmetros e retorna void
    public void incrementaCont(){
        cont++;
    }

    //adicionando ao incrementaCont
    public void incrementaCont(int k){
        cont += k;
    }

    public void setCont (double n) {
        cont = n;
    }

    public void setAchou(boolean achou){
        this.achou = achou;
        // se achou = achou, o compilador enxerga curto, o achou somente existe naquela variável, então se tiver a ambiguidade usar o this
    }
    // agora mudamos as buscas no MeuVetor para retornar um objeto do tipo Retorno
}
