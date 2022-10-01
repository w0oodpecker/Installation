import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Dirsandfiles {

    ArrayList<String> dirs; //Список каталогов для создания
    ArrayList<String> files; //Список файлов для создания
    String MESSAGECREATED = "- создан";
    String MESSAGENOCREATED = " - не создан или уже существует";
    String MESSAGENODIRS = " - каталоги для создания не были заданы";
    String MESSAGENOFILES = " - файл для создания не были заданы";


    Dirsandfiles(ArrayList<String> dirs, ArrayList<String> files) { //Конструктор: создаем каталоги
        this.dirs = dirs;
        this.files = files;
    }


    private void dirInit(String dest) {
        File dir = new File(dest);
        try {
            if (dir.mkdir()) {
                this.fixToLog(new Date().toString() + " " + dest + " " + this.MESSAGECREATED);
            } else {
                this.fixToLog(new Date().toString() + " " + dest + " " + this.MESSAGENOCREATED);
            }
        } catch (Exception exc) {
            this.fixToLog(new Date().toString() + " " + dest + " " + exc.getMessage());
        }
    }


    private void filesInit(String dest) {
        File file = new File(dest);
        try {
            if (file.createNewFile()) {
                this.fixToLog(new Date().toString() + " " + dest + " " + this.MESSAGECREATED);
            } else {
                this.fixToLog(new Date().toString() + " " + dest + " " + this.MESSAGENOCREATED);
            }
        } catch (IOException exc) {
            this.fixToLog(new Date().toString() + " " + dest + " " + exc.getMessage());
        }
    }


    private void fixToLog(String message) {

        try (FileWriter writer = new FileWriter(this.files.get(0), true)) {
            writer.append(message + '\n');
            writer.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }


    public void init() {
        this.dirInit(dirs.get(0));
        this.dirInit(dirs.get(1));
        fixToLog(new Date().toString() + " " + files.get(0) + " " + this.MESSAGECREATED); //Создание файлов

        for (int index = 2; index < dirs.size(); index++) {
            this.dirInit(dirs.get(index));
        }

        for (int index = 1; index < files.size(); index++) {
            this.filesInit(files.get(index));
        }
    }
}
