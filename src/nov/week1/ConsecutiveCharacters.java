package nov.week1;

public class ConsecutiveCharacters
{
    public int maxPower(String s) {
        if(s.length() ==1) return 1;
        if(s.length() ==0) return 0;
        int res =1;
        int p =1;
        char c = s.charAt(0);

        for(int j =1; j<s.length(); j++){
            if(c== s.charAt(j)){
                p++;
            }else{
                res = Math.max(res,p);
                p=1;
            }
            c= s.charAt(j);
        }
        res = Math.max(res,p);
        return res;
    }
}
