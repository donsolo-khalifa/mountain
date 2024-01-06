package mountain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IncidentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField incidentNo;
	private JTextField reporterNo;
	private JTextField date;
	private JTextField time;
	private JTextField gps3;
	private JTable table;
	private JComboBox ongoing;
	private JTextArea incidentDet;
	private Incident selectedIncident;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public IncidentWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1072, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.CYAN, 2));
		panel.setBounds(10, 122, 292, 595);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Incident NO");
		lblNewLabel.setBounds(10, 10, 83, 41);
		panel.add(lblNewLabel);

		JLabel lblReporterNo = new JLabel("Reporter No");
		lblReporterNo.setBounds(10, 60, 83, 41);
		panel.add(lblReporterNo);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 111, 83, 41);
		panel.add(lblDate);

		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(10, 162, 83, 41);
		panel.add(lblTime);

		JLabel lblGpswords = new JLabel("GPS 3-words");
		lblGpswords.setBounds(10, 216, 83, 41);
		panel.add(lblGpswords);

		JLabel lblOngoing = new JLabel("Ongoing");
		lblOngoing.setBounds(10, 267, 83, 41);
		panel.add(lblOngoing);

		JLabel lblIncidentDetails = new JLabel("Incident Details");
		lblIncidentDetails.setBounds(10, 305, 83, 41);
		panel.add(lblIncidentDetails);

		incidentNo = new JTextField();
		incidentNo.setBounds(128, 21, 154, 19);
		panel.add(incidentNo);
		incidentNo.setColumns(10);

		reporterNo = new JTextField();
		reporterNo.setColumns(10);
		reporterNo.setBounds(128, 71, 154, 19);
		panel.add(reporterNo);

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(128, 122, 154, 19);
		panel.add(date);

		time = new JTextField();
		time.setColumns(10);
		time.setBounds(128, 173, 154, 19);
		panel.add(time);

		gps3 = new JTextField();
		gps3.setColumns(10);
		gps3.setBounds(128, 227, 154, 19);
		panel.add(gps3);

		ongoing = new JComboBox();
		ongoing.setModel(new DefaultComboBoxModel(new String[] { "", "Yes", "No" }));
		ongoing.setBounds(128, 277, 154, 21);
		panel.add(ongoing);

		incidentDet = new JTextArea();
		incidentDet.setBounds(128, 313, 154, 272);
		panel.add(incidentDet);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//To-do
				incidentNo.setText("");
				reporterNo.setText("");
				date.setText("");
				time.setText("");
				gps3.setText("");
				ongoing.setSelectedIndex(0);
				incidentDet.setText("");
				
			}
		});
		btnReset.setBounds(10, 530, 85, 55);
		panel.add(btnReset);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.CYAN, 2));
		panel_1.setBounds(312, 122, 736, 510);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 716, 490);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { "", null, null, null, null, null, null }, },
				new String[] { "Incident No", "Reporter No", "Date", "Time", "GPS3Words", "Ongoing", "Details" }));

		populateTableFromFile();
		setupTableSelectionListener();

		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.CYAN));
		panel_2.setBounds(312, 642, 736, 75);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton createBtn = new JButton("Add New");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewIncident();
			}
		});
		createBtn.setBounds(10, 10, 85, 55);
		panel_2.add(createBtn);

		JButton editBtn = new JButton("Edit");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editSelectedRow();

			}
		});
		editBtn.setBounds(110, 10, 85, 55);
		panel_2.add(editBtn);

		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSelectedRow();
			}
		});
		deleteBtn.setBounds(205, 10, 85, 55);
		panel_2.add(deleteBtn);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homescreen = new HomeScreen();
				homescreen.setVisible(true);
				
				dispose();
			}
		});
		home.setBounds(641, 10, 85, 55);
		panel_2.add(home);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Resource" }));
		comboBox.setBounds(320, 10, 154, 55);
		panel_2.add(comboBox);

		populateResourceComboBox();

		JButton addRes = new JButton("Assign Resource");
		addRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignResource();
			}

		});
		addRes.setBounds(484, 10, 120, 55);
		panel_2.add(addRes);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(Color.CYAN));
		panel_2_1.setBounds(10, 10, 1038, 75);
		contentPane.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Incident Page");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 1018, 55);
		panel_2_1.add(lblNewLabel_1);
	}

	private void setupTableSelectionListener() {
		table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				// Get the data from the selected row and populate the text fields and combo box
				String incidentNoValue = table.getValueAt(selectedRow, 0).toString();
				String reporterNoValue = table.getValueAt(selectedRow, 1).toString();
				String dateValue = table.getValueAt(selectedRow, 2).toString();
				String timeValue = table.getValueAt(selectedRow, 3).toString();
				String words = table.getValueAt(selectedRow, 4).toString();
				String ongoingValue = table.getValueAt(selectedRow, 5).toString();
				String incidentDetValue = table.getValueAt(selectedRow, 6).toString();

				// Populate the text fields and combo box with the selected incident data
				incidentNo.setText(incidentNoValue);
				reporterNo.setText(reporterNoValue);
				date.setText(dateValue);
				time.setText(timeValue);
				gps3.setText(words);
				ongoing.setSelectedItem(ongoingValue);
				incidentDet.setText(incidentDetValue);
			}
		});
	}

	private void addNewIncident() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		String incidentNum = incidentNo.getText();
		String reporterNum = reporterNo.getText();
		String incidentDate = date.getText();
		String incidentTime = time.getText();
		String gpsWords = gps3.getText();
		String ongoingStatus = (String) ongoing.getSelectedItem();
		String incidentDetails = incidentDet.getText();

		if (incidentNum.isEmpty() || reporterNum.isEmpty() || incidentDate.isEmpty() || incidentTime.isEmpty()
				|| gpsWords.isEmpty() || ongoingStatus.isEmpty() || incidentDetails.isEmpty()) {
			// Ensure that all fields are filled before adding the new incident
			// You can show an error message or perform appropriate actions here
			System.out.println("Please fill in all fields.");
			return;
		}

		// Create a new Incident object with the entered data
		Incident newIncident = new Incident(Integer.parseInt(incidentNum), Integer.parseInt(reporterNum), incidentDate,
				incidentTime, gpsWords, incidentDetails, ongoingStatus);

		// Add the new incident data to the table
		Object[] rowData = { newIncident.getIncidentNo(), newIncident.getReporterNo(), newIncident.getDate(),
				newIncident.getTime(), newIncident.getWords(), newIncident.getOngoing(), newIncident.getIncidentDet() };
		model.addRow(rowData);

		// Save the new incident to the text file
		try {
			writeCsv("src/mountain/incident.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clear the text fields and combo box after adding the new incident
		incidentNo.setText("");
		reporterNo.setText("");
		date.setText("");
		time.setText("");
		gps3.setText("");
		ongoing.setSelectedIndex(0);
		incidentDet.setText("");
	}

	private void editSelectedRow() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String incidentNum = incidentNo.getText();
			String reporterNum = reporterNo.getText();
			String incidentDate = date.getText();
			String incidentTime = time.getText();
			String gpsWords = gps3.getText();
			String ongoingStatus = (String) ongoing.getSelectedItem();
			String incidentDetails = incidentDet.getText();

			if (incidentNum.isEmpty() || reporterNum.isEmpty() || incidentDate.isEmpty() || incidentTime.isEmpty()
					|| gpsWords.isEmpty() || ongoingStatus.isEmpty() || incidentDetails.isEmpty()) {
				// Ensure that all fields are filled before updating the incident
				// You can show an error message or perform appropriate actions here
				System.out.println("Please fill in all fields.");
				return;
			}

			// Create a new Incident object with the updated data
			Incident updatedIncident = new Incident(Integer.parseInt(incidentNum), Integer.parseInt(reporterNum),
					incidentDate, incidentTime, gpsWords, incidentDetails, ongoingStatus);

			// Update the table row with the updated incident data
			model.setValueAt(updatedIncident.getIncidentNo(), selectedRow, 0);
			model.setValueAt(updatedIncident.getReporterNo(), selectedRow, 1);
			model.setValueAt(updatedIncident.getDate(), selectedRow, 2);
			model.setValueAt(updatedIncident.getTime(), selectedRow, 3);
			model.setValueAt(updatedIncident.getWords(), selectedRow, 4);
			model.setValueAt(updatedIncident.getOngoing(), selectedRow, 5);
			model.setValueAt(updatedIncident.getIncidentDet(), selectedRow, 6);

			try {
				writeCsv("src/mountain/incident.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Clear the text fields and combo box after updating the incident
			incidentNo.setText("");
			reporterNo.setText("");
			date.setText("");
			time.setText("");
			gps3.setText("");
			ongoing.setSelectedIndex(0);
			incidentDet.setText("");
		} else {
			// Show an error message or perform any desired action if no row is selected
			System.out.println("Please select a row to edit.");
		}
	}

	private void deleteSelectedRow() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();

		if (selectedRow != -1) {
			// Remove the selected row from the table
			model.removeRow(selectedRow);
		} else {
			// Show an error message or perform any desired action if no row is selected
			System.out.println("Please select a row to delete.");
		}
		try {
			writeCsv("src/mountain/incident.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void populateTableFromFile() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		try {
			// Replace "src/mountain/incident.txt" with the actual path to your text file
			HashMap<String, Incident> incidentMap = IncidentFileReader.readTXT("src/mountain/incident.txt");

			// Add data from the Incident map to the table
			for (Incident incident : incidentMap.values()) {
				Object[] rowData = { incident.getIncidentNo(), incident.getReporterNo(), incident.getDate(),
						incident.getTime(), incident.getWords(), incident.getOngoing(), incident.getIncidentDet() };
				model.addRow(rowData);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void populateResourceComboBox() {
		// TODO Auto-generated method stub
		try {
			// Replace "src/mountain/resource.txt" with the actual path to your resource
			// text file
			HashMap<String, Resource> resourceMap = ResourceFileReader.readTXT("src/mountain/resource.txt");

			// Add resource descriptions to the "Assign Resource" comboBox
			DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
			comboBoxModel.addElement(""); // Add an empty option
			for (Resource resource : resourceMap.values()) {
				comboBoxModel.addElement(resource.getResourceDesc());
			}

			// Set the model for the "Assign Resource" comboBox
			comboBox.setModel(comboBoxModel);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void assignResource() {
		// TODO Auto-generated method stub
//    HashMap<String, Reporter> reportersMap;

		// Populate the reporter map with reporter numbers and names
//    reporterMap.putAll(reportersMap);

		String selectedResource = (String) comboBox.getSelectedItem();
		if (selectedResource.equals("") || table.getSelectedRow() == -1) {
			// Show an error message or perform any desired action if no resource or
			// incident is selected
			System.out.println("Please select a resource and an incident.");
			return;
		}

		// Get the incident data from the selected row
		String incidentNum = table.getValueAt(table.getSelectedRow(), 0).toString();
		String reporterNum = table.getValueAt(table.getSelectedRow(), 1).toString();
		String dateValue = table.getValueAt(table.getSelectedRow(), 2).toString();
		String timeValue = table.getValueAt(table.getSelectedRow(), 3).toString();
		String gpsWords = table.getValueAt(table.getSelectedRow(), 4).toString();
		String incidentDetails = table.getValueAt(table.getSelectedRow(), 6).toString();
		String ongoingStatus = table.getValueAt(table.getSelectedRow(), 5).toString();
		String reporterName = "";

		HashMap<String, Reporter> reporterMap = new HashMap<>();

		try {
			reporterMap = ReporterFileReader.readTXT("src/mountain/reporter.txt");
			reporterName = reporterMap.get(reporterNum).getName();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		String data = incidentNum + "," + reporterName + "," + dateValue + "," + timeValue + "," + gpsWords + ","
				+ incidentDetails + "," + selectedResource + "," + ongoingStatus+"\n";

		FileWriter writer;
		try {
			writer = new FileWriter("src/mountain/recordings.txt",true);
			writer.write(data);
			writer.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getAllTableDataAsString() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		StringBuilder dataAsString = new StringBuilder();

		int rowCount = model.getRowCount();
		int columnCount = model.getColumnCount();

		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				Object cellData = model.getValueAt(row, column);
				dataAsString.append(cellData);

				// Add a comma after the cell value, except for the last column
				if (column < columnCount - 1) {
					dataAsString.append(", ");
				}
			}

			// Add a newline after each row, except for the last row
			if (row < rowCount - 1) {
				dataAsString.append("\n");
			}
		}

		return dataAsString.toString();
	}

	public void writeCsv(String file) throws IOException {

		FileWriter writer = new FileWriter(file);
		writer.write(getAllTableDataAsString());
		writer.close();

	}
}
