import java.util.Scanner;

public class EncontrarMenorEMaior {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[10];
        int[] contagem = new int[101]; // Intervalo de -50 a 50

        // Cadastrando os números
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            numeros[i] = scanner.nextInt();
        }

        // Ordenando os números (método bolha)
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }

        int menor = numeros[0];
        int maior = numeros[numeros.length - 1];

        
        for (int numero : numeros) {
            contagem[numero + 50]++;

        System.out.println("\nNúmeros ordenados:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.printf("\n\nO menor número é %d e aparece %d vezes.", menor, contagem[menor + 50]);
        System.out.printf("\nO maior número é %d e aparece %d vezes.", maior, contagem[maior + 50]);
    }
}
