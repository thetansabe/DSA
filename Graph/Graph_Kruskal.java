import java.util.*;

public class Graph_Kruskal {

    //class to store edge
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
 
        // Comparator function used for
        // sorting edgesbased on their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };

    //create edge list
    Edge edgeList[]; //edge list
    int V, E; //number of Vertices and number of Edges
    Graph_Kruskal(int v, int e){
        //v -> vertex , e -> edge
        V = v;
        E = e;
        edgeList = new Edge[v];

        for(int i = 0 ; i < e; ++ i){
            edgeList[i] = new Edge();
        }
    }

    //main function to construct MST
    void KruskalMST(){
        //store result
        Edge result[] = new Edge[V];
        //index variable used for result[]
        // int e = 0;
        //index variable for sorted edges
        int i = 0;
        //initialize 
        for(i = 0 ; i < V ; i++)
            result[i] = new Edge();

        //Step 1: sort edge list
        Arrays.sort(edgeList);

        
    }
}

class UnionFind{
    private Vector<Integer> p;
    private Vector<Integer> rank;
    private Vector<Integer> setSize;

    public UnionFind(int N){
        p = new Vector<Integer>(N);
        rank = new Vector<>(N);
        setSize = new Vector<>(N);

        for(int i = 0 ; i < N ; i++){
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i){
        if(p.get(i) == i) 
            return i;
        else{
            int ret = findSet(p.get(i));
            p.set(i,ret);
            return ret;
        }
    }

    public void unionSet(int i , int j){
        if(!isSameSet(i,j)){
            int x = findSet(i);
            int y = findSet(j);

            if(rank.get(x) > rank.get(y)){
                p.set(y,x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            }else{
                p.set(x,y);
                setSize.set(y,setSize.get(y) + setSize.get(x));
                if(rank.get(x) == rank.get(y))
                    rank.set(y, rank.get(y) + 1);
            }
        }
    }

    public boolean isSameSet(int i, int j){
        return findSet(i) == findSet(j);
    }
}