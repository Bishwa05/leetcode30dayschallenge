package sept.week4;

public class FindTheDifference
{
    public char findTheDifference(String s, String t) {
        int arr[] = new int[26];
        char x = ' ';

        for(char c : s.toCharArray()){
            arr[c-97]++;
        }

        for(char c2 : t.toCharArray()){
            if(arr[c2-97]==0){
                x = c2;
                break;
            } else{
                arr[c2-97]--;
            }
        }
        return x;

    }
}
