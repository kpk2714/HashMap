public class Max_HeapSort
{
    void Heapify(int[] array,int n,int i)
    {
        int root = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && array[l]>array[root])
            root = l;
        if(r<n && array[r]>array[root])
            root = r;
        if(root!=i)
        {
            int temp = array[i];
            array[i] = array[root];
            array[root] = temp;
            Heapify(array,n,root);
        }
    }
    void MaxHeap(int[] array,int n)
    {
        for(int i=n/2-1;i>=0;i--)
        {
            Heapify(array,n,i);
        }

        for(int i=n-1;i>=0;i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            Heapify(array,i,0);
        }
    }

    void print(int[] array,int n)
    {
        System.out.print("Max Heap : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{15,5,20,1,17,10,30};
        Max_HeapSort heap = new Max_HeapSort();
        heap.MaxHeap(array,array.length);
        heap.print(array,array.length);
    }
}
