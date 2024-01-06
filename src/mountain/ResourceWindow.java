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

public class ResourceWindow extends JFrame {

	private JPanel contentPane;
	private JTextField resourceNo;
	private JTextField resourceCode;
	private JTextField units;
	private JTable table;
	private JTextArea resourceDes;


	public ResourceWindow() {
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

		JLabel lblResourceNo = new JLabel("Resource No");
		lblResourceNo.setBounds(10, 10, 83, 41);
		panel.add(lblResourceNo);

		JLabel lblResourceCode = new JLabel("Resource Code");
		lblResourceCode.setBounds(10, 60, 83, 41);
		panel.add(lblResourceCode);

		JLabel lblDate = new JLabel("Units");
		lblDate.setBounds(10, 111, 83, 41);
		panel.add(lblDate);

		JLabel lblDescription = new JLabel("Details");
		lblDescription.setBounds(10, 162, 83, 41);
		panel.add(lblDescription);

		resourceNo = new JTextField();
		resourceNo.setBounds(128, 21, 154, 19);
		panel.add(resourceNo);
		resourceNo.setColumns(10);

		resourceCode = new JTextField();
		resourceCode.setColumns(10);
		resourceCode.setBounds(128, 71, 154, 19);
		panel.add(resourceCode);

		units = new JTextField();
		units.setColumns(10);
		units.setBounds(128, 122, 154, 19);
		panel.add(units);

		resourceDes = new JTextArea(); // Initialize the resourceDes JTextArea
		resourceDes.setBounds(128, 170, 154, 415);
		panel.add(resourceDes);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.CYAN, 2));
		panel_1.setBounds(312, 122, 736, 510);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 716, 490);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { "", null, null, null }, },
				new String[] { "ResourceNo", "Resource Code", "Units", "Description" }));

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
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resourceNo.setText("");
				resourceCode.setText("");
				units.setText("");
				resourceDes.setText("");
				
			}
		});
		btnReset.setBounds(326, 10, 85, 55);
		panel_2.add(btnReset);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(Color.CYAN));
		panel_2_1.setBounds(10, 10, 1038, 75);
		contentPane.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Resource Page");
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
				String resourceNoValue = table.getValueAt(selectedRow, 0).toString();
				String resourceCodeValue = table.getValueAt(selectedRow, 1).toString();
				String unitsValue = table.getValueAt(selectedRow, 2).toString();
				String descriptionValue = table.getValueAt(selectedRow, 3).toString();

				resourceNo.setText(resourceNoValue);
				units.setText(unitsValue);
				resourceCode.setText(resourceCodeValue);
				resourceDes.setText(descriptionValue);
			}
		});
	}

	private void editSelectedRow() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();

		if (selectedRow != -1) {
			// Retrieve data from the text fields
			String resourceNoValue = resourceNo.getText();
			String resourceCodeValue = resourceCode.getText();
			String unitsValue = units.getText();
			String descriptionValue = resourceDes.getText();

			// Update the data in the selected row
			model.setValueAt(resourceNoValue, selectedRow, 0);
			model.setValueAt(resourceCodeValue, selectedRow, 1);
			model.setValueAt(unitsValue, selectedRow, 2);
			model.setValueAt(descriptionValue, selectedRow, 3);

			// Clear the text fields after editing data
			resourceNo.setText("");
			resourceCode.setText("");
			units.setText("");
			resourceDes.setText("");
		} else {
			// Show an error message or perform any desired action if no row is selected
			System.out.println("Please select a row to edit.");
		}

		try {
			writeCsv("src/mountain/resource.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addDataToTable() {
		// Retrieve data from the text fields
		String resourceNoValue = resourceNo.getText();
		String resourceCodeValue = resourceCode.getText();
		String unitsValue = units.getText();
		String descriptionValue = resourceDes.getText();

		// Create an array to hold the data
		Object[] rowData = { resourceNoValue, resourceCodeValue, unitsValue, descriptionValue };

		// Get the table model
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// Add the data to the table
		model.addRow(rowData);

		// Clear the text fields after adding data
		resourceNo.setText("");
		resourceCode.setText("");
		units.setText("");
		resourceDes.setText("");

		try {
			writeCsv("src/mountain/resource.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			writeCsv("src/mountain/resource.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void populateTableFromFile() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// Remove all existing rows from the table
		model.setRowCount(0);

		try {
			// Replace "src/mountain/resource.txt" with the actual path to your text file
			HashMap<String,Resource> resourceMap = ResourceFileReader.readTXT("src/mountain/resource.txt");

			// Add data from the Resource map to the table
			for (Resource resource : resourceMap.values()) {
				Object[] rowData = { resource.getResourceNo(), resource.getResourceCode(), resource.getNumOfUnits(),
						resource.getResourceDesc() };
				model.addRow(rowData);
			}

		} catch (IOException e) {
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
