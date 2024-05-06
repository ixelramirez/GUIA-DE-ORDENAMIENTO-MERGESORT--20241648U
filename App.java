public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
public class MergeSort {

    // Método principal para ordenar un arreglo usando MergeSort
    public static void mergeSort(int[] arr, int izq, int der) {
        if (izq < der) {
            // Encuentra el punto medio del arreglo
            int medio = (izq + der) / 2;

            // Ordena las dos mitades
            mergeSort(arr, izq, medio);
            mergeSort(arr, medio + 1, der);

            // Combina las mitades ordenadas
            merge(arr, izq, medio, der);
        }
    }

    // Método para combinar las dos mitades de un arreglo
    public static void merge(int[] arr, int izq, int medio, int der) {
        // Encuentra el tamaño de los subarreglos para combinarlos
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        // Crea arreglos temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arreglos temporales
        for (int i = 0; i < n1; ++i)
            L[i] = arr[izq + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[medio + 1 + j];

        // Índices iniciales del primer y segundo subarreglo
        int i = 0, j = 0;

        // Índice inicial del subarreglo combinado
        int k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de L si los hay
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de R si los hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Método para imprimir el arreglo de tamaño n
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Método principal para probar el algoritmo
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Arreglo original:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArreglo ordenado:");
        printArray(arr);
    }
}