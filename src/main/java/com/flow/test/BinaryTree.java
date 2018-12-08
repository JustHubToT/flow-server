package com.flow.test;

/**
 * 二叉树
 *
 * @author FangChao
 * @date 2018/12/6 11:46
 */
public class BinaryTree {
    private BNode root; // 根节点

    public BinaryTree(){
        root = null;
    }
    // 二叉搜索树查找的时间复杂度为O(logN)
    public BNode find(int key){ // 找到节点，根据key
        BNode current = root;
        while (current.key != key){
            if (key < current.key){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    // 插入节点
    public void insert(int key, double value){
        BNode newNode = new BNode();
        newNode.key = key;
        newNode.data = value;
        if (root == null){ // 如果二叉树为空
            root = newNode;
        } else {
            BNode current = root;
            BNode parent;
            while (true){
                parent = current;
                if (key < current.data){ // 转向左边
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        newNode.parent = parent;
                        return;
                    }
                } else { // 转向右边
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
            }
        }
    }

    // 遍历二叉树
    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                System.out.println("前向遍历");
                proOrder(root);
                break;
            case 2:
                System.out.println("中向遍历");
                inOrder(root);
                break;
            case 3:
                System.out.println("后向遍历");
                postOrder(root);
                break;
            default:
                System.out.println("中向遍历");
                inOrder(root);
                break;
        }
    }

    private void postOrder(BNode root) {
        if (root != null){
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.println(root.data + " ");
        }
    }

    private void inOrder(BNode root) {
        if (root != null){
            inOrder(root.leftChild);
            System.out.println(root.data + " ");
            inOrder(root.rightChild);
        }
    }

    private void proOrder(BNode root) {
        if (root != null){
            System.out.println(root.data + " ");
            proOrder(root.leftChild);
            proOrder(root.rightChild);
        }
    }
}

class BNode {

    public int key;
    public double data;
    public BNode parent;
    public BNode leftChild;
    public BNode rightChild;

    public void displayNode() {
        System.out.println("{" + key + ":" + data + "}");
    }
}

