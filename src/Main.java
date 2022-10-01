import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        ArrayList<String> dirs = new ArrayList<>();
        ArrayList<String> files = new ArrayList<>();
        Dirsandfiles directories = new Dirsandfiles(dirs, files);


        //Инициализация каталогов
        dirs.add("D://Games");
        dirs.add(dirs.get(0) + "/temp");
        dirs.add(dirs.get(0) + "/src");
        dirs.add(dirs.get(0) + "/res");
        dirs.add(dirs.get(0) + "/savegames");
        dirs.add(dirs.get(0) + "/src/main");
        dirs.add(dirs.get(0) + "/src/test");
        dirs.add(dirs.get(0) + "/res/drawables");
        dirs.add(dirs.get(0) + "/res/vectors");
        dirs.add(dirs.get(0) + "/res/icons");

        //Инициализация файлов
        files.add(dirs.get(0) + "/temp/temp.txt");
        files.add(dirs.get(0) + "/src/main/Main.java");
        files.add(dirs.get(0) + "/src/main/Utils.java");

        directories.init();

    }
}