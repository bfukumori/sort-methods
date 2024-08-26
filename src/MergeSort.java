import java.util.Random;
import java.util.Scanner;

public class MergeSort{

    public static int N = 10;
    // define o tamanho do vetor a ser ordenado

    public static void main(String[] args)  {

        Scanner entrada = new Scanner(System.in);
        Random gerador = new Random();

        int i;

        /*cria a estrutura de dados (vetor) com N elementos*/
        int vetor[] = new int[N];
        System.out.println("Criando vetor com"+N+" elementos");
        for(i = 0; i<N; i++)
            vetor[i] = (int)gerador.nextInt()/10000;

        System.out.println("Ordenando o vetor criado...");
        merge(vetor,0,N-1);

        System.out.println("Vetor ordenado:");
        for(i = 0; i<N; i++)
            System.out.println(i +"	"+vetor[i]);
        entrada.close();
    }

    public static void merge(int vet[], int low, int hi) {
        int mid;
        if (low < hi) {
            mid = (low + hi)/2;
            merge (vet,low,mid);
            merge (vet,mid+1,hi);
            intercala(vet,low,hi,mid);
        }
    }

    public static void intercala(int vet[], int low, int hi, int mid)
    {
        int poslivre, low_v1, low_v2, i;
        int aux[] = new int[N];
        low_v1 = low;
        low_v2 = mid+1;
        poslivre = low;
        while (low_v1 <= mid && low_v2 <= hi) {
            if(vet[low_v1] <= vet[low_v2]) {
                aux[poslivre] = vet[low_v1];
                low_v1++;
            }
            else {
                aux[poslivre] = vet[low_v2];
                low_v2++;
            }
            poslivre++;
        }
        for (i = low_v1; i<=mid; i++) {
            aux[poslivre] = vet[i];
            poslivre++;
        }
        for (i = low_v2; i<=hi; i++) {
            aux[poslivre] = vet[i];
            poslivre++;
        }
        for (i=low; i<=hi; i++)
            vet[i] = aux[i];
    }
}