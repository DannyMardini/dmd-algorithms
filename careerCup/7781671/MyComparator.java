import java.util.Comparator;

class MyComparator implements Comparator<Integer>
{
    public int compare(Integer a, Integer b)
    {
        if(a == b)
        {
            return 0;
        }

        char[] a_arr = Integer.toString(a.intValue()).toCharArray();
        char[] b_arr = Integer.toString(b.intValue()).toCharArray();
        int i = 0;
        while(i < a_arr.length && i < b_arr.length)
        {
            if(a_arr[i] > b_arr[i])
            {
                return -1;
            }
            else if(a_arr[i] < b_arr[i])
            {
                return 1;
            }
            i++;
        }
        
        if(i >= a_arr.length)
        {
            return -1;
        }

        return 1;
    }
}
