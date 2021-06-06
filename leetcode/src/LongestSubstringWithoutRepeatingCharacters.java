import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
//    public static int lengthOfLongest(String s) {
//        int l = 0, r = -1;
//        int ret = 1;
//        int[] freq = new int[256];
//        while(l < s.length()) {
//            if(r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
//                freq[s.charAt(++r)]++;
//            } else {
//                freq[s.charAt(l++)]--;
//            }
//            ret = Math.max(ret, r -l + 1);
//        }
//        return ret;
//    }

    public static int lengthOfLongest(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxLen = 1;
        int slow = 0, hi = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(; hi < n; hi++) {
            char cur = s.charAt(hi);
            if(map.containsKey(cur)) {
                slow = map.get(cur) + 1;
            }
            map.put(cur, hi);
            maxLen = Math.max(maxLen, hi - slow + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int res = lengthOfLongest("abcabcbb");
        System.out.println(res);
    }
}
