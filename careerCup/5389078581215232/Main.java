import java.util.HashMap;

public class Main
{
    public static boolean anagramSubstring(String a, String b)
    {
        if(b.length() < a.length())
        {
            return false;
        }

        for(int i = 0; i <= b.length() - a.length(); i++) {
            if(isAnagram(a, b.substring(i, i+a.length()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnagram(String a, String b) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        char[] c_array = a.toCharArray();

        for(char c : c_array) {
            Character c_ref = new Character(c);
            if(!h.containsKey(c_ref)) {
                h.put(c_ref, new Integer(1));
            }
            else {
                Integer count = h.get(c_ref);
                h.put(c_ref, new Integer(count + 1));
            }
        }

        c_array = b.toCharArray();

        for(char c : c_array) {
            Character c_ref = new Character(c);

            if(h.containsKey(c_ref)) {
                Integer count = h.get(c_ref);
                count = new Integer(count.intValue() - 1);
                if(count <= 0) {
                    h.remove(c_ref);
                }
                else {
                    h.put(c_ref, count);
                }
            }
        }
        
        return h.size() == 0;
    }

    public static void main(String[] args)
    {
        if(args.length < 2) {
            System.out.println("Please give me two strings.");
            return;
        }

        String a = args[0];
        String b = args[1];

        System.out.println("is anagram of " + a + " a substring of " + b + "? " + String.valueOf(anagramSubstring(a, b)));
    }
}

