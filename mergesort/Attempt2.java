import java.util.Arrays;
import java.util.ArrayList;

public class Attempt2
{
    public static void MergeSort(int[] a) {
        int[] helper = new int[a.length];
        MergeSort(a, helper, 0, a.length-1);
    }

    public static void MergeSort(int[] a, int[] helper, int low, int high) {
        if(low >= high) {
            return;
        }

        int middle = (low + high)/2;
        MergeSort(a, helper, low, middle);
        MergeSort(a, helper, middle+1, high);
        Merge(a, helper, low, middle, high);
    }

    public static void Merge(int[] a, int[] helper, int low, int middle, int high) {
        if(low > middle || middle > high) {
            return;
        }

        for(int i = low; i <= high; i++) {
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

    public static int[] toIntArray(ArrayList<Integer> a) {
        int[] arr = new int[a.size()];

        for(int i = 0; i < a.size(); i++) {
            arr[i] = a.get(i);
        }

        return arr;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();

        for(String s : args)
        {
            a.add(Integer.parseInt(s));
        }

        int[] arr = toIntArray(a);
            
        System.out.println("Before: " + Arrays.toString(arr));
        MergeSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }
}
