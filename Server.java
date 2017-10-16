/**
Server class designed to serve clients. the server listen to client for 
connection and once it receives the request, it will handle the task
and communicate with the connecting client
@author jeongj
*/
import java.io.*;
import java.net.*;

public class Server 
{  
   /**
   Main method of Server that allows to run the server.
   @param args  is unused
   */
   public static void main(String [] argv)
   {
      try
      {
         Server server = new Server();
         server.run();
      }
      catch( Exception ex )
      {
         System.out.println( "Error: " + ex ); 
      }
   }
   
   /**
   Run method that create server socket with port number '4758'
   then accept the socket and hand it the server thread to handle 
   the request. 
   */
   public void run()
   {
      try
      {
         int portNum = 4758;
         
         ServerSocket servSock = new ServerSocket( portNum );
         while ( true )
         {
            Socket sock = servSock.accept();
            ServerThread servThread = new ServerThread( sock );
            servThread.start();
         }
      }
      catch( Exception ex )
      {
         System.out.println( "Error: " + ex ); 
      }
   }
}

