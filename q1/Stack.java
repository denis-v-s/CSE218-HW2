package q1;

import java.util.*;

public class Stack<T> {
  private ArrayList<T> sArray;
  
  public Stack() {
    sArray = new ArrayList<>();
  }
  
  public void push(T value) {
    sArray.add(value);
  }
  
  public T pop() {
    if (sArray.size() == 0) throw new EmptyStackException();
    return sArray.remove(sArray.size() - 1);
  }
  
  public T peek() {
    return sArray.get(sArray.size() - 1);
  }
  
  public boolean isEmpty() {
    return sArray.size() == 0;
  }
    
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}
