package q2;

import q1.Stack;
import java.util.regex.Pattern;

public class ReverseAllSentences {

  public static void main(String[] args) {
    String data = "Lorem. Ipsum dolor sit amet! Consectetur adipiscing elit? sed do eiusmod. tempor incididunt!";
    
    // reverse the sentences, split by . ! or ?
    Stack<String> stringStack = new Stack<>();
    Pattern.compile("\\.|\\!|\\?").splitAsStream(data).forEach(stringStack::push);
    
    while (!stringStack.isEmpty() ) {
      System.out.println(stringStack.pop());
    }
    
    // reverse all characters
    Stack<Character> charStack = new Stack<>();
    for (char c : data.toCharArray()) {
      charStack.push(c);
    }
    while (!charStack.isEmpty()) {
      System.out.println(charStack.pop());
    }
  }
}
