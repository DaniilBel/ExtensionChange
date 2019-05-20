package Changer;

import java.io.*;

public class Changer {

    public void findFiles(File file, String extension){
        //вносим в список все файлы с расширением .java/.kt в данной директории
        File[] files = file.listFiles(pathname -> {
            if (!pathname.isFile())
                return false;

            if (pathname.getAbsolutePath().endsWith(extension))
                return true;

            return false;
        });

        renameFile(files);
    }

    public void renameFile(File[] files){
        //переименование всех фалов с расширением .java/.kt
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < files.length; ++i){

            stringBuilder.append(files[i].getAbsolutePath());
            stringBuilder.append(".2019");

            File newFile = new File(stringBuilder.toString());

            if(files[i].renameTo(newFile)){
                System.out.println("Файл " + files[i] + " переименован в " + files[i].getName() + ".2019");
            }
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    //В этой функции проходим по всем директориям начиная с данной(file)
    public void fetchChild(File file){

        if(file.isDirectory()){
            File[] children = file.listFiles();

            findFiles(file, ".java");
            findFiles(file, ".kt");

            for (File child : children){
                this.fetchChild(child);
            }
        }
    }
}
