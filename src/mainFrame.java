/*
 * PART 3 COMMENTS:
 * Now that the Database has been integrated, no changes have occurred in the mainFrame except for the addition of extra functions as stated from part 1.
 * Minimal changes in the client were achieved thanks to the MVC design pattern used.
 * 
 * PART 2:
 * Some changes were made to the view to redirect the data to the client connection rather than sending it to the controller class.
 * By doing so data can pass to the server through the client Connection, all connections to the controller from the view must be routed back through the server.
 * Instead of calling the controller, a new object called funcController was called instead.
 * The mainframe's (the view) constructor would now take in an argument of the connection,  
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatter;
import javax.swing.DefaultComboBoxModel;
/*
 * The View - GUI Class
 */

public class mainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField modifyFirstName;
	private JTextField modifyLastName;
	private JTextField modifyInitial;
	private JTextField modifyCity;
	private JTextField modifyState;
	private JTextField modifyMajor;
	private JTextField modifyYear;
	private JTextField modifyCredit;
	private JTextField modifyStudentID;
	private JTable searchTable;
	private JFormattedTextField firstNameSearch;
	private JFormattedTextField studentIDSearch;
	private JFormattedTextField majorSearch;
	private JFormattedTextField lastNameSearch;
	private JTextField gpaFirstRange;
	private JTextField gpaSecondRange;
	private JTextField modifyGender;
	private JTextField modifyCGPA;
	//private mainController controller = new mainController();
	private clientConnection funcController;
	private JTextField CGPAAverage;
	private JTable modifyTable;
	private JTextField studentIDSearchTranscript;
	private JTextField modifyPhoneNumber;
	private JFormattedTextField searchYear;
	private JTable courseTable;
	private JTextField tcourse3;
	private JTextField tcourse2;
	private JTextField credit3;
	private JTextField credit2;
	private JTextField modifySearch;
	private JTextField credit4;
	private JTextField credit1;
	private JTextField tcourse1;
	private JTextField tcourse4;
	private JTextField tcourse5;
	private JTextField credit5;
	private JComboBox tgrade4;
	private JComboBox tgrade5;
	private JComboBox tgrade3;
	private JComboBox tgrade2;
	private JComboBox tgrade1;
	private JComboBox courseSelect;
	private Integer OldStudentID;
	private String[] returnedItems;
	GridLayout modifyWindowLayout = new GridLayout(0,2);
	DefaultFormatter format = new DefaultFormatter();
	/**
	 * @wbp.nonvisual location=-48,89
	 */
	public String getLast() {
		return lastNameSearch.getText();
	}
	public String getID() {
		return studentIDSearch.getText();
	}
	public String getMajor() {
		return majorSearch.getText();
	}
	public mainFrame(clientConnection connection) {
		format.setCommitsOnValidEdit(true);
		funcController =  connection;
		final String labels[] = {"All Genders","M", "F"};
		final JComboBox gender = new JComboBox(labels);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Management System");
		setBounds(100, 100, 696, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{825, 0};
		gbl_contentPane.rowHeights = new int[]{432, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		JPanel displayTab = new JPanel();
		tabbedPane.addTab("Home", null, displayTab, null);
		GridBagLayout gbl_displayTab = new GridBagLayout();
		gbl_displayTab.columnWidths = new int[]{90, 0, 77, 75, 0, 0, 0};
		gbl_displayTab.rowHeights = new int[]{0, 0, 33, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_displayTab.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_displayTab.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		displayTab.setLayout(gbl_displayTab);
		
		JLabel lblNewLabel = new JLabel("First Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		displayTab.add(lblNewLabel, gbc_lblNewLabel);
		
		firstNameSearch = new JFormattedTextField(format);
		firstNameSearch.setColumns(10);
		GridBagConstraints gbc_firstNameSearch = new GridBagConstraints();
		gbc_firstNameSearch.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameSearch.gridx = 1;
		gbc_firstNameSearch.gridy = 0;
		displayTab.add(firstNameSearch, gbc_firstNameSearch);
		firstNameSearch.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = (String) gender.getSelectedItem();
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
			}
			
		});
		
		JLabel lblMajor = new JLabel("Major");
		GridBagConstraints gbc_lblMajor = new GridBagConstraints();
		gbc_lblMajor.anchor = GridBagConstraints.EAST;
		gbc_lblMajor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMajor.gridx = 3;
		gbc_lblMajor.gridy = 0;
		displayTab.add(lblMajor, gbc_lblMajor);
		
		majorSearch = new JFormattedTextField(format);
		majorSearch.setColumns(10);
		GridBagConstraints gbc_majorSearch = new GridBagConstraints();
		gbc_majorSearch.insets = new Insets(0, 0, 5, 5);
		gbc_majorSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_majorSearch.gridx = 4;
		gbc_majorSearch.gridy = 0;
		displayTab.add(majorSearch, gbc_majorSearch);
		majorSearch.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = (String) gender.getSelectedItem();
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
			}
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		displayTab.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lastNameSearch = new JFormattedTextField(format);
		lastNameSearch.setColumns(10);
		GridBagConstraints gbc_lastNameSearch = new GridBagConstraints();
		gbc_lastNameSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameSearch.gridx = 1;
		gbc_lastNameSearch.gridy = 1;
		displayTab.add(lastNameSearch, gbc_lastNameSearch);
		lastNameSearch.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = (String) gender.getSelectedItem();
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
			}
			
		});
		
		JLabel lblStudentId = new JLabel("Student ID");
		GridBagConstraints gbc_lblStudentId = new GridBagConstraints();
		gbc_lblStudentId.anchor = GridBagConstraints.EAST;
		gbc_lblStudentId.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentId.gridx = 3;
		gbc_lblStudentId.gridy = 1;
		displayTab.add(lblStudentId, gbc_lblStudentId);
		
		studentIDSearch = new JFormattedTextField(format);
		studentIDSearch.setColumns(10);
		GridBagConstraints gbc_studentIDSearch = new GridBagConstraints();
		gbc_studentIDSearch.insets = new Insets(0, 0, 5, 5);
		gbc_studentIDSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_studentIDSearch.gridx = 4;
		gbc_studentIDSearch.gridy = 1;
		displayTab.add(studentIDSearch, gbc_studentIDSearch);
		studentIDSearch.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = (String) gender.getSelectedItem();
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
			}
			
		});
		
		JLabel lblCredit = new JLabel("Gender");
		GridBagConstraints gbc_lblCredit = new GridBagConstraints();
		gbc_lblCredit.anchor = GridBagConstraints.EAST;
		gbc_lblCredit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredit.gridx = 0;
		gbc_lblCredit.gridy = 2;
		displayTab.add(lblCredit, gbc_lblCredit);
		/*
		 * Gender combo box
		 * Under display tab
		 */
		gender.setEditable(false);
		final JRadioButton male = new JRadioButton("Male");
		final JRadioButton female = new JRadioButton("Female");
		JRadioButton all = new JRadioButton("All");
		final ButtonGroup bG = new ButtonGroup();
	     bG.add(male);
	     bG.add(female);
	     bG.add(all);
		male.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = "M";
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
		    }
		});
	     female.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e) {
	    	    	System.out.println("called");
		        	//reading in all the inputs to be sent to the method in the controller
					Integer studentID = null;
					//using a try block to catch the number exception to avoid errors when reading input
					try{studentID = Integer.parseInt(studentIDSearch.getText());}
					catch(NumberFormatException e1){
					}
					String firstName = firstNameSearch.getText();
					String lastName = lastNameSearch.getText();
					String Gender = "F";
					String Major = majorSearch.getText();
					Integer Year = null;
					try{Year = Integer.parseInt(searchYear.getText());}
					catch(NumberFormatException e1){
					}
					Double GPAF = null; //null incase nothing is entered because its a range and its a double
					try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
					catch(NumberFormatException e1){
					}
					Double GPAS = null;
					try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
					catch(NumberFormatException e1){
					}
					//end of reading in all the inputs
					//calling the student search function from the new controller controller
					try {
						mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
						CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
						//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
						searchTable.setModel(updatedModel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					    e1.printStackTrace();
					}
	    	    }
	    	});
	     all.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e) {
	    	    	System.out.println("called");
		        	//reading in all the inputs to be sent to the method in the controller
					Integer studentID = null;
					//using a try block to catch the number exception to avoid errors when reading input
					try{studentID = Integer.parseInt(studentIDSearch.getText());}
					catch(NumberFormatException e1){
					}
					String firstName = firstNameSearch.getText();
					String lastName = lastNameSearch.getText();
					String Gender = null;
					String Major = majorSearch.getText();
					Integer Year = null;
					try{Year = Integer.parseInt(searchYear.getText());}
					catch(NumberFormatException e1){
					}
					Double GPAF = null; //null incase nothing is entered because its a range and its a double
					try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
					catch(NumberFormatException e1){
					}
					Double GPAS = null;
					try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
					catch(NumberFormatException e1){
					}
					//end of reading in all the inputs
					//calling the student search function from the new controller controller
					try {
						mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
						CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
						//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
						searchTable.setModel(updatedModel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					    e1.printStackTrace();
					}
	    	    }
	    	});
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.insets = new Insets(0, 0, 5, 5);
		gbc_gender.fill = GridBagConstraints.EAST;
		gbc_gender.gridx = 1;
		gbc_gender.gridy = 2;
		displayTab.add(male, gbc_gender);
		GridBagConstraints gbc_gender1 = new GridBagConstraints();
		gbc_gender1.insets = new Insets(0, 0, 5, 5);
		gbc_gender1.fill = GridBagConstraints.HORIZONTAL;
		gbc_gender1.gridx = 1;
		gbc_gender1.gridy = 2;
		displayTab.add(female, gbc_gender1);
		//GridBagConstraints gbc_gender2 = new GridBagConstraints();
		//gbc_gender2.insets = new Insets(0, 0, 0, 0);
		//gbc_gender2.fill = GridBagConstraints.EAST;
		//gbc_gender2.gridx = 2;
		//gbc_gender2.gridy = 2;
		//displayTab.add(all, gbc_gender2);
		/*
		 * Adding year label
		 * Under search tab
		 */
		JLabel lblYear = new JLabel("Year");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.anchor = GridBagConstraints.EAST;
		gbc_lblYear.gridx = 3;
		gbc_lblYear.gridy = 2;
		displayTab.add(lblYear, gbc_lblYear);
		/*
		 * Adding Search Year text Field
		 * Under search tab
		 */
		searchYear = new JFormattedTextField(format);
		searchYear.setColumns(10);
		GridBagConstraints gbc_searchYear = new GridBagConstraints();
		gbc_searchYear.insets = new Insets(0, 0, 5, 5);
		gbc_searchYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchYear.gridx = 4;
		gbc_searchYear.gridy = 2;
		displayTab.add(searchYear, gbc_searchYear);
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 6;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 3;
		displayTab.add(separator_1, gbc_separator_1);
		searchYear.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = (String) gender.getSelectedItem();
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
			}
			
		});
		/*
		 * CGPA range label
		 * Under display tab
		 */
		JLabel lblCity = new JLabel("CGPA Range");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.WEST;
		gbc_lblCity.gridwidth = 2;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 4;
		displayTab.add(lblCity, gbc_lblCity);
		/*
		 * From label referring to CGPA range
		 * Under display tab
		 */
		JLabel lblState = new JLabel("From");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.EAST;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 5;
		displayTab.add(lblState, gbc_lblState);
		/*
		 * First CGPA range text field
		 * Under display tab
		 */
		gpaFirstRange = new JFormattedTextField(format);
		gpaFirstRange.setColumns(10);
		//gpaFirstRange.setBounds(0, 5, 3, 3);
		GridBagConstraints gbc_gpaFirstRange = new GridBagConstraints();
		gbc_gpaFirstRange.insets = new Insets(0, 0, 5, 5);
		gbc_gpaFirstRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_gpaFirstRange.gridx = 1;
		gbc_gpaFirstRange.gridy = 5;
		displayTab.add(gpaFirstRange, gbc_gpaFirstRange);
		gpaFirstRange.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = (String) gender.getSelectedItem();
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
			}
			
		});
		/*
		 * To label referring to CGPA range
		 * Under display tab
		 */
		JLabel lblTo = new JLabel("->");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 2;
		gbc_lblTo.gridy = 5;
		displayTab.add(lblTo, gbc_lblTo);
		/*
		 * Second CGPA range text field
		 * Under display tab
		 */
		gpaSecondRange = new JFormattedTextField(format);
		gpaSecondRange.setColumns(10);
		//gpaSecondRange.setBounds(1, 5, 10, 3);
		GridBagConstraints gbc_gpaSecondRange = new GridBagConstraints();
		gbc_gpaSecondRange.insets = new Insets(0, 0, 5, 5);
		gbc_gpaSecondRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_gpaSecondRange.gridx = 4;
		gbc_gpaSecondRange.gridy = 5;
		displayTab.add(gpaSecondRange, gbc_gpaSecondRange);
		gpaSecondRange.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = (String) gender.getSelectedItem();
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
			}
			
		});
		
		/*
		 * Clear text fields button
		 * Under display tab
		 */
		JButton clearFields = new JButton("Clear");
		clearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets the text fields to empty strings
				studentIDSearch.setText("");
				majorSearch.setText("");
				firstNameSearch.setText("");
				lastNameSearch.setText("");
				male.setSelected(false);
				female.setSelected(false);
				CGPAAverage.setText("");
				gpaFirstRange.setText("");
				gpaSecondRange.setText("");
				System.out.println("called");
	        	//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearch.getText());}
				catch(NumberFormatException e1){
				}
				String firstName = firstNameSearch.getText();
				String lastName = lastNameSearch.getText();
				String Gender = null;
				String Major = majorSearch.getText();
				Integer Year = null;
				try{Year = Integer.parseInt(searchYear.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAF = null; //null incase nothing is entered because its a range and its a double
				try{GPAF = Double.parseDouble(gpaFirstRange.getText());}
				catch(NumberFormatException e1){
				}
				Double GPAS = null;
				try{GPAS = Double.parseDouble(gpaSecondRange.getText());}
				catch(NumberFormatException e1){
				}
				//end of reading in all the inputs
				//calling the student search function from the new controller controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentSearch(studentID,firstName,lastName, Gender , Major, Year, GPAF, GPAS));
					CGPAAverage.setText(Double.toString(funcController.getCGPAAverage()));
					//CGPAAverage.setText(Double.toString(funcController.returnAverage()));
					searchTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				    e1.printStackTrace();
				}
			}
		});
		/*
		 * CGPA Average label
		 * Under display tab
		 */
		JLabel lblCgpaAverage = new JLabel("CGPA Average");
		GridBagConstraints gbc_lblCgpaAverage = new GridBagConstraints();
		gbc_lblCgpaAverage.anchor = GridBagConstraints.EAST;
		gbc_lblCgpaAverage.insets = new Insets(0, 0, 5, 5);
		gbc_lblCgpaAverage.gridx = 0;
		gbc_lblCgpaAverage.gridy = 6;
		displayTab.add(lblCgpaAverage, gbc_lblCgpaAverage);
		/*
		 * CGPA Average text field
		 * Under display tab
		 */
		CGPAAverage = new JTextField();
		CGPAAverage.setEditable(false);
		CGPAAverage.setColumns(10);
		GridBagConstraints gbc_CGPAAverage = new GridBagConstraints();
		gbc_CGPAAverage.insets = new Insets(0, 0, 5, 5);
		gbc_CGPAAverage.fill = GridBagConstraints.HORIZONTAL;
		gbc_CGPAAverage.gridx = 1;
		gbc_CGPAAverage.gridy = 6;
		displayTab.add(CGPAAverage, gbc_CGPAAverage);
		/*
		 * Separator between CGPA range and buttons
		 * Under display tab
		 */
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.fill = GridBagConstraints.BOTH;
		gbc_separator_2.gridwidth = 6;
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 7;
		displayTab.add(separator_2, gbc_separator_2);
		GridBagConstraints gbc_clearFields = new GridBagConstraints();
		gbc_clearFields.fill = GridBagConstraints.HORIZONTAL;
		gbc_clearFields.gridwidth = 2;
		gbc_clearFields.insets = new Insets(0, 0, 0, 0);
		gbc_clearFields.gridx = 4;
		gbc_clearFields.gridy = 8;
		displayTab.add(clearFields, gbc_clearFields);
		/*
		 * Scroll pane for the search table
		 * Under search tab
		 */
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		displayTab.add(scrollPane, gbc_scrollPane);
		/*
		 * Creating search table
		 * Under search tab
		 */
		searchTable = new JTable();
		try {
			searchTable.setModel(new mainModel(funcController.returnArrayList()));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		searchTable.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(searchTable);
		/*
		 * Creating them modify tab
		 */
		JPanel modifyTab = new JPanel();
		tabbedPane.addTab("Edit", null, modifyTab, null);
		GridBagLayout gbl_modifyTab = new GridBagLayout();
		gbl_modifyTab.columnWidths = new int[]{118, 0, 75, 0, 0, 0, 0};
		gbl_modifyTab.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_modifyTab.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_modifyTab.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		modifyTab.setLayout(gbl_modifyTab);
		/*
		 * First name label
		 * Under modify tab
		 */
		JLabel label_1 = new JLabel("First Name:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		
		//modifyTab.add(label_1, gbc_label_1);
		/*
		 * First name text field
		 * Under modify tab
		 */
		modifyFirstName = new JTextField();
		JButton editTable = new JButton("Add/Edit");
		JButton Remove = new JButton("Remove Row");
		GridBagConstraints gbc_modifyFirstName = new GridBagConstraints();
		gbc_modifyFirstName.insets = new Insets(0, 0, 0, 0);
		gbc_modifyFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyFirstName.gridwidth = 2;
		//gbc_modifyFirstName.
		gbc_modifyFirstName.gridx = 0;
		gbc_modifyFirstName.gridy = 2;
		modifyTab.add(editTable, gbc_modifyFirstName);
		GridBagConstraints gbc_modifyFirstName1 = new GridBagConstraints();
		gbc_modifyFirstName1.insets = new Insets(0, 0, 0, 0);
		gbc_modifyFirstName1.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyFirstName1.gridwidth = 2;
		gbc_modifyFirstName1.gridx = 3;
		gbc_modifyFirstName1.gridy = 2;
		modifyTab.add(Remove, gbc_modifyFirstName1);
		modifyFirstName.setColumns(10);
        Remove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(modifyTable.getSelectedRow() >= 0){
					Integer studentID = null;
					//Removes student based on Student ID match
					try{studentID = Integer.parseInt(modifyTable.getValueAt(modifyTable.getSelectedRow(), 0).toString());}
					catch(NumberFormatException e){
					}
					//Calling remove student function from controller
					try {
						mainModel updatedModel = new mainModel(funcController.removeStudent(studentID));
						modifyTable.setModel(updatedModel);
						searchTable.setModel(updatedModel);
						updateStudentModel updatePurposes = new updateStudentModel(funcController.returnCouseArrayList());
						courseTable.setModel(updatePurposes);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
        	
        });
		/*
		 * Major label
		 * Under modify tab
		 */
		JLabel label_2 = new JLabel("Major");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 0;
		//modifyTab.add(label_2, gbc_label_2);
		/*
		 * Major text field
		 * Under modify tab
		 */
		modifyMajor = new JTextField();
		modifyMajor.setColumns(10);
		GridBagConstraints gbc_modifyMajor = new GridBagConstraints();
		gbc_modifyMajor.insets = new Insets(0, 0, 5, 5);
		gbc_modifyMajor.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyMajor.gridx = 3;
		gbc_modifyMajor.gridy = 0;
		//modifyTab.add(modifyMajor, gbc_modifyMajor);
		

		GridBagConstraints gbc_modifySave = new GridBagConstraints();
		gbc_modifySave.insets = new Insets(0, 0, 5, 0);
		gbc_modifySave.gridx = 5;
		gbc_modifySave.gridy = 0;
		//modifyTab.add(modifySave, gbc_modifySave);
		/*
		 * Last Name label
		 * Under modify tab
		 */
		JLabel label_3 = new JLabel("Last Name");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		//modifyTab.add(label_3, gbc_label_3);
		/*
		 * Last name text field
		 * Under modify tab
		 */
		modifyLastName = new JTextField();
		GridBagConstraints gbc_modifyLastName = new GridBagConstraints();
		gbc_modifyLastName.insets = new Insets(0, 0, 5, 5);
		gbc_modifyLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyLastName.gridx = 1;
		gbc_modifyLastName.gridy = 1;
		//modifyTab.add(modifyLastName, gbc_modifyLastName);
		modifyLastName.setColumns(10);
		/*
		 * Year label
		 * Under modify tab
		 */
		JLabel label_4 = new JLabel("Year");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 1;
		//modifyTab.add(label_4, gbc_label_4);
		/*
		 * Year text field
		 * Under modify tab
		 */
		modifyYear = new JTextField();
		modifyYear.setColumns(10);
		GridBagConstraints gbc_modifyYear = new GridBagConstraints();
		gbc_modifyYear.insets = new Insets(0, 0, 5, 5);
		gbc_modifyYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyYear.gridx = 3;
		gbc_modifyYear.gridy = 1;
		//modifyTab.add(modifyYear, gbc_modifyYear);
		/*
		 * Remove Student Button
		 * Under modify tab
		 */
		GridBagConstraints gbc_btnRemoveStudent = new GridBagConstraints();
		gbc_btnRemoveStudent.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveStudent.gridx = 5;
		gbc_btnRemoveStudent.gridy = 1;
		//modifyTab.add(removeStudent, gbc_btnRemoveStudent);

		JLabel label_5 = new JLabel("Initial");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 2;
		//modifyTab.add(label_5, gbc_label_5);
		/*
		 * Initial text field
		 * Under modify tab
		 */
		modifyInitial = new JTextField();
		modifyInitial.setColumns(10);
		GridBagConstraints gbc_modifyInitial = new GridBagConstraints();
		gbc_modifyInitial.insets = new Insets(0, 0, 5, 5);
		gbc_modifyInitial.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyInitial.gridx = 1;
		gbc_modifyInitial.gridy = 2;
		//modifyTab.add(modifyInitial, gbc_modifyInitial);
		/*
		 * Credit label
		 * Under modify tab
		 */
		JLabel label_6 = new JLabel("Credit");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 2;
		//modifyTab.add(label_6, gbc_label_6);
		/*
		 * Credit text field
		 * Under modify tab
		 */
		modifyCredit = new JTextField();
		modifyCredit.setColumns(10);
		GridBagConstraints gbc_modifyCredit = new GridBagConstraints();
		gbc_modifyCredit.insets = new Insets(0, 0, 5, 5);
		gbc_modifyCredit.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyCredit.gridx = 3;
		gbc_modifyCredit.gridy = 2;
		//modifyTab.add(modifyCredit, gbc_modifyCredit);
		/*
		 * Edit Student Button
		 * Under modify tab
		 */
		
		
				/*
		 * City label
		 * Under modify tab
		 */
		JLabel label_7 = new JLabel("City");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 3;
		//modifyTab.add(label_7, gbc_label_7);
		/*
		 * City text field
		 * Under modify tab
		 */
		modifyCity = new JTextField();
		modifyCity.setColumns(10);
		GridBagConstraints gbc_modifyCity = new GridBagConstraints();
		gbc_modifyCity.insets = new Insets(0, 0, 5, 5);
		gbc_modifyCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyCity.gridx = 1;
		gbc_modifyCity.gridy = 3;
		//modifyTab.add(modifyCity, gbc_modifyCity);
		/*
		 * Student ID label
		 * Under modify tab
		 */
		JLabel label_10 = new JLabel("Student ID");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 2;
		gbc_label_10.gridy = 3;
		//modifyTab.add(label_10, gbc_label_10);
		/*
		 * Student ID text field
		 * Under modify tab
		 */
		modifyStudentID = new JTextField();
		modifyStudentID.setColumns(10);
		GridBagConstraints gbc_modifyStudentID = new GridBagConstraints();
		gbc_modifyStudentID.insets = new Insets(0, 0, 5, 5);
		gbc_modifyStudentID.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyStudentID.gridx = 3;
		gbc_modifyStudentID.gridy = 3;
		//modifyTab.add(modifyStudentID, gbc_modifyStudentID);
		/*
		 * Update Student Button
		 * Under modify tab
		 */
				GridBagConstraints gbc_updateStudent = new GridBagConstraints();
		gbc_updateStudent.insets = new Insets(0, 0, 5, 0);
		gbc_updateStudent.gridx = 5;
		gbc_updateStudent.gridy = 3;
		//modifyTab.add(updateStudent, gbc_updateStudent);
		JLabel label_9 = new JLabel("State");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 4;
		//modifyTab.add(label_9, gbc_label_9);
		/*
		 * State text field
		 * Under modify tab
		 */
		modifyState = new JTextField();
		modifyState.setColumns(10);
		GridBagConstraints gbc_modifyState = new GridBagConstraints();
		gbc_modifyState.insets = new Insets(0, 0, 5, 5);
		gbc_modifyState.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyState.gridx = 1;
		gbc_modifyState.gridy = 4;
		//modifyTab.add(modifyState, gbc_modifyState);
		/*
		 * Gender label
		 * Under modify tab
		 */
	
		//modifyTab.add(lblGender, gbc_lblGender);
		/*
		 * Gender text field
		 * Under modify tab
		 */
		modifyGender = new JTextField();
		modifyGender.setColumns(10);
		GridBagConstraints gbc_modifyGender = new GridBagConstraints();
		gbc_modifyGender.insets = new Insets(0, 0, 5, 5);
		gbc_modifyGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyGender.gridx = 3;
		gbc_modifyGender.gridy = 4;
	
	
		
		/*
		 * CGPA text field
		 * Under modify tab
		 */
		modifyCGPA = new JTextField();
		modifyCGPA.setColumns(10);
		GridBagConstraints gbc_modifyCGPA = new GridBagConstraints();
		gbc_modifyCGPA.insets = new Insets(0, 0, 5, 5);
		gbc_modifyCGPA.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyCGPA.gridx = 1;
		gbc_modifyCGPA.gridy = 5;
		//modifyTab.add(modifyCGPA, gbc_modifyCGPA);
		/*
		 * Phone Number label
		 * Under modify tab
		 */
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.gridx = 2;
		gbc_lblPhoneNumber.gridy = 5;
		//modifyTab.add(lblPhoneNumber, gbc_lblPhoneNumber);
		/*
		 * Modify Phone Number Text Field
		 * Under modify tab
		 */
		modifyPhoneNumber = new JTextField();
		modifyPhoneNumber.setColumns(10);
		GridBagConstraints gbc_modifyPhoneNumber = new GridBagConstraints();
		gbc_modifyPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_modifyPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyPhoneNumber.gridx = 3;
		gbc_modifyPhoneNumber.gridy = 5;
		//modifyTab.add(modifyPhoneNumber, gbc_modifyPhoneNumber);
		/*
		 * Separator between adding students and removing students
		 * Under modify tab
		 */
		/*
		 * Adds search button
		 * Under modify tab
		 */
		
		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.gridwidth = 6;
		gbc_separator_5.insets = new Insets(0, 0, 5, 0);
		gbc_separator_5.gridx = 0;
		gbc_separator_5.gridy = 6;
		//modifyTab.add(separator_5, gbc_separator_5);
		
		JLabel lblStudentIdSearch = new JLabel("Student ID Search");
		GridBagConstraints gbc_lblStudentIdSearch = new GridBagConstraints();
		gbc_lblStudentIdSearch.anchor = GridBagConstraints.EAST;
		gbc_lblStudentIdSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentIdSearch.gridx = 0;
		gbc_lblStudentIdSearch.gridy = 7;
		//modifyTab.add(lblStudentIdSearch, gbc_lblStudentIdSearch);
		
		modifySearch = new JTextField();
		modifySearch.setColumns(10);
		GridBagConstraints gbc_modifySearch = new GridBagConstraints();
		gbc_modifySearch.insets = new Insets(0, 0, 5, 5);
		gbc_modifySearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifySearch.gridx = 1;
		gbc_modifySearch.gridy = 7;
		//modifyTab.add(modifySearch, gbc_modifySearch);
		JButton searchModify = new JButton("Search");
		searchModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(modifySearch.getText());}
				catch(NumberFormatException b){
				}
				//end of reading in all the inputs
				//calling the student search function from the controller
				try {
					mainModel updatedModel = new mainModel(funcController.studentIDSearch(studentID));
					modifyTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//updating the table with the new model
			}
		});
		GridBagConstraints gbc_searchModify = new GridBagConstraints();
		gbc_searchModify.insets = new Insets(0, 0, 5, 0);
		gbc_searchModify.gridx = 5;
		gbc_searchModify.gridy = 7;
		//modifyTab.add(searchModify, gbc_searchModify);
		
		JButton displayAllModify = new JButton("Display All");
		displayAllModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calls return arraylist function from the controller, basically it updates the model of the table to the list of all students
				try {
					mainModel updatedModel = new mainModel(funcController.returnArrayList());
					modifyTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_displayAllModify = new GridBagConstraints();
		gbc_displayAllModify.insets = new Insets(0, 0, 5, 0);
		gbc_displayAllModify.gridx = 5;
		gbc_displayAllModify.gridy = 8;
		//modifyTab.add(displayAllModify, gbc_displayAllModify);
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 9;
		modifyTab.add(separator, gbc_separator);
		/*
		 * The edit button to modify a student entry
		 * Under modify tab
		 */
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 10;
        modifyTable = new JTable();
		
		
		
		modifyTab.add(scrollPane_1, gbc_scrollPane_1);
		try {
			modifyTable.setModel(new mainModel(funcController.returnArrayList()));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		scrollPane_1.setViewportView(modifyTable);
		/*
		 * Adds modify table
		 * Under modify tab
		 */
		
		final JFrame controls = new JFrame();
        controls.getContentPane().setLayout(new GridLayout(14,2));
        controls.getContentPane().add(new JLabel("Old ID for Editing"));
        final JTextField oldID = new JTextField();
        controls.getContentPane().add(oldID);
        controls.getContentPane().add(new JLabel("Student ID"));
        controls.getContentPane().add(modifyStudentID);
        controls.getContentPane().add(label_1);
        controls.getContentPane().add(modifyFirstName);
        controls.getContentPane().add(new JLabel("Last Name:"));
        controls.getContentPane().add(modifyLastName);
        controls.getContentPane().add(new JLabel("Initial:"));
        controls.getContentPane().add(modifyInitial);
        controls.getContentPane().add(new JLabel("City:"));
        controls.getContentPane().add(modifyCity);
        controls.getContentPane().add(new JLabel("State:"));
        controls.getContentPane().add(modifyState);
        controls.getContentPane().add(new JLabel("Phone No."));
        controls.getContentPane().add(modifyPhoneNumber);
        controls.getContentPane().add(new JLabel("Gender"));
        controls.getContentPane().add(modifyGender);
        controls.getContentPane().add(new JLabel("Year:"));
        controls.getContentPane().add(modifyYear);
        controls.getContentPane().add(new JLabel("Major:"));
        controls.getContentPane().add(modifyMajor);
        controls.getContentPane().add(new JLabel("Credit:"));
        controls.getContentPane().add(modifyCredit);
        controls.getContentPane().add(new JLabel("CGPA"));
        controls.getContentPane().add(modifyCGPA);
        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        controls.getContentPane().add(add);
        controls.getContentPane().add(edit);
		editTable.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controls.setSize(500, 300);
				controls.setVisible(true);
			}
			
		});
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Integer studentID = null;
					studentID = Integer.parseInt(modifyStudentID.getText());
					String firstName = modifyFirstName.getText();
					String lastName = modifyLastName.getText();
					String Initial = modifyInitial.getText();
					String Gender = modifyGender.getText();
					String Major = modifyMajor.getText();
					Double CGPA = null; //null incase nothing is entered because its a range and its a double
					CGPA = Double.parseDouble(modifyCGPA.getText());
					String City = modifyCity.getText();
					String State = modifyState.getText();
					String PhoneNumber = modifyPhoneNumber.getText();
					Integer Credit = null;
					Credit = Integer.parseInt(modifyCredit.getText());
					Integer Year = null;
					Year = Integer.parseInt(modifyYear.getText());
					mainModel updatedModel = new mainModel(funcController.addStudent(studentID, firstName, lastName, Initial, Gender, Major, CGPA, City, State, PhoneNumber, Credit, Year));
					modifyTable.setModel(updatedModel);
					searchTable.setModel(updatedModel);
					updateStudentModel updatePurposes = new updateStudentModel(funcController.returnCouseArrayList());
					courseTable.setModel(updatePurposes);
				}
				//each exception is dealt with in the students class as it is being handled by the controller
				//the error will be unique to each case as it catches each option's "Error message" exception
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid Data, please check your fields and make sure they are filled out and not clashing with other entries.", "Error!",JOptionPane.ERROR_MESSAGE);
				}
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error arrised in the Input Output Stream", "Error!",JOptionPane.ERROR_MESSAGE);
				}
				controls.setVisible(false);
			}
			
		});
        edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OldStudentID = Integer.parseInt(oldID.getText());
				if(OldStudentID != null){
					Integer studentID = null;
					try{studentID = Integer.parseInt(modifyStudentID.getText());}
					catch(NumberFormatException e1){
					}
					String firstName = modifyFirstName.getText();
					String lastName = modifyLastName.getText();
					String Initial = modifyInitial.getText();
					String Gender = modifyGender.getText();
					String Major = modifyMajor.getText();
					Double CGPA = null; //null incase nothing is entered because its a range and its a double
					try{CGPA = Double.parseDouble(modifyCGPA.getText());}
					catch(NumberFormatException e1){
					}
					String City = modifyCity.getText();
					String State = modifyState.getText();
					String PhoneNumber = modifyPhoneNumber.getText();
					Integer Credit = null;
					try{Credit = Integer.parseInt(modifyCredit.getText());}
					catch(NumberFormatException e1){
					}
					Integer Year = null;
					try{Year = Integer.parseInt(modifyYear.getText());}
					catch(NumberFormatException e1){
					}
					// tries the edit student function as it calls it from the controller, sends in the values that are recieved from the textfields
					try{
						mainModel updatedModel = new mainModel(funcController.editStudent(OldStudentID, studentID, firstName, lastName, Initial, Gender, Major, CGPA, City, State, PhoneNumber, Credit, Year));
						modifyTable.setModel(updatedModel);
						searchTable.setModel(updatedModel);
						updateStudentModel updatePurposes = new updateStudentModel(funcController.returnCouseArrayList());
						courseTable.setModel(updatePurposes);
					}
					//each exception is dealt with in the students class as it is being handled by the controller
					//the error will be unique to each case as it catches each option's "Error message" exception
					catch (IllegalArgumentException e1){
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				controls.setVisible(false);
			}
        	
        });
		/*
		 * Adds transcript tab
		 */
		JPanel transcriptTab = new JPanel();
		tabbedPane.addTab("Report", null, transcriptTab, null);
		GridBagLayout gbl_transcriptTab = new GridBagLayout();
		gbl_transcriptTab.columnWidths = new int[]{54, 91, 33, 49, 0, 0, 88, 0, 60, 98, 22, 73, 0};
		gbl_transcriptTab.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_transcriptTab.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_transcriptTab.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		transcriptTab.setLayout(gbl_transcriptTab);
		JLabel lblStudentidSearch = new JLabel("Student ID:");
		GridBagConstraints gbc_lblStudentidSearch = new GridBagConstraints();
		gbc_lblStudentidSearch.anchor = GridBagConstraints.EAST;
		gbc_lblStudentidSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentidSearch.gridx = 0;
		gbc_lblStudentidSearch.gridy = 0;
		transcriptTab.add(lblStudentidSearch, gbc_lblStudentidSearch);
		studentIDSearchTranscript = new JTextField();
		GridBagConstraints gbc_studentIDSearchTranscript = new GridBagConstraints();
		gbc_studentIDSearchTranscript.gridwidth = 3;
		gbc_studentIDSearchTranscript.insets = new Insets(0, 0, 5, 5);
		gbc_studentIDSearchTranscript.fill = GridBagConstraints.HORIZONTAL;
		gbc_studentIDSearchTranscript.gridx = 1;
		gbc_studentIDSearchTranscript.gridy = 0;
		transcriptTab.add(studentIDSearchTranscript, gbc_studentIDSearchTranscript);
		studentIDSearchTranscript.setColumns(10);
		studentIDSearchTranscript.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					Integer studentID = null;
					//using a try block to catch the number exception to avoid errors when reading input
					try{studentID = Integer.parseInt(studentIDSearchTranscript.getText());}
					catch(NumberFormatException b){
						b.printStackTrace();
					}
					try {
						updateStudentModel updatedModel = new updateStudentModel(funcController.updateStudentIDSearch(studentID));
						courseTable.setModel(updatedModel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		/*JButton transcriptSearch = new JButton("Search");
		transcriptSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reading in all the inputs to be sent to the method in the controller
				Integer studentID = null;
				//using a try block to catch the number exception to avoid errors when reading input
				try{studentID = Integer.parseInt(studentIDSearchTranscript.getText());}
				catch(NumberFormatException b){
					b.printStackTrace();
				}
				try {
					updateStudentModel updatedModel = new updateStudentModel(funcController.updateStudentIDSearch(studentID));
					courseTable.setModel(updatedModel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});*/
		
		GridBagConstraints gbc_transcriptSearch = new GridBagConstraints();
		gbc_transcriptSearch.gridwidth = 2;
		gbc_transcriptSearch.insets = new Insets(0, 0, 5, 5);
		gbc_transcriptSearch.gridx = 2;
		gbc_transcriptSearch.gridy = 0;
		//transcriptTab.add(transcriptSearch, gbc_transcriptSearch);
		
		JButton displayAllTranscript = new JButton("Reset Table");
		displayAllTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					updateStudentModel updatedModel = new updateStudentModel(funcController.returnCouseArrayList());
					courseTable.setModel(updatedModel);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_displayAllTranscript = new GridBagConstraints();
		gbc_displayAllTranscript.anchor = GridBagConstraints.WEST;
		gbc_displayAllTranscript.gridwidth = 5;
		gbc_displayAllTranscript.insets = new Insets(0, 0, 5, 5);
		gbc_displayAllTranscript.gridx = 4;
		gbc_displayAllTranscript.gridy = 0;
		transcriptTab.add(displayAllTranscript, gbc_displayAllTranscript);
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.fill = GridBagConstraints.BOTH;
		gbc_separator_3.gridwidth = 12;
		gbc_separator_3.insets = new Insets(0, 0, 5, 0);
		gbc_separator_3.gridx = 0;
		gbc_separator_3.gridy = 1;
		transcriptTab.add(separator_3, gbc_separator_3);
		
		JLabel lblCourse = new JLabel("Course 1");
		GridBagConstraints gbc_lblCourse = new GridBagConstraints();
		gbc_lblCourse.insets = new Insets(0, 0, 5, 5);
		gbc_lblCourse.anchor = GridBagConstraints.EAST;
		gbc_lblCourse.gridx = 0;
		gbc_lblCourse.gridy = 2;
		transcriptTab.add(lblCourse, gbc_lblCourse);
		
		tcourse1 = new JTextField();
		tcourse1.setColumns(10);
		GridBagConstraints gbc_tcourse1 = new GridBagConstraints();
		gbc_tcourse1.insets = new Insets(0, 0, 5, 5);
		gbc_tcourse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tcourse1.gridx = 1;
		gbc_tcourse1.gridy = 2;
		transcriptTab.add(tcourse1, gbc_tcourse1);
		
		JLabel lblCredits_3 = new JLabel("Credits ");
		GridBagConstraints gbc_lblCredits_3 = new GridBagConstraints();
		gbc_lblCredits_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredits_3.anchor = GridBagConstraints.EAST;
		gbc_lblCredits_3.gridx = 3;
		gbc_lblCredits_3.gridy = 2;
		transcriptTab.add(lblCredits_3, gbc_lblCredits_3);
		
		credit1 = new JTextField();
		credit1.setColumns(10);
		GridBagConstraints gbc_credit1 = new GridBagConstraints();
		gbc_credit1.insets = new Insets(0, 0, 5, 5);
		gbc_credit1.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit1.gridx = 6;
		gbc_credit1.gridy = 2;
		transcriptTab.add(credit1, gbc_credit1);
		
		JLabel lblGrade_1 = new JLabel("Grade");
		GridBagConstraints gbc_lblGrade_1 = new GridBagConstraints();
		gbc_lblGrade_1.anchor = GridBagConstraints.EAST;
		gbc_lblGrade_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrade_1.gridx = 8;
		gbc_lblGrade_1.gridy = 2;
		transcriptTab.add(lblGrade_1, gbc_lblGrade_1);
		
		String courselabels[] = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
		tgrade1 = new JComboBox(courselabels);
		tgrade1.setModel(new DefaultComboBoxModel(new String[] {"", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"}));
		GridBagConstraints gbc_tgrade1 = new GridBagConstraints();
		gbc_tgrade1.insets = new Insets(0, 0, 5, 5);
		gbc_tgrade1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tgrade1.gridx = 9;
		gbc_tgrade1.gridy = 2;
		transcriptTab.add(tgrade1, gbc_tgrade1);
		
		JButton editCoursesTranscript = new JButton("Edit Course(s)");
		editCoursesTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Gets a selected row
				if(courseTable.getSelectedRow() >= 0){
				try{
					//The following gets the value at every textfield to be inputted into the text fields
					Integer studentID = null;
					//Removes student based on Student ID match
					studentID = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 0).toString());
					String course1 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 1);
					String grade1 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 2);
					Integer coursecredit1 = null;
					coursecredit1 = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 3).toString());
					
					String course2 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 4);
					String grade2 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 5);
					Integer coursecredit2 = null;
					coursecredit2 = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 6).toString());
					
					String course3 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 7);
					String grade3 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 8);
					Integer coursecredit3 = null;
					coursecredit3 = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 9).toString());
					
					String course4 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 10);
					String grade4 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 11);
					Integer coursecredit4 = null;
					coursecredit4 = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 12).toString());
					
					String course5 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 13);
					String grade5 = (String) courseTable.getValueAt(courseTable.getSelectedRow(), 14);
					Integer coursecredit5 = null;
					coursecredit5 = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 15).toString());
					
					// this sets the textfields to all the values
					studentIDSearchTranscript.setText(String.valueOf(studentID));
					tcourse1.setText(course1);
					tgrade1.setSelectedItem(grade1);
					credit1.setText(String.valueOf(coursecredit1));
					tcourse2.setText(course2);
					tgrade2.setSelectedItem(grade2);
					credit2.setText(String.valueOf(coursecredit2));
					tcourse3.setText(course3);
					tgrade3.setSelectedItem(grade3);
					credit3.setText(String.valueOf(coursecredit3));
					tcourse4.setText(course4);
					tgrade4.setSelectedItem(grade4);
					credit4.setText(String.valueOf(coursecredit4));
					tcourse5.setText(course5);
					tgrade5.setSelectedItem(grade5);
					credit5.setText(String.valueOf(coursecredit5));
					//Updating the table with the new model
						mainModel updatedModel = new mainModel(funcController.returnArrayList());
						searchTable.setModel(updatedModel);
						modifyTable.setModel(updatedModel);
					}
					catch (IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		GridBagConstraints gbc_editCoursesTranscript = new GridBagConstraints();
		gbc_editCoursesTranscript.insets = new Insets(0, 0, 5, 0);
		gbc_editCoursesTranscript.gridx = 11;
		gbc_editCoursesTranscript.gridy = 2;
		transcriptTab.add(editCoursesTranscript, gbc_editCoursesTranscript);
		JLabel lblCoursePrefix = new JLabel("Course 2");
		GridBagConstraints gbc_lblCoursePrefix = new GridBagConstraints();
		gbc_lblCoursePrefix.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoursePrefix.anchor = GridBagConstraints.EAST;
		gbc_lblCoursePrefix.gridx = 0;
		gbc_lblCoursePrefix.gridy = 3;
		transcriptTab.add(lblCoursePrefix, gbc_lblCoursePrefix);
		/*
		 * Adds Course Prefix label
		 * Under transcript tab
		 */
		tcourse2 = new JTextField();
		tcourse2.setColumns(10);
		GridBagConstraints gbc_tcourse2 = new GridBagConstraints();
		gbc_tcourse2.insets = new Insets(0, 0, 5, 5);
		gbc_tcourse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tcourse2.gridx = 1;
		gbc_tcourse2.gridy = 3;
		transcriptTab.add(tcourse2, gbc_tcourse2);
		/*
		 * Adds Course Title text field
		 * Under transcript tab
		 */
		
		JLabel lblCredits = new JLabel("Credits ");
		GridBagConstraints gbc_lblCredits = new GridBagConstraints();
		gbc_lblCredits.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredits.anchor = GridBagConstraints.EAST;
		gbc_lblCredits.gridx = 3;
		gbc_lblCredits.gridy = 3;
		transcriptTab.add(lblCredits, gbc_lblCredits);
		credit2 = new JTextField();
		credit2.setColumns(10);
		GridBagConstraints gbc_credit2 = new GridBagConstraints();
		gbc_credit2.insets = new Insets(0, 0, 5, 5);
		gbc_credit2.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit2.gridx = 6;
		gbc_credit2.gridy = 3;
		transcriptTab.add(credit2, gbc_credit2);
		
		JLabel label_8 = new JLabel("Grade");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.gridx = 8;
		gbc_label_8.gridy = 3;
		transcriptTab.add(label_8, gbc_label_8);
		
		tgrade2 = new JComboBox(courselabels);
		tgrade2.setModel(new DefaultComboBoxModel(new String[] {"", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"}));
		GridBagConstraints gbc_tgrade2 = new GridBagConstraints();
		gbc_tgrade2.insets = new Insets(0, 0, 5, 5);
		gbc_tgrade2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tgrade2.gridx = 9;
		gbc_tgrade2.gridy = 3;
		transcriptTab.add(tgrade2, gbc_tgrade2);
		JButton updateCoursesTranscript = new JButton("Update Course(s)");
		updateCoursesTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//reading in all the inputs
				Integer studentID = null;
				try{studentID = Integer.parseInt(studentIDSearchTranscript.getText());}
				catch(NumberFormatException e){
				}
				String course1 = tcourse1.getText();
				String grade1 = (String) tgrade1.getSelectedItem();
				Integer coursecredit1 = null;
				try{coursecredit1 = Integer.parseInt(credit1.getText());}
				catch(NumberFormatException e){
				}
				String course2 = tcourse2.getText();
				String grade2 = (String) tgrade2.getSelectedItem();
				Integer coursecredit2 = null;
				try{coursecredit2 = Integer.parseInt(credit2.getText());}
				catch(NumberFormatException e){
				}
				String course3 = tcourse3.getText();
				String grade3 = (String) tgrade3.getSelectedItem();
				Integer coursecredit3 = null;
				try{coursecredit3 = Integer.parseInt(credit3.getText());}
				catch(NumberFormatException e){
				}
				String course4 = tcourse4.getText();
				String grade4 = (String) tgrade4.getSelectedItem();
				Integer coursecredit4 = null;
				try{coursecredit4 = Integer.parseInt(credit4.getText());}
				catch(NumberFormatException e){
				}
				String course5 = tcourse5.getText();
				String grade5 = (String) tgrade5.getSelectedItem();
				Integer coursecredit5 = null;
				try{coursecredit5 = Integer.parseInt(credit5.getText());}
				catch(NumberFormatException e){
				}
				// tries the edit student update function as it calls it from the controller, sends in the values that are recieved from the textfields
				try{
					updateStudentModel updatedModel = new updateStudentModel(funcController.editStudentUpdate(studentID, course1, grade1, coursecredit1, course2, grade2, coursecredit2, course3, grade3, coursecredit3, course4, grade4, coursecredit4, course5, grade5, coursecredit5));
					courseTable.setModel(updatedModel);
					mainModel updatePurposes = new mainModel(funcController.returnArrayList());
					searchTable.setModel(updatePurposes);
					modifyTable.setModel(updatePurposes);
				}
				//each exception is dealt with in the students class as it is being handled by the controller
				//the error will be unique to each case as it catches each option's "Error message" exception
				catch (IllegalArgumentException e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_updateCoursesTranscript = new GridBagConstraints();
		gbc_updateCoursesTranscript.insets = new Insets(0, 0, 5, 0);
		gbc_updateCoursesTranscript.gridx = 11;
		gbc_updateCoursesTranscript.gridy = 3;
		transcriptTab.add(updateCoursesTranscript, gbc_updateCoursesTranscript);
		/*
		 * Adds Course Number label
		 * Under transcript tab
		 */
		JLabel lblCourseNumber = new JLabel("Course 3");
		GridBagConstraints gbc_lblCourseNumber = new GridBagConstraints();
		gbc_lblCourseNumber.anchor = GridBagConstraints.EAST;
		gbc_lblCourseNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblCourseNumber.gridx = 0;
		gbc_lblCourseNumber.gridy = 4;
		transcriptTab.add(lblCourseNumber, gbc_lblCourseNumber);
		/*
		 * Adds Course Number text field
		 * Under transcript tab
		 */
		tcourse3 = new JTextField();
		tcourse3.setColumns(10);
		GridBagConstraints gbc_tcourse3 = new GridBagConstraints();
		gbc_tcourse3.insets = new Insets(0, 0, 5, 5);
		gbc_tcourse3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tcourse3.gridx = 1;
		gbc_tcourse3.gridy = 4;
		transcriptTab.add(tcourse3, gbc_tcourse3);
		/*
		 * Adds Grade label
		 * Under transcript tab
		 */
		JLabel lblGrade = new JLabel("Credits ");
		GridBagConstraints gbc_lblGrade = new GridBagConstraints();
		gbc_lblGrade.anchor = GridBagConstraints.EAST;
		gbc_lblGrade.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrade.gridx = 3;
		gbc_lblGrade.gridy = 4;
		transcriptTab.add(lblGrade, gbc_lblGrade);
		/*
		 * Adds grade text field
		 * Under transcript tab
		 */
		credit3 = new JTextField();
		credit3.setColumns(10);
		GridBagConstraints gbc_credit3 = new GridBagConstraints();
		gbc_credit3.insets = new Insets(0, 0, 5, 5);
		gbc_credit3.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit3.gridx = 6;
		gbc_credit3.gridy = 4;
		transcriptTab.add(credit3, gbc_credit3);
		/*
		 * Adds modify course button
		 * Under transcript tab
		 */
		JButton clearAllTranscript = new JButton("Clear All");
		clearAllTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tcourse1.setText("");
				credit1.setText("");
				tgrade1.setSelectedItem("A");
				tcourse2.setText("");
				credit2.setText("");
				tgrade2.setSelectedItem("A");
				tcourse3.setText("");
				credit3.setText("");
				tgrade3.setSelectedItem("A");
				tcourse4.setText("");
				credit4.setText("");
				tgrade4.setSelectedItem("A");
				tcourse5.setText("");
				credit5.setText("");
				tgrade5.setSelectedItem("A");
			}
		});
		
		JLabel label_11 = new JLabel("Grade");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.gridx = 8;
		gbc_label_11.gridy = 4;
		transcriptTab.add(label_11, gbc_label_11);
		
		tgrade3 = new JComboBox(courselabels);
		tgrade3.setModel(new DefaultComboBoxModel(new String[] {"", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"}));
		GridBagConstraints gbc_tgrade3 = new GridBagConstraints();
		gbc_tgrade3.insets = new Insets(0, 0, 5, 5);
		gbc_tgrade3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tgrade3.gridx = 9;
		gbc_tgrade3.gridy = 4;
		transcriptTab.add(tgrade3, gbc_tgrade3);
		GridBagConstraints gbc_clearAllTranscript = new GridBagConstraints();
		gbc_clearAllTranscript.insets = new Insets(0, 0, 5, 0);
		gbc_clearAllTranscript.gridx = 11;
		gbc_clearAllTranscript.gridy = 4;
		transcriptTab.add(clearAllTranscript, gbc_clearAllTranscript);
		/*
		 * Adds Separator
		 * Under transcript tab
		 */
		
		JLabel lblCourse_1 = new JLabel("Course 4");
		GridBagConstraints gbc_lblCourse_1 = new GridBagConstraints();
		gbc_lblCourse_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCourse_1.anchor = GridBagConstraints.EAST;
		gbc_lblCourse_1.gridx = 0;
		gbc_lblCourse_1.gridy = 5;
		transcriptTab.add(lblCourse_1, gbc_lblCourse_1);
		
		tcourse4 = new JTextField();
		tcourse4.setColumns(10);
		GridBagConstraints gbc_tcourse4 = new GridBagConstraints();
		gbc_tcourse4.insets = new Insets(0, 0, 5, 5);
		gbc_tcourse4.fill = GridBagConstraints.HORIZONTAL;
		gbc_tcourse4.gridx = 1;
		gbc_tcourse4.gridy = 5;
		transcriptTab.add(tcourse4, gbc_tcourse4);
		
		JLabel lblCredits_1 = new JLabel("Credits ");
		GridBagConstraints gbc_lblCredits_1 = new GridBagConstraints();
		gbc_lblCredits_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredits_1.anchor = GridBagConstraints.EAST;
		gbc_lblCredits_1.gridx = 3;
		gbc_lblCredits_1.gridy = 5;
		transcriptTab.add(lblCredits_1, gbc_lblCredits_1);
		
		credit4 = new JTextField();
		credit4.setColumns(10);
		GridBagConstraints gbc_credit4 = new GridBagConstraints();
		gbc_credit4.insets = new Insets(0, 0, 5, 5);
		gbc_credit4.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit4.gridx = 6;
		gbc_credit4.gridy = 5;
		transcriptTab.add(credit4, gbc_credit4);
		
		JLabel label_12 = new JLabel("Grade");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.anchor = GridBagConstraints.EAST;
		gbc_label_12.gridx = 8;
		gbc_label_12.gridy = 5;
		transcriptTab.add(label_12, gbc_label_12);
		
		tgrade4 = new JComboBox(courselabels);
		tgrade4.setModel(new DefaultComboBoxModel(new String[] {"", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"}));
		GridBagConstraints gbc_tgrade4 = new GridBagConstraints();
		gbc_tgrade4.insets = new Insets(0, 0, 5, 5);
		gbc_tgrade4.fill = GridBagConstraints.HORIZONTAL;
		gbc_tgrade4.gridx = 9;
		gbc_tgrade4.gridy = 5;
		transcriptTab.add(tgrade4, gbc_tgrade4);
		
		JLabel lblCourse_2 = new JLabel("Course 5");
		GridBagConstraints gbc_lblCourse_2 = new GridBagConstraints();
		gbc_lblCourse_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCourse_2.anchor = GridBagConstraints.EAST;
		gbc_lblCourse_2.gridx = 0;
		gbc_lblCourse_2.gridy = 6;
		transcriptTab.add(lblCourse_2, gbc_lblCourse_2);
		
		tcourse5 = new JTextField();
		tcourse5.setColumns(10);
		GridBagConstraints gbc_tcourse5 = new GridBagConstraints();
		gbc_tcourse5.insets = new Insets(0, 0, 5, 5);
		gbc_tcourse5.fill = GridBagConstraints.HORIZONTAL;
		gbc_tcourse5.gridx = 1;
		gbc_tcourse5.gridy = 6;
		transcriptTab.add(tcourse5, gbc_tcourse5);
		
		JLabel lblCredits_2 = new JLabel("Credits ");
		GridBagConstraints gbc_lblCredits_2 = new GridBagConstraints();
		gbc_lblCredits_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredits_2.anchor = GridBagConstraints.EAST;
		gbc_lblCredits_2.gridx = 3;
		gbc_lblCredits_2.gridy = 6;
		transcriptTab.add(lblCredits_2, gbc_lblCredits_2);
		
		credit5 = new JTextField();
		credit5.setColumns(10);
		GridBagConstraints gbc_credit5 = new GridBagConstraints();
		gbc_credit5.insets = new Insets(0, 0, 5, 5);
		gbc_credit5.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit5.gridx = 6;
		gbc_credit5.gridy = 6;
		transcriptTab.add(credit5, gbc_credit5);
		
		JLabel label_13 = new JLabel("Grade");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.anchor = GridBagConstraints.EAST;
		gbc_label_13.gridx = 8;
		gbc_label_13.gridy = 6;
		transcriptTab.add(label_13, gbc_label_13);
		
		tgrade5 = new JComboBox(courselabels);
		tgrade5.setModel(new DefaultComboBoxModel(new String[] {"", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"}));
		GridBagConstraints gbc_tgrade5 = new GridBagConstraints();
		gbc_tgrade5.insets = new Insets(0, 0, 5, 5);
		gbc_tgrade5.fill = GridBagConstraints.HORIZONTAL;
		gbc_tgrade5.gridx = 9;
		gbc_tgrade5.gridy = 6;
		transcriptTab.add(tgrade5, gbc_tgrade5);
		
		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.gridwidth = 12;
		gbc_separator_6.insets = new Insets(0, 0, 5, 0);
		gbc_separator_6.gridx = 0;
		gbc_separator_6.gridy = 7;
		transcriptTab.add(separator_6, gbc_separator_6);
		
		courseSelect = new JComboBox(new Object[]{"Course 1", "Course 2", "Course 3", "Course 4", "Course 5"});
		courseSelect.setModel(new DefaultComboBoxModel(new String[] {"", "Course 1", "Course 2", "Course 3", "Course 4", "Course 5"}));
		GridBagConstraints gbc_courseSelect = new GridBagConstraints();
		gbc_courseSelect.gridwidth = 3;
		gbc_courseSelect.insets = new Insets(0, 0, 5, 5);
		gbc_courseSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_courseSelect.gridx = 8;
		gbc_courseSelect.gridy = 8;
		transcriptTab.add(courseSelect, gbc_courseSelect);
		
		JButton dropCourse = new JButton("Drop Course");
		dropCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(courseTable.getSelectedRow() >= 0){
					try{
						//The following gets the value at every textfield
						Integer studentID = null;
						//Removes student based on Student ID match
						studentID = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 0).toString());
						//String command = dropCourse.getSelected
						String command = (String) courseSelect.getSelectedItem();
						updateStudentModel updatedModel = new updateStudentModel(funcController.dropCourse(studentID, command));
						courseTable.setModel(updatedModel);
						mainModel updatePurposes = new mainModel(funcController.returnArrayList());
						searchTable.setModel(updatePurposes);
						modifyTable.setModel(updatePurposes);
					}
					catch (IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		GridBagConstraints gbc_dropCourse = new GridBagConstraints();
		gbc_dropCourse.insets = new Insets(0, 0, 5, 0);
		gbc_dropCourse.gridx = 11;
		gbc_dropCourse.gridy = 8;
		transcriptTab.add(dropCourse, gbc_dropCourse);
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.fill = GridBagConstraints.BOTH;
		gbc_separator_4.gridwidth = 12;
		gbc_separator_4.insets = new Insets(0, 0, 5, 0);
		gbc_separator_4.gridx = 0;
		gbc_separator_4.gridy = 9;
		transcriptTab.add(separator_4, gbc_separator_4);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridwidth = 12;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 10;
		transcriptTab.add(scrollPane_3, gbc_scrollPane_3);
		courseTable = new JTable();
			try {
				updateStudentModel updatedModel = new updateStudentModel(funcController.returnCouseArrayList());
				courseTable.setModel(updatedModel);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		scrollPane_3.setViewportView(courseTable);
		/*
		 * Adds transcript report button
		 * Under transcript tab
		 */
		JButton transcriptReport = new JButton("View Report");
		transcriptReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(courseTable.getSelectedRow() >= 0){
					try{
						Integer studentID = null;
						studentID = Integer.parseInt(courseTable.getValueAt(courseTable.getSelectedRow(), 0).toString());
						returnedItems = funcController.addToUpdateTable(studentID);
						transcriptReportView transcriptReportV = new transcriptReportView(returnedItems);
						transcriptReportV.setVisible(true);
					}
					catch(NumberFormatException e){
						System.out.println(e.getMessage());
						//e.printStackTrace();
						//JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					} catch (IOException e) {
						System.out.println(e.getMessage());
						//e.printStackTrace();
						//JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
						//e.printStackTrace();
						//JOptionPane.showMessageDialog(null, e.getMessage(), "Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		GridBagConstraints gbc_transcriptReport = new GridBagConstraints();
		gbc_transcriptReport.gridwidth = 12;
		gbc_transcriptReport.gridx = 0;
		gbc_transcriptReport.gridy = 11;
		transcriptTab.add(transcriptReport, gbc_transcriptReport);
		//Checks for the status of the window to see if it is open or not, if it is closed it will send back a false variable to be used.
		this.addWindowStateListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				funcController.stopConnection();
			}
		});
	}
}