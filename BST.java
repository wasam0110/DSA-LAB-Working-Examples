/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Ai231001
 */
class BST {
    class Node {
        int key;
        Node left, right;
        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Method to search for a key in the BST
    Node search(int key) {
        return searchRec(root, key);
    }

    Node searchRec(Node root, int key) {
        // Base cases: root is null or key is present at the root
        if (root == null || root.key == key) {
            return root;
        }

        // Key is greater than root's key, search in the right subtree
        if (key > root.key) {
            return searchRec(root.right, key);
        }

        // Key is smaller than root's key, search in the left subtree
        return searchRec(root.left, key);
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        // Test search method
        int searchKey = 40;
        System.out.println("\n\nSearch for " + searchKey + ":");
        if (tree.search(searchKey) != null) {
            System.out.println(searchKey + " found in the tree.");
        } else {
            System.out.println(searchKey + " not found in the tree.");
        }

        System.out.println("\n\nDelete 70:");
        tree.delete(70);
        tree.inorder();

        System.out.println("\n\nDelete 30:");
        tree.delete(30);
        tree.inorder();

        System.out.println("\n\nDelete 50:");
        tree.delete(50);
        tree.inorder();
    }
}


 

