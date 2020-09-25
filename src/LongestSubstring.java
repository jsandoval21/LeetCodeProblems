import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    private final int ALPHABET = 26;

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int longest = 0;
        int temp;
        char key;
        Map<Character, Integer> c = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            key = s.charAt(i);
            if(c.containsKey(key)){
                temp = i - c.get(key);
                if(temp > length)
                    length += 1;
                else
                    length = temp;

                c.put(key, i);
            } else {
                c.put(key, i);
                length += 1;
            }

            if(longest < length) {
                longest = length;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();

        System.out.println(ls.lengthOfLongestSubstring(" "));
    }
}
