package com.example.scratch;

public class Generic {

    public static void main(String[] args) {
        Box<String> myStringBox = new Box<>();
        myStringBox.setItem("This box has a string in it!");

        Box<Integer> myIntegerBox = new Box<>();
        myIntegerBox.setItem(12345);

        System.out.println(myStringBox.getItem());
        System.out.println(myIntegerBox.getItem());
    }
}


class Box<T> {
    T item;

    void setItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}
