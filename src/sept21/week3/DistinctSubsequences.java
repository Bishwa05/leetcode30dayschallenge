package sept21.week3;

import java.util.Arrays;

public class DistinctSubsequences
{
    public int numDistinct(String s, String t) {
        int[] arr = new int[1];

        dfs("",0, s, t, arr);
        return arr[0];
    }

    // This approach got TLE
    public void dfs(String nw,int index, String s, String t, int[] arr){
        if(nw.equals(t)){
            arr[0] += 1;
            return;
        }

        for(int i =index; i<s.length(); i++){
            int x = nw.length();
            if(s.charAt(i) == t.charAt(x)){
                StringBuffer sb = new StringBuffer();
                sb.append(nw).append(s.charAt(i));
                dfs(sb.toString(), i+1, s, t, arr);
            }

        }

    }

    int[][] dp;
    public int numDistinct2(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int [] arr : dp) Arrays.fill(arr, -1);

        return dfs(0,0, s, t);
    }

    public int dfs(int i, int j, String s, String t) {
        //if t = "" then we can form atleast 1 string regardless of s, ie s can be "" or have characters
        if (j == t.length()) return 1;

        //if s="" and t != "" then we cannot form any substring. (here t !="" since t=="" already handled in above case)
        if (i == s.length()) return 0;

        //Already encountered this i and j. This because we are doing top-down recursion and each time recursion stack will go from i--> i+1--> i+2, then from i+2 we    return back to i+1.
        if (dp[i][j]!=-1) return dp[i][j];

        //recursion logic.
        if (s.charAt(i) == t.charAt(j)) {
            //Characters are same, ie "b" == "b", however, we dont know if string s has other b's too,
            //ie "bb" & "b", so we compare s(0) with t(0) and s(1) with t(0). Similarly "bbb", "b", etc.
            dp[i][j] = dfs(i+1, j+1, s, t) + dfs(i+1, j, s, t);
        } else {
            // Characters are not same, ie "a" and "b". However, we don't know if s has future characters as b,
            //ie "ab" and "b", here we compare s(1) with t(0)
            dp[i][j] = dfs(i+1, j, s, t);
        }

        return dp[i][j];
    }
}
