package Sort;
/*
 *  Merge sort
 *  Time complexity : O( nlgn )
 *  Solve with divide and conquer approach.
 *
 *  Divide and conquer approach include three step:
 *  1.Divide : break problem to some subproblems that like original problem in smaller size.
 *  2.Conquer : solve subproblems in recursively manner, to reach basic condition then solve that straightForward.
 *  3.Combine : combine solutions of subproblems to obtain solution of original problem.
 *
 *  Best-Case Running Time : O(  ) -> it's occur when
 *  Worst-Case Running Time : O(  ) -> it's occur when
 *  Average-Case Running Time: O(  )
 *
 *  It is not an in-place sorting algorithm. (in-place: no need for extra space)
 *  It's good sorting for huge amounts of data.
 *
 *  Explain :
 *
 *  Author: Reza Amirzadeh Fard
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2};
        printArray(mergeSort(a,0,a.length-1));
        //mergeSortDisplay(a,0,a.length-1);
    }

    /* Example of indices in two condition:
     * Set Parentheses demonstrates an array that include indices of its home.
     * Length of array is even:
     * e.g = 4 -> {0,1,2,3} -> [p = 0 , r = 3, q = 1] -> left array: q-p+1 = 1-0+1 = 2 -> {0,1}, right array -> r-q = 3-1 = 2 -> {2,4}
     * Length of array  is odd:
     * e.g = 5 -> {0,1,2,3,4} -> [p = 0 , r = 4, q = 2] -> left array: q-p+1 = 2-0+1 = 3 -> {0,1,2}, right array -> r-p = 4-2= 2 -> {3,4}
     */

    static int[] mergeSort(int[] array, int p, int r){
        if (p < r){
            int q = (p+r)/2 ;
            mergeSort(array,p,q);
            mergeSort(array,q+1,r);
            merge(array, p, q, r);
        }
        return array;
    }

    static void merge(int[] array, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] leftArray = new int[n1+1];
        int[] rightArray = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[p+i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[j+q+1];
        }
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++){
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    static void mergeDisplay(int[] array, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] leftArray = new int[n1+1];
        int[] rightArray = new int[n2+1];
        System.out.print(" Left part:");
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[p+i];
            System.out.print(" "+ leftArray[i]);
        }
        System.out.println();
        System.out.print(" Right part:");
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[j+q+1];
            System.out.print(" "+ rightArray[j]);
        }
        System.out.println();
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++){
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }else {
                array[k] = rightArray[j];
                j++;
            }
        }
        System.out.print(" Merge left and right parts:");
        printArray(array);
    }

    static void printArray(int[] array){
        for(int a: array)
            System.out.print(" " + a);
        System.out.println();
    }
}
