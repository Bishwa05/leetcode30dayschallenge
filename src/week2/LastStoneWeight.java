package week2;

import java.util.Arrays;
import java.util.Comparator;

class Heap{
    int arr[];
    int size;
    int max =-1;
    int secondMax = -1;


    public void buildHeap(int[] A){
        size = A.length;
        this.arr = new int[size];

        for(int i =0; i<size; i++)
            this.arr[i] = A[i];

        for(int i = 0; i <size-1; i++)
            percolateUp(i);
    }

    public void percolateUp(int index){
        int parent = (index-1) / 2;
        int bottom = this.arr[index];
        while( index > 0 && this.arr[parent] < bottom )
        {
            this.arr[index] = this.arr[parent]; // move it down
            index = parent;
            parent = (parent-1) / 2;
        } // end while
        this.arr[index] = bottom;
    }



    public void percolateDown( int index){

        int largerChild;
        int top = this.arr[index];
        while(index < size/2)
        {
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;

            if(rightChild < size && this.arr[leftChild] < arr[rightChild])
                largerChild = rightChild;
            else
                largerChild = leftChild;
        if( top >= this.arr[largerChild])
            break;
        this.arr[index] = this.arr[largerChild];
            index = largerChild;
        }
        this.arr[index] = top;

    }


    public void get2MaxElement() {
        if(this.size>=2){
            max = this.arr[0];
            if(this.size>2) {
                int index = this.arr[1] > this.arr[2] ? 1 : 2;
                secondMax = this.arr[index];
                this.arr[index]=-1;
                percolateDown(index);
                size -=1;
            }
            else {
                secondMax = this.arr[1];
                this.arr[1]=-1;
                percolateDown(1);
                size -=1;
            }
            int val = max-secondMax;
            if(val ==0){
                this.arr[0] =-1;
            } else {
                this.arr[0] = val;
            }
            percolateDown(0);
            size -=1;

        } else{
            max = -1;
            secondMax = -1;
        }
    }

    public int calculate(){
        while(this.size >1){
            get2MaxElement();
        }
        return this.arr[0];
    }


}

public class LastStoneWeight {

    public static int lastStoneWeight(int arr[]){
        Heap h = new Heap();
        h.buildHeap(arr);
        return h.calculate();
    }

    // Working solution
    public static int lastStoneWeight2(int arr[]){

        int n = arr.length;
        int size = arr.length;
        Arrays.sort(arr);

        int val =0;

        if(size ==1) {
            return arr[0];
        }

        while(size>=2){
            int max = arr[n-1];
            int secondMax = arr[n-2];
            val = max-secondMax;
            if(val==0) {
                arr[n - 2] = -1;
                arr[n - 1] = -1;
                size -= 2;
            } else{
                arr[n - 2] = val;
                arr[n - 1] = -1;
                size -= 1;
            }

            Arrays.sort(arr);
        }


        return size>0?arr[n-1]:0;
    }

    public static void main(String arg[]){
        // int arr[] = {2,7,4,1,8,1};
         int arr[] = {1,3};
        // int arr[] = {3,7,2};

       // System.out.println(lastStoneWeight(arr));


        //Arr Approach
        System.out.println(lastStoneWeight2(arr));
    }
}
