package mergesort;

import java.util.Scanner;
import java.util.Random;

public class MergeSort {

    public static int[] vetor;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Numeros de elemetos:");
        int num = teclado.nextInt();
        vetor = new int[num];
        Random numeros = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = numeros.nextInt(num);
        }
        System.out.println("Vetor gerado:");

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println();

        int[] copiaVetor = new int[vetor.length];

        System.arraycopy(vetor, 0, copiaVetor, 0, vetor.length);

        System.out.println("Copia do vetor original:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(copiaVetor[i] + " ");
        }
        System.out.println();

        System.out.println("Copia ordenada:");
        mergeSort(0, vetor.length);
        imprimeVetor();

    }

    public static void merge(int inicio, int meio, int fim) {

        int[] vetorW = new int[vetor.length];

        int i, j, k;

        i = inicio;
        j = meio;
        k = 0;

        while (i < meio && j < fim) {
            if (vetor[i] < vetor[j]) {
                vetorW[k] = vetor[i];
                i++;
            } else {
                vetorW[k] = vetor[j];
                j++;
            }

            k++;
        }

        while (i < meio) {
            vetorW[k] = vetor[i];
            i++;
            k++;
        }
        while (j < fim) {
            vetorW[k] = vetor[j];
            j++;
            k++;
        }
        for (i = inicio; i < fim; i++) {
            vetor[i] = vetorW[i - inicio];
        }

    }

    public static void mergeSort(int inicio, int fim) {

        int meio;
        if (inicio < fim - 1) {
            meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio, fim);
            merge(inicio, meio, fim);
        }
    }

    static void imprimeVetor() {

        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("%d ", vetor[i]);
        }

        System.out.println();

    }
}
