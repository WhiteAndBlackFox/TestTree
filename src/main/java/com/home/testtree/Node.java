/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.testtree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vlad
 */
public class Node<T> {

    private T value = null;
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<Node<T>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }
    
    public List<Node<T>> getChildren() {
        return children;
    }

    public T getData() {
        return value;
    }

    public void setData(T value) {
        this.value = value;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getParent() {
        return parent;
    }
}
