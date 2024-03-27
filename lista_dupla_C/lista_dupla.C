#include <stdio.h>
#include <stdlib.h>

// lingaugem estruturada como c não tem métodos, somente funções

// vamos fazer o no e a lista e o teste em um só arquivo

typedef struct no {
    // estrutura que constroi e define nosso no
    int info;
    struct no * anterior;
    struct no * proximo;


} t_no;// esse é um tipo novo criado por nós mesmo

typedef struct lista {
    // tertá um ponteiro de nó
    t_no * primeiro;
    t_no * ultimo; // o certo é t_no *ultimo para indicar que o operador * é da variável, indicando ponteiro pelo tipo t_no
} t_lista;

t_no * constroi_no (int info){ // isso equivale ao tipo t_no, * constroi no para indicar a criação de uma função{}
    t_no * no =(t_no *) malloc (sizeof(t_no)); // dessa forma alocamos um espaço na memoria para o ponteiro
    // é um ponteiro de strutura
    // se a alocação falha devolver null, criamos um caso para isso
    if (no != NULL){
        no->info = info;
        no->anterior = NULL;
        no->proximo = NULL;
    } // até aqui estamos pensando no no e na sua alocação
    return no;
} 

void inicia_lista (t_lista * l){ // o parametro recebe um ponteiro de lista do tipo lista
    l->primeiro = NULL; // assim eu zero o cara para qual o primeiro aponta
    l->ultimo = NULL; 
}

int esta_vazia (t_lista * l){ // parametro interno, parametro dentro da própria função
    return l->primeiro == NULL; // é uma pergunta se o primeiro da lista l do argumento recebido é nulo
}

void insere_inicio(int info, t_lista * l){// recebe parametro externo
    t_no * novo = constroi_no(info);
    if (esta_vazia(l)){ // equivale a se minha lista l estiver vazia
        l->ultimo = novo; // vai no bloco de memória do l no ultimo e faz receber novo
    }
    else{
        // fazemos a ligação
        novo->proximo = l->primeiro; // equivale ao novo do proximo receber o primeiro do l
        l->primeiro->anterior = novo;
    }
    l->primeiro = novo;
}

void exibe_lista(t_lista * l){
    if (esta_vazia(l)){
        printf("lista vaiza\n");
    }
    else{
        t_no * aux = l->primeiro;
        while(aux != NULL){
            //faz o processamento, print e depois anda
            printf("endereço: %p, valor: %d\n ", aux, aux->info); // vai no elemento que o aux aponta e pega a info
            // andar
            aux = aux->proximo;
            // andamos

        }
    }
    printf("\n");

}

int remove_inicio(t_lista * l){
    if (esta_vazia(l)){
        return -1;
    }
    int info = l->primeiro->info; // equivale a int info recebe o primeiro referenciado pela lista e a info referenciada por primeiro
    t_no* lixo = l->primeiro;
    l->primeiro = l->primeiro->proximo; // para andar
    if (l->primeiro == NULL){ //esvaziou a lista se o primeiro ficou nulo
        l->ultimo = NULL;
    }
    else{
        l->primeiro->anterior = NULL; // aqui o anterior recebe NULL

    }
    free(lixo);
    return info;
    
}

int main(){
    struct no * no1; // struct no funciona como tipo, assim como t_no
    t_no * no2; // declaramos ponteiro do tipo no
    no1 = constroi_no(10);
    no2 = constroi_no(20);

    t_lista lista; // criado um objeto t_lista de nome lista, que tem atributos de lista
    // printf("primeiro antes: %p\n", lista.primeiro);
    // printf("ultimo antes: %p\n", lista.ultimo);
    inicia_lista(&lista);
    // printf("primeiro depois: %p\n", lista.primeiro);
    // printf("ultimo depois: %p\n", lista.ultimo);

    insere_inicio(10, &lista); // & é o endereço de memória, pois o ponteiro precisa apontar para o endereço de memória & é o operador referencia
    insere_inicio(20, &lista);
    insere_inicio(30, &lista);
    exibe_lista(&lista); // por que passar &lista ? para economizar memoria pois ponteiro tem 4 bytes

    printf("%d foi removido do inicio\n", remove_inicio(&lista));
    exibe_lista(&lista);


    return 0;
}