import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
public class transcriptReportView extends JFrame {
	/*
	 * This JFrame will display the student transcript, the values are processed and sent to the mainframe where they are then passed in through the
	 * constructor of this class. The rest of the GUI elements in this class were created using Window Builder.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStudentName;
	private JLabel lblCourse;
	private JLabel lblYear;
	private JLabel lblCredit;
	private JLabel lblInitials;
	private JTextField firstName;
	private JTextField studentID;
	private JTextField credit1;
	private JTextField grade1;
	private JTextField course1;
	private JTextField course2;
	private JTextField course3;
	private JTextField course4;
	private JTextField Initial;
	private JTextField lastName;
	private JTextField grade2;
	private JTextField credit2;
	private JTextField grade3;
	private JTextField credit3;
	private JTextField credit4;
	private JTextField grade5;
	private JTextField grade4;
	private JTextField credit5;
	private JTextField course5;
	private JTextField CCredits;
	private JTextField CurrentGPA;
	private JTextField CCGPA;
	private JLabel lblComulativeCredits;
	private JLabel lblCurrentGpa;
	private JLabel lblCumulativeGpa;
	private JSeparator separator;
	private JLabel lblGradeReportSemester;
	private String[] transcript;
	/**
	 * Create the frame.
	 */
	/*
	 * The View - Transcript Report View
	 */
	/*
	 * This code was created using Window Builder - It will be commented on later in the next coursework
	 */
	public transcriptReportView(String variable[]) {
		this.transcript = variable;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 704, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{94, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblGradeReportSemester = new JLabel("GRADE REPORT SEMESTER X");
		GridBagConstraints gbc_lblGradeReportSemester = new GridBagConstraints();
		gbc_lblGradeReportSemester.gridwidth = 7;
		gbc_lblGradeReportSemester.insets = new Insets(0, 0, 5, 5);
		gbc_lblGradeReportSemester.gridx = 0;
		gbc_lblGradeReportSemester.gridy = 0;
		contentPane.add(lblGradeReportSemester, gbc_lblGradeReportSemester);
		
		lblStudentName = new JLabel("Student Name");
		GridBagConstraints gbc_lblStudentName = new GridBagConstraints();
		gbc_lblStudentName.anchor = GridBagConstraints.EAST;
		gbc_lblStudentName.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentName.gridx = 0;
		gbc_lblStudentName.gridy = 1;
		contentPane.add(lblStudentName, gbc_lblStudentName);
		
		firstName = new JTextField();
		firstName.setEditable(false);
		GridBagConstraints gbc_firstName = new GridBagConstraints();
		gbc_firstName.insets = new Insets(0, 0, 5, 5);
		gbc_firstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstName.gridx = 1;
		gbc_firstName.gridy = 1;
		contentPane.add(firstName, gbc_firstName);
		firstName.setColumns(10);
		
		Initial = new JTextField();
		Initial.setEditable(false);
		Initial.setColumns(10);
		GridBagConstraints gbc_Initial = new GridBagConstraints();
		gbc_Initial.insets = new Insets(0, 0, 5, 5);
		gbc_Initial.fill = GridBagConstraints.HORIZONTAL;
		gbc_Initial.gridx = 3;
		gbc_Initial.gridy = 1;
		contentPane.add(Initial, gbc_Initial);
		
		lastName = new JTextField();
		lastName.setEditable(false);
		lastName.setColumns(10);
		GridBagConstraints gbc_lastName = new GridBagConstraints();
		gbc_lastName.insets = new Insets(0, 0, 5, 5);
		gbc_lastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastName.gridx = 5;
		gbc_lastName.gridy = 1;
		contentPane.add(lastName, gbc_lastName);
		
		lblInitials = new JLabel("Student ID");
		GridBagConstraints gbc_lblInitials = new GridBagConstraints();
		gbc_lblInitials.anchor = GridBagConstraints.EAST;
		gbc_lblInitials.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitials.gridx = 0;
		gbc_lblInitials.gridy = 2;
		contentPane.add(lblInitials, gbc_lblInitials);
		
		studentID = new JTextField();
		studentID.setEditable(false);
		studentID.setColumns(10);
		GridBagConstraints gbc_studentID = new GridBagConstraints();
		gbc_studentID.insets = new Insets(0, 0, 5, 5);
		gbc_studentID.fill = GridBagConstraints.HORIZONTAL;
		gbc_studentID.gridx = 1;
		gbc_studentID.gridy = 2;
		contentPane.add(studentID, gbc_studentID);
		
		lblCourse = new JLabel("Course");
		GridBagConstraints gbc_lblCourse = new GridBagConstraints();
		gbc_lblCourse.insets = new Insets(0, 0, 5, 5);
		gbc_lblCourse.gridx = 1;
		gbc_lblCourse.gridy = 4;
		contentPane.add(lblCourse, gbc_lblCourse);
		
		lblYear = new JLabel("Grade");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 3;
		gbc_lblYear.gridy = 4;
		contentPane.add(lblYear, gbc_lblYear);
		
		lblCredit = new JLabel("Credits");
		GridBagConstraints gbc_lblCredit = new GridBagConstraints();
		gbc_lblCredit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredit.gridx = 5;
		gbc_lblCredit.gridy = 4;
		contentPane.add(lblCredit, gbc_lblCredit);
		
		course1 = new JTextField();
		course1.setEditable(false);
		course1.setColumns(10);
		GridBagConstraints gbc_course1 = new GridBagConstraints();
		gbc_course1.insets = new Insets(0, 0, 5, 5);
		gbc_course1.fill = GridBagConstraints.HORIZONTAL;
		gbc_course1.gridx = 1;
		gbc_course1.gridy = 5;
		contentPane.add(course1, gbc_course1);
		
		grade1 = new JTextField();
		grade1.setEditable(false);
		grade1.setColumns(10);
		GridBagConstraints gbc_grade1 = new GridBagConstraints();
		gbc_grade1.insets = new Insets(0, 0, 5, 5);
		gbc_grade1.fill = GridBagConstraints.HORIZONTAL;
		gbc_grade1.gridx = 3;
		gbc_grade1.gridy = 5;
		contentPane.add(grade1, gbc_grade1);
		
		credit1 = new JTextField();
		credit1.setEditable(false);
		credit1.setColumns(10);
		GridBagConstraints gbc_credit1 = new GridBagConstraints();
		gbc_credit1.insets = new Insets(0, 0, 5, 5);
		gbc_credit1.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit1.gridx = 5;
		gbc_credit1.gridy = 5;
		contentPane.add(credit1, gbc_credit1);
		
		course2 = new JTextField();
		course2.setEditable(false);
		course2.setColumns(10);
		GridBagConstraints gbc_course2 = new GridBagConstraints();
		gbc_course2.insets = new Insets(0, 0, 5, 5);
		gbc_course2.fill = GridBagConstraints.HORIZONTAL;
		gbc_course2.gridx = 1;
		gbc_course2.gridy = 6;
		contentPane.add(course2, gbc_course2);
		
		grade2 = new JTextField();
		grade2.setEditable(false);
		grade2.setColumns(10);
		GridBagConstraints gbc_grade2 = new GridBagConstraints();
		gbc_grade2.insets = new Insets(0, 0, 5, 5);
		gbc_grade2.fill = GridBagConstraints.HORIZONTAL;
		gbc_grade2.gridx = 3;
		gbc_grade2.gridy = 6;
		contentPane.add(grade2, gbc_grade2);
		
		credit2 = new JTextField();
		credit2.setEditable(false);
		credit2.setColumns(10);
		GridBagConstraints gbc_credit2 = new GridBagConstraints();
		gbc_credit2.insets = new Insets(0, 0, 5, 5);
		gbc_credit2.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit2.gridx = 5;
		gbc_credit2.gridy = 6;
		contentPane.add(credit2, gbc_credit2);
		
		course3 = new JTextField();
		course3.setEditable(false);
		course3.setColumns(10);
		GridBagConstraints gbc_course3 = new GridBagConstraints();
		gbc_course3.insets = new Insets(0, 0, 5, 5);
		gbc_course3.fill = GridBagConstraints.HORIZONTAL;
		gbc_course3.gridx = 1;
		gbc_course3.gridy = 7;
		contentPane.add(course3, gbc_course3);
		
		grade3 = new JTextField();
		grade3.setEditable(false);
		grade3.setColumns(10);
		GridBagConstraints gbc_grade3 = new GridBagConstraints();
		gbc_grade3.insets = new Insets(0, 0, 5, 5);
		gbc_grade3.fill = GridBagConstraints.HORIZONTAL;
		gbc_grade3.gridx = 3;
		gbc_grade3.gridy = 7;
		contentPane.add(grade3, gbc_grade3);
		
		credit3 = new JTextField();
		credit3.setEditable(false);
		credit3.setColumns(10);
		GridBagConstraints gbc_credit3 = new GridBagConstraints();
		gbc_credit3.insets = new Insets(0, 0, 5, 5);
		gbc_credit3.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit3.gridx = 5;
		gbc_credit3.gridy = 7;
		contentPane.add(credit3, gbc_credit3);
		
		course4 = new JTextField();
		course4.setEditable(false);
		course4.setColumns(10);
		GridBagConstraints gbc_course4 = new GridBagConstraints();
		gbc_course4.insets = new Insets(0, 0, 5, 5);
		gbc_course4.fill = GridBagConstraints.HORIZONTAL;
		gbc_course4.gridx = 1;
		gbc_course4.gridy = 8;
		contentPane.add(course4, gbc_course4);
		
		grade4 = new JTextField();
		grade4.setEditable(false);
		grade4.setColumns(10);
		GridBagConstraints gbc_grade4 = new GridBagConstraints();
		gbc_grade4.insets = new Insets(0, 0, 5, 5);
		gbc_grade4.fill = GridBagConstraints.HORIZONTAL;
		gbc_grade4.gridx = 3;
		gbc_grade4.gridy = 8;
		contentPane.add(grade4, gbc_grade4);
		
		credit4 = new JTextField();
		credit4.setEditable(false);
		credit4.setColumns(10);
		GridBagConstraints gbc_credit4 = new GridBagConstraints();
		gbc_credit4.insets = new Insets(0, 0, 5, 5);
		gbc_credit4.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit4.gridx = 5;
		gbc_credit4.gridy = 8;
		contentPane.add(credit4, gbc_credit4);
		
		course5 = new JTextField();
		course5.setEditable(false);
		course5.setColumns(10);
		GridBagConstraints gbc_course5 = new GridBagConstraints();
		gbc_course5.insets = new Insets(0, 0, 5, 5);
		gbc_course5.fill = GridBagConstraints.HORIZONTAL;
		gbc_course5.gridx = 1;
		gbc_course5.gridy = 9;
		contentPane.add(course5, gbc_course5);
		
		grade5 = new JTextField();
		grade5.setEditable(false);
		grade5.setColumns(10);
		GridBagConstraints gbc_grade5 = new GridBagConstraints();
		gbc_grade5.insets = new Insets(0, 0, 5, 5);
		gbc_grade5.fill = GridBagConstraints.HORIZONTAL;
		gbc_grade5.gridx = 3;
		gbc_grade5.gridy = 9;
		contentPane.add(grade5, gbc_grade5);
		
		credit5 = new JTextField();
		credit5.setEditable(false);
		credit5.setColumns(10);
		GridBagConstraints gbc_credit5 = new GridBagConstraints();
		gbc_credit5.insets = new Insets(0, 0, 5, 5);
		gbc_credit5.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit5.gridx = 5;
		gbc_credit5.gridy = 9;
		contentPane.add(credit5, gbc_credit5);
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridwidth = 7;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 11;
		contentPane.add(separator, gbc_separator);
		
		lblComulativeCredits = new JLabel("Cumulative Credits");
		GridBagConstraints gbc_lblComulativeCredits = new GridBagConstraints();
		gbc_lblComulativeCredits.insets = new Insets(0, 0, 5, 5);
		gbc_lblComulativeCredits.anchor = GridBagConstraints.EAST;
		gbc_lblComulativeCredits.gridx = 1;
		gbc_lblComulativeCredits.gridy = 12;
		contentPane.add(lblComulativeCredits, gbc_lblComulativeCredits);
		
		CCredits = new JTextField();
		CCredits.setEditable(false);
		CCredits.setColumns(10);
		GridBagConstraints gbc_CCredits = new GridBagConstraints();
		gbc_CCredits.insets = new Insets(0, 0, 5, 5);
		gbc_CCredits.fill = GridBagConstraints.HORIZONTAL;
		gbc_CCredits.gridx = 3;
		gbc_CCredits.gridy = 12;
		contentPane.add(CCredits, gbc_CCredits);
		
		lblCurrentGpa = new JLabel("Current GPA");
		GridBagConstraints gbc_lblCurrentGpa = new GridBagConstraints();
		gbc_lblCurrentGpa.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentGpa.anchor = GridBagConstraints.EAST;
		gbc_lblCurrentGpa.gridx = 1;
		gbc_lblCurrentGpa.gridy = 13;
		contentPane.add(lblCurrentGpa, gbc_lblCurrentGpa);
		
		CurrentGPA = new JTextField();
		CurrentGPA.setEditable(false);
		CurrentGPA.setColumns(10);
		GridBagConstraints gbc_CurrentGPA = new GridBagConstraints();
		gbc_CurrentGPA.insets = new Insets(0, 0, 5, 5);
		gbc_CurrentGPA.fill = GridBagConstraints.HORIZONTAL;
		gbc_CurrentGPA.gridx = 3;
		gbc_CurrentGPA.gridy = 13;
		contentPane.add(CurrentGPA, gbc_CurrentGPA);
		
		lblCumulativeGpa = new JLabel("Cumulative GPA");
		GridBagConstraints gbc_lblCumulativeGpa = new GridBagConstraints();
		gbc_lblCumulativeGpa.insets = new Insets(0, 0, 0, 5);
		gbc_lblCumulativeGpa.anchor = GridBagConstraints.EAST;
		gbc_lblCumulativeGpa.gridx = 1;
		gbc_lblCumulativeGpa.gridy = 14;
		contentPane.add(lblCumulativeGpa, gbc_lblCumulativeGpa);
		
		CCGPA = new JTextField();
		CCGPA.setEditable(false);
		CCGPA.setColumns(10);
		GridBagConstraints gbc_CCGPA = new GridBagConstraints();
		gbc_CCGPA.insets = new Insets(0, 0, 0, 5);
		gbc_CCGPA.fill = GridBagConstraints.HORIZONTAL;
		gbc_CCGPA.gridx = 3;
		gbc_CCGPA.gridy = 14;
		contentPane.add(CCGPA, gbc_CCGPA);
		
		studentID.setText(transcript[0].toString());
		firstName.setText(transcript[1].toString());
		Initial.setText(transcript[2].toString());
		lastName.setText(transcript[3].toString());
		course1.setText(transcript[4].toString());
		course2.setText(transcript[5].toString());
		course3.setText(transcript[6].toString());
		course4.setText(transcript[7].toString());
		course5.setText(transcript[8].toString());
		grade1.setText(transcript[9].toString());
		grade2.setText(transcript[10].toString());
		grade3.setText(transcript[11].toString());
		grade4.setText(transcript[12].toString());
		grade5.setText(transcript[13].toString());
		credit1.setText(transcript[14].toString());
		credit2.setText(transcript[15].toString());
		credit3.setText(transcript[16].toString());
		credit4.setText(transcript[17].toString());
		credit5.setText(transcript[18].toString());
		CCredits.setText(transcript[19].toString());
		CurrentGPA.setText(transcript[20].toString());
		CCGPA.setText(transcript[21].toString());
	}
}
