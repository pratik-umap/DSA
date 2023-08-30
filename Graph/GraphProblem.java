package Graph;
import java.util.*;

public class GraphProblem {
    ArrayList<ArrayList<Integer>>list=new ArrayList<>();
    int v;
    int indegree[];
    GraphProblem(int v){
        this.v=v;
        for (int i = 0; i < v; i++) {
             list.add(new ArrayList<>());
        }
        indegree=new int[v];
    }
    // directed graph
    public void addEdge(int src,int desc) {
        list.get(src).add(desc);
    } 
    // calculated indegree for every node
    public void inDegree() {
        for (ArrayList<Integer> adj: list) {
            for (Integer neighbour : adj) {
                indegree[neighbour]++;
            }
        }
        for (int i : indegree) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public  void DFS(int src,boolean vis[], ArrayDeque<Integer>s) {
        vis[src]=true;

        for (Integer neighbour :list.get(src)) {
            if (!vis[neighbour]) {
                DFS(neighbour, vis,s);
            }
        }
        s.push(src);
    }
    public void TopologicalSortingUsingDfs() {
        ArrayDeque<Integer>s=new ArrayDeque<>();
         boolean vis[]=new boolean[v];

         for (int i = 0; i < v; i++) {
            if(!vis[i]){
                DFS(i, vis,s);
            }
         }
       
         while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
         }
    }
    // kahn's algorithm
    public void TopologicalSortingUsingbfs() {
        ArrayDeque<Integer>q=new ArrayDeque<>();
        inDegree();
        int cnt=0;
        for (int i = 0; i < v; i++) {
            if (indegree[i]==0) {
                q.add(i);
                cnt++;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while (!q.isEmpty()) {
            int cur=q.poll();
            ans.add(cur);
            // System.out.println(cur);
            for (Integer neighbour : list.get(cur)) {
                indegree[neighbour]--;
                if (indegree[neighbour]==0) {
                    q.add(neighbour);
                    cnt++;
                }
            }
        }
        // if (cnt < v) {
        //     System.out.println("topological sort not possible");
        // } else {
        //     for (Integer e : ans) {
        //         System.out.print(e+" ");
        //     }
        // }
    }
    public  boolean DFSutil(int src,boolean vis[], boolean recS[]) {
        vis[src]=true;
        recS[src]=true;
        for (Integer neighbour :list.get(src)) {
            if (!vis[neighbour]) {
                if(DFSutil(neighbour, vis,recS)) return true;
            }else if(recS[neighbour]){
                 return true;
            }
        }
        recS[src]=false;
        return false;
    }
    public boolean cyclePresentIndirectGraph() {
        // cycle present in directed graph
        boolean vis[]=new boolean[v];
        boolean recS[]=new boolean[v];

         for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if(DFSutil(i, vis, recS)) return true;
             } 
         }
         
         return false;
    }
    public boolean isBiPartite(int src,boolean vis[]) {
        int color[]=new int[v];
        Arrays.fill(color, -1);
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        vis[src]=true;
        color[src]=0;

        while (!q.isEmpty()) {
            int cur=q.poll();

            for (Integer neighbour :list.get(cur)) {
                if (!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour]=true;
                    color[neighbour]=1-color[cur];
                }else if(color[cur]==color[neighbour]){
                     return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int v=6;
        GraphProblem g=new GraphProblem(v);
         
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(2, 4);
        // g.addEdge(4, 5);

        // g.addEdge(3, 2);
//    System.out.println(g.cyclePresentIndirectGraph());
        boolean vis[]=new boolean[v];
      System.out.println(g.isBiPartite(0, vis));
        // g.inDegree();
        // g.TopologicalSortingUsingDfs();

        // g.TopologicalSortingUsingbfs();
    }
}
