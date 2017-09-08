package package1;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class EditPersonDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Name Text box */
	private JTextField nameField;

	/** Mother Text box */
	private JTextField motherField;

	/** Father Text box */
	private JTextField fatherField;

	/** Spouse Text box */
	private JTextField spouseField;

	/** Birthday JCalendar */
	private JTextField birthdayField;

	/** Child Text box */
	private JTextArea childrenField;

	/** Name Label */
	private JLabel name;

	/** Mother Label */
	private JLabel mother;

	/** Father Label */
	private JLabel father;

	/** Spouse Label */
	private JLabel spouse;

	/** Gender Label */
	private JLabel gender;

	/** Child Label */
	private JLabel children;

	/** Ok Button */
	private JButton okButton;

	/** Cancel Button */
	private JButton cancelButton;

	/** Main Panel */
	private JPanel panel;

	/** Panel */
	private JPanel panel_1;

	/** ... Panel */
	private JPanel buttonPanel;

	/** ... Panel */
	private JPanel mainPanel;

	private JLabel eyeColorL;

	private JLabel lblBirthday;

	/** Determines if box should be open or closed */
	private boolean closeStatus;

	/** If cancel button was pushed */
	private Boolean cancelStatus;

	/** Current Person */
	private Person person; 

	/** Current FamilyTree */
	private FamilyTree treeP;

	/** Current TreeLibary */
	private TreeLibrary library;

	/** Ok and cancel buttons */
	ButtonListener listener = new ButtonListener();

	/** Combo box for genders */
	private JComboBox<Gender> genderBox;

	/** Combo box for eye colors */
	private JComboBox<EyeColor> eyeBox;
	
	/** New tree to store edited information */
	private FamilyTree edited;

	/** JLabel to display image */
	private JLabel lblImage;

	/** JButton to open filechooser */
	private JButton btnBrowse;

	/** Text field to display filename */
	private JTextField imgFileField;
	
	/*******************************************************************
	 *Constructor: Sets up the pop up dialog box to add a person to a 
	 *tree
	 ******************************************************************/
	public EditPersonDialog (JFrame parent, FamilyTree treeP) {

		//Set up Dialog Box
		super(parent,true);
		setPreferredSize(new Dimension(350, 450));
		setTitle("Edit");
		closeStatus = false;
		getContentPane().setLayout(new GridLayout(1, 1, 0, 0));

		person = treeP.getRoot();

		// Creates the panel to hold the components
		panel = new JPanel();
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{332, 0};
		gbl_panel.rowHeights = new int[] {340, 70, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(20, 5, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{326, 0};
		gbl_panel_1.rowHeights = new int[]{315, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		mainPanel = new JPanel();
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.insets = new Insets(0, 5, 0, 5);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 0;
		gbc_mainPanel.gridy = 0;
		panel_1.add(mainPanel, gbc_mainPanel);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {111, 80, 0};
		gbl_panel_3.rowHeights = new int[]{25, 25, 0, 0, 25, 25, 25, 76, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_panel_3);
		name = new JLabel("Name");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.fill = GridBagConstraints.BOTH;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 0;
		gbc_name.gridy = 0;
		mainPanel.add(name, gbc_name);

		// Instantiates the components of the dialog box
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.fill = GridBagConstraints.BOTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		mainPanel.add(nameField, gbc_nameField);
		gender = new JLabel("Gender");
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.fill = GridBagConstraints.VERTICAL;
		gbc_gender.insets = new Insets(0, 0, 5, 5);
		gbc_gender.gridx = 0;
		gbc_gender.gridy = 1;
		mainPanel.add(gender, gbc_gender);

		// Instantiates pull down gender selection
		genderBox = new JComboBox<Gender>();
		genderBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(genderBox.getSelectedItem() == Gender.MALE){
					person.setGender(Gender.MALE);
				}else{
					person.setGender(Gender.FEMALE);
				}
			}
		});
		genderBox.setModel(new DefaultComboBoxModel<Gender>(Gender.values()));
		genderBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		mainPanel.add(genderBox, gbc_comboBox);

		eyeBox = new JComboBox<EyeColor>();
		eyeBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(eyeBox.getSelectedItem() == EyeColor.BLACK){
					person.setEyeColor(EyeColor.BLACK);
				}else if(eyeBox.getSelectedItem() == EyeColor.BLUE){
					person.setEyeColor(EyeColor.BLUE);
				}else if(eyeBox.getSelectedItem() == EyeColor.BROWN){
					person.setEyeColor(EyeColor.BROWN);
				}else if(eyeBox.getSelectedItem() == EyeColor.GREEN){
					person.setEyeColor(EyeColor.GREEN);
				}else if(eyeBox.getSelectedItem() == EyeColor.GREY){
					person.setEyeColor(EyeColor.GREY);
				}else if(eyeBox.getSelectedItem() == EyeColor.HAZEL){
					person.setEyeColor(EyeColor.HAZEL);
				}else{
					person.setEyeColor(EyeColor.MULTICOLOR);
				}
			}
		});

		eyeColorL = new JLabel("Eye Color");
		eyeColorL.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_EyeColor = new GridBagConstraints();
		gbc_EyeColor.insets = new Insets(0, 0, 5, 5);
		gbc_EyeColor.gridx = 0;
		gbc_EyeColor.gridy = 2;
		mainPanel.add(eyeColorL, gbc_EyeColor);

		eyeBox.setModel(new DefaultComboBoxModel<EyeColor>(EyeColor.values()));
		eyeBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox2.gridx = 1;
		gbc_comboBox2.gridy = 2;
		mainPanel.add(eyeBox, gbc_comboBox2);

		lblBirthday = new JLabel("Birthday (MM/DD/YYYY)");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.insets = new Insets(0, 5, 5, 5);
		gbc_lblBirthday.gridx = 0;
		gbc_lblBirthday.gridy = 3;
		mainPanel.add(lblBirthday, gbc_lblBirthday);

		birthdayField = new JTextField();
		GridBagConstraints gbc_birthdayField = new GridBagConstraints();
		gbc_birthdayField.insets = new Insets(0, 0, 5, 0);
		gbc_birthdayField.fill = GridBagConstraints.HORIZONTAL;
		gbc_birthdayField.gridx = 1;
		gbc_birthdayField.gridy = 3;
		mainPanel.add(birthdayField, gbc_birthdayField);
		birthdayField.setColumns(10);

		mother = new JLabel("Mother");
		mother.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_mother = new GridBagConstraints();
		gbc_mother.fill = GridBagConstraints.BOTH;
		gbc_mother.insets = new Insets(0, 0, 5, 5);
		gbc_mother.gridx = 0;
		gbc_mother.gridy = 4;
		mainPanel.add(mother, gbc_mother);
		motherField = new JTextField();
		GridBagConstraints gbc_motherField = new GridBagConstraints();
		gbc_motherField.fill = GridBagConstraints.BOTH;
		gbc_motherField.insets = new Insets(0, 0, 5, 0);
		gbc_motherField.gridx = 1;
		gbc_motherField.gridy = 4;
		mainPanel.add(motherField, gbc_motherField);

		father = new JLabel("Father");
		father.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_father = new GridBagConstraints();
		gbc_father.fill = GridBagConstraints.BOTH;
		gbc_father.insets = new Insets(0, 0, 5, 5);
		gbc_father.gridx = 0;
		gbc_father.gridy = 5;
		mainPanel.add(father, gbc_father);
		fatherField = new JTextField();
		GridBagConstraints gbc_fatherField = new GridBagConstraints();
		gbc_fatherField.fill = GridBagConstraints.BOTH;
		gbc_fatherField.insets = new Insets(0, 0, 5, 0);
		gbc_fatherField.gridx = 1;
		gbc_fatherField.gridy = 5;
		mainPanel.add(fatherField, gbc_fatherField);

		spouse = new JLabel ("Spouse");
		spouse.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_spouse = new GridBagConstraints();
		gbc_spouse.fill = GridBagConstraints.BOTH;
		gbc_spouse.insets = new Insets(0, 0, 5, 5);
		gbc_spouse.gridx = 0;
		gbc_spouse.gridy = 6;
		mainPanel.add(spouse, gbc_spouse);
		spouseField = new JTextField();
		GridBagConstraints gbc_spouseField = new GridBagConstraints();
		gbc_spouseField.fill = GridBagConstraints.BOTH;
		gbc_spouseField.insets = new Insets(0, 0, 5, 0);
		gbc_spouseField.gridx = 1;
		gbc_spouseField.gridy = 6;
		mainPanel.add(spouseField, gbc_spouseField);

		children = new JLabel("Children");
		children.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_children = new GridBagConstraints();
		gbc_children.fill = GridBagConstraints.BOTH;
		gbc_children.insets = new Insets(0, 0, 5, 5);
		gbc_children.gridx = 0;
		gbc_children.gridy = 7;
		mainPanel.add(children, gbc_children);
		childrenField = new JTextArea();
		GridBagConstraints gbc_childrenField = new GridBagConstraints();
		gbc_childrenField.insets = new Insets(0, 0, 5, 0);
		gbc_childrenField.fill = GridBagConstraints.BOTH;
		gbc_childrenField.gridx = 1;
		gbc_childrenField.gridy = 7;
		mainPanel.add(childrenField, gbc_childrenField);
		childrenField.setMinimumSize(new Dimension(8, 22));
		childrenField.setPreferredSize(new Dimension(8, 20));

		lblImage = new JLabel("Image");
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 0;
		gbc_lblImage.gridy = 8;
		mainPanel.add(lblImage, gbc_lblImage);

		imgFileField = new JTextField();
		GridBagConstraints gbc_imgFileField = new GridBagConstraints();
		gbc_imgFileField.insets = new Insets(0, 0, 5, 0);
		gbc_imgFileField.fill = GridBagConstraints.HORIZONTAL;
		gbc_imgFileField.gridx = 1;
		gbc_imgFileField.gridy = 8;
		mainPanel.add(imgFileField, gbc_imgFileField);
		imgFileField.setColumns(10);

		btnBrowse = new JButton("Browse");
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.gridx = 1;
		gbc_btnBrowse.gridy = 9;
		mainPanel.add(btnBrowse, gbc_btnBrowse);
		GridBagConstraints gbc_genderBox = new GridBagConstraints();
		gbc_genderBox.fill = GridBagConstraints.BOTH;
		gbc_genderBox.insets = new Insets(0, 0, 5, 0);
		gbc_genderBox.gridx = 1;
		gbc_genderBox.gridy = 1;

		buttonPanel = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(buttonPanel, gbc_panel_2);
		buttonPanel.setMinimumSize(new Dimension(10, 5));
		buttonPanel.setPreferredSize(new Dimension(7, 5));
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{47, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{23, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_panel_2);
		okButton = new JButton("OK");
		okButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_okButton.insets = new Insets(0, 0, 5, 5);
		gbc_okButton.gridx = 6;
		gbc_okButton.gridy = 1;
		buttonPanel.add(okButton, gbc_okButton);

		cancelButton = new JButton("Cancel");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_cancelButton.gridx = 9;
		gbc_cancelButton.gridy = 1;
		cancelButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);

		// Adds action listeners to the buttons and combo box
		okButton.addActionListener(listener);
		buttonPanel.add(cancelButton, gbc_cancelButton);
		cancelButton.addActionListener(listener);
		btnBrowse.addActionListener(listener);

		cancelStatus = false;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

	}
	/*******************************************************************
	 *Helper: Attaches actions to buttons
	 ******************************************************************/
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			edited = new FamilyTree();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String filename = "";

			// If ok button is selected
			if (okButton == e.getSource()){

				String nameStr = nameField.getText();
				String motherStr = motherField.getText();
				String fatherStr = fatherField.getText();
				String spouseStr = spouseField.getText();
				String childrenStr = childrenField.getText();

				String birthdayStr = birthdayField.getText();

				// If the name field is empty
				if (nameStr.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Please make sure necessary fields are complete");
					//Instead of closing we can return to the dialog box
					closeStatus = false;

					// If all entries are ok, set the information
				} else {

					//Set the current persons Name
					person.setName(nameStr);

					//Sets Eye Color
					person.setEyeColor((EyeColor) eyeBox.getSelectedItem());

					//Sets the Gender
					person.setGender((Gender) genderBox.getSelectedItem());

					//Sets the image file
					filename = imgFileField.getText();
					person.setImageFilename(filename);
					if(filename.isEmpty()){
						person.setImageFilename("C:\\Users\\Bryana\\workspace\\Family Tree\\src\\package1\\default.jpg");
					}

					if (birthdayStr.length() > 0){
						try {
							Date date = df.parse(birthdayStr);					
							//Sets the Birthday
							person.setbDay(date);
						} catch (ParseException e2) {
							JOptionPane.showMessageDialog(null,
									"The date was not correct");
							closeStatus = false;
						}
					}

					//Sets Mother
					if(!motherStr.isEmpty()){
						FamilyTree ma = library.findName(motherStr);

						//If the mother is not created 
						if(ma == null){
							JOptionPane.showMessageDialog(null,
									"Selected mother does not exist.");
						}
						else if(ma.getRoot().getGender().equals(Gender.FEMALE)){
							edited.setMother(ma);
							ma.addChild(edited);
						}else{
							JOptionPane.showMessageDialog(null,
									"Selected mother is wrong gender.");
							closeStatus = false;
						}
					}
					if(!fatherStr.isEmpty()){
						FamilyTree pa = library.findName(fatherStr);
						if(pa == null){
							JOptionPane.showMessageDialog(null,
									"Selected father does not exist.");
							closeStatus = false;
						}
						else if(pa.getRoot().getGender().equals(Gender.MALE)){
							edited.setFather(pa);
							pa.addChild(edited);
						}else{
							JOptionPane.showMessageDialog(null,
									"Selected father is wrong gender.");
							closeStatus = false;

						}
					}
					if(!spouseStr.isEmpty()){
						FamilyTree sp = library.findName(spouseStr);
						if(sp == null){
							JOptionPane.showMessageDialog(null,
									"Selected spouse does not exist.");
							closeStatus = false;
						}else{
							edited.setSpouse(sp);
							sp.setSpouse(edited);
							//library.findName(spouseStr).addChild(tree);
						}
					}
					if(!childrenStr.isEmpty()){
						FamilyTree ch = library.findName(childrenStr);
						if(ch == null){
							JOptionPane.showMessageDialog(null,
									"Selected child does not exist.");
						}else{
							try {
								String[] tokens = childrenStr.split(",");
								for(int i = 0; i < tokens.length; i++){
									FamilyTree child = library.findName(tokens[i]);
									edited.addChild(child);
									if(edited.getRoot().getGender() == Gender.FEMALE){
										child.setMother(edited);
									}else{
										child.setFather(edited);
									}
								}
							} catch (Exception e1) {
								System.out.println("Error in adding child");
								closeStatus = false;
							}
						}
					}

					//Once tree is built, then add it to the library
					edited.setRoot(person);
					closeStatus = true;
				}
			}

			// If cancel is selected, hide the box
			else if (cancelButton == e.getSource()){
				closeStatus = true;
				cancelStatus = true;
			}

			if(closeStatus){
				setVisible(false);
				dispose();
			}
		}
	}

	/*******************************************************************
	 *Helper: Returns the current FamilyTree
	 *@return tree the current FamilyTree
	 ******************************************************************/
	public FamilyTree getTree() {
		return edited;
	}


	/*******************************************************************
	 *Helper: Returns the current FamilyTree
	 *@return tree the current FamilyTree
	 ******************************************************************/
	public TreeLibrary getLibrary() {
		return library;
	}

	/*******************************************************************
	 *Helper: Determines if the cancel button was pushed
	 *@return true if the cancel button was pushed
	 *@return false if the cancel button was not pushed
	 ******************************************************************/
	public boolean getCancaelStatus() {
		return cancelStatus;
	}	
	
	/*******************************************************************
	 *Helper: Determines if the dialog box can close of not
	 *@return true if the dialog box is able to close
	 *@return false if the dialog box is not able to close
	 ******************************************************************/
	public boolean getCloseStatus() {
		return closeStatus;
	}
}