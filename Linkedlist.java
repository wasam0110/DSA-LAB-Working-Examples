/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


class Node {
    int data;
    Node address;

    public Node(int data) {
        this.data = data;
        this.address = null;
    }
}

public class Linkedlist {
    Node head, tail;
    int size;

    public Linkedlist() {
        head = tail = null;
        size = 0;
    }

    public void add(int d) {
        Node n = new Node(d);
        if (head == null) {
            head = tail = n;
        } else {
            tail.address = n;
            tail = n;
        }
        size++;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.address;
        }
    }

    public void printSize() {
        System.out.println("Size : " + size);
    }

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();
        list.printSize();
    }
}



