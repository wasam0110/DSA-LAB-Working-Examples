/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wasam
 */
public class LL {
   Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    // to add first
    public void addfirst(String data){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    // to add last
    public void addlast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
        currNode = currNode.next;
    }
        currNode.next = newNode;
}        
    //to print
    public void printlist(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.println(currNode.next + "->");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }
    public static void main(String[]args){
    LL list = new LL();
    list.addfirst("a");
    list.addfirst("is");
    list.printlist();
    
    list.addlast("list");
    list.printlist();
    
    list.addfirst("This");
    list.printlist();
    }
}
