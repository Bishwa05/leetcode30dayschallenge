package oct.week1;

public class ComplementOfBase10Integer
{
    public int bitwiseComplement(int N) {
        if(N ==0) return 1;
        int res =0;
        StringBuilder sb = new StringBuilder();
        while(N!=0) {
            int rem = N%2;
            int num = (rem==1) ?0:1;
            sb.append(num);
            N = N>>1;
        }

        String bool = sb.toString();
        for(int i =0; i< bool.length(); i++){
          if(bool.charAt(i)=='1'){
              res+=Math.pow(2,i);
          }
        }
        return res;
    }


    public int findComplement(int num)
    {
        int ans = 0;
        int count = 0;

        while (num > 0) {
            if ((1 & num) == 0) {
                ans = ans + (int)Math.pow(2, count);
            }
            num = num >> 1;
            count++;
        }
        return ans;
    }

    public static void main(String arg[]){
        ComplementOfBase10Integer c = new ComplementOfBase10Integer();
        System.out.println(c.bitwiseComplement(10));
    }
}
