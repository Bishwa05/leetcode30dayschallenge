package may.week3;

import java.util.*;

public class FindAllAnagramsInAString {


    public boolean matchAnagram(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) return false;
        int[] dict = new int[26];
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            dict[ch-'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            dict[ch-'a']--;
            if (dict[ch-'a'] < 0) return false;
        }
        return true;
    }


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (p == null || s == null || s.length() < p.length()) return res;
        int m = s.length(), n = p.length();
        for (int i = 0; i < m-n+1; i++) {
            String cur = s.substring(i, i + n);
            if (matchAnagram(cur, p)) res.add(i);
        }
        return res;
    }


    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (p.length() > s.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    match++;
                }
            }
            if (i >= p.length()) {
                c = s.charAt(i - p.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        if (s == null || p == null) {
            return Collections.emptyList();
        }
        int m = p.length(), n = s.length();
        if (m > n) {
            return Collections.emptyList();
        }
        int[] pf = new int[26];
        for (int i = 0; i < m; i++) {
            int idx = p.charAt(i) - 'a';
            pf[idx]++;
        }
        List<Integer> ans = new ArrayList<>();
        int[] sf = new int[26];
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            sf[idx]++;
            if (i < m - 1) {
                continue;
            }
            if (i >= m) {
                idx = s.charAt(i - m) - 'a';
                sf[idx]--;
            }
            boolean found = true;
            for (int j = 0; j < 26; j++) {
                if (pf[j] != sf[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ans.add(i - m + 1);
            }
        }
        return ans;
    }

    public static void main(String arg[]){

        FindAllAnagramsInAString f = new FindAllAnagramsInAString();

        String s = "cbaebabacd";
        String p = "abc";

        f.findAnagrams3(s, p).forEach(e -> System.out.println(e));

    }
}
