import java.util.ArrayList;
import java.io.*;

public class MainDecrypt{

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
    String PASSWORD = args[0];

    for(File f:C.PrimaryList){
      FE.DecryptFile(f, PASSWORD);
    }
  }
}
