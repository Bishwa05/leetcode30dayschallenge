package week2;

public class PerformStringShifts {
    public static String stringShift(String s, int[][] shift){
        int leftShift =0;
        for(int i=0; i<shift.length; i++){
            int arr[] = shift[i];
            if(arr[0]==0){
                leftShift +=arr[1];
            }else{
                leftShift-=arr[1];
            }
        }

        System.out.println(leftShift);

        StringBuilder sb = new StringBuilder();
        int l = s.length();
        if(leftShift<0){
            int x = leftShift*-1;
            x = x%l;
            sb.append(s.substring(l-x,l));
            sb.append(s.substring(0,l-x));
        } else{
            leftShift = leftShift%l;
            sb.append(s.substring(leftShift,l));
            sb.append(s.substring(0,leftShift));

        }
        return sb.toString();
    }
    public static void main(String arg[]){
        int [][]shift = {{1,1},{1,1},{0,2},{1,3}};
        String s = "abcdefg";

//        int [][]shift = {{0,6},{1,4}};
//        String s = "abc";

        System.out.println(stringShift(s, shift));
    }
}
