package jgroth2740ex3f;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField positionTextField;
	private JList employeeList;
	private JComboBox deptComboBox;
	private DefaultListModel employeeListModel;
	private JButton noArgConstructerButton;
	private JButton twoArgConstructorButton;
	private JButton fourArgConstructorButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setTitle("JGroth Exercise 3F: Overload Constructors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 439, 195);
		contentPane.add(scrollPane);
		
		employeeListModel = new DefaultListModel();
		employeeList = new JList(employeeListModel);
		employeeList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(10, 241, 95, 22);
		contentPane.add(lblEmployeeId);
		
		empIdTextField = new JTextField();
		lblEmployeeId.setLabelFor(empIdTextField);
		empIdTextField.setText("101");
		empIdTextField.setBounds(129, 242, 86, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(10, 274, 106, 22);
		contentPane.add(lblEmployeeName);
		
		empNameTextField = new JTextField();
		lblEmployeeName.setLabelFor(empNameTextField);
		empNameTextField.setText("Jon Groth");
		empNameTextField.setBounds(129, 275, 121, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(10, 307, 86, 22);
		contentPane.add(lblDepartment);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Manufacturing", "Shipping", "Maintenance"}));
		lblDepartment.setLabelFor(deptComboBox);
		deptComboBox.setBounds(128, 308, 152, 20);
		contentPane.add(deptComboBox);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 342, 86, 22);
		contentPane.add(lblPosition);
		
		positionTextField = new JTextField();
		lblPosition.setLabelFor(positionTextField);
		positionTextField.setText("Software Engineer");
		positionTextField.setBounds(128, 343, 130, 20);
		contentPane.add(positionTextField);
		positionTextField.setColumns(10);
		
		noArgConstructerButton = new JButton("No Arg");
		noArgConstructerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgConstructerButton_actionPerformed(arg0);
			}
		});
		noArgConstructerButton.setBounds(49, 380, 89, 23);
		contentPane.add(noArgConstructerButton);
		
		twoArgConstructorButton = new JButton("2 Arg");
		twoArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgConstructorButton_actionPerformed(e);
			}
		});
		twoArgConstructorButton.setBounds(157, 380, 89, 23);
		contentPane.add(twoArgConstructorButton);
		
		fourArgConstructorButton = new JButton("4 Arg");
		fourArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgConstructorButton_actionPerformed(e);
			}
		});
		fourArgConstructorButton.setBounds(268, 380, 89, 23);
		contentPane.add(fourArgConstructorButton);
	}
	protected void do_noArgConstructerButton_actionPerformed(ActionEvent arg0) {
		Employee emp = new Employee();
		Employee employee = (Employee) employeeList.getSelectedValue();
		employeeListModel.addElement(emp);
	}
	protected void do_twoArgConstructorButton_actionPerformed(ActionEvent e) {
		int id = Integer.parseInt(empIdTextField.getText());
		Employee emp = new Employee (id, empNameTextField.getText());
		Employee employee = (Employee) employeeList.getSelectedValue();
		employeeListModel.addElement(emp);
	}
	protected void do_fourArgConstructorButton_actionPerformed(ActionEvent e) {
		int id = Integer.parseInt(empIdTextField.getText());
		String dept = (String) deptComboBox.getSelectedItem();
		Employee emp = new Employee (id, dept, empNameTextField.getText(),positionTextField.getText());
		Employee employee = (Employee) employeeList.getSelectedValue();
		employeeListModel.addElement(emp);
	}
}
