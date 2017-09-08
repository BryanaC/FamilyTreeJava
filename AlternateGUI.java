package package1;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;

public class AlternateGUI extends JFrame implements ActionListener {

	/** Main Frame */
	public JFrame frame;

	/** Name Text Box */
	private JTextField NameTextField;

	/** Birthday Text Box */
	private JTextField BirthdayTextField;

	/** Gender Text Box */
	private JTextField GenderTextField;

	/** Eye Color Text Box */
	private JTextField EyeColorTextField;

	/** Mother Text Box */
	private JTextField textFieldMother;

	/** Father Text Box */
	private JTextField textFieldFather;

	/** Spouse Text Box */
	private JTextField textFieldSpouse;

	/** Gender Label */
	private JLabel lblGender;

	/** Gender Text Box */
	private JTextField GenderTxtField;

	/** Child Text Box */
	private JTextArea txtrChild;

	private JLabel lblPicture;

	/** Main Menu Bar */
	JMenuBar menuBar;

	/** File Menu */
	JMenu FileMenu;

	/** Load Menu Item */
	JMenuItem mntmLoad;

	/** Save Menu Item */
	JMenuItem mntmSave;

	/** Action Menu */
	JMenu mnActions;

	/** Edit Menu Item*/
	JMenuItem mntmEdit;

	JButton btnEditButton;

	/** Exit Menu Item */
	public JMenuItem mntmExit;

	/** Add Person Menu Item */
	public JMenuItem mntmAddPerson;

	/** Delete Person Menu Item */
	public JMenuItem mntmDeletePerson;

	/** Search Menu Item */
	public JMenuItem mntmSearch;

	/** Display of the library */
	public JList<FamilyTree> listDisplay;

	/** ArrayList of FamilyTrees */
	public TreeLibrary library;

	/*******************************************************************
	 *Constructor: Initializes look of the main page
	 ******************************************************************/
	public AlternateGUI() {
		frame = new JFrame("Family Tree");
		frame.setBackground(new Color(204, 255, 153));
		frame.setPreferredSize(new Dimension(700, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{199, 0, 122, 317, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 368, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(5, 0, 20, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		library = new TreeLibrary();

		listDisplay = new JList<FamilyTree>(library);
		listDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDisplay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setViewportView(listDisplay);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 7;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 3;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);

		JPanel BiographyPanel = new JPanel();
		tabbedPane.addTab("Biography", null, BiographyPanel, null);
		GridBagLayout gbl_BiographyPanel = new GridBagLayout();
		gbl_BiographyPanel.columnWidths = new int[]{118, 31, 0};
		gbl_BiographyPanel.rowHeights = new int[] {30, 30, 30, 30, 0, 30, 0, 0, 0, 0, 30, 80, 0};
		gbl_BiographyPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_BiographyPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		BiographyPanel.setLayout(gbl_BiographyPanel);

		lblPicture = new JLabel("");
		lblPicture.setIcon(new ImageIcon("C:\\Users\\Bryana\\workspace\\Family Tree\\src\\package1\\default.jpg"));
		GridBagConstraints gbc_lblPicture = new GridBagConstraints();
		gbc_lblPicture.gridheight = 4;
		gbc_lblPicture.gridwidth = 4;
		gbc_lblPicture.insets = new Insets(0, 0, 5, 0);
		gbc_lblPicture.gridx = 0;
		gbc_lblPicture.gridy = 1;
		BiographyPanel.add(lblPicture, gbc_lblPicture);

		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 6;
		BiographyPanel.add(lblName, gbc_lblName);

		NameTextField = new JTextField();
		NameTextField.setEditable(false);
		NameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_NameTextField = new GridBagConstraints();
		gbc_NameTextField.gridwidth = 2;
		gbc_NameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_NameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameTextField.gridx = 1;
		gbc_NameTextField.gridy = 6;
		BiographyPanel.add(NameTextField, gbc_NameTextField);
		NameTextField.setColumns(10);

		JLabel lblBirthDate = new JLabel("Birth Date:");
		GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
		gbc_lblBirthDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthDate.gridx = 0;
		gbc_lblBirthDate.gridy = 7;
		BiographyPanel.add(lblBirthDate, gbc_lblBirthDate);

		BirthdayTextField = new JTextField();
		BirthdayTextField.setEditable(false);
		GridBagConstraints gbc_BirthdayTextField = new GridBagConstraints();
		gbc_BirthdayTextField.gridwidth = 2;
		gbc_BirthdayTextField.insets = new Insets(0, 0, 5, 5);
		gbc_BirthdayTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_BirthdayTextField.gridx = 1;
		gbc_BirthdayTextField.gridy = 7;
		BiographyPanel.add(BirthdayTextField, gbc_BirthdayTextField);
		BirthdayTextField.setColumns(10);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 8;
		BiographyPanel.add(lblGender, gbc_lblGender);

		GenderTextField = new JTextField();
		GenderTextField.setEditable(false);
		GridBagConstraints gbc_GenderTextField = new GridBagConstraints();
		gbc_GenderTextField.gridwidth = 2;
		gbc_GenderTextField.insets = new Insets(0, 0, 5, 5);
		gbc_GenderTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_GenderTextField.gridx = 1;
		gbc_GenderTextField.gridy = 8;
		BiographyPanel.add(GenderTextField, gbc_GenderTextField);
		GenderTextField.setColumns(10);

		JLabel lblEyeColor = new JLabel("Eye Color:");
		GridBagConstraints gbc_lblEyeColor = new GridBagConstraints();
		gbc_lblEyeColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblEyeColor.gridx = 0;
		gbc_lblEyeColor.gridy = 9;
		BiographyPanel.add(lblEyeColor, gbc_lblEyeColor);

		EyeColorTextField = new JTextField();
		EyeColorTextField.setEditable(false);
		GridBagConstraints gbc_EyeColorTextField = new GridBagConstraints();
		gbc_EyeColorTextField.gridwidth = 2;
		gbc_EyeColorTextField.insets = new Insets(0, 0, 5, 5);
		gbc_EyeColorTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_EyeColorTextField.gridx = 1;
		gbc_EyeColorTextField.gridy = 9;
		BiographyPanel.add(EyeColorTextField, gbc_EyeColorTextField);
		EyeColorTextField.setColumns(10);

		btnEditButton = new JButton("Edit");
		GridBagConstraints gbc_btnEditButton = new GridBagConstraints();
		gbc_btnEditButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditButton.gridwidth = 5;
		gbc_btnEditButton.gridx = 0;
		gbc_btnEditButton.gridy = 10;
		BiographyPanel.add(btnEditButton, gbc_btnEditButton);

		JPanel FamilyPanel = new JPanel();
		tabbedPane.addTab("Family", null, FamilyPanel, null);
		GridBagLayout gbl_FamilyPanel = new GridBagLayout();
		gbl_FamilyPanel.columnWidths = new int[] {110, 200, 20};
		gbl_FamilyPanel.rowHeights = new int[] {30, 30, 30, 0, 0, 0, 30, 0, 210, 262, 0};
		gbl_FamilyPanel.columnWeights = new double[]{1.0, 0.0};
		gbl_FamilyPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		FamilyPanel.setLayout(gbl_FamilyPanel);

		JLabel label_1 = new JLabel("Mother:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		FamilyPanel.add(label_1, gbc_label_1);

		textFieldMother = new JTextField();
		textFieldMother.setEditable(false);
		textFieldMother.setColumns(10);
		GridBagConstraints gbc_textFieldMother = new GridBagConstraints();
		gbc_textFieldMother.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMother.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMother.gridx = 1;
		gbc_textFieldMother.gridy = 3;
		FamilyPanel.add(textFieldMother, gbc_textFieldMother);

		JLabel label_2 = new JLabel("Father:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		FamilyPanel.add(label_2, gbc_label_2);

		textFieldFather = new JTextField();
		textFieldFather.setEditable(false);
		textFieldFather.setColumns(10);
		GridBagConstraints gbc_textFieldFather = new GridBagConstraints();
		gbc_textFieldFather.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFather.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFather.gridx = 1;
		gbc_textFieldFather.gridy = 4;
		FamilyPanel.add(textFieldFather, gbc_textFieldFather);

		JLabel label_3 = new JLabel("Spouse:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 5;
		FamilyPanel.add(label_3, gbc_label_3);

		textFieldSpouse = new JTextField();
		textFieldSpouse.setEditable(false);
		textFieldSpouse.setColumns(10);
		GridBagConstraints gbc_textFieldSpouse = new GridBagConstraints();
		gbc_textFieldSpouse.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSpouse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSpouse.gridx = 1;
		gbc_textFieldSpouse.gridy = 5;
		FamilyPanel.add(textFieldSpouse, gbc_textFieldSpouse);

		JLabel label_4 = new JLabel("Children:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.gridwidth = 3;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 7;
		FamilyPanel.add(label_4, gbc_label_4);

		txtrChild = new JTextArea();
		txtrChild.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 20, 15, 20);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 8;
		FamilyPanel.add(txtrChild, gbc_textArea);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		FileMenu = new JMenu("File");
		menuBar.add(FileMenu);

		mntmLoad = new JMenuItem("Load");
		FileMenu.add(mntmLoad);

		mntmSave = new JMenuItem("Save");
		FileMenu.add(mntmSave);

		mntmExit = new JMenuItem("Exit");
		FileMenu.add(mntmExit);

		mnActions = new JMenu("Actions");
		menuBar.add(mnActions);

		mntmAddPerson = new JMenuItem("Add Person");
		mnActions.add(mntmAddPerson);

		mntmDeletePerson = new JMenuItem("Delete Person");
		mnActions.add(mntmDeletePerson);

		mntmEdit = new JMenuItem("Edit");
		mnActions.add(mntmEdit);

		mntmSearch = new JMenuItem("Search");
		mnActions.add(mntmSearch);

		// Sets the frame to visible
		frame.pack();
		frame.setVisible(true);

		mntmEdit.addActionListener(this);
		mntmExit.addActionListener(this);
		mntmAddPerson.addActionListener(this);
		mntmDeletePerson.addActionListener(this);
		mntmSearch.addActionListener(this);
		mntmSave.addActionListener(this);
		btnEditButton.addActionListener(this);
		mntmLoad.addActionListener(this);

		listDisplay.addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {

					if (listDisplay.getSelectedIndex() == -1) {
						//No selection, disable fire button.
						JOptionPane.showMessageDialog(frame, "No selection made");

					} else {
						//Selection, enable the fire button.
						int index = listDisplay.getSelectedIndex();
						FamilyTree selected = library.getElementAt(index);

						String imgFile = selected.getRoot().getImageFilename();
						String name = selected.getRoot().getName();
						String Gender = selected.getRoot().getGender().toString();
						String EyeColor = selected.getRoot().getEyeColor().toString();

						String maName = "";
						String paName = "";
						String spName = "";
						String childNames = "";
						String Birthdate = "Unknown";

						if(selected.getRoot().getbDay() != null){
							Birthdate = selected.getRoot().bDayToString();
						}

						if(selected.getMother() != null){
							maName = selected.getMother().getName();
						}
						if(selected.getFather() != null){
							paName = selected.getFather().getName();
						}
						if(selected.getSpouse() != null){
							spName = selected.getSpouse().getName();
						}
						if(selected.getChildrenList().size() != 0){
							childNames = selected.childToString(selected.getChildrenList());
						}

						lblPicture.setIcon(new ImageIcon(imgFile));
						NameTextField.setText(name);
						if(Birthdate.isEmpty()){
							BirthdayTextField.setText("");
						}else{
							BirthdayTextField.setText(Birthdate);
						}
						GenderTextField.setText(Gender);
						EyeColorTextField.setText(EyeColor);
						textFieldMother.setText(maName);
						textFieldFather.setText(paName);
						textFieldSpouse.setText(spName);
						if(!childNames.isEmpty()){
							txtrChild.setText(childNames);
						}else{
							txtrChild.setText("");
						}
					}
				}
			}
		});
	}

	/*******************************************************************
	 *Helper: Attaches actions to events
	 *@param e An event from the user
	 ******************************************************************/
	public void actionPerformed(ActionEvent e) {

		if (mntmDeletePerson == e.getSource()){
			int index = listDisplay.getSelectedIndex();
			if (index != -1){
				library.remove(index);
				// remove from spouse and children as well
			}else{
				JOptionPane.showMessageDialog(frame, "No selection made");
			}
		}
		if (mntmAddPerson == e.getSource()){
			FamilyTree person = new FamilyTree();
			DialogAddPerson dialog = new DialogAddPerson(this,person, library);
			if(dialog.getCloseStatus() && !dialog.getCancelStatus()){
				library = dialog.getLibrary();
				library.add(dialog.getTree());
				library.update();
			}

			dialog.setModal(true);
		}
		if (mntmExit == e.getSource() && JOptionPane.showConfirmDialog(null,
				"Are you sure?") == 0) {
			System.exit(1);
		}else{
			// do nothing
		}
		if (mntmEdit == e.getSource() || btnEditButton == e.getSource()){
			int index = listDisplay.getSelectedIndex();
			if (index == -1) {
				JOptionPane.showMessageDialog(frame, "No selection made");
				return;
			}else{
				FamilyTree person = library.getElementAt(index);
				EditPersonDialog dialog = new EditPersonDialog(this,person);
				dialog.setModal(true);
				person = dialog.getTree();

				library.update();
				listDisplay.setModel(library);
			}
		}
		if (mntmSearch == e.getSource()) {

			// User inputs search criteria
			String s = 
					JOptionPane.showInputDialog(frame, 
							"What would you like to search for?");

			// Result starts empty
			String result2 = "";

			if(s != null){
				// Checks each item in the JList
				for(int i = 0; i < library.getSize(); i++) {

					// Gets the name of the person in the list
					String name = library.getElementAt(i).toString();

					// Checks if search criteria is part of the name
					if(name.toLowerCase().contains(s.toLowerCase()))
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

		if (mntmExit == e.getSource() && JOptionPane.showConfirmDialog(null,
				"Are you sure?") == 0) {
			System.exit(1);
		}if (mntmLoad == e.getSource()){
			library.loadSerializable(this);
			listDisplay.setModel(library);
			library.update();
		}if (mntmSave == e.getSource()){
			library.saveSerializable(this);
		}if (mntmEdit == e.getSource()){
			int index = listDisplay.getSelectedIndex();
			FamilyTree tree = new FamilyTree();
			tree = library.getElementAt(index);
			EditPersonDialog editDialog = new EditPersonDialog(this, tree);
			library = editDialog.getLibrary();
		}
	}

	/******************************************************************
	 * Main method to run the GUI
	 * @param args
	 *****************************************************************/
	public static void main (String[] args) {
		new AlternateGUI();
	}
}
