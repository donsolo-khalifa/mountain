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
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class ReporterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField reporterNo;
	private JTextField date;
	private JTextField time;
	private JTextField phoneNo;
	private JTable table;
	private JTextField address;
	private JTextField postCode;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ReporterWindow() {
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

		JLabel lblNewLabel = new JLabel("Name");
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

		JLabel lblGpswords = new JLabel("Phone Number");
		lblGpswords.setBounds(10, 216, 83, 41);
		panel.add(lblGpswords);

		name = new JTextField();
		name.setBounds(128, 21, 154, 19);
		panel.add(name);
		name.setColumns(10);

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

		phoneNo = new JTextField();
		phoneNo.setColumns(10);
		phoneNo.setBounds(128, 227, 154, 19);
		panel.add(phoneNo);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 267, 83, 41);
		panel.add(lblAddress);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(128, 278, 154, 19);
		panel.add(address);

		JLabel lblPostCode = new JLabel("Post Code");
		lblPostCode.setBounds(10, 315, 83, 41);
		panel.add(lblPostCode);

		postCode = new JTextField();
		postCode.setColumns(10);
		postCode.setBounds(128, 326, 154, 19);
		panel.add(postCode);

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
				new String[] { "Name", "Reporter No", "Date", "Time", "Phone No", "Address", "Post Code" }));

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
				addDataToTable();

			}
		});
		createBtn.setBounds(10, 10, 85, 55);
		panel_2.add(createBtn);

		JButton editBtn = new JButton("Edit");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editReporter();
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
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reporterNo.setText("");
				name.setText("");
				date.setText("");
				time.setText("");
				phoneNo.setText("");
				address.setText("");
				postCode.setText("");
			}
		});
		btnReset.setBounds(324, 10, 85, 55);
		panel_2.add(btnReset);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(Color.CYAN));
		panel_2_1.setBounds(10, 10, 1038, 75);
		contentPane.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Reporter Page");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 1018, 55);
		panel_2_1.add(lblNewLabel_1);
	}

	private void setupTableSelectionListener() {
		table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				// Get the data from the selected row and populate the text fields
				String reporterNoValue = table.getValueAt(selectedRow, 1).toString();
				String nameValue = table.getValueAt(selectedRow, 0).toString();
				String dateValue = table.getValueAt(selectedRow, 2).toString();
				String timeValue = table.getValueAt(selectedRow, 3).toString();
				String phoneNoValue = table.getValueAt(selectedRow, 4).toString();
				String addressValue = table.getValueAt(selectedRow, 5).toString();
				String postCodeValue = table.getValueAt(selectedRow, 6).toString();

				reporterNo.setText(reporterNoValue);
				name.setText(nameValue);
				date.setText(dateValue);
				time.setText(timeValue);
				phoneNo.setText(phoneNoValue);
				address.setText(addressValue);
				postCode.setText(postCodeValue);
			}
		});
	}

	private void populateTableFromFile() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// Remove all existing rows from the table
		model.setRowCount(0);

		try {
			// Replace "src/mountain/reporter.txt" with the actual path to your text file
			HashMap<String, Reporter> reporterMap = ReporterFileReader.readTXT("src/mountain/reporter.txt");

			// Add data from the reporter map to the table
			for (Reporter reporter : reporterMap.values()) {
				Object[] rowData = { reporter.getName(), reporter.getReportNo(), reporter.getDate(), reporter.getTime(),
						reporter.getTelNo(), reporter.getAdrress(), reporter.getPostCode() };
				model.addRow(rowData);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addDataToTable() {
		// Retrieve data from the text fields
		String reporterNoValue = reporterNo.getText();
		String nameValue = name.getText();
		String dateValue = date.getText();
		String timeValue = time.getText();
		String phoneNoValue = phoneNo.getText();
		String addressValue = address.getText();
		String postCodeValue = postCode.getText();

		// Validate if all fields are filled
		if (reporterNoValue.isEmpty() || nameValue.isEmpty() || dateValue.isEmpty() || timeValue.isEmpty()
				|| phoneNoValue.isEmpty() || addressValue.isEmpty() || postCodeValue.isEmpty()) {
			System.out.println("Please fill in all fields.");
			return;
		}

		int reporterNoInt = Integer.parseInt(reporterNoValue);
		int phoneNoInt = Integer.parseInt(phoneNoValue);

		// Create a new Reporter object with the entered data
		Reporter newReporter = new Reporter(nameValue, dateValue, timeValue, addressValue, postCodeValue, reporterNoInt,
				phoneNoInt);

		// Add the new reporter data to the table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] rowData = { newReporter.getName(), newReporter.getReportNo(), newReporter.getDate(),
				newReporter.getTime(), newReporter.getTelNo(), newReporter.getAdrress(), newReporter.getPostCode() };
		model.addRow(rowData);

		try {
			writeCsv("src/mountain/reporter.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clear the text fields after adding the new reporter
		reporterNo.setText("");
		name.setText("");
		date.setText("");
		time.setText("");
		phoneNo.setText("");
		address.setText("");
		postCode.setText("");
	}

	private void editReporter() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			String reporterNoValue = reporterNo.getText();
			String nameValue = name.getText();
			String dateValue = date.getText();
			String timeValue = time.getText();
			String phoneNoValue = phoneNo.getText();
			String addressValue = address.getText();
			String postCodeValue = postCode.getText();

			// Validate if all fields are filled
			if (reporterNoValue.isEmpty() || nameValue.isEmpty() || dateValue.isEmpty() || timeValue.isEmpty()
					|| phoneNoValue.isEmpty() || addressValue.isEmpty() || postCodeValue.isEmpty()) {
				System.out.println("Please fill in all fields.");
				return;
			}

			Reporter reporter = new Reporter(nameValue, dateValue, timeValue, addressValue, postCodeValue,
					Integer.parseInt(reporterNoValue), Integer.parseInt(phoneNoValue));

			// Update the reporter object with the new data
			reporter.setName(nameValue);
			reporter.setDate(dateValue);
			reporter.setTime(timeValue);
			reporter.setTelNo(Integer.parseInt(phoneNoValue));
			reporter.setAdrress(addressValue);
			reporter.setPostCode(postCodeValue);

			// Update the data in the selected row of the table
			model.setValueAt(reporter.getName(), selectedRow, 0);
			model.setValueAt(reporter.getReportNo(), selectedRow, 1);
			model.setValueAt(reporter.getDate(), selectedRow, 2);
			model.setValueAt(reporter.getTime(), selectedRow, 3);
			model.setValueAt(reporter.getTelNo(), selectedRow, 4);
			model.setValueAt(reporter.getAdrress(), selectedRow, 5);
			model.setValueAt(reporter.getPostCode(), selectedRow, 6);

			// Save the updated reporterMap to the text file
			try {
				writeCsv("src/mountain/reporter.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Clear the text fields after editing the reporter
			reporterNo.setText("");
			name.setText("");
			date.setText("");
			time.setText("");
			phoneNo.setText("");
			address.setText("");
			postCode.setText("");
		} else {
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
			writeCsv("src/mountain/reporter.txt");
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
