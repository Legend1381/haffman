module com.example.huffman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.huffman to javafx.fxml;
    exports com.example.huffman;
}