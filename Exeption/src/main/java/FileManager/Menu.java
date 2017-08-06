package FileManager;


import java.util.Scanner;

public class Menu {

    public static void run(){
        System.out.println("Выберите действие:");
        System.out.println("1. Выбрать директорию:");
        System.out.println("2. Создать текстовый файл:");
        System.out.println("3. Удалить текстовый файл:");
        System.out.println("4. Редактировать текстовый файл:");
        int key;
        Scanner in = new Scanner(System.in);
        key = in.nextInt();

        switch (key) {
            case 1:
                FileManager.showCatalog();
                break;
            case 2:
                FileManager.createTxt();
                break;
            case 3:
                FileManager.deleteFile();
                break;
            case 4:
                FileManager.appendTxt();
                break;
                default:
                    System.out.println("Try againg");
                    Menu.run();
        }
    }
}
