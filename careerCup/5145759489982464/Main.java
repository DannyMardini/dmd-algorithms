import java.util.Arrays;
import java.util.Random;

class Main
{
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void toWave(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            if( i%2 == 0 ) {
                if( !(a[i] <= a[i+1]) ) {
                    swap(a, i, i+1);
                }
            } else {
                if( !(a[i] >= a[i+1]) ) {
                    swap(a, i, i+1);
                }
            }
        }
    }

    public static void ShuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ShuffleArray(a);
        System.out.println("Before: " + Arrays.toString(a));

        toWave(a);

        System.out.println("After: " + Arrays.toString(a));
    }
}
