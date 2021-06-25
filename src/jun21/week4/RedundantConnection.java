package jun21.week4;

public class RedundantConnection
{

    public int[] findRedundantConnection(int[][] edges){
        int arr[] = new int[edges.length];

        for(int i =0; i< edges.length; i++){
            arr[i] = i;
        }

        for(int[] edge: edges){
            int u = find(arr, edge[0]-1);
            int v = find(arr, edge[1] -1);

            if(u==v) {
                return edge;
            }
            arr[u] = v;
        }
        int arr1[] = {-1,-1};
        return arr1;
    }

    private int find(int[] arr, int i){
        if(arr[i] == i) return i;
        else return find(arr, arr[i]);
    }
}
