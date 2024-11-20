/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ghazi
 */
// Take elements(numbers in the range of 1-50) of a Linked List as input from the user. Delete all nodes which have values greater than 25.

public class SLL{
Node head;
class Node{
    String data;
    Node next;
    Node(String data){
      this.data = data;
      this.next = null;
       }
   }
public void addfirst(String data){
    Node newNode = new Node(data);
    if(head==null){
        head = newNode;
        return;
    }
    newNode.next = null;
    head = newNode;
}
public void printlist(String data){
    if(head == null){
        System.out.println("list is empty");
    }
    Node currNode = head;
    while(currNode != null){
        System.out.println(currNode.next + "->");
    currNode = currNode.next;
    }
    System.out.println("null");
}
    public static void main(String[] args){
        SLL list = new SLL();
        list.addfirst("1");
        list.printlist("1");
        
    }
}
