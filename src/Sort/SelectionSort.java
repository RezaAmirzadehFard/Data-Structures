package Sort;
/*
 *  Selection sort:
 *  Time complexity: O(n^2)
 *  Solve with incremental approach.
 *
 *  Best-Case Running Time : O(n^2)
 *  Worst-Case Running Time : O(n^2)
 *  Average-Case Running Time: O(n^2)
 *
 *  It's an in-place sorting algorithm. (in-place: no need for extra space)
 *  It's fast sorting for little amounts but slow sorting for huge amounts of data.
 *
 *  Explain :
 *
 *  Author: Reza Amirzadeh Fard
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] a ={7,6,3,6,4,6,7,4,2,1,5};
        printArray(selectionSort(a));
    }

    // Selection sort with increasing order
    // This selection sort each time find minimum element in array
    // Exercise 2.2-2 (CLRS)
    static int[] selectionSort(int[] array){
        int l = array.length;
        for (int i = 0 ; i < l - 1; i++){                                                                               // n
            int min = array[i];                                                                                         // n-1
            int indexMin = i;                                                                                           // n-1
            for (int j = i+1; j < l; j++){                                                                              // n
                if ( min > array[j]){                                                                                   // sigma(j=1 to n) t_j-1
                    min = array[j];                                                                                     // sigma(j=1 to n) t_j-1
                    indexMin = j;                                                                                       // sigma(j=1 to n) t_j-1
                }
            }
            int temp = array[i];                                                                                        // n-1
            array[i] = min;                                                                                             // n-1
            array[indexMin] = temp;                                                                                     // n-1
        }
        return array;                                                                                                   // T(n) = O(n^2)
    }

    static void printArray(int[] array){
        for(int a: array)
            System.out.print(" " + a);
        System.out.println();
    }

}