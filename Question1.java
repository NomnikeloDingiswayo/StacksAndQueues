import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1 {

  public static void main(String[] args) {
//declare a Queue to make a buffer of lines
    Queue buffer = new LinkedList();
//declare a Scanner object 
    Scanner sc = new Scanner(System.in);
// Declare String to store the user input
    String input;
// character to determine when program ends
    char exit = 'Y';
    // exit is diffenrent of X
    while (exit != 'X') {
      //get the user input
      input = sc.nextLine();
      // split each word by space and save in array each line
      String lines[] = input.split(" ");

      // for to go througth the array of lines
      for (int i = 0; i < lines.length; i++) {
        // if the first character of the lines is O
        if (lines[i].charAt(0) == 'O') {
          // check if the buffer is empty
          if (buffer.isEmpty()) {
            // print
            System.out.println("buffer empty");
          } else {//if is not empty
            // use poll to retrieve and delete the first element on the list
            System.out.println("Data: " + buffer.poll());
          }
          //if the line begins with the letter X
        } else if (lines[i].charAt(0) == 'X') {
          //set exit X this will stop the while
          exit = 'X';
          //break the for
          break;
        } else {//if the user input does not meet the above conditions 
          //add the line to the buffer
          buffer.add(lines[i]);
        }

      }

    }

  }

}