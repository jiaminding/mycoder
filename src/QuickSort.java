import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int start, int end){
        if (start >= end) {
            return;
        }
        int keyPos = partition(a, start, end);
        quickSort(a, start, keyPos - 1);
        quickSort(a, keyPos + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int key = a[start];
        while (start < end) {
            while(a[end] >= key && start < end) end--;
            a[start] = a[end];
            while(a[start] <= key && start < end) start++;
            a[end] = a[start];
        }
        a[end] = key;
        return end;
    }

    public static void main(String[] args) {
        int a[] = {6,5,4,3,2,1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);

        System.out.println();
    }
}
