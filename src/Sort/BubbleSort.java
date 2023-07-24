package Sort;

/*
 *  Bubble sort
 *  Time complexity : O( n^2 )
 *  Solve with incremental approach.
 *
 *  Best-Case Running Time :
 *  Worst-Case Running Time :
 *  Average-Case Running Time:
 *
 *  It's an in-place sorting algorithm. ( in-place: no need for extra space )
 *  It's fast sorting for little amounts but slow sorting for huge amounts of data.
 *
 *  Explain :
 *  As name of algorithm shows in each cycle of nested loop -
 *  one element set into a bubble and goes up (close to first of array), when reach the desired location it's bursting. :)
 *
 *  Author: Reza Amirzadeh Fard
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {8,7,6,5,3,2,1};
        printArray(bubbleSortDisplay(a));
    }

    // Bubble sort with increasing order
    static int[] bubbleSort(int[] array){
        int l = array.length;
        for (int i = 0; i < l; i++){
            for (int j = l; j > i + 1 ; j--){
                if (array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }

    static int[] bubbleSortDisplay(int[] array){
        int l = array.length;
        for (int i = 0; i < l; i++){
            for (int j = l-1; j >= i+1; j--){
                if (array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    printArray(array);
                }
            }
        }
        return array;
    }


    static void printArray(int[] array){
        for(int a: array)
            System.out.print(" " + a);
        System.out.println();
    }
}