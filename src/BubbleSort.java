import java.util.Scanner;

public class BubbleSort {
    // define o tamanho do vetor a ser ordenado
    public static int N = 8;

    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);

        /*gera vetor fora de ordem*/
        int i;
        int[] vector = new int[N];
        System.out.println("Digite "+N+" números inteiros: ");

        for(i = 0; i < N; i++)
            vector[i] = input.nextInt();

        System.out.println("Ordenando o vetor com Bubblesort mais eficiente ");
        boolean swap= true; /* supõe realizar troca */
        for (i=0;i<N-1 && swap==true; i++){
            int aux;
            swap= false; /* supõe não realizar troca */
            for (int j=0;j<N-i-1;j++){
                if (vector[j]> vector[j+1]){
                    aux= vector[j];
                    vector[j]= vector[j+1];
                    vector[j+1]=aux;

                    /*registra que houve troca na iteração*/
                    swap=true;
                }
            }
        }
        for(i = 0; i <N; i++)
            System.out.println(i +"	"+ vector[i]);
        input.close();
    }
}
