import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
  public static void main(String[] args) throws IOException {


    System.out.println("Enter the port number where the server should run:");
    Scanner scanner = new Scanner(System.in);
    int portNo = scanner.nextInt();
    scanner.nextLine();
    ServerSocket server = new ServerSocket(portNo);
    System.out.println("Starting the server:");
    System.out.println("Server started on port "+portNo);
    System.out.println("Waiting for client");
    Socket client = server.accept();
    System.out.println("Client connection established");
    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
      String line = is.readLine();
      String result = reverseStringCase(line);
      DataOutputStream os = new DataOutputStream(client.getOutputStream());
      os.writeBytes(result + "\n");
      System.out.println("Response sent to client");
      os.close();
      is.close();
      client.close();
      System.out.println("Server Exit");
      server.close();
    } catch (NullPointerException e){
      System.out.println("Error occurred, couldn't receive data from client");
    }

  }

  /*Helper method which takes in a string and reverses it
  and also reverses the capitalization of the strings
  */
  public static String reverseStringCase(String line) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      if (Character.isUpperCase(c)) {
        sb.append(Character.toLowerCase(c));
      } else {
        sb.append(Character.toUpperCase(c));
      }
    }
    return sb.reverse().toString();
  }
}