package sept21.week2;

public class ShiftingLetters
{
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long[] arr = new long[n];
        arr[n-1] = shifts[n-1]%26;
        for(int i = n-2, j =0; i>=0; i--){
            arr[i] = arr[i+1]+ shifts[i];
            if(arr[i]>=26){
                arr[i] = arr[i]%26;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i =0;
        for(char ch : s.toCharArray()){
            char x = (char)(ch + arr[i]);
            if(x-'a'>=26){
                System.out.println(x);
                int d = x-'a';
                System.out.println(d);
                d = d%26;
                System.out.println(d);
                x = (char)('a' + d);
                System.out.println(x);
            }

            sb.append(x);
            i++;
        }
        return sb.toString();
    }
}
