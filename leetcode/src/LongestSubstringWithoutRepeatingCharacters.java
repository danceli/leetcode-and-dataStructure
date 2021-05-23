public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongest(String s) {
        int l = 0, r = -1;
        int ret = 1;
        int[] freq = new int[256];
        while(l < s.length()) {
            if(r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            ret = Math.max(ret, r -l + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int res = lengthOfLongest("abcabcbb");
        System.out.println(res);
    }
}
