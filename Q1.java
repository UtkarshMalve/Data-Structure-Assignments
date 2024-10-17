package DSProblem;

import java.util.Scanner;

class Stack {
    private char[] stack;
    private int top;
    private int maxSize;

    
    public Stack(int size) {
        maxSize = size;
        stack = new char[maxSize];
        top = -1;
    }

    
    public void push(char c) {
        if (top < maxSize - 1) {
            stack[++top] = c;
        } else {
            System.out.println("Stack Overflow");
        }
    }

  
    public char pop() {
        if (top >= 0) {
            return stack[top--];
        } else {
            System.out.println("Stack Underflow");
            return '\0'; 
        }
    }

    
    public boolean isEmpty() {
        return top == -1;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
       
        Stack stack = new Stack(input.length());

        
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        
        System.out.println("Reversed string: " + reversedString);
        
    }
}

