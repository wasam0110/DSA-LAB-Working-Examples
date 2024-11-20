/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 123
 */
public class CircularLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public void printList() {
        Node n = head;
        if (head == null)
            System.out.println("Empty linked list");
        else {
            do {
                System.out.println(n.data);
                n = n.next;
            } while (n != head);
        }
    }

    public void insertAtHead(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            new_node.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.next = head;
            head = new_node;
        }
    }

    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("Previous node cannot be null.");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insertAtEnd(int new_data) {
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        Node new_node = new Node(new_data);
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = new_node;
        new_node.next = head;
    }

    public void deleteStart() {
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cilist = new CircularLinkedList();
        
        cilist.head = new Node(2);
        Node second = new Node(6);
        Node third = new Node(9);
        
        cilist.head.next = second;
        second.next = third;
        third.next = cilist.head;

        cilist.printList();
        
        cilist.insertAtHead(4);
        cilist.printList();
        
        cilist.insertAtEnd(10);
        cilist.printList();
        
        cilist.insertAfter(second, 8);
        cilist.printList();
        
        cilist.deleteStart();
        cilist.printList();
        
        cilist.deleteEnd();
        cilist.printList();
    }
}

