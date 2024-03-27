import java.util.Date;

public class Insert_MinHeap
{
    void Heapify(int[] array,int i)
    {
        int parent = (i-1)/2;
        if(array[parent]>0)
        {
            if(array[i]<array[parent])
            {
                int temp = array[i];
                array[i] = array[parent];
                array[parent] = temp;
                Heapify(array,parent);
            }
        }
    }
    int[] Insert(int[] array,int n,int data)
    {
        int n1 = n+1;
        int[] arr = new int[n1];
        for(int i=0;i<n;i++)
            arr[i] = array[i];
        arr[n1-1] = data;
        Heapify(arr,n1-1);
        return arr;
    }

    void print(int[] array,int n)
    {
        System.out.print("Min Heap After Insertion : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{1,5,10,17,20,30,40};
        int data = 3;
        Insert_MinHeap heap = new Insert_MinHeap();
        int[] arr = heap.Insert(array,array.length,data);
        heap.print(arr,arr.length);
    }
}
