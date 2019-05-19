package Changer;

import java.io.*;

public class Changer {

    public void findAll(File file, String extension){
        //вносим в список все файлы с расширением .java/.kt в данной директории
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (!pathname.isFile())
                    return false;

                if (pathname.getAbsolutePath().endsWith(extension))
                    return true;

                return false;
            }
        });

        renameFile(files);
    }

    public void renameFile(File[] files){
        //переименование всех фалов с расширением .java/.kt
        for(int i = 0; i < files.length; ++i){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(files[i].getAbsolutePath());
            stringBuilder.append(".2019");
            File newFile = new File(stringBuilder.toString());
            if(files[i].renameTo(newFile)){
                System.out.println("Файл " + files[i] + " переименован");
            }
        }
    }

    //В этой функции проходим по всем директориям начиная с данной(file)
    public void fetchChild(File file){
        //System.out.println(file.getAbsolutePath());

        if(file.isDirectory()){
            File[] children = file.listFiles();

            findAll(file, ".java");
            findAll(file, ".kt");

            for (File child : children){
                this.fetchChild(child);
            }
        }
    }
}
