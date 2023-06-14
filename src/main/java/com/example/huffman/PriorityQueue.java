package com.example.huffman;
//represent priority queue


import java.util.ArrayList;

public class PriorityQueue {
    ArrayList<Node> queue = new ArrayList<>();

    public void add(Node node){
        queue.add(node);
        sort();
    }

    //sort the queue every time one item added
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

    //constructor
    public PriorityQueue() {
    }

    //remove one item
    public void remove(int i){
        queue.remove(i);
    }

    //return summation of first two elements frequency
    public int sum(){
        return queue.get(0).frequency + queue.get(1).frequency;
    }

    //choose wich element should be left node
    public Node left(){
        if (queue.get(0).frequency > queue.get(1).frequency){
            return queue.get(1);
        }
        return queue.get(0);
    }

    //choose wich element should be left node
    public Node right(){
        if (queue.get(0).frequency > queue.get(1).frequency){
            return queue.get(0);
        }
        return queue.get(1);
    }

    //check if we rich end of elements or not
    public boolean check(){
        if (queue.size() == 1){
            return false;
        }
        return true;
    }

    //return tree root
    public Node return_root(){
        return queue.get(0);
    }
}
