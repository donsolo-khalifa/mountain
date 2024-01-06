package mountain;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ResourceFileReader {

    public static HashMap<String, Resource> readTXT(String fileName) throws IOException {
        HashMap<String, Resource> resourceMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                int resourceNo = Integer.parseInt(parts[0].trim()); // Trim the string before parsing
                String resourceCode = parts[1].trim(); // Trim the string before using it
                int numOfUnits = Integer.parseInt(parts[2].trim()); // Trim the string before parsing
                String resourceDesc = parts[3].trim(); // Trim the string before using it

                Resource resource = new Resource(resourceNo, numOfUnits, resourceCode, resourceDesc);
                resourceMap.put(parts[0], resource);
            }
        }

        return resourceMap;
    }
}
