public class Teste1 {
    //classe de aplicação
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(4); // 10 é a length do vetor
        System.out.println("ultima posicao depois da construcao: " + v1.getUltimaPos());
        // agora trocamos para nos referirmos ao metodo que está público

        v1.setUltimaPos(35);
        System.out.println("ultama posicao depois do set: " + v1.getUltimaPos());
        
        // v1.adiciona(100);
        // apesar de parecer que funcionou o retorno é desperdiçado

        if (v1.adiciona(100)){
            System.out.println("elemento inserido com sucesso");
        }
        else{
            System.out.println("vetor esta cheio");
            // o teste de cheio deu true e não inseriu
        }
        //conclusão jamais deixar o cliente mexer no controle
    }
}
