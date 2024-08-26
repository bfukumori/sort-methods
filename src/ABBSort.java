import java.util.*;
import java.util.Random;

public class ABBSort {
    public static int N = 10;
    private static class ARVORE{
        public int dado;
        public ARVORE dir;
        public ARVORE esq;
    }

    public static ARVORE init()
    {
        return null;
    }
    public static void main(String[] args) {
        Scanner entra = new Scanner(System.in);
        ARVORE raiz = init();

        Random gerador = new Random();

        int i;

        /*cria a estrutura de dados (vetor) com N elementos*/
        int vetor[] = new int[N];
        System.out.println("Criando vetor com" + N +" elementos");
        for(i = 0; i<N; i++)
            vetor[i] = (int)gerador.nextInt()/10000;

        System.out.println("Pré-processamento criando ABB");
        for(i = 0; i<N; i++)
            raiz = inserir(raiz, vetor[i]);

        System.out.println("Ordenando o vetor criado...");
        i = retira_em_ordem(raiz, 0, vetor);

        for(i = 0; i<N; i++)
            System.out.println(i +"	"+vetor[i]);

        entra.close();
    }

    private static ARVORE inserir(ARVORE p, int info) {
        // insere elemento em uma ABB
        if (p == null) {
            p=new ARVORE();
            p.dado = info;
            p.esq = null;
            p.dir = null;
        }
        else if (info < p.dado)
            p.esq= inserir (p.esq, info);
        else
            p.dir=inserir(p.dir, info);


        return p;
    }

    private static int retira_em_ordem(ARVORE root,int i, int vetor[]) {
        // lista elementos percorrendo em ordem
        if (root != null) {
            i = retira_em_ordem(root.esq,i,vetor);
            vetor[i]=root.dado;
            i++;
            i = retira_em_ordem(root.dir,i,vetor);
        }
        return i;
    }
}