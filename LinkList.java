/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 123
 */
public class LinkList {
    private Node top;
    
    public static class Node {
        public int data;
        public Node next;
        
        public Node(int data){
            this.data = data;
        }
    }
    public void insertFirst(int data){
        Node n = new Node(data);
        n.next = top;
        top = n;
    }
    public Node deleteFirst(){
        Node temp = top;
        top = top.next;
        return temp;
    }
    public void displayList(){
        Node current = top;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public class LinkedListStack{
        LinkList li = new LinkList();
        
        public void push(int element){
            li.insertFirst(element);
        }
        public void pop(){
            li.deleteFirst();
        }
        public void displayStack(){
            System.out.println("   ");
            li.displayList();
        }
    }
    public class LiStackClient{
        public static void main(String[] args){
            LinkList li = new LinkList();
            LinkedListStack st = li.new LinkedListStack();
        
            st.push(50);
            st.push(70);
            st.push(150);
            System.out.println("1. Stack after push operations : ");
            st.displayStack();
            System.out.println("\n2. stack after pop operations");
            st.pop();
            st.displayStack();
        }
    }
}
