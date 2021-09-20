package sept21.week3;

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
}
