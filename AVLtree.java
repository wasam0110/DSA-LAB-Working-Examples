/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 123
 */
class AVLtree {
    class Node {
        int key, height;
        Node left, right;

        Node(int item) {
            key = item;
            height = 1;
        }
    }

    Node root;

    AVLtree() {
        root = null;
    }

    int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; // No duplicates allowed
        }

        node.height = max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node); // Left-Left case
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node); // Right-Right case
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node); // Left-Right case
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node); // Right-Left case
        }

        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }

                System.out.println("Deleted " + temp.key + " from leaf node.");
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
                System.out.println("Deleted " + temp.key + " from right child.");
            }
        }

        if (root == null) {
            return root;
        }

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            System.out.println("Left-Left case is used to delete " + root.key + ". Performing right rotation.");
            return rightRotate(root);
        }

        if (balance > 1 && getBalance(root.left) < 0) {
            System.out.println("Left-Right case is used to delete " + root.key + ". Performing left rotation on left child, then right rotation.");
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0) {
            System.out.println("Right-Right case is used to delete " + root.key + ". Performing left rotation.");
            return leftRotate(root);
        }

        if (balance < -1 && getBalance(root.right) > 0) {
            System.out.println("Right-Left case is used to delete " + root.key + ". Performing right rotation on right child, then left rotation.");
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        AVLtree tree = new AVLtree();

        System.out.println("Inserting nodes:");
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 10);   
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 5);    
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 35);   

        System.out.println("\nInorder traversal after insertion:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("\nDeleting nodes:");

        tree.root = tree.delete(tree.root, 10);

        tree.root = tree.delete(tree.root, 5);

        tree.root = tree.delete(tree.root, 20);

        tree.root = tree.delete(tree.root, 30);

        System.out.println("\nInorder traversal after deletions:");
        tree.inorder(tree.root);
    }
}




