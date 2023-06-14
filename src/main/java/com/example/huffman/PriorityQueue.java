package com.example.huffman;

import java.util.ArrayList;

public class PriorityQueue {
    ArrayList<Node> queue = new ArrayList<>();

    public void add(Node node){
        queue.add(node);
        sort();
    }
    public void sort(){
        for (int i = 0; i < queue.size() - 1; i++) {
            for (int j = 0; j < queue.size() - i - 1; j++) {
                if (queue.get(j).frequency > queue.get(j + 1).frequency){
                    Node temp = queue.get(j);
                    queue.set(j, queue.get(j + 1));
                    queue.set(j + 1, temp);
                }
            }
        }
    }

    public PriorityQueue() {
    }

    public void remove(int i){
        queue.remove(i);
    }

    public int sum(){
        return queue.get(0).frequency + queue.get(1).frequency;
    }

    public Node left(){
        if (queue.get(0).frequency > queue.get(1).frequency){
            return queue.get(1);
        }
        return queue.get(0);
    }

    public Node right(){
        if (queue.get(0).frequency > queue.get(1).frequency){
            return queue.get(0);
        }
        return queue.get(1);
    }

    public boolean check(){
        if (queue.size() == 1){
            return false;
        }
        return true;
    }

    public Node return_root(){
        return queue.get(0);
    }
}
