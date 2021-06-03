package jun21;

public class InterleavingString
{
    public boolean isInterleave(String s1, int i, String s2, int j, String res, String s3){
        if(res.equals(s3) && i == s1.length() && j == s2.length()){
            return true;
        }
        boolean ans = false;
        if(i< s1.length()){
            ans|=isInterleave(s1, i+1, s2, j, res+ s1.charAt(i), s3);
        }
        if(j< s2.length()){
            ans |= isInterleave(s1, i, s2, j+1, res+s2.charAt(j), s3);
        }
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        return isInterleave(s1, 0, s2, 0, "", s3);
    }
}
