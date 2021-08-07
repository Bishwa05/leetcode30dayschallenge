package aug21;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 */
public class PalindromePartitioningII
{
    private boolean isPalindrome(String str, int i, int j){
        while(i<j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
    private int minPalindromePartition(String s, int i, int j){
        if(i>=j || isPalindrome(s, i, j)) return 0;

        int ans = Integer.MAX_VALUE, count;

        for(int k =i; k<j; k++){
            count = minPalindromePartition(s, i, k)+
                minPalindromePartition(s, k+1, j) +1;
            ans = Math.min(ans, count);
        }
        return ans;
    }
    // TLE
    public int minCut(String s) {
        return minPalindromePartition(s, 0, s.length()-1);
    }


    public int minCutDP(String s){
        int[] cut = new int[s.length()];
        boolean[][] palindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            int minCut = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    minCut = Math.min(minCut, j == 0 ? 0 : (cut[j - 1] + 1));
                }
            }
            cut[i] = minCut;
        }

        return cut[s.length() - 1];
    }
}
