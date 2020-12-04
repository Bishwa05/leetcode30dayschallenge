package dec;

public class KthFactorOfN
{
    public int kthFactor(int n, int k) {
        int[] factorArr = new int[n/2+1];
        int factorIndex =0;

        for(int i =1; i<=n/2; i++){
            if(n%i==0){
                factorArr[factorIndex] = i;
                factorIndex++;
            }
        }

        factorArr[factorIndex] = n;
        factorIndex++;

        return (k>n/2+1)? -1 : (factorArr[k-1] ==0) ? -1 : factorArr[k-1];
    }
}
