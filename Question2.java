import java.util.Scanner;
import java.util.Stack;

public class Question2 {

  /* Returns true if character1 and character2 
    are matching left and right Parenthesis */
  static boolean isMatchingPair(char character1, char character2) {
    if (character1 == '(' && character2 == ')') {
      return true;
    } else if (character1 == '{' && character2 == '}') {
      return true;
    } else if (character1 == '[' && character2 == ']') {
      return true;
    } else if (character1 == '<' && character2 == '>') {
      return true;
    } else {//not matching print the error
      System.out.println("error: '" + character2 + "' does not match with '" + character1 + "'.");

      return false;
    }
  }

  /* Check a string if the string is not balanced print the error*/
  static void isBalanced(String text) {
    boolean valid = true;
    char[] characters = text.toCharArray();// transform a String to chararray 
    /* Declare an empty character stack */
    Stack<Character> st = new Stack<>();

    /* Traverse the given expression to  
     check matching parenthesis */
    for (int i = 0; i < characters.length; i++) {

      /*If the characters[i] is a starting  
      parenthesis then push it*/
      if (characters[i] == '{' || characters[i] == '(' || characters[i] == '[' || characters[i] == '<') {
        st.push(characters[i]);
      }

      /* If characters[i] is an ending parenthesis  
       then pop from stack and check if the  
       popped parenthesis is a matching pair*/
      if (characters[i] == '}' || characters[i] == ')' || characters[i] == ']' || characters[i] == '>') {

        /* If we see an ending parenthesis without  
         a pair then return false*/
        if (st.isEmpty()) {
          valid = false;
          System.out.println("error at end: the close bracket '" + characters[i] + "' does not have a corresponding opening bracket");
          //return false;
        } /* Pop the top element from stack, if  
        it is not a pair parenthesis of character  
        then there is a mismatch. This happens for  
        expressions like {(}) */ 
        else if (!isMatchingPair(st.pop(), characters[i])) {
          valid = false;
          //break the for
          break;
        }
      }

    }

    /* If there is something left in expression  
     then there is a starting parenthesis without  
     a closing parenthesis */
    if (st.isEmpty() && valid) {
      System.out.println("The string is correct! There are no mismatched brackets.");

    }
    if (!st.isEmpty() && valid) {  //not balanced
      System.out.println("error at end: opening bracket " + st.peek() + " remains unclosed.");

    }
  }

  public static void main(String[] args) {
    //declare a Scanner object 
    Scanner sc = new Scanner(System.in);
    //declare a string to store the input
    String line;
    //while true
    while (true) {
      //ask for the string to check  
      System.out.print("Enter a string to test: ");

      line = sc.nextLine();
      // if the user enter X we end this program
      if (line.charAt(0) == 'X') {
        //break the while
        break;
      }
      //check if the line is balanced
      isBalanced(line);

      System.out.println();
    }

  }

}