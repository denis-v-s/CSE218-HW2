package q1;

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
  private ArrayList<T> qArray;
  
  public PriorityQueue() {
    qArray = new ArrayList<>();
  }
  
  // gets the smallest item (top item, since it's already sorted)
  public T remove() {
    return qArray.remove(qArray.size() - 1);
  }
  
  public T peekMin() {
    return qArray.get(qArray.size() - 1);
  }
  
  public boolean isEmpty() {
    return qArray.size() == 0;
  }
  
  public int size() {
    return qArray.size();
  }
    
  public void insert(T item) {
    int j = qArray.size() - 1;
    qArray.add(item);
    
    while (j >= 0 && item.compareTo(qArray.get(j)) > 0) {
      qArray.set(j + 1, qArray.get(j));
      j--;
    }
    
    qArray.set(j + 1, item);
  }
  
  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.insert(3);
    pq.insert(1);
    pq.insert(5);
    pq.insert(4);
    pq.insert(2);
    
    while (!pq.isEmpty()) {
      System.out.println(pq.remove());
    }
  }
}
