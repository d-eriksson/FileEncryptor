import java.io.*;
import org.apache.commons.io.FilenameUtils;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileEncryptor {

  public void EncryptFile(File file, String password) throws Exception{
    Encryptor en=new Encryptor();
    //ArrayList<String> TextRows =new ArrayList<String>();
    byte[] fileContent = Files.readAllBytes(file.toPath());
    FileOutputStream fos = new FileOutputStream(file);
    fos.write(en.encryptByte(fileContent, password));
    fos.close();
  }
  public void DecryptFile(File file, String password) throws Exception{
    Encryptor en=new Encryptor();
    //ArrayList<String> TextRows =new ArrayList<String>();
    byte[] fileContent = Files.readAllBytes(file.toPath());
    FileOutputStream fos = new FileOutputStream(file);
    fos.write(en.decryptByte(fileContent, password));
    fos.close();
  }
  public static void main( String[] args ) throws Exception{
    long startTime = System.currentTimeMillis();
    File f = new File("C:/Users/odavi/Programmering/Java/FileEncryptor/ok.PNG");
    FileEncryptor FE = new FileEncryptor();
    //FE.EncryptFile(f,"Password");
    FE.DecryptFile(f, "Password");
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println(elapsedTime);
  }
}
