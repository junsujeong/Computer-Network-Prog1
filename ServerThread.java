/**
Server Thread class which serves the request of clients.
Basically, in this program server thread brings the input number
from the socket and calculate the factorial of it and 
write the answer it back to socket.
@author jeongj
*/
import java.io.*;
import java.net.*;


public class ServerThread extends Thread
{
   private Socket sock;	         
   private PrintWriter outToClient;     
   private BufferedReader inFromClient; 
   
   /**
   Constructor of serverThread class that initialize sock,
   printWriter and bufferedReader
   @param socket socket that was created in the server class
   */
   public ServerThread(Socket socket)
   {
      try
      {
         sock = socket;
         inFromClient = new BufferedReader(new InputStreamReader
                                          (sock.getInputStream())); 
         outToClient = new PrintWriter(sock.getOutputStream(), true);     
      }
      catch( Exception ex )
      {
         System.out.println( "Error: " + ex ); 
      }
   }
   
   /**
   run method which reads a number from client and 
   calls factorial method to process the request from client.
   Once it done with factorial write the value back to socket.
   And close it after.
   */
   public void run()
   {
      try
      {
         String inLine = inFromClient.readLine();
         int numFromClient = Integer.parseInt(inLine);
         outToClient.println(factorial(numFromClient));
         sock.close();
      }
      catch( Exception ex )
      {
         System.out.println( "Error: " + ex ); 
      }
   }

   /**
   Method that calculates the factorial of number
   @param inFromClient is an int type that were requested from a client
   */   
   public int factorial(int inFromClient)
   {
      if(inFromClient == 0)
      {
         return 1;
      }
      else
      {
         return (inFromClient * factorial(inFromClient - 1 ));
      }
   }
}
