public class Teste1 {
    //classe de aplicação
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(4);
        System.out.println("ultima posicao depois da construcao: " + v1.getUltimaPos());
        System.out.println("vetor recem construido: " + v1);

        for (int i=0; i <=100; i++){
            v1.adiciona(i);
            System.out.println("adicionou " + i + " capacidade: " + v1.getV().length);
        }
        System.out.println("/////////////////////");
        while (!v1.estaVazio()) {
            System.out.println(v1.remove() + " foi atendido, capacidade: " + v1.getV().length);
        }
        System.out.println("/////////////////////");
        for (int i=0; i <=100; i++){
            v1.adiciona(i);
            System.out.println("adicionou " + i + " capacidade: " + v1.getV().length);
        }
    }
}


// public class Teste1 {
//     public static void main(String[] args) {
//         MeuVetor v1 = new MeuVetor(4);
//         System.out.println("ultima posicao depois da construcao: " + v1.getUltimaPos());
//         System.out.println("vetor recem construido: " + v1);

//         // v1.setUltimaPos(35);
//         // System.out.println("ultima posicao depois do set: " + v1.getUltimaPos());
        
//         // if (v1.adiciona(100)) {
//         //     System.out.println("elemento inserido com sucesso");
//         // }
//         // else {
//         //     System.out.println("vetor esta cheio");
//         // }
//         // System.out.println("ultima posicao depois da insercao: " + v1.getUltimaPos());
//         // System.out.println("vetor depois da insercao: " + v1);

//         // for (int n=0; n<=v1.getV().length; n++) {
//         //     v1.adiciona((n+1)*10);
//         //     System.out.println(v1);
//         // }

//         for (int  i=0; i<=100; i++) {
//             v1.adiciona(i);
//             System.out.println("adicionou " + i + " capacidade: " + v1.getV().length);
//         }
//         while (!v1.estaVazio()) {
//             System.out.println(v1.remove() + " foi atendido, capacidade: " + v1.getV().length);
//         }
//         for (int  i=0; i<=100; i++) {
//             v1.adiciona(i);
//             System.out.println("adicionou " + i + " capacidade: " + v1.getV().length);
//         }

//     }