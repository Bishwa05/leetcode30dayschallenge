package dec.week2;

public class ValidMountainArray
{
    public boolean validMountainArray(int[] arr) {

        int n = arr.length;
        int point =0;
        boolean res = true;

        if(n < 3) return false;

        for(int i=0; i< n-1; i++){
            if(arr[i]<arr[i+1]){
                point = i+1;
            }else{
                break;
            }
        }
        if(point == 0 || point == n-1) return false;
        System.out.println(point);
        for(int i=point; i<n-1; i++){
            if(arr[i]<=arr[i+1]){
                res = false;
            }
        }
        return res;
    }
}
