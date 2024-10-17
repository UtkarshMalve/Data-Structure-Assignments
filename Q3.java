package q3;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void insert(int number) {
        Node newNode = new Node(number % 10);
        newNode.next = head;
        head = newNode;

        number /= 10;
        while (number > 0) {
            newNode = new Node(number % 10);
            newNode.next = head;
            head = newNode;

            number /= 10;
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        LinkedList list = new LinkedList();
        list.insert(number);

        System.out.println("Linked list with individual digits:");
        list.display();
    }
}