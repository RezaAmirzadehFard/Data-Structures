package Sort;

/*
 *  Insertion sort
 *  Time complexity : O( n^2 )
 *  Solve with incremental approach.
 *
 *  Best-Case Running Time : O( n ) -> it's occur when array is sorted, then condition of while loop doesn't execute -
 *  and key stay in its place.
 *  Worst-Case Running Time : O( n^2 ) -> it's occur when array is sorted reverse order (decreasing order).
 *  Average-Case Running Time: O( n^2 )
 *
 *  It's an in-place sorting algorithm. ( in-place: no need for extra space )
 *  It's fast sorting for little amounts but slow sorting for huge amounts of data.
 *
 *  Explain :
 *  Insertion sort like a card play game.
 *  If you have some card in your hand, and you're beginning from right to left -
 *  each time take a card from table and compare with left cards
 *  and insert current card in suitable place.
 *
 *  Author: Reza Amirzadeh Fard
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] intArray = {8,3,2,4,9,1,6,2,1,7,8};
        System.out.print("Input array:");
        printArray(intArray);
        System.out.print("Insertion sort with increasing order :");
        printArray(insertionSort(intArray));
        System.out.print("Insertion sort with decreasing order :");
        printArray(insertionSortDec(intArray));
        System.out.println("===========================");
        insertionSortDisplay(intArray);
    }

    // Insertion sort with increasing order
    // add low-key to first of array
    static int[] insertionSort(int[] array){
        // length of array
        int l = array.length;
        // iterate loop from second element of array and for first iterate consider second element as KEY
        for (int j = 1; j < l ; j ++){                                                                                  // n
            int key = array[j];                                                                                         // n-1
            int i = j - 1;                                                                                              // n-1
            // insert left element of key to next home if satisfy condition
            // and also do this to achieve first of array
            while (i >= 0 && array[i] > key){                                                                           // sigma(j=2 to n) t_j
                array[i+1] = array[i];                                                                                  // sigma(j=2 to n) t_j-1
                i = i - 1;                                                                                              // sigma(j=2 to n) t_j-1
            }
            // insert KEY to place that all left element of KEY is smaller than KEY
            array[i+1] = key;                                                                                           // n-1
        }
        return array;                                                                                                   // T(n) = O(n^2)
    }

    // Insertion sort with decreasing order
    // Exercise 2.1-2 (CLRS)
    static int[] insertionSortDec(int[] array){
        int l = array.length;
        for (int j = 1; j < l; j++){
            int key = array[j];
            int i = j - 1;
            while( i >= 0 && array[i] < key){
                array[i+1] = array[i];
                i = i-1;
            }
            array[i+1] = key;
        }
        return array;
    }

    // Insertion sort within display step by step
    static void insertionSortDisplay(int[] array){
        int l = array.length;
        for (int j = 1; j < l ; j ++){
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key){
                array[i+1] = array[i];
                i = i - 1;
                System.out.printf("a[%d] -> a[%d]:\t",i+1,i);
                printArray(array);
            }
            array[i+1] = key;
            System.out.printf("key  -> a[%d]:\t",i+1);
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