public class Teste1 {
    //classe de aplicação
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(4);
        System.out.println("ultima posicao depois da construcao: " + v1.getUltimaPos());
        System.out.println("vetor recem construido: " + v1);

        // v1.setUltimaPos(35);
        // System.out.println("ultama posicao depois do set: " + v1.getUltimaPos());
            // lembrandoq ue aqui é para simular o que ocorre quando damos o controle na mão do usuário

        // if (v1.adiciona(100)){
        //     System.out.println("elemento inserido com sucesso");
        // }
        // else{
        //     System.out.println("vetor esta cheio");
            
        // }
        // System.out.println("ultima posicao depois da insercao: " + v1.getUltimaPos());
        // System.out.println("vetor depopis da insercao: " + v1);

        for (int n = 0; n<=v1.getV().length; n++){
            //se quero o length do v, tenho que capturar o v e depois chamar o length dele, tenho que entrar em uma caixinha e tirar ele, ilustrado por: n<v1.getV().length]

            v1.adiciona((n+1)*10);
            // adiciona de 10 em 10
            System.out.println(v1);
        }
        
    }
}
