/**
 * LSD class.
 */
public class LSD {
    /**
     * integer BITS_PER_BYTE.
     */
    private static final int BITS_PER_BYTE = 8;

    // do not instantiate.
    /**
     * default constructor.
     */
    public LSD() {
     }
     /**.
      * result string.
      */
    public static String[] result;

    /**
      * Rearranges the array of W-character strings in ascending order.
      * Time Complexity is O(N*W)
      * @param a the array to be sorted
      * @param w the number of characters per string
      */
    public static void sort(final String[] a, final int w) {
        int n = a.length;
        result = a;
        final int res = 256;   // extend ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[res + 1];
            for (int i = 0; i < n; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // compute cumulates
            for (int r = 0; r < res; r++) {
                count[r + 1] += count[r];
            }

            // move data
            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // copy back
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
            result = a;
        }
    }
    /**
     * toString method.
     * @return string.
     */
    public String toString() {
        String str = "[";
        for (int i = 0; i < result.length - 1; i++) {
            str += result[i] + ", ";
        }
        str += result[result.length - 1] + "]";
        return str;
    }

}
