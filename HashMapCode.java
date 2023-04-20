import java.util.LinkedList;
public class HashMapCode {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int bi= key.hashCode(); // can return any value -ve or +ve
            return Math.abs(bi) % N; // to get value b/w = to N-1
            
        }
        private int searchInLL(K key , int bi){
            LinkedList<Node> ll=buckets[bi];
            // int di=0;
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldbucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0;i<N*2;i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0;i<oldbucket.length;i++){
                LinkedList<Node> ll = oldbucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key,V value){
            int bi=hashFunction(key);
            int di=searchInLL(key , bi);

            if(di == -1){
                buckets[bi].add(new Node(key, value));
            }
            else{
                Node data=buckets[bi].get(di);
                data.value = value;
            }

            double lembda=(double)n/N;
            if(lembda > 2.0){
                //rehashing
                rehash();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String , Integer> map=new HashMap<>();
        map.put("India", 120);
        map.put("China", 150);
        map.put("US", 100);

        // System.out.println(map);
        System.out.println("sadd");
    }
}
