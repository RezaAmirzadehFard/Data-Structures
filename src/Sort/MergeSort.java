package Sort;
/*
 *  Merge sort:
 *  Time complexity: O(nlgn)
 *  Solve with divide and conquer approach.
 *
 *  Divide and conquer approach include three steps:
 *  1.Divide: break problem to some subproblems that like the original problem in smaller size.
 *  2.Conquer: solve subproblems in a recursive manner, to reach basic condition then solve that straightForwardly.
 *  3.Combine: combine solutions of subproblems to obtain a solution of original problem.
 *
 *  Notice: The recursion bottoms out when the subproblem to be sorted has length 1, -
 *  in which case there is no work to be done, since every sequence of length 1 is already in sorted order.
 *
 *  Best-Case Running Time: O(nlgn)
 *  Worst-Case Running Time: O(nlgn)
 *  Average-Case Running Time: O(nlgn)
 *
 *  Notice: when the size of an array (n) that should sort with mergeSort is bigger than 1 (n>1) in all circumstances
 *  case time complexity is O(nlgn).
 *
 *  It is not an in-place sorting algorithm. (in-place: no need for extra space)
 *  It's good sorting for huge amounts of data.
 *
 *  Explain:
 *  Consider you have two piles of sorted cards (mergeSort(array,p,q),mergeSort(array,q+1,r)).
 *  We want to combine (merge) these two piles to one output pile that sorted.
 *  In each recursion that we have with calling mergeSort inside itself, we break a problem
 *  and repeat these steps until reach to array length 1 (that sorted); then it's ready for merge operation.
 *
 *  Author: Reza Amirzadeh Fard
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2};
        // Exercise 2.3-1 (CLRS)
        int[] b = {3,41,52,26,38,57,9,49};
        printArray(mergeSort(a,0,a.length-1));
        //mergeSortDisplay(a,0,a.length-1);
    }

    /* Example of indices in two conditions:
     * Set Parentheses demonstrates an array that include indices of its home.
     * Length of array is even:
     * e.g = 4 -> {0,1,2,3} -> [p = 0 , r = 3, q = 1] -> left array: q-p+1 = 1-0+1 = 2 -> {0,1}, right array -> r-q = 3-1 = 2 -> {2,4}
     * Length of array  is odd:
     * e.g = 5 -> {0,1,2,3,4} -> [p = 0 , r = 4, q = 2] -> left array: q-p+1 = 2-0+1 = 3 -> {0,1,2}, right array -> r-p = 4-2= 2 -> {3,4}
     */

    // Parameter p is the start index of the array that we assume zero in first invokes.
    // Parameter r is the last index of the array ( array.length - 1).
    static int[] mergeSort(int[] array, int p, int r){
        int i =0;
        // if a statement checks at least we have one element in an array.
        if (p < r){
            // find a point for break point of problem to subproblems.
            int q = (p+r)/2 ;
            // Divide step: divide into two array[p..q], array[q+1..r] subproblems.
            // Conquer step: solve two subproblems recursively by calling its mergeSort method.
            // These two subproblems return sorted an array.
            mergeSort(array,p,q);                                                                                       // T(n/2)
            mergeSort(array,q+1,r);                                                                                  // T(n/2)
            // The combine step here occurs with an auxiliary method names merge.
            // Returned sorted arrays merge here.
            merge2(array, p, q, r);                                                                                      // theta of n (ref:for-start-index-k)
        }
        return array;
    }                                                                                                                   // T(n) = 2T(n/2) + theta(n)


    static void merge(int[] array, int p, int q, int r){
        // Compute length of subarray array[p..q]
        int n1 = q - p + 1;                                                                                             // const
        // Compute length of subarray array[q+1..r]
        int n2 = r - q;                                                                                                 // const
        // Create two arrays with one extra place for holding sentinel
        int[] leftArray = new int[n1+1];                                                                                // const
        int[] rightArray = new int[n2+1];                                                                               // const
        // Copy elements of array[p..q] to leftArray
        for (int i = 0; i < n1; i++) {                                                                                  // theta of n1
            leftArray[i] = array[p+i];
        }
        // Copy elements of array[q+1..r] to rightArray
        for (int j = 0; j < n2; j++) {                                                                                  // theta of n2
            rightArray[j] = array[j+q+1];
        }
        // Sentinels
        leftArray[n1] = Integer.MAX_VALUE;                                                                              // const
        rightArray[n2] = Integer.MAX_VALUE;                                                                             // const

        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++){                                                                                    // n = r - p + 1 => theta of n
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }                                                                                                                   // theta(n1 + n2) + theta(n) = theta(2n) = theta(n)

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
            rightArray[j] = array[q+1+j];
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

    // TODO: incomplete
    // merge without sentinel
    static void merge2(int array[], int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i = 0; i < n1; i++){
            leftArray[i] = array[p+i];
        }
        for (int j = 0; j < n2; j++){
            rightArray[j] = array[q+1+j];
        }

        int i = 0;
        int j = 0;
        int leftFlag = 0;
        int rightFlag = 0;
        for(int k = p; k <= r; k++){
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    static void printArray(int[] array){
        for(int a: array)
            System.out.print(" " + a);
        System.out.println();
    }
}