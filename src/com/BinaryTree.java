package com;

public class BinaryTree {

    Node root;

    public BinaryTree() {
    }

    public int size(){
        return getSize(root);
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {
            Node startingNode = root;
            Node parent;

            while (true) {
                parent = startingNode;
                if (value < startingNode.value) {
                    startingNode = startingNode.leftChild;
                    if (startingNode == null) {
                        parent.leftChild = newNode;
                        return; // All Done
                    }
                } else {
                    startingNode = startingNode.rightChild;
                    if (startingNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public int getSize(Node startingNode) {
        if(startingNode == null){
            return 0;
        } else {
            return(getSize(startingNode.leftChild) + 1 + getSize(startingNode.rightChild));
        }
    }


    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean exists(int value) {
        Node startingNode = root;
        while(startingNode.value != value){
            if(value < startingNode.value){
                startingNode = startingNode.leftChild;
            } else {
                startingNode = startingNode.rightChild;
            }

            if(startingNode == null)
                return false;
        }
        return true;
    }

    public Integer max(){
        Node checkNode = root;
        while(checkNode.rightChild != null)
            checkNode = checkNode.rightChild;

        return(checkNode.value);
    }

    public Integer min(){
        Node checkNode = root;
        while(checkNode.leftChild != null)
            checkNode = checkNode.leftChild;

        return(checkNode.value);
    }

    class Node {

        int value;

        Node leftChild;
        Node rightChild;

        Node(int value) {
            this.value = value;
        }
    }
}

