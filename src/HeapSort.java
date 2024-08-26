import java.util.Random;
import java.util.Scanner;

public class HeapSort {

    public static int N = 10;
// define o tamanho do vetor a ser ordenado

    public static void main(String[] args)  {
        Scanner entrada = new Scanner(System.in);
        Random gerador = new Random();
        int i;

        /*cria a estrutura de dados (vetor) com N elementos*/
        int vetor[] = new int[N];
        System.out.println("Criando vetor com " + N+"  elementos");
        for(i = 0; i<N; i++)
            vetor[i] = (int)gerador.nextInt()/10000;
        System.out.println("Pré-processamento-criado heap");

        /*cria heap no mesmo vetor, sempre nó pai é maior que seus filhos*/
        int elem,pai,filho,iv;
        for(i=1;i<N;i++){
            elem=vetor[i];

// elemento que se imagina ser o maior
            filho=i;

// índice do elemento (considerado filho)   
            pai=(filho-1)/2;

//posição do pai do elemento
            while(filho>0 && vetor[pai]<elem){

// verifica se o pai do elemento é menor
                vetor[filho]=vetor[pai];

//sendo menor, troca valor do pai e filho
                filho=pai;

// índice do elemento muda para o filho
                pai=(filho-1)/2;

//calcula novo índice do pai do elemento
            }
            vetor[filho]=elem;

//menor elemento desce na árvore, tornando-se nó filho
        }
        int nh=N;

        /* utiliza heap para aplicar o método de seleção */
        for (i=N-1; i>0; i--){

            System.out.println("Configuração da Heap ...");

            for(int j= 0; j<nh; j++)
                System.out.println(j +"	"+vetor[j]);
            nh--;
            iv=vetor[i];
//iv guarda o elemento da posição onde o maior ocupará
            vetor[i]=vetor[0];

//coloca o maior elemento na sua posição final e inicia 
// o processo de busca de qual elemento que ocupará a raiz
            pai=0;

// encontra o maior filho na raiz
            if(i==1)
                filho=-1;

//marca com -1 que não há mais filho
            else
                filho=1;

//supõe que o maior filho seja o da esquerda
            if(i>2 &&vetor[2]>vetor[1])
                filho=2;

//verifica que o nó direito tem valor maior e faz o 
//deslocamento dos elementos, mantendo a estrutura da heap
            while(filho>=0 &&iv<vetor[filho]){
                vetor[pai]=vetor[filho];

// desloca o maior para a raiz
                pai=filho;

//inicia o posicionamento do filho do nó deslocado
                filho=2*pai+1;

//decide o nó que ficará à esquerda
                if(filho+1<=i-1&& vetor[filho]<vetor[filho+1])
                    filho=filho+1;

//inicia o posicionamento do filho do nó deslocado
                if (filho>i-1)
                    filho=-1;

//marca que o nó deslocado não tem filho
            }
            vetor[pai]=iv;

            /*troca o valor de elemento sobreposto pelo maior na posição do pai da subárvore alterada*/
        }
        System.out.println("Vetor ordenado:");
        for(i = 0; i<N; i++)
            System.out.println(i +"	"+vetor[i]);
        entrada.close();
    }
}