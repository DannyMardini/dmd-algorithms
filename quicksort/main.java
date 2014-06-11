import java.util.Arrays;
import java.util.Random;

class main
{
    public static void quicksort(int[] a, int low, int high)
    {
        int index = partition(a, low, high);

        if(low < index) {
            quicksort(a, low, index - 1);
        }

        if(high > index) {
            quicksort(a, index + 1, high);
        }
    }

    public static void swap(int[] a, int x, int y)
    {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static int partition(int[] a, int low, int high)
    {
        int pivot = a[(low+high)/2];

        int left = low;
        int right = high;

        while(left < right) {
            while(a[left] < pivot) {
                left++;
            }

            while(a[right] > pivot) {
                right--;
            }

            /*
            if(left < right) {
                swap(a, left, right);
            }
            */
            if(left < right)
            {
                swap(a, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    public static int[] createRandomArray(int length)
    {
        Random r = new Random();
        int[] a = new int[length];

        for(int i = 0; i < a.length; i++)
        {
            a[i] = r.nextInt(a.length);
        }

        return a;
    }

    public static void main(String[] args)
    {
        int[] a = createRandomArray(10);
        //int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] a = {5, 4, 3, 2, 1};
        System.out.println("Before: " + Arrays.toString(a));
        quicksort(a, 0, a.length-1);
        System.out.println("After: " + Arrays.toString(a));
    }
}
