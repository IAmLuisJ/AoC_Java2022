import java.util.ArrayList;

public class Directory {
    String dirPath = "";
    int size = 0;
    ArrayList<String> files = new ArrayList<>();
    ArrayList<Directory> subDirs = new ArrayList<>();

    public Directory(String pathName) {
        dirPath = pathName;
    }

}
