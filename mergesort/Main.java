import java.util.ArrayList;
import java.util.List;

/*
 * Best Case: O(n log n)
 * Worst Case: O(n log n)
 */

class Main
{

    public static List<Integer> mergeSort(List<Integer> list)
    {
        if(list.size() == 1) {
            return list;
        }

        List<Integer> lista = list.subList(0, list.size()/2);
        List<Integer> listb = list.subList(list.size()/2, list.size());

        return merge(mergeSort(lista), mergeSort(listb));
    }

    public static List<Integer> merge(List<Integer> lista, List<Integer> listb) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int ita = 0;
        int itb = 0;

        while(ita < lista.size() || itb < listb.size()) {
            int a = (ita < lista.size()) ? lista.get(ita) : Integer.MAX_VALUE;
            int b = (itb < listb.size()) ? listb.get(itb) : Integer.MAX_VALUE;

            if(a < b) {
                result.add(a);
                ita++;
            } else {
                result.add(b);
                itb++;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(2);

        List<Integer> sorted = mergeSort(list);

        System.out.println("Sorted list:");
        for(int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i) + " ");
        }
        System.out.println();
    }
}
