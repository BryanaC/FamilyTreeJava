package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame implements ActionListener {

	/** Library of People */
	public static TreeLibrary plist;

	/** Display of Lists */
	public JList listDisplay;

	/** Main Frame*/
	public JFrame frame;

	/** Main Menu Bar */
	public JMenuBar menuBar;

	/** File Menu */
	public JMenu File;

	/** Action Menu */
	public JMenu Action;

	/** Open Menu Item */
	public JMenuItem OpenSerial;

	/** Save Menu Item */
	public JMenuItem SaveSerial;

	/** Exit Menu Item */
	public JMenuItem Exit;

	/** Add Person Menu Item */
	public JMenuItem AddPerson;

	/** Delete Person Menu Item */
	public JMenuItem DeletePerson;

	/** Search Menu Item */
	public JMenuItem Search;

	/** Main Panel */
	private JPanel panel;

	/** Right Panel */
	private JPanel panel_2;

	/** Left Panel */
	private JPanel panel_3;

	/** Center Panel */
	private JPanel panel_1;

	/** Mother Label */
	private JLabel lblMother;

	/** Father Label */
	private JLabel lblFather;

	/** Spouse Label */
	private JLabel lblSpouse;

	/** Child Label */
	private JLabel lblChildren;

	/** Mother Text Box */
	private JTextField MotherTxtField;

	/** Father Text Box */
	private JTextField FatherTxtField;

	/** Spouse Text Box */
	private JTextField SpouseTxtField;

	/** Gender Label */
	private JLabel lblGender;

	/** Gender Text Box */
	private JTextField GenderTxtField;

	/** Child Text Box */
	private JTextArea txtrChild;


	/*******************************************************************
	 *Constructor: Initializes look of the main page
	 ******************************************************************/
	public GUI() {

		frame = new JFrame("Family Tree");
		frame.setBackground(new Color(204, 255, 153));
		frame.setPreferredSize(new Dimension(700, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		plist = new TreeLibrary();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {228, 456, 0};
		gridBagLayout.rowHeights = new int[]{440, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		// Creates a JList
		listDisplay = new JList<TreeLibrary>(plist);
		JScrollPane scrollPane = new JScrollPane(listDisplay);
		scrollPane.setPreferredSize(new Dimension(2, 1));

		// Sets the scroll bar to the JList
		scrollPane.setViewportView(listDisplay);

		// Adds the scrollable JList
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;

		//Instantiates the main Panel
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{228, 228, 0};
		gbl_panel.rowHeights = new int[]{455, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		//Instantiates panel_2
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {100};
		gbl_panel_2.rowHeights = new int[] {300, 30};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0};
		panel_2.setLayout(gbl_panel_2);

		//Instantiates panel_1 and adds it to panel_2
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_2.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {200, 0};
		gbl_panel_1.rowHeights = new int[] {30, 20, 30, 30, 30, 30, 30, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);

		//Adds mother Label and text field to panel_1
		lblMother = new JLabel("Mother:  ");
		GridBagConstraints gbc_lblMother = new GridBagConstraints();
		gbc_lblMother.gridwidth = 5;
		gbc_lblMother.insets = new Insets(0, 0, 5, 0);
		gbc_lblMother.gridx = 0;
		gbc_lblMother.gridy = 0;
		panel_1.add(lblMother, gbc_lblMother);

		MotherTxtField = new JTextField();
		MotherTxtField.setEditable(false);
		MotherTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_MotherTxtField = new GridBagConstraints();
		gbc_MotherTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_MotherTxtField.anchor = GridBagConstraints.NORTH;
		gbc_MotherTxtField.insets = new Insets(5, 10, 5, 10);
		gbc_MotherTxtField.gridwidth = 5;
		gbc_MotherTxtField.gridx = 0;
		gbc_MotherTxtField.gridy = 1;
		panel_1.add(MotherTxtField, gbc_MotherTxtField);
		MotherTxtField.setColumns(10);

		//Adds Father Label and text field to panel_1
		lblFather = new JLabel("Father:");
		GridBagConstraints gbc_lblFather = new GridBagConstraints();
		gbc_lblFather.gridwidth = 5;
		gbc_lblFather.insets = new Insets(0, 0, 5, 0);
		gbc_lblFather.gridx = 0;
		gbc_lblFather.gridy = 2;
		panel_1.add(lblFather, gbc_lblFather);

		FatherTxtField = new JTextField();
		FatherTxtField.setEditable(false);
		FatherTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_FatherTxtField = new GridBagConstraints();
		gbc_FatherTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_FatherTxtField.anchor = GridBagConstraints.NORTH;
		gbc_FatherTxtField.insets = new Insets(5, 10, 5, 10);
		gbc_FatherTxtField.gridwidth = 5;
		gbc_FatherTxtField.gridx = 0;
		gbc_FatherTxtField.gridy = 3;
		panel_1.add(FatherTxtField, gbc_FatherTxtField);
		FatherTxtField.setColumns(10);

		//Adds Spouse Label and text field to panel_1
		lblSpouse = new JLabel("Spouse: ");
		GridBagConstraints gbc_lblSpouse = new GridBagConstraints();
		gbc_lblSpouse.gridwidth = 5;
		gbc_lblSpouse.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpouse.gridx = 0;
		gbc_lblSpouse.gridy = 4;
		panel_1.add(lblSpouse, gbc_lblSpouse);

		SpouseTxtField = new JTextField();
		SpouseTxtField.setEditable(false);
		SpouseTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_SpouseTxtField = new GridBagConstraints();
		gbc_SpouseTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SpouseTxtField.anchor = GridBagConstraints.NORTH;
		gbc_SpouseTxtField.insets = new Insets(5, 10, 5, 10);
		gbc_SpouseTxtField.gridwidth = 5;
		gbc_SpouseTxtField.gridx = 0;
		gbc_SpouseTxtField.gridy = 5;
		panel_1.add(SpouseTxtField, gbc_SpouseTxtField);
		SpouseTxtField.setColumns(10);

		//Adds Gender Label and pull down to panel_1
		lblGender = new JLabel("Gender");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.insets = new Insets(0, 0, 5, 0);
		gbc_lblGender.gridwidth = 5;
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 6;
		panel_1.add(lblGender, gbc_lblGender);

		GenderTxtField = new JTextField();
		GenderTxtField.setEditable(false);
		GenderTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_GenderTxtField = new GridBagConstraints();
		gbc_GenderTxtField.insets = new Insets(5, 10, 5, 10);
		gbc_GenderTxtField.gridwidth = 5;
		gbc_GenderTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_GenderTxtField.gridx = 0;
		gbc_GenderTxtField.gridy = 7;
		panel_1.add(GenderTxtField, gbc_GenderTxtField);
		GenderTxtField.setColumns(10);

		//Instantiates Panel_3
		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{171, 0};
		gbl_panel_3.rowHeights = new int[] {50, 390, 30, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);

		//Adds Children Lable and list to panel_3
		lblChildren = new JLabel("Children:");
		GridBagConstraints gbc_lblChildren = new GridBagConstraints();
		gbc_lblChildren.anchor = GridBagConstraints.SOUTH;
		gbc_lblChildren.insets = new Insets(0, 0, 5, 0);
		gbc_lblChildren.gridx = 0;
		gbc_lblChildren.gridy = 0;
		panel_3.add(lblChildren, gbc_lblChildren);

		txtrChild = new JTextArea();
		txtrChild.setEditable(false);
		GridBagConstraints gbc_txtrChildlist1 = new GridBagConstraints();
		gbc_txtrChildlist1.fill = GridBagConstraints.BOTH;
		gbc_txtrChildlist1.insets = new Insets(0, 10, 5, 10);
		gbc_txtrChildlist1.gridx = 0;
		gbc_txtrChildlist1.gridy = 1;
		panel_3.add(txtrChild, gbc_txtrChildlist1);

		// Creates the new menu bar
		menuBar = new JMenuBar();

		// Creates the File Menu and its items
		File = new JMenu("File");
		OpenSerial = new JMenuItem("Open Serial...");
		SaveSerial = new JMenuItem("Save Serial");
		Exit = new JMenuItem("Exit");

		// Adds the File Menu, its separators, and its items
		File.add(OpenSerial);
		File.add(SaveSerial);
		File.addSeparator();
		File.add(Exit);

		// Creates the action menu and its items
		Action = new JMenu("Action");
		AddPerson = new JMenuItem("Add Person");
		DeletePerson = new JMenuItem("Delete Person");
		Search = new JMenuItem("Search");

		// Adds the action menu, its separators, and its items
		Action.add(AddPerson);
		Action.addSeparator();
		Action.add(DeletePerson);
		Action.add(Search);

		// Adds the action listeners for all of the MenuItems
		AddPerson.addActionListener(this);
		DeletePerson.addActionListener(this);
		OpenSerial.addActionListener(this);
		SaveSerial.addActionListener(this);
		Search.addActionListener(this);
		Exit.addActionListener(this);

		listDisplay.addTreeSelectionListener(listSelectionListener);

		// Adds the Menus to the menu bar
		menuBar.add(File);
		menuBar.add(Action);

		// Places the menu bar on the frame
		frame.setJMenuBar(menuBar);

		// Sets the frame to visible
		frame.pack();
		frame.setVisible(true);
	}

	ListSelectionListener listSelectionListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent listSelectionEvent) {

			MotherTxtField.setText("");
			FatherTxtField.setText("");
			SpouseTxtField.setText("");
			txtrChild.setText("");

			int index = listDisplay.getSelectedIndex();

			//If a name is selected the information on the person selected is displayed 
			//in the center or panel_1
			if (index != -1){
				FamilyTree selected = plist.get(index);

				//sets all names to null
				String moName = null, faName = null, maName = null;

				//updates names if available 
				if(selected.getMother() != null){
					moName = selected.getMother().getName();
				}
				if(selected.getFather() != null){
					faName = selected.getFather().getName();
				}
				if(selected.getSpouse() != null){
					maName = selected.getSpouse().getName();
				}

				//Updates the GUI
				if(moName == null){

				}else{
					MotherTxtField.setText(moName);
				}
				if(faName == null){

				}else{
					FatherTxtField.setText(faName);
				}
				if(maName == null){
				}else{
					SpouseTxtField.setText(maName);
				}
				GenderTxtField.setText(selected.getRoot().genderToString());
				txtrChild.setText(selected.childToString(selected.getChildrenList()));
			}
		}
	};

	/*******************************************************************
	 *Helper: Attaches actions to events
	 *@param e An event from the user
	 ******************************************************************/
	public void actionPerformed(ActionEvent e) {

		int index = listDisplay.getSelectedIndex();

		//Deletes a person
		if (DeletePerson == e.getSource()) {
			if(index != -1){
				plist.remove(index);
			}else{
				JOptionPane.showMessageDialog(frame, "No selection made");
			}
		}

		//Adds a person
		if (AddPerson == e.getSource()) {
			FamilyTree person = new FamilyTree();
			DialogAddPerson dialog = new DialogAddPerson(this,person);

			if(person.getRoot().getName() != null){
				plist.add(person);
			}
			dialog.setModal(true);
		}

		// If search item is selected
		if (Search == e.getSource()) {

			// User inputs search criteria
			String s = 
					JOptionPane.showInputDialog(frame, 
							"What would you like to search for?");

			// Result starts empty
			String result2 = "";

			if(s != null){
				// Checks each item in the JList
				for(int i = 0; i < plist.getSize(); i++) {

					// Gets the name of the person in the list
					String name = plist.get(i).toString();

					// Checks if search criteria is part of the name
					if(name.contains(s))
					{
						// Adds person to the list
						result2 += name + "\n";
					}
				}

				// Displays the list of items containing the search criteria
				// in the title
				JOptionPane.showMessageDialog(null, result2);
			}
		}

		// If the save serial item is selected
		if (SaveSerial == e.getSource()){
			plist.saveSerializable(this);
		}else{
			// do nothing
		}

		// If the load serial item is selected
		if (OpenSerial == e.getSource()){
			plist.loadSerializable(this);
		}else{
			// do nothing
		}

		if (Exit == e.getSource() && JOptionPane.showConfirmDialog(null,
				"Are you sure?") == 0) {
			System.exit(1);
		}else{
			// do nothing
		}

	}


	/******************************************************************
	 * Helper: Gets and returns the plist
	 * @return plist a list of ...
	 *****************************************************************/
	static public TreeLibrary getList(){
		return plist;
	}

	/******************************************************************
	 * Main method to run the GUI
	 * @param args
	 *****************************************************************/
	public static void main (String[] args) {
		new GUI();
	}
}
