package Sort;
//incomplete

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1};
        printArray(mergeSort(a,0,a.length-1));
    }
    static int[] mergeSort(int[] array, int p, int r){
        if (p < r){
            int q = (p+r)/2 ;
            mergeSort(array,p,q);
            mergeSort(array,q+1,r);
            merge(array, p, q, r);
        }
        return array;
    }

    // length of array is even = 4 -> {0,1,2,3} -> p = 0 , r = 3, q = 1 -> left array: q-p+1 = 1-0+1=2 -> {0,1},right array -> r-q=3-1=2 -> {2,4}
    // length of array  is odd = 5 -> {0,1,2,3,4} -> p = 0 , r = 4, q = 2 -> left array: 2-0+1 = 3 -> {0,1,2}. right array -> 4-2= 2 -> {3,4}

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

    static void printArray(int[] array){
        for(int a: array)
            System.out.print(" " + a);
        System.out.println();
    }
}
