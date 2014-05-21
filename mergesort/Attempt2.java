import java.util.Arrays;

public class Attempt2
{
    public static void MergeSort(int[] a, int low, int high) {
        if(low >= high) {
            return;
        }

        int middle = (low + high)/2;
        MergeSort(a, low, middle);
        MergeSort(a, middle+1, high);
        Merge(a, low, middle, high);
    }

    public static void Merge(int[] a, int low, int middle, int high) {
        if(low > middle || middle > high) {
            return;
        }

        int[] helper = new int[a.length];
        for(int i = 0; i < helper.length; i++) {
            helper[i] = a[i];
        }

        int left = low;
        int right = middle+1;
        int i = low;

        while(right <= high && left <= middle) {
            if(helper[left] < helper[right]) {
                a[i] = helper[left];
                left++;
            }else {
                a[i] = helper[right];
                right++;
            }
            i++;
        }

        while(left <= middle) {
            a[i] = helper[left];
            i++;
            left++;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5, 3, 4, 6, 2, 10};
        System.out.println("Before: " + Arrays.toString(a));
        MergeSort(a, 0, a.length-1);
        System.out.println("After: " + Arrays.toString(a));
    }
}
