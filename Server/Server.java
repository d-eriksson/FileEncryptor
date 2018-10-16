import java.net.*;
import java.io.*;

public class Server extends Thread{
  private ServerSocket serverSocket;

  public Server(int port) throws IOException{
    serverSocket = new ServerSocket(port);
    //serverSocket.setSoTimeout(10000);
  }

  public void run(){
    while(true){
      try{
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "..." + InetAddress.getLocalHost());
        Socket server = serverSocket.accept();


        System.out.println("Just connected to " + server.getRemoteSocketAddress());
        DataInputStream in = new DataInputStream(server.getInputStream());
        PrintWriter writer = new PrintWriter("TARGET_" + System.currentTimeMillis() + ".txt", "UTF-8");
        writer.println(server.getRemoteSocketAddress());
        writer.println(in.readUTF());
        writer.println(in.readUTF());
        writer.close();
        server.close();
      } catch(SocketTimeoutException s){
        System.out.println("Socket timed out!");
        break;
      } catch(IOException e){
        e.printStackTrace();
        break;
      }
    }
  }
  public static void main(String[] args){
    int port = Integer.parseInt(args[0]);
    try{
      Thread t = new Server(port);
      t.start();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
