package com.company;

public class Main {

    public static void main(String[] args) {
        SearchTree abLinkedList = new SearchTree(null);
//        abLinkedList.traverse(abLinkedList.getRoot());
        String strbaPeople = "Filip Zuzka Patrik Andrej Igor Karin Rachel Adam Maros";
        String[] strbaArray = strbaPeople.split(" ");
        for (String s : strbaArray){
            abLinkedList.addItem(new AbNode(s));
        }
        abLinkedList.traverse(abLinkedList.getRoot());
        System.out.println("-----------------------");
        abLinkedList.removeItem(new AbNode("Rachel"));
        abLinkedList.traverse(abLinkedList.getRoot());
        System.out.println("-----------------------");
        abLinkedList.removeItem(abLinkedList.getRoot());
        abLinkedList.traverse(abLinkedList.getRoot());
        System.out.println("-----------------------");
        abLinkedList.removeItem(new AbNode("Emma"));
        abLinkedList.traverse(abLinkedList.getRoot());
        System.out.println("-----------------------");
    }
}
