package sept.week4;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber
{

    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=String.valueOf(nums[i]);
        }

//        Arrays.sort(arr, new Comparator<String>(){
//            public int compare(String a, String b){
//                return (b+a).compareTo(a+b);
//            }
//        });

        Arrays.sort(arr, (String a, String b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }

        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);

        return sb.toString();
    }

    public static void main(String arg[]) {
        int [] nums = {3,30,34,5,9};

        LargestNumber l = new LargestNumber();
        System.out.println(l.largestNumber(nums));
    }
}
