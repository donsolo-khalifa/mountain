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

public class HomeScreen extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1072, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.CYAN, 2));
		panel_1.setBounds(10, 122, 1038, 595);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Reporter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporterWindow reporterWindow = new ReporterWindow();
                reporterWindow.setVisible(true);

                // Close the HomeScreen
                dispose();
			}
		});
		btnNewButton.setBounds(10, 233, 200, 142);
		panel_1.add(btnNewButton);
		
		JButton btnIncident = new JButton("Incident");
		btnIncident.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncidentWindow incidentWindow = new IncidentWindow();
                incidentWindow.setVisible(true);
                dispose();

			}
		});
		btnIncident.setBounds(417, 233, 200, 142);
		panel_1.add(btnIncident);
		
		JButton btnResource = new JButton("Resource");
		btnResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResourceWindow resourceWindow = new ResourceWindow();
                resourceWindow.setVisible(true);
                dispose();

			}
		});
		btnResource.setBounds(814, 233, 200, 142);
		panel_1.add(btnResource);
		
		JButton btnRecords = new JButton("Records");
		btnRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recordings recordings = new Recordings();
				recordings.setVisible(true);
				dispose();
			}
		});
		btnRecords.setBounds(417, 414, 200, 142);
		panel_1.add(btnRecords);


		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(Color.CYAN));
		panel_2_1.setBounds(10, 10, 1038, 75);
		contentPane.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Home");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 1018, 55);
		panel_2_1.add(lblNewLabel_1);
	}


	


	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
