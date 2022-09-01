import java.util.*;
import java.io.*;
class StackException extends Exception {
    public StackException(String s) {
        super(s);
    }
}
class Stack {
    public static void main(String[] args) throws StackException {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.display();
        stack.pop();
    }
}
class MyStack<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }
    private Node<T> top;
    
    public T pop() throws StackException{
        if(top == null) {
            throw new StackException("Stack is Empty");
        }
        T item = top.data;
        top = top.next;
        return item;
    }
    public void push(T item) {
        Node<T> temp = new Node<T>(item);
        temp.next = top;
        top = temp;
    }
    public T peek() throws StackException {
        if(top == null) {
            throw new StackException("Stack is Empty");
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void display() {
        Node<T> temp = top;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
