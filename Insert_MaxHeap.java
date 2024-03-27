public class Insert_MaxHeap
{
    void Heapify(int[] array,int i)
    {
        int parent = (i-1)/2;
        if(array[parent]>0)
        {
            if(array[parent]<array[i])
            {
                int temp = array[i];
                array[i] = array[parent];
                array[parent] = temp;
                Heapify(array,parent);
            }
        }
    }
    int[] Insert(int[] array,int data,int n)
    {
        int n1 = n+1;
        int[] arr = new int[n1];
        for(int i=0;i<n;i++)
            arr[i] = array[i];
        arr[n1-1] = data;
        Heapify(arr,n1-1);
        return  arr;
    }

    void print(int[] array,int n)
    {
        System.out.print("Max Heap After Insertion : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{30,20,17,15,10,5,1};
        int data = 40;
        Insert_MaxHeap heap = new Insert_MaxHeap();
        int[] arr = heap.Insert(array,data,array.length);
        heap.print(arr,arr.length);
    }
}
