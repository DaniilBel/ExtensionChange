package Changer;

import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    //Проверяем существование пути
    private static boolean directoryExist(Path path) throws IOException{
        if(Files.isDirectory(path)){
            path.getFileSystem().provider().checkAccess(path.toRealPath(), AccessMode.READ);
            return false;
        } else {
            System.out.println("Path not found");
            return true;
        }
    }

    public static void main(String[] args) throws IOException{

        Path path;
        String directory;
        Scanner in = new Scanner(System.in);

        System.out.println("Current directory");
        File curDir = new File(new File("").getAbsolutePath());
        System.out.println(curDir);

        //проверяем существование введённого пути
        do {
            System.out.println("Enter the absolute path to the folder or press enter to change the files");
            directory = in.nextLine();

            //if(directory.equals(Integer.toString(KeyEvent.VK_ENTER))){
            if(directory.equals("")){
                path = Paths.get(curDir.toString());
            } else {
                path = Paths.get(directory);
            }

        } while(directoryExist(path));
        in.close();

        //указываем, с какой директорией должна проводиться вся работа
        Changer changer = new Changer();
        File dir = new File(path.toString());
        changer.fetchChild(dir);

        changer.printNumOfRenamedFiles();
    }
}
