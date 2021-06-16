package jun21.week3;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String>res, String curr, int open, int close, int n)     {
        if(curr.length() == 2*n) {
            res.add(curr);
            return;
        }

        if(open<n) backtrack(res, curr+"(", open+1, close, n);
        if(close<open) backtrack(res, curr+")", open, close+1, n);
    }
}
