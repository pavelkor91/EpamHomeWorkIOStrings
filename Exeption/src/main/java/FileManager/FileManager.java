package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void showCatalog(){
        try {
            File catalog = new File(enterPath());
            String[] allFiles = catalog.list();
            for(String file : allFiles)
                System.out.println(file);
        }
        catch (NullPointerException e){
            showCatalog();
        }
    }
    public static void createTxt(){
        try{
            File txtfile = new File(enterPath() + ".txt");
            txtfile.createNewFile();
        } catch (IOException e){
            System.out.println("Error");
            Menu.run();
        }
    }
    public static void deleteFile(){
      try {
          File deleteFile = new File(enterPath());
          deleteFile.delete();
      }catch (NullPointerException e){
          System.out.println("File not found");
          Menu.run();
      }
    }
    public static void appendTxt(){
        Scanner in = new Scanner(System.in);
        File file = new File(enterPath());
        String txt;
        System.out.println("Введите текст:");
        txt = in.nextLine();
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.append(txt);
        }
        catch (IOException e){
            System.out.println("Cant Write");
        }
    }
    private static String enterPath(){
        System.out.println("Введите путь:");
        Scanner scanner = new Scanner(System.in);
        String path;
        path = scanner.nextLine();
        return path;
    }
}
