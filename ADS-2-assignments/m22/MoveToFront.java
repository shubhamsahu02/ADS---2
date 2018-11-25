// import java.util.Scanner;
// import java.util.*;
import java.util.ArrayList;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;


public class MoveToFront {

    public static void encode() {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < 256; i++) {
            list.add((char) i);

        }
        String s = BinaryStdIn.readString();

        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            int ch = list.indexOf(c);
            BinaryStdOut.write((char) ch);
            list.remove(ch);
            list.add(0, c);
        }
        BinaryStdOut.close();



    }

    public static void decode() {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < 256; i++) {
            list.add((char)i);

        }
        String s = BinaryStdIn.readString();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char ch = list.get(c);
            BinaryStdOut.write(ch);
            list.remove(c);
            list.add(0, ch);
        }
        BinaryStdOut.close();

    }

    public static void main(String[] args) {

        // encode(str);
        if (args.length <= 0)
            throw new IllegalArgumentException("Expected + or -\n");
        if (args[0].equals("-")) {
            encode();
        } else {

            decode();
        }
    }
}
