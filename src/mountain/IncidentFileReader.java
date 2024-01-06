package mountain;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class IncidentFileReader {

    public static HashMap<String, Incident> readTXT(String fileName) throws IOException {
        HashMap<String, Incident> incidentsMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                    Incident incident = new Incident();
                    incident.setIncidentNo(Integer.parseInt(parts[0].trim()));
                    incident.setReporterNo(Integer.parseInt(parts[1].trim()));
                    incident.setDate(parts[2].trim());
                    incident.setTime(parts[3].trim());
                    incident.setWords(parts[4].trim());
                    incident.setOngoing(parts[5].trim());
                    incident.setIncidentDet(parts[6].trim());

                    incidentsMap.put(parts[0], incident);
               
            }
        }

        return incidentsMap;
    }
}
