package Graph;
import java.util.*;

class Pair {
   int v,wt;
    Pair(int  v,int wt){
      this.v=v;
      this.wt=wt;
    }   
}
public class GraphProblem1 {
     
    int v;
    ArrayList<ArrayList<Pair>> list;
    GraphProblem1(int v){
       this.v=v;
       list=new ArrayList<>();
       for (int i = 0; i < v; i++) {
        list.add(new ArrayList<Pair>());
       }
    }
    public void addEdge(int src,int dest,int wt) {
        list.get(src).add(new Pair(dest, wt));
    }
    public void addUndirectEdge(int src,int dest,int wt) {
        list.get(src).add(new Pair(dest, wt));
        list.get(dest).add(new Pair(src, wt));
    }
    public  void DFS(int src,boolean vis[], ArrayDeque<Integer>s) {
        vis[src]=true;

        for (Pair neighbour :list.get(src)) {
            if (!vis[neighbour.v]) {
                DFS(neighbour.v, vis,s);
            }
        }
        s.push(src);
    }
    public ArrayDeque<Integer> TopologicalSortingUsingDfs() {
        ArrayDeque<Integer>s=new ArrayDeque<>();
         boolean vis[]=new boolean[v];

         for (int i = 0; i < v; i++) {
            if(!vis[i]){
                DFS(i, vis,s);
            }
         }
       return s;
    }
    public void ShortestPathInDAG() {
        ArrayDeque<Integer> stack=TopologicalSortingUsingDfs();
        int dis[]=new int[v];
        Arrays.fill(dis, 1000);
        dis[stack.peek()]=0;

        while (!stack.isEmpty()) {
            int cur=stack.pop();
           for (Pair neighbour : list.get(cur)) {
              if (dis[neighbour.v] > dis[cur]+neighbour.wt) {
                dis[neighbour.v] = dis[cur]+neighbour.wt;
              }
           }
        }
        for (int i : dis) {
            System.out.print(i+" ");
        }
    }
    public void primsMST() {
        int dis[]=new int[v];
        // find path from src to that vertex
        int parent[]=new int[v];
        Arrays.fill(dis, 1000);
        boolean vis[]=new boolean[v];
        dis[0]=0;
        parent[0]=-1;
        PriorityQueue<Pair>pq=new PriorityQueue<>((p,q)->p.wt-q.wt);
        pq.add(new Pair(0, 0));
  
        while (!pq.isEmpty()) {
            Pair cur=pq.poll();
            if (vis[cur.v]) {
                continue;
            }
            vis[cur.v]=true;
       
            for (Pair neighbour : list.get(cur.v)) {
                if (!vis[neighbour.v]) {
                    if (dis[neighbour.v] > neighbour.wt) {
                        dis[neighbour.v] = neighbour.wt;
                        parent[neighbour.v]=cur.v;
                        pq.add(new Pair(neighbour.v, neighbour.wt));
                    }    
                } 
            }
        }
      for (int e : dis) {
        System.out.print(e+" ");
      }
      System.out.println();
      // print a path of any vertex
    //   printPath(parent);
    }
    public void printPath(int parent[]){
        int cur=4;
         while (cur!=-1) {
            System.out.print(cur+" ");
            cur=parent[cur];
         }
    }
    public void dijkstraAlgo() {
     // find shortest path in weighted graph
        int dis[]=new int[v];
        Arrays.fill(dis, 1000);
        boolean vis[]=new boolean[v];
        dis[0]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>((p,q)->p.wt-q.wt);
        pq.add(new Pair(0, 0));
  
        while (!pq.isEmpty()) {
            Pair cur=pq.poll();
            if (vis[cur.v]) {
                continue;
            }
            vis[cur.v]=true;
       
            for (Pair neighbour : list.get(cur.v)) {
                if (!vis[neighbour.v]) {
                    if (dis[neighbour.v] > dis[cur.v] + neighbour.wt) {
                        dis[neighbour.v] =dis[cur.v] + neighbour.wt;
                        pq.add(new Pair(neighbour.v, dis[neighbour.v]));
                    }    
                } 
            }
        }
      for (int e : dis) {
        System.out.print(e+" ");
      }
    }
    public  void BellmanFord() {
        // only work in directed and not negative cycle present
        int[] dis=new int[v];
        Arrays.fill(dis, 10000);
         dis[0]=0;
        
         for (int i = 0; i < v-1; i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.get(j).size(); k++) {
                    if (dis[list.get(j).get(k).v] > dis[j] + list.get(j).get(k).wt) {
                        dis[list.get(j).get(k).v] = dis[j] + list.get(j).get(k).wt;
                    }
                }
            }
         }
         
         for (int i : dis) {
            System.out.print(i+" ");
         }

    }
    public static void main(String[] args) {
        int v=6;
        GraphProblem1 g=new GraphProblem1(v);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 3, -2);
        g.addEdge(1, 2, -1);
        g.addEdge(1, 3, -3);
        g.addEdge(3, 4, -4);
        g.addEdge(2, 4, 3);
        g.addEdge(2, 5, -3);
        g.addEdge(4, 5, -1);

        // g.addUndirectEdge(0, 1, 7);
        // g.addUndirectEdge(0, 3, 3);
        // g.addUndirectEdge(0, 2, 8);
        // g.addUndirectEdge(1, 4, 2);
        // g.addUndirectEdge(1, 3, 1);
        // g.addUndirectEdge(2, 1, 2);
        // g.addUndirectEdge(2, 3, 1);
        // g.addUndirectEdge(3, 4, 5);


        // g.ShortestPathInDAG();
        // g.primsMST();
        // g.dijkstraAlgo();
        g.BellmanFord();
    }
}
