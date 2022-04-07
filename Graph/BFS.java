import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {{0,1,0,0,0,0,0},
                         {0,0,1,1,1,0,0},
                         {0,0,0,0,0,1,0},
                         {0,0,0,0,0,1,1},
                         {0,0,0,0,0,0,1},
                         {0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0}};
        
        Set<Integer> traversedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        //Start up
        queue.add(0);
        traversedNodes.add(0);

        //main
        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + " ");

            for(int v = 0 ; v < graph.length ; v++){
                if(graph[u][v] == 1 && traversedNodes.contains(v) == false){
                    queue.add(v);
                    traversedNodes.add(v);
                }
            }
        }
        
    }
}