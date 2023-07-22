package Sort;
//incomplete

public class MergeSort {
    public static void main(String[] args) {

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

    static int[] merge(int[] array, int p, int q, int r){
        return array;
    }
}
