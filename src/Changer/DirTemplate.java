package Changer;

import java.io.*;

public class DirTemplate {
    private final int N = 3;

    public void createTemplate() throws IOException {
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
        StringBuilder stringBuilderJava = new StringBuilder();
        stringBuilderJava.append(" .java");

        for (int i = 1; i <= N; ++i){

            stringBuilderJava.replace(0, 1, String.valueOf(i));
            file = new File(stringBuilderJava.toString());
            if(!file.exists()){
                file.createNewFile();
            }
        }

        /////////////////////////////
        StringBuilder stringBuilderKt = new StringBuilder();
        stringBuilderKt.append(" .kt");

        for (int i = 1; i <= N; ++i){

            stringBuilderKt.replace(0, 1, String.valueOf(i));
            file = new File(stringBuilderKt.toString());
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
        StringBuilder stringBuilderJava = new StringBuilder();
        stringBuilderJava.append(" .java");

        for (int i = 1; i <= N; ++i){

            stringBuilderJava.replace(0, 1, String.valueOf(i));
            file = new File(stringBuilderJava.toString());
            if(file.exists()){
                file.delete();
            }
        }
        /////////////////////////////
        StringBuilder stringBuilderKt = new StringBuilder();
        stringBuilderKt.append(" .kt");

        for (int i = 1; i <= N; ++i){

            stringBuilderKt.replace(0, 1, String.valueOf(i));
            file = new File(stringBuilderKt.toString());
            if(file.exists()){
                file.delete();
            }
        }
    }
}
