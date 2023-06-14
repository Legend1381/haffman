package com.example.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class file {
    public static ArrayList<String> reader (){
        ArrayList<String> data = new ArrayList<>();
        File admin_data = new File("src\\main\\resources\\file\\example.txt");
        try {
            Scanner reader = new Scanner(admin_data);
            while (reader.hasNextLine()) {
                String text = reader.nextLine();
                data.add(text);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
        return data;
    }
}
