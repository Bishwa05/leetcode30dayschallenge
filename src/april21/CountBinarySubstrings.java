package april21;

/**
 *
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 *
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 *
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 *
 *
 *
 */
public class CountBinarySubstrings
{
    public int countBinarySubstrings(String s) {
        if (s== null) return 0;

        int numberConsecutiveOnes = 0;
        int numberConsecutiveZeroes = 0;
        int result = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++)
        {
            if (ch[i] == '0')
            {
                if (i - 1 >= 0 && ch[i - 1] == '1') numberConsecutiveZeroes = 0;
                numberConsecutiveZeroes++;
                if (numberConsecutiveZeroes <= numberConsecutiveOnes) result++;
            }
            else
            {
                if (i - 1 >= 0 && ch[i - 1] == '0') numberConsecutiveOnes = 0;
                numberConsecutiveOnes++;
                if (numberConsecutiveOnes <= numberConsecutiveZeroes) result++;
            }
        }

        return result;
    }


}
