/*
 * Notes:
 * 1. To access elements in the arraylist, the function is called .get, not .at.
 * 2. ArrayList only accepts reference types, does not accept primitives (must use Integer instead of int).
 * 3. Min value is Integer.MIN_VALUE.
 * 4. Shallow copy A, B will copy all of A's field values. Including memory addresses. Therefore if you set the value at that address, what A is pointing to will be modified.
 * 5. Better to use the copy constructor in Java to copy two objects (such as arraylists).
 */

import java.util.ArrayList;

class Main
{
    public static ArrayList<Integer> getMaxArray(ArrayList<Integer> list) {
        int maxValue = Integer.MIN_VALUE;
        ArrayList<Integer> maxList = new ArrayList<Integer>();

        for(int i = 0; i < list.size(); i++) {
            ArrayList<Integer> currList = new ArrayList<Integer>();
            int sum = 0;
            for(int j = i; j < list.size(); j++) {
                sum += list.get(j);
                currList.add(list.get(j));
                if( sum > maxValue ) {
                    maxValue = sum;
                    maxList = new ArrayList<Integer>(currList);
                }
            }
        }

        return maxList;
    }

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        int[] nums = {2, -8, 3, -2, 4, -10};
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }

        ArrayList<Integer> max = getMaxArray(arr);

        for(int i = 0; i < max.size(); i++)
        {
            sb.append(max.get(i));
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
