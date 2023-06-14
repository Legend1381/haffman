package com.example.huffman;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class huffman {

    static ArrayList<String[]> chart = new ArrayList<>();
    static String result = "";
    static String all_results = "";
    static double compression = 0;

    public static void execute(String in){
        PriorityQueue queue = new PriorityQueue();

        ArrayList<Character> alphabet = find_chars(in);
        int[] frequency = frequency(alphabet, in);

        for (int i = 0; i < alphabet.size(); i++) {
            Node temp = new Node(String.valueOf(alphabet.get(i)), frequency[i]);
            queue.add(temp);
        }
        tree(queue);

        for (int i = 0; i < chart.size(); i++) {
            result = result.concat("<");
            if (Objects.equals(chart.get(i)[0], "\n")){
                result = result.concat( "newLine,");
            }else {
                result = result.concat(chart.get(i)[0] + ",");
            }
            result = result.concat(chart.get(i)[1] + ",");
            result = result.concat(chart.get(i)[2] + "> ");
        }
        result = result.concat("\n");
        encode(in);
        Compression_rate();
        System.out.println( result);
    }
    public static void tree(PriorityQueue queue){
        while (queue.check()){
            Node temp = new Node("null", queue.sum());
            temp.left_node = queue.left();
            temp.right_node = queue.right();
            queue.remove(0);
            queue.remove(0);
            queue.add(temp);
        }

        Node root = queue.return_root();
        traversal(root, "");

    }

    public static void traversal(Node root, String code){
        if (root.right_node != null){
            traversal(root.right_node, code.concat("1"));
        }
        if (root.left_node != null){
            traversal(root.left_node, code.concat("0"));
        }
        if (root.left_node == null && root.right_node == null){
            String[] temp = {root.value, String.valueOf(root.frequency), code};
            chart.add(temp);
        }
    }

    public static  ArrayList<Character> find_chars(String in){
        ArrayList<Character> alphabet = new ArrayList<>();
        alphabet.add(in.charAt(0));

        for (int i = 1; i < in.length(); i++) {
            boolean check = false;
            char temp = in.charAt(i);
            for (Character character : alphabet) {
                if (temp == character){
                    check = true;
                }
            }
            if (!check){
                alphabet.add(temp);
            }
        }

        return alphabet;
    }

    public static int[] frequency(ArrayList<Character> alphabet,  String in){
        int[] frequency = new int[alphabet.size()];

        for (int i = 0; i < in.length(); i++) {
            char temp = in.charAt(i);
            for (int j = 0; j < alphabet.size(); j++) {
                if (temp == alphabet.get(j)){
                    frequency[j]++;
                }
            }
        }
        return frequency;
    }

    public static void Compression_rate(){
        int ascii_size = 0;
        int huffman_size = 0;

        for (String[] strings : chart) {
            String temp = Integer.toBinaryString(strings[0].charAt(0));
            ascii_size += Integer.parseInt(strings[1]) * temp.length();

            huffman_size += Integer.parseInt(strings[1]) * strings[2].length();
        }
        double t = ((double) huffman_size / ascii_size) * 100;
//        System.out.println(100 - t);
        double rate = 100 - t;
        compression += rate;
        result = result.concat("Compression rate: %" + rate + "\n");
    }

    public static void encode(String in){
        result = result.concat("Encoded String: ");
        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < chart.size(); j++) {
                if (chart.get(j)[0].equals(String.valueOf(in.charAt(i)))){
                    result = result.concat(chart.get(j)[2]);
                }
            }
        }
        result = result.concat("\n");
        result = result.concat("Decoded: " + in + "\n");
    }
    public static void examples(){
        ArrayList<String> cases = file.reader();
        for (String aCase : cases) {
            result = result.concat(aCase.substring(0, 3) + "\n");
            execute(aCase);
            result = result.concat("-------------------------------------------\n");
            all_results = all_results.concat(result);
            reset();
        }

        all_results = all_results.concat("\naverage compression rate: %" + String.valueOf(compression / 100));
        compression = 0;
    }

    public static void reset(){
        result = "";
        chart.removeAll(chart);
    }

//    public static void createDotGraph(String dotFormat,String fileName)
//    {
//        GraphViz gv=new GraphViz();
//        gv.addln(gv.start_graph());
//        gv.add(dotFormat);
//        gv.addln(gv.end_graph());
//        // String type = "gif";
//        String type = "pdf";
//        // gv.increaseDpi();
//        gv.decreaseDpi();
//        gv.decreaseDpi();
//        File out = new File(fileName+"."+ type);
//        gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
//    }

//    public static void show(){
//        String dotFormat="1->2;1->3;1->4;4->5;4->6;6->7;5->7;3->8;3->6;8->7;2->8;2->5;";
//        createDotGraph(dotFormat, "DotGraph");
//    }

}
