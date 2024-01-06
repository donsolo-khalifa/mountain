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
import java.awt.print.PrinterException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

public class Recordings extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public Recordings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1072, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.CYAN, 2));
		panel_1.setBounds(10, 122, 1038, 510);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1018, 490);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null, null, null},
			},
			new String[] {
				"IncidentNo", "Reported By", "Date", "Time", "Location", "Type", "Resource", "Ongoing"
			}
		));

		populateTableFromFile();
//		setupTableSelectionListener();

		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.CYAN));
		panel_2.setBounds(312, 642, 736, 75);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton prin = new JButton("Print");
		prin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		prin.setBounds(10, 10, 85, 55);
		panel_2.add(prin);

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

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(Color.CYAN));
		panel_2_1.setBounds(10, 10, 1038, 75);
		contentPane.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Records");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 1018, 55);
		panel_2_1.add(lblNewLabel_1);
	}

//	private void setupTableSelectionListener() {
//		table.getSelectionModel().addListSelectionListener(e -> {
//			int selectedRow = table.getSelectedRow();
//			if (selectedRow != -1) {
//				// Get the data from the selected row and populate the text fields
//				String resourceNoValue = table.getValueAt(selectedRow, 0).toString();
//				String resourceCodeValue = table.getValueAt(selectedRow, 1).toString();
//				String unitsValue = table.getValueAt(selectedRow, 2).toString();
//				String descriptionValue = table.getValueAt(selectedRow, 3).toString();
//
//				resourceNo.setText(resourceNoValue);
//				units.setText(unitsValue);
//				resourceCode.setText(resourceCodeValue);
//				resourceDes.setText(descriptionValue);
//			}
//		});
//	}

//	private void addDataToTable() {
//		// Retrieve data from the text fields
//		String resourceNoValue = resourceNo.getText();
//		String resourceCodeValue = resourceCode.getText();
//		String unitsValue = units.getText();
//		String descriptionValue = resourceDes.getText();
//
//		// Create an array to hold the data
//		Object[] rowData = { resourceNoValue, resourceCodeValue, unitsValue, descriptionValue };
//
//		// Get the table model
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//
//		// Add the data to the table
//		model.addRow(rowData);
//
//		// Clear the text fields after adding data
//		resourceNo.setText("");
//		resourceCode.setText("");
//		units.setText("");
//		resourceDes.setText("");
//
//		try {
//			writeCsv("src/mountain/resource.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	private void populateTableFromFile() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    // Remove all existing rows from the table
	    model.setRowCount(0);

	    try {
	        // Replace "src/mountain/recording.txt" with the actual path to your text file
	        List<String> lines = FileUtil.readLines("src/mountain/recordings.txt");

	        // Add data from the text file to the table
	        for (String line : lines) {
	            String[] rowData = line.split(",");
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

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
