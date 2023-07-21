package Sort;

public class Sort {
    // insertion sort
    // O( n^2 )
    // it's fast sorting for little amount ( but heavy sort for big amount of data )
    static int[] insertionSort(int[] array){
        // length of array
        int l = array.length;
        // iterate loop from second element of array and for first iterate consider second element as KEY
        for (int j = 1; j < l ; j ++){
            int key = array[j];
            int i = j - 1;
            // insert left element of key to next home if satisfy condition
            // and also do this to achieve first of array
            while (i >= 0 && array[i] > key){
                array[i+1] = array[i];
                i = i - 1;
            }
            // insert KEY to place that all left element of KEY is smaller than KEY
            array[i+1] = key;
        }
        return array;
    }

    // insertion sort with display steps
    static void insertionSortDis(int[] array){
        int l = array.length;
        for (int j = 1; j < l ; j ++){
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key){
                array[i+1] = array[i];
                i = i - 1;
                System.out.printf("a[%d] -> a[%d]: ",i+1,i);
                printArray(array);
            }
            array[i+1] = key;
            System.out.printf("key -> a[%d]: ",i+1);
            printArray(array);
        }
        System.out.println("\nResult of sorting with insertion sort:");
        printArray(array);
    }

    static void printArray(int[] array){
        for(int a: array)
            System.out.print(" " + a);
        System.out.println();
    }
}
