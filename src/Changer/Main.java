package Changer;

import java.io.*;

public class Main {

    public void createTemplate() throws IOException{
        File dir1 = new File("a");
        File dir2 = new File("b");

        if(!dir1.exists()){
            dir1.mkdir();
            System.out.println("Создана 1 директория");
        }
        if(!dir2.exists()){
            dir2.mkdir();
            System.out.println("Создана 2 директория");
        }

        File file;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" .java");

        for (int i = 1; i <= 3; ++i){

            stringBuilder.replace(0, 1, String.valueOf(i));
            file = new File(stringBuilder.toString());
            if(!file.exists()){
                file.createNewFile();
            }
        }
    }

    public void deleteTemplate() throws IOException{
        File dir1 = new File("a");
        File dir2 = new File("b");
        if(dir1.exists()) {
            dir1.delete();
            System.out.println("Удалена 1 директория");
        }
        if(dir2.exists()) {
            dir2.delete();
            System.out.println("Удалена 2 директория");
        }

        File file;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" .java");

        for (int i = 1; i <= 3; ++i){

            stringBuilder.replace(0, 1, String.valueOf(i));
            file = new File(stringBuilder.toString());
            if(file.exists()){
                file.delete();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        //main.deleteTemplate();
        //main.createTemplate();
    }
}
