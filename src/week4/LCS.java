package week4;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class LCS {

    /**
     * The recursive solution
     * Time complexity : O(2^m *(m+n))
     */
    public int longestCommonSubsequence(String text1, String text2){
        if(text1.isEmpty()|| text2.isEmpty()) return 0;

        if(text1.charAt(0)== text2.charAt(0)){
            return 1+ longestCommonSubsequence(text1.substring(1), text2.substring(1));
        }

        return Math.max(longestCommonSubsequence(text1,text2.substring(1)),
                longestCommonSubsequence(text1.substring(1),text2));
    }


    Map<Pair<String,String>,Integer> cache = new HashMap<>();

    public int longestCommonSubsequenceMemo(String text1, String text2){
        if(text1.isEmpty()|| text2.isEmpty()) return 0;

        Pair<String,String> x = new Pair(text1,text2);

        if(cache.containsKey(x)) return cache.get(x);
        if(text1.charAt(0)== text2.charAt(0)){
            return 1+ longestCommonSubsequenceMemo(text1.substring(1), text2.substring(1));
        }

        cache.put(x,Math.max(longestCommonSubsequenceMemo(text1,text2.substring(1)),
                longestCommonSubsequenceMemo(text1.substring(1),text2)));

        return cache.values().stream().max((a,b) -> (a>b)?a:b).orElse(0);
    }

    /**
     *
     * DP bottom up approach
     *
     */
    public int longestCommonSubsequenceDP(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int [n+1][m+1];

        char []ch1= text1.toCharArray();
        char []ch2 = text2.toCharArray();

        for(int i=1;i<=n; i++){
            for(int j =1; j<=m; j++){
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String arg[]){
        int m =6; int n =7;
        //int m =1; int n = 2147483647;
        //int m =1; int n =3;
        LCS l = new LCS();
        System.out.println(l.longestCommonSubsequence("abbc",
                "abc"));
        System.out.println(l.longestCommonSubsequenceMemo("bl",
                "yby"));


    }
}
