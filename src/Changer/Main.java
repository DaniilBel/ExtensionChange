package Changer;

import java.io.*;

public class Main {

    //В этой функции проходим по всем директориям начиная с данной(file)
    private void fetchChild(File file){
        //System.out.println(file.getAbsolutePath());

        if(file.isDirectory()){
            File[] children = file.listFiles();

            //вносим в список все файлы с расширением .java в данной директории
            File[] javaFiles = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (!pathname.isFile()) {
                        return false;
                    }

                    if (pathname.getAbsolutePath().endsWith(".java")) {
                        return true;
                    }

                    return false;
                }
            });

            //вносим в список все файлы с расширением .kt в данной директории
            File[] ktFiles = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (!pathname.isFile()) {
                        return false;
                    }

                    if (pathname.getAbsolutePath().endsWith(".kt")) {
                        return true;
                    }

                    return false;
                }
            });

            //переименование всех фалов с расширением .java
            for(int i = 0; i < javaFiles.length; ++i){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(javaFiles[i].getAbsolutePath());
                //String str = javaFiles[i].getName();
                stringBuilder.append(".2019");
                File newFile = new File(stringBuilder.toString());
                if(javaFiles[i].renameTo(newFile)){
                    System.out.println("Файл " + javaFiles[i] + " переименован");
                }
            }

            //переименование всех фалов с расширением .kt
            for(int i = 0; i < ktFiles.length; ++i){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(ktFiles[i].getAbsolutePath());
                //String str = javaFiles[i].getName();
                stringBuilder.append(".2019");
                File newFile = new File(stringBuilder.toString());
                if(ktFiles[i].renameTo(newFile)){
                    System.out.println("Файл " + ktFiles[i] + " переименован");
                }
            }

            for (File child : children){
                this.fetchChild(child);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        DirTemplate dirTemplate = new DirTemplate();
        dirTemplate.createTemplate();
        //dirTemplate.deleteTemplate();

        //Main main = new Main();
        //File dir = new File("c:/javaSaves/ExtensionChange/test");
        //main.fetchChild(dir);
    }
}
