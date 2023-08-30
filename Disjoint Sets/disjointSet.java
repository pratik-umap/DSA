public class disjointSet {
   
    int []parent;
    int rank[];
    disjointSet(int n){
        parent=new int[n];
        rank=new int[n];
        for (int i = 0; i < parent.length; i++) {
             parent[i]=i;
        }
    }

    int find(int x){
        // normal way
        // if (x != parent[x]) {
        //     return find(parent[x]);
        // }
        // optimization path compression
         if (x != parent[x]) {
            parent[x] =find(parent[x]);
        }
        return parent[x];
    }
    void union(int a,int b){
        int captainA=find(a);
        int captainB=find(b);

        if (captainA == captainB) return;
         // rank optimize
        if (rank[captainA] < rank[captainB]) {
            parent[captainA]=captainB;
        } else if(rank[captainB] < rank[captainA]){
            parent[captainB]=captainA;
        }else{
            parent[captainB]=captainA;
            rank[captainA]++;
        }
    }

    boolean isConnected(int a,int b){
        int captainA=find(a);
        int captainB=find(b);

        return captainA == captainB; 
    }
  public static void main(String[] args){

    disjointSet d=new disjointSet(8);

     d.union(2, 3);
     d.union(4, 5);
     System.out.println(d.isConnected(2, 5));

     d.union(0, 1);
     d.union(0, 5);
     System.out.println(d.isConnected(0, 5));

  }
}
