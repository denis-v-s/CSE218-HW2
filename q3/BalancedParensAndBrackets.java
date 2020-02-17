package q3;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import q1.Stack;

public class BalancedParensAndBrackets {

  public static boolean isBalanced(Path file) {
    Stack<Character> stack = new Stack<>();
    Hashtable<Character, Character> tokens = new Hashtable<>();
    tokens.put(']', '[');
    tokens.put(')', '(');
    
    try (FileReader fr = new FileReader(file.toString()); 
         BufferedReader reader = new BufferedReader(fr)) {
      int c = 0;
      while ((c = reader.read()) != -1) {
        // if it's an opening token, then add it to the stack
        if (tokens.containsValue((char) c)) {
          stack.push((char) c);
        }
        // if this is a closing token, then compare it to the top of the stack
        // if they don't match, then there is no balance.
        else if (tokens.containsKey((char) c)) {
          char matchingToken = tokens.get((char) c);
          if (stack.pop() != matchingToken) {
            return false;
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    Path dir = Paths.get("").toAbsolutePath().resolve("src/q3/");
    
    System.out.println(isBalanced(dir.resolve("balanced.txt"))); // true
    System.out.println(isBalanced(dir.resolve("unbalanced.txt"))); // false
    System.out.println(isBalanced(dir.resolve("unbalanced (2).txt"))); // false
  }
}
