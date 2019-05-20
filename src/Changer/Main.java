package Changer;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    static boolean ensureDirectoryExists(Path path) throws IOException{
        if(Files.isDirectory(path)){
            path.getFileSystem().provider().checkAccess(path.toRealPath(), AccessMode.READ);
            return false;
        } else {
            System.out.println("Path not found");
            return true;
        }
    }

    public static void main(String[] args) throws IOException{

        Path path = null;
        String directory;
        Scanner in = new Scanner(System.in);

        //проверяем существование введённого пути
        do {
            //просим ввести путь
            System.out.println("Введите абсолютный путь: ");
            directory = in.nextLine();
            path = Paths.get(directory);

        } while(ensureDirectoryExists(path));
        in.close();

        //указываем, с какой директорией должна проводиться вся работа

        Changer changer = new Changer();
        File dir = new File(directory);
        changer.fetchChild(dir);

        //File dir = new File("c:/javaSaves/ExtensionChange/test");
    }
}
