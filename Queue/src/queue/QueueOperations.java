/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queue;
import java.util.LinkedList;
import java.util.Queue;
public class QueueOperations {
    public static void main(String[] args) {
        // TODO code application logic here
         Queue<Integer> queue = new LinkedList<>();
        // Add elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        // Display the elements of the queue
        System.out.println("Queue: " + queue);
        // Remove elements from the queue
        int removedElement = queue.remove();
        System.out.println("Removed element: " + removedElement);
        // Display the queue after removal
        System.out.println("Queue after removal: " + queue);
        // Peek at the front element of the queue
        int frontElement = queue.peek();
        System.out.println("Front element: " + frontElement);
        // Check the size of the queue
        int size = queue.size();
        System.out.println("Size of the queue: " + size);
        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);
        // Poll an element from the queue
        int polledElement = queue.poll();
        System.out.println("Polled element: " + polledElement);
        // Display the queue after polling
        System.out.println("Queue after polling: " + queue);
    }
    
}
