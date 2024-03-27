public class Delete_MinHeap
{
    void Heapify(int[] array,int n,int i)
    {
        int root = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && array[root]>array[l])
            root = l;
        if(r<n && array[root]>array[r])
            root = r;
        if(root!=i)
        {
            int temp = array[i];
            array[i] = array[root];
            array[root] = temp;
            Heapify(array,n,root);
        }
    }
    int Delete(int[] array,int n)
    {
        array[0] = array[n-1];
        n=n-1;
        Heapify(array,n,0);
        return  n;
    }

    void print(int[] array,int n)
    {
        System.out.print("Max Heap After Deletion : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{1,5,10,17,20,30,40};
        Delete_MinHeap heap = new Delete_MinHeap();
        int n = heap.Delete(array,array.length);
        heap.print(array,n);
    }
}
