package com.example.huffman;

public class Node {

    String value;
    Node left_node = null;
    Node right_node = null;
    int frequency;

    public Node(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }
}
