public class WordNet {
    LinearProbingHashST<String, Integer> ht;
    Digraph graph;
    private int processSynsets(String synsets) {
        In in = new In(synsets);
        int count = 0;
        ht = new LinearProbingHashST<String, Integer>();
        while (!in.isEmpty()) {
            String[] tokens = in.readLine().split(",");
            String[] nouns = tokens[1].split(" ");
            for (String noun : nouns) {
                ht.put(noun, Integer.parseInt(tokens[0]));
            }
            count++;
        }
        return count;
    }
    private Digraph buildGraph(String hypernyms, int count) {
        Digraph graph = new Digraph(count);
        In in = new In(hypernyms);
        while (!in.isEmpty()) {
            String[] tokens = in.readLine().split(",");
            for (int i = 1; i < tokens.length; i++) {
                graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[i]));
            }
        }
        return graph;
    }
    private boolean multipleRoot(Digraph graph) {
        int count = 0;
        for (int i=0;i<graph.numberofVertices();i++) {
            if (graph.outdegree(i) == 0) {
                count++;
            }           
        }
        if (count == 1) {
            return true;            
        }
        return false;
    }

    public void printGraph() {
        //System.out.println(graph.numberofVertices()+"vertices, "+graph.numberofEdges()+" edges" )
        DirectedCycle directedcycle = new DirectedCycle(graph);
        if (directedcycle.hasCycle()) {
            System.out.println("Cycle detected");
            return;
        }
        else if (!multipleRoot(graph)) {
            System.out.println("Multiple roots");
        }
        else
        System.out.println(graph);
    }

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        int count = processSynsets(synsets);
        graph = buildGraph(hypernyms, count);
        //printGraph();
        //System.out.println("Count = " + count);
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return ht.keys();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return ht.contains(word);
    }
    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        return 0; 
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        return null;
    }

    // do unit testing of this class
    // public static void main(String[] args) {

    // }
}
