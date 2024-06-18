/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackadt;
import java.util.EmptyStackException;
/**
 *
 * @author halo4
 */
public class StackADT<T> {
    // Node class to represent each element in the stack
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;  // Top of the stack

    // Push operation: Add an element to the top of the stack
    public void push(T item) {
        Node<T> t = new Node<>(item);
        t.next = top;
        top = t;
    }

    // Pop operation: Remove and return the top element of the stack
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    // Peek operation: Return the top element of the stack without removing it
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // isEmpty operation: Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    public static void main(String[] args) {
                StackADT<Integer> stack = new StackADT<>();

        // Test push operation
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Test peek operation
        System.out.println("Top element is: " + stack.peek());  // Output: 30

        // Test pop operation
        System.out.println("Popped element is: " + stack.pop());  // Output: 30

        // Test isEmpty operation
        System.out.println("Is stack empty? " + stack.isEmpty());  // Output: false

        // Pop remaining elements
        System.out.println("Popped element is: " + stack.pop());  // Output: 20
        System.out.println("Popped element is: " + stack.pop());  // Output: 10

        // Test isEmpty operation again
        System.out.println("Is stack empty? " + stack.isEmpty());  // Output: true
    }
    
}
