package com.owodigi.util;

import java.util. * ;

class BinaryTree{
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Integer nodeData) {
        this.root = new Node(nodeData);
    }

    public BinaryTree(List<Integer> nodeDataList) {
        this.root = null;
        for (Integer nodeData : nodeDataList) {
            insert(nodeData);
        }
    }
    // for BST insertion
    public void insert(int nodeData) {
        Node newNode = new Node(nodeData);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node parent = null;
            Node tempNode = this.root;
            while (tempNode != null) {
                parent = tempNode;
                if (nodeData <= tempNode.value) {
                    tempNode = tempNode.left;
                } else {
                    tempNode = tempNode.right;
                }
            }
            if (nodeData <= parent.value) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }
    private Node findInBSTRec(Node node, int nodeData) {
        if (node == null)
            return null;

        if (node.value == nodeData) {
            return node;
        } else if (node.value > nodeData) {
            return findInBSTRec(node.left, nodeData);
        } else {
            return findInBSTRec(node.right, nodeData);
        }
    }
    public Node findInBST(int nodeData) {
        return findInBSTRec(this.root, nodeData);
    }
    public int getSubTreeNodeCount(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSubTreeNodeCount(node.left) + getSubTreeNodeCount(node.right);
        }
    }
    private Node getTreeDeepCopyRec(Node node) {
        if (node != null) {
            Node newNode = new Node(node.value);
            newNode.left = getTreeDeepCopyRec(node.left);
            newNode.right = getTreeDeepCopyRec(node.right);
            return newNode;
        } else {
            return null;
        }
    }
    public BinaryTree getTreeDeepCopy() {
        if (this.root == null) {
            return null;
        } else {
            BinaryTree treeCopy = new BinaryTree();
            treeCopy.root = getTreeDeepCopyRec(root);
            return treeCopy;
        }
    }
}
