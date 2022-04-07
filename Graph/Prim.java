
public class Prim {
    //declare constance number of vertices in the graph
    private static final int V = 5;

    //find vertex that has min value in the set of vertices not yet included in MST
    int minCost(int cost[], boolean visited[]){
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int v = 0 ; v < V ; v++){
            if(visited[v] == false && cost[v] < min){ //false -> chua dc duyet
                min = cost[v];
                min_index = v;
            }
        }

        return min_index;
    }

    //print result (from adjacency matrix)
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    //main
    void primMST(int graph[][]){
        //arr to store constructed MST
        int parent[] = new int[V];
        //arr of cost values to pick minimum edge weight
        int cost[] = new int[V];
        //set of vertices included in MST (true -> included)
        boolean visited[] = new boolean[V];

        //initialize all cost as INFINITE
        for(int i = 0 ; i<V;i++){
            cost[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        cost[0] = 0;
        parent[0] = -1;

        //process the algo
        // V vertices => V - 1 edges
        for(int count = 0 ; count < V - 1 ; count++){
            int u = minCost(cost, visited);
            visited[u] = true;
            for(int v = 0 ; v < V ; v ++){
                //tim vertex: co lien ket + chua duoc duyet + cost < weight cua edge
                if(graph[u][v] != 0 && visited[v] == false && graph[u][v] < cost[v] ){
                    parent[v] = u;
                    cost[v] = graph[u][v];
                }
            }
        }

        //print out
        printMST(parent,graph);
    }

    public static void main(String[] args) {
        /* Let us create the following graph
        2 3
        (0)--(1)--(2)
        | / \ |
        6| 8/ \5 |7
        | /     \ |
        (3)-------(4)
            9         */
            Prim t = new Prim();
            int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                          { 2, 0, 3, 8, 5 },
                                          { 0, 3, 0, 0, 7 },
                                          { 6, 8, 0, 0, 9 },
                                          { 0, 5, 7, 9, 0 } };
     
            // Print the solution
            t.primMST(graph);
    }
}
