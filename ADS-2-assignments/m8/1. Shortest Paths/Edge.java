/**
 * Class for edge.
 */
class Edge implements Comparable<Edge> {
    /**
     * first vertex to connect.
     */
    private int v1;
    /**
     * second vertex connect from first one.
     */
    private int v2;
    /**
     * weight of the edge.
     */
    private double weight;
    /**
     * Constructs the object.
     *
     * @param      v     1st vertex
     * @param      w     2nd vertex
     * @param      weight1  weight of edge
     */
    Edge(final int v, final int w, final double weight1) {
        this.v1 = v;
        this.v2 = w;
        this.weight = weight1;
    }
    /**
     * returns first end of edge.
     * Time complexity is constant as each statement is executed only oce
     * @return     returns first end of edge.
     */
    public int either() {
        return v1;
    }
    /**
     * returns other end of edge.
     *Time complexity is constant as each statement is executed only oce
     * @param      v     connected vertex.
     *
     * @return      returns other end of edge.
     */
    public int other(final int v) {
        if (v1 == v) {
            return v2;
        }
        return v1;
    }
    /**
     * compares both edges weight.
     *Time complexity is constant as each statement is executed only oce
     * @param      that  The that
     *
     * @return     returns integer value.
     */
    public int compareTo(final Edge that) {
        if (this.weight < that.weight) {
            return -1;
        } else if (this.weight > that.weight) {
            return 1;
        }
        return 0;
    }
    /**.
     * Gets the weight.
     *Time complexity is constant as each statement is executed only oce
     * @return     The weight.
     */
    public double weight() {
        return this.weight;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // String str = "";
        // str += str + v1 + v2 + weight;
        // System.out.println("String."+str);
        // return str;
        return String.format("%d-%d %.5f", v1, v2, weight);
        //return "Hello";
    }
}
