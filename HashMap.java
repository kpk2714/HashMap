import java.util.*;

public class HashMapCode
{
    static class HashMap<K,V>
    {
        private class Node
        {
            K key;
            V value;

            public Node(K key,V value)
            {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;

        private double lf = 0.75;
        private LinkedList<Node> buckets[];

        public HashMap()
        {
            this.N = 2;
            this.buckets = new LinkedList[N];
            for(int i=0;i<N;i++)
                buckets[i] = new LinkedList<>();
        }

        private int HashFunction(K key)
        {
            if(key==null)
                return 0;
            int bi = key.hashCode();
            return Math.abs(bi)%N;
        }

        private int SerachInLL(K key,int bi)
        {
            LinkedList<Node> ll = buckets[bi];
            for(int i=0;i<ll.size();i++)
            {
                Node node = ll.get(i);
                if(node.key==key)
                    return i;
            }
            return -1;
        }

        private void ReHash()
        {
            LinkedList<Node> oldBuckets[] = buckets;
            N=N*2;
            buckets = new LinkedList[N];// Double it's Size
            for(int i=0;i<N;i++)
                buckets[i] = new LinkedList<>();

            for(int i=0;i<oldBuckets.length;i++)
            {
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0;j<ll.size();j++)
                {
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        public V put(K key,V value)
        {
            int bi = HashFunction(key);
            int di = SerachInLL(key,bi);
            if(di==-1)
            {
                buckets[bi].add(new Node(key,value));
                n++;
                double lambda = (double) (n/N);
                double k = lf*N;//threshould value
                if(lambda>=k)
                    ReHash();
                return null;
            }
            else
            {
                Node node = buckets[bi].get(di);
                node.value=value;
                return node.value;
            }

        }

        public V get(K key)
        {
            int bi = HashFunction(key);
            int di = SerachInLL(key,bi);
            if(di==-1)
                return null;
            else
            {
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key)
        {
            int bi = HashFunction(key);
            int di = SerachInLL(key,bi);
            if(di==-1)
                return false;
            return true;
        }

        public V remove(K key)
        {
            int bi = HashFunction(key);
            int di = SerachInLL(key,bi);
            if(di==-1)
                return null;
            else
            {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty()
        {
            return n==0;
        }

        public ArrayList<K> keySet()
        {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++)
            {
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++)
                {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args)
    {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",190);
        map.put("China",200);
        map.put("Nepal",5);
        map.put("US",null);
        map.put(null,null);
        map.put(null,400);
        ArrayList<String> keys = map.keySet();
        for(String k : keys)
            System.out.println(k+" "+map.get(k));
        System.out.println(map.N);
    }
}
