import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for page rank.
 */
class PageRank {
    private int inDegree;
    private int outDegree;
    private Digraph graph;
    private LinearProbingHashST<Integer, ArrayList<Integer>> inLinks;
    private LinearProbingHashST<Integer, Double> values;
    public PageRank(Digraph graphh, int vertex) {
        this.inDegree = graph.indegree(vertex);
        this.outDegree = graph.outdegree(vertex);
        this.graph = graphh;
        inLinks = new LinearProbingHashST<Integer, ArrayList<Integer>>();
        for (int i = 0; i < graph.V(); i++) {
            for (int j : graph.adj(i)) {
                if (inLinks.contains(j)) {
                    ArrayList<Integer> arr = inLinks.get(j);
                    arr.add(i);
                    inLinks.put(j, arr);
                    } else {
                    ArrayList<Integer> arr1 = new ArrayList<Integer>();
                    arr1.add(i);
                    inLinks.put(j, arr1);
                }
            }
        }
    }

    public double getPR(int vertex) {
        values = new LinearProbingHashST<Integer, Double>();
        for (int i = 0; i < graph.V(); i++) {
            values.put(i , 1.0 / graph.V());
        }
        double rank = 0.0;
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> arrlist = inLinks.get(vertex);
            for (int j = 0; j < arrlist.size(); j++) {
                int key = arrlist.get(j);
                rank = values.get(key) / graph.outdegree(key);
                values.put(key , rank);
            }
        }
        return rank;
    }


class WebSearch {

}

/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution () {

    }
    /**
     * client program.
     *
     * @param      args  The arguments
     */
    void main(final String[] args) {
        // read the first line of the input to get the number of vertices
        Scanner scan = new Scanner(System.in);      
        int vertices = Integer.parseInt(scan.nextLine());
        // iterate count of vertices times 
        // to read the adjacency list from std input
        // and build the graph
        Digraph dg = new Digraph(vertices);
        int vcopy = vertices;
        while(vcopy > 0 ) {
            String[] varr = scan.nextLine().split(" ");
            int v = Integer.parseInt(varr[0]);
            for(int i = 1; i < varr.length; i++) {
                dg.addEdge(v, Integer.parseInt(varr[i]));
            }
            vcopy--;
        }
        ArrayList<PageRank> prArr = new ArrayList<>();
        System.out.println(dg.V() + " vertices, "+ dg.E() + " edges ");

        for(int j = 0; j < vertices; j++) {
            System.out.print(j + ": ");
            PageRank pr = new PageRank(dg, j);
            prArr.add(pr);
            pr.getPR(j);
            for(int k : dg.adj(j)) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        
        // Create page rank object and pass the graph object to the constructor
        
        // print the page rank object
        
        // This part is only for the final test case
        
        // File path to the web content
        String file = "WebContent.txt";
        
        // instantiate web search object
        // and pass the page rank object and the file path to the constructor
        
        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky
        }
    }
}
