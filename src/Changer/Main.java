package Changer;

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

        //проверяем существование введённого пути
        do {
            System.out.println("Enter the absolute path to the folder ");
            directory = in.nextLine();
            path = Paths.get(directory);

        } while(directoryExist(path));
        in.close();

        //указываем, с какой директорией должна проводиться вся работа
        Changer changer = new Changer();
        File dir = new File(directory);
        changer.fetchChild(dir);

        changer.printNumOfRenamedFiles();
    }
}
