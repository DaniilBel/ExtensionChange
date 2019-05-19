package Changer;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        DirTemplate dirTemplate = new DirTemplate();
        //dirTemplate.createTemplate();
        //dirTemplate.deleteTemplate();

        Changer changer = new Changer();
        File dir = new File("c:/javaSaves/ExtensionChange/test");
        changer.fetchChild(dir);
    }
}
