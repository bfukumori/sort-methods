import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    public static int N = 8;
    //define quantidade de elementos do vetor

    public static void main(String[] args)  {

        Scanner entrada = new Scanner(System.in);
        Random gerador = new Random();

        int i;

        /*cria a estrutura de dados (vetor) com N elementos*/
        int vetor[] = new int[N];
        System.out.println("Criando vetor com " + N + " elementos");
        for(i = 0; i<N; i++)
            vetor[i] = (int)gerador.nextInt()/10000;



        System.out.println("Ordenando o vetor criado...");
        quicksort(vetor, 0, N-1);

        for(i = 0; i<N; i++)
            System.out.println(i +"	"+vetor[i]);
        entrada.close();
    }

    public static int particiona (int x[], int li, int ls){
        int pivo,down,temp,up;
        pivo=x[li];
        System.out.println("pivo: " + pivo);
        up=ls;
        down=li;
        while(down<up)
        {
            while(x[down]<=pivo && down<ls)
                down++;
            while (x[up]>pivo)
                up--;
            if (down<up){
                temp=x[down];
                x[down]=x[up];
                x[up]=temp;
            }
        }
        x[li]=x[up];
        x[up]=pivo;
        return up;
    }
    public static void quicksort(int x[],int li,int ls){
        int j;
        if (li<ls){
            j = particiona(x, li, ls);
            quicksort(x, li, j-1);
            quicksort(x, j+1,ls);
        }
    }
}