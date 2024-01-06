package mountain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readLines(String file) throws IOException {
        return Files.readAllLines(Paths.get(file));
    }
}
