import java.io.*;
import org.apache.commons.io.FilenameUtils;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCreeper {
  ArrayList<File> PrimaryList;
  ArrayList<String> FileTypes;
  ArrayList<String> ignoredDir;
  FileCreeper(ArrayList<String> T){
    PrimaryList =new ArrayList<File>();
    ignoredDir = new ArrayList<String>();
    FileTypes = T;
    ignoredDir.add("node_modules");
    ignoredDir.add("AppData");
    ignoredDir.add("Program Files (x86)");
    ignoredDir.add("Program Files");
    ignoredDir.add("Windows");
    ignoredDir.add("Windows10Upgrade");
    ignoredDir.add("ProgramData");
    ignoredDir.add("BIOS");
  }

  public void creep(File dir){
    File[] listOfFiles = dir.listFiles();
    System.out.println(dir);
    for (int i = 0; i < listOfFiles.length; i++) {
      try{
        if (listOfFiles[i].isFile()) {
          //System.out.println("File " + listOfFiles[i].getName() + "File type: " + FilenameUtils.getExtension(listOfFiles[i].getPath()));
          if(CheckFileType(FilenameUtils.getExtension(listOfFiles[i].getPath()))){
            PrimaryList.add(listOfFiles[i]);
          }
        } else if (listOfFiles[i].isDirectory()) {
          //System.out.println("Directory " + listOfFiles[i]);
          if(IgnoredDirectories(listOfFiles[i])){
            creep(listOfFiles[i]);
          }
        }
      }
      catch(java.lang.NullPointerException exception){
        System.out.println(exception);
      }
    }
  }

  private boolean CheckFileType(String t){
    for(String type:FileTypes){
      if(FilenameUtils.equals(t, type)){
        return true;
      }
    }
    return false;
  }
  private boolean IgnoredDirectories(File file){
    for(String i:ignoredDir){
      if(file.getName().equals(i)){
        return false;
      }
    }
    return true;
  }

  public static void main( String[] args ) {
    ArrayList<String> T = new ArrayList<String>();
    T.add("txt");
    T.add("jpeg");
    T.add("jpg");
    T.add("png");
    T.add("PNG");
    T.add("pdf");
    T.add("mp4");
    T.add("mov");
    FileCreeper C = new FileCreeper(T);
    File folder = new File("C:/");
    C.creep(folder);
    System.out.println(C.PrimaryList.size());
  }
}
