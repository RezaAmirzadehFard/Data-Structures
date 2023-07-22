package Sort;

public class SelectionSort {
    public static void main(String[] args){
        int[] a ={7,6,4,3,6,4,2,1};
        printArray(selectionSort(a));
        //selectionSort(a);
    }

    // Exercise 2.2-2 (CLRS)
    static int[] selectionSort(int[] array){
        int l = array.length;
        for (int i = 0; i < l - 1; i++){
            int min = array[i];
            for (int j = i+1; j <= l-1; j++){
                if ( min > array[j]){
                    min = array[j];
                }
            }
            int indexMin = 0;
            for (int k = 0; k<l;k++) {
                if (array[k] == min)
                    indexMin = k;
            }
            int temp = array[i];
            array[i] = min;
            array[indexMin] = temp;
        }
        return array;
    }

    static void printArray(int[] array){
        for(int a: array)
            System.out.print(" " + a);
        System.out.println();
    }

}
