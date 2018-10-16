import java.net.*;
import java.io.*;

public class ClientConnection{
  public void sendInformation(String serverName, int port, String pass, int NumberOfFiles){
    try{
      Socket client = new Socket(serverName, port);
      OutputStream outToServer = client.getOutputStream();
      DataOutputStream out = new DataOutputStream(outToServer);
      
      out.writeUTF(pass);
      out.writeUTF(Integer.toString(NumberOfFiles));
      InputStream inFromServer = client.getInputStream();
      DataInputStream in = new DataInputStream(inFromServer);

      client.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    ClientConnection con = new ClientConnection();
    con.sendInformation("192.168.31.2", 8159, "Password", 12345);
  }
}
