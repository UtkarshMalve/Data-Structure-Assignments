package DSProblem;

import java.util.Scanner;

class Node {
	
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    
    public void insertSorted(int value) {
        Node newNode = new Node(value);
        if (head == null || head.data > value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < value) {
                current = current.next;
            }
            
            if (current.data != value) {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    
    public SinglyLinkedList union(SinglyLinkedList list2) {
        SinglyLinkedList result = new SinglyLinkedList();
        Node current1 = this.head;
        Node current2 = list2.head;

        while (current1 != null) {
            result.insertSorted(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            result.insertSorted(current2.data);
            current2 = current2.next;
        }

        return result;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();

        
        System.out.println("Enter elements for the first sorted linked list (type -1 to end):");
        int value;
        while (true) {
            value = scanner.nextInt();
            if (value == -1) break;
            list1.insertSorted(value);
        }

       
        System.out.println("Enter elements for the second sorted linked list (type -1 to end):");
        while (true) {
            value = scanner.nextInt();
            if (value == -1) break;
            list2.insertSorted(value);
        }

       
        System.out.print("First Linked List: ");
        list1.display();
        System.out.print("Second Linked List: ");
        list2.display();
       

       
        SinglyLinkedList unionList = list1.union(list2);
        System.out.print("Union of the two linked lists: ");
        unionList.display();
    }
}

