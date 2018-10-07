/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.testtree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author vlad
 */

public class main {
    
    public static int depth = 0;
    public static void main(String[] args) {
        
        System.out.println("=================================================");        
        System.out.println("Creating tree.");
        System.out.println("=================================================");        
        //Создаем дерево
        Node<Integer> root = createTree();
        
        System.out.println("=================================================");
        System.out.println("Print tree.");
        System.out.println("=================================================");        
        //Показываем его
        printTree(root, " ");
        
        System.out.println("=================================================");        
        System.out.println("Find in depth");
        System.out.println("=================================================");        
        //в ширину пошли
        searchDepth(root, 11);
        printResult((depth == 0)?0:depth);
//        printResult();
        
        System.out.println("=================================================");        
        System.out.println("Find in width");
        System.out.println("=================================================");        
        //в ширину пошли
        printResult(searchBreadth(root, 2));
    }

    private static Node<Integer> createTree() {
        Node<Integer> root = new Node<>(0);

        Node<Integer> node1 = root.addChild(new Node<Integer>(1));
        
        Node<Integer> node11 = node1.addChild(new Node<Integer>(11));
        Node<Integer> node111 = node11.addChild(new Node<Integer>(111));
        Node<Integer> node112 = node11.addChild(new Node<Integer>(112));

        Node<Integer> node12 = node1.addChild(new Node<Integer>(12));

        Node<Integer> node2 = root.addChild(new Node<Integer>(2));

        Node<Integer> node21 = node2.addChild(new Node<Integer>(21));
        Node<Integer> node211 = node2.addChild(new Node<Integer>(22));
        return root;
    }
    
    private static <T> void searchDepth(Node<T> node, int value) {
        if (value == Integer.valueOf(node.getData().toString()))
            depth = value;
        node.getChildren().forEach(each -> searchDepth(each, value));
    }

    private static <T> int searchBreadth(Node<T> node, int value) {
        List<Node<T>> children = node.getChildren();
        for (Node n : children) {
            if (value == (int) n.getData()) {
                return value;
            }
        }
        return 0;
    }
    
    private static <T> void printResult(int value){
        if (value == 0)
            System.out.println("Result not found.");
        else
            System.out.println("Result found: " + value + ".");
        
    }

    private static <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each -> printTree(each, appender + appender));
    }
}
