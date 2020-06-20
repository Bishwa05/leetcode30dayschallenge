package june.week3;

import java.util.HashSet;

/**
 *
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
 *
 * Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
 *
 *
 *
 * Example 1:
 *
 * Input: "banana"
 * Output: "ana"
 * Example 2:
 *
 * Input: "abcd"
 * Output: ""
 *
 */
public class LongestDuplicateSubstring {

    public int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for(int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for(int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = (int)S.charAt(i) - (int)'a';
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) left = L + 1;
            else right = L;
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }
}
