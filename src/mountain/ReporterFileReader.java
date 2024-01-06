package mountain;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ReporterFileReader {
	public static HashMap<String, Reporter> readTXT(String fileName) throws IOException {
		HashMap<String, Reporter> reporterMap = new HashMap<String, Reporter>();
		Scanner scanner = new Scanner(new File(fileName));

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] data = line.split(",");

			String name = data[0].trim();
			int reporterNo = Integer.parseInt(data[1].trim());
			String date = data[2].trim();
			String time = data[3].trim();
			int telNo = Integer.parseInt(data[4].trim());
			String address = data[5].trim();
			String postCode = data[6].trim();

			// Create a new Reporter object and add it to the reporterMap
			Reporter reporter = new Reporter(name, date, time, address, postCode, reporterNo, telNo);
			reporterMap.put(data[1].trim(), reporter);
		}
		scanner.close();
		return reporterMap;

	}
}
