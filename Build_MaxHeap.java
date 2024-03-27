public class Max_Heap
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
        Max_Heap heap = new Max_Heap();
        heap.MaxHeap(array,array.length);
        heap.print(array,array.length);
    }
}
