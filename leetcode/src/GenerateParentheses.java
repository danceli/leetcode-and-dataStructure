import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private static List<String> res;
    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate(n, 0, 0, "");
        return res;
    }
    public static void generate(int n, int left, int right, String s) {
        //terminator
        if(left == n && right == n) {
            res.add(s);
            return;
        }
        // process
        if(left < n) generate(n, left + 1, right, s + "(");
        if(right < n) generate(n, left, right + 1, s + ")");
    }

    public static void main(String[] args) {
        List<String> ret = generateParenthesis(3);
        System.out.println(ret);
    }
}
