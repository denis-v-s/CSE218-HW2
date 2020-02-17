package q1;
import java.util.*;

public class Queue<T> {
  private ArrayList<T> qArray;
  private int maxSize;
  private int front;
  private int rear;
  private int nItems;
  
  public Queue(int maxSize) {
    this.maxSize = maxSize;
    qArray = new ArrayList<>(maxSize);
    front = 0;
    rear = -1;
    nItems = 0;
  }
  
  public T peekFront() {
    return qArray.get(front);
  }
  
  public boolean isEmpty() {
    return nItems == 0;
  }
  
  public boolean isFull() {
    return nItems == maxSize;
  }
  
  public T remove() {
    T temp = qArray.get(front++);
    if (front == maxSize) {
      front = 0;
    }
    nItems--;
    return temp;
  }
  
  public void insert(T value) {
    if (rear == maxSize - 1) {
      rear = -1;
    }
    if (qArray.size() < maxSize) {
      qArray.add(value);      
      nItems++;
    } else {
      qArray.set(++rear, value);      
    }
  }
  
  public static void main(String[] args) {
    Queue<Integer> q = new Queue<>(5);
    q.insert(1);
    q.insert(2);
    q.insert(3);
    q.insert(4);
    q.insert(5);
    q.insert(6);
    
    while (!q.isEmpty()) {
      System.out.println(q.remove());
    }
  }
}
