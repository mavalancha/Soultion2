package hardwarestore;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.FileHandler;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;



public class MainApp extends JFrame {
	
	private static final Logger logger = Logger.getLogger(MainApp.class.getName());

	//Main Menu option
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton exit;
	private JFrame mainFrame;
	private JTextField titleSelection;

	//Option1: Show all existing items in database
	private JFrame itemFrame;
	private JPanel itemPanel;
	private JButton returnButton;
	private JTextArea textArea;
	private JScrollPane itemScroller;
	
	
	//Option 2: Adding new Item
	private JFrame addItemFrame;
	private JPanel addItemPanelForText;
	private JPanel addItemPanelButtons;
	private JPanel addItemPanelLabel;
	private JTextField addItemId;
	private JTextField addItemName;
	private JTextField addItemCat;
	private JTextField addItemQuant;
	private JTextField addItemPrice;
	private JButton addButton;
	private JButton addItemBackButton; 
	private JLabel itemName;
	private JLabel itemId;
	private JLabel itemCat;
	private JLabel itemQuant;
	private JLabel itemPrice;
	
	
	//Option 3: Delete an Item
	private JFrame dItemFrame;
	private JPanel dItemPanel;
	private JLabel deleteLabel;
	private JButton deleteItem;
	private JButton goBack;
	private JTextField itemToBeDeleted;
	
	
	//Option 4: Searching for an Item
	private JFrame searchFrame;
	private JTextField itemToBeSearched;
	private JLabel itemSearchTitle;
	private JButton searchItem;
	private JButton searchExit;
	private JPanel searchPanelForText;
	private JPanel searchPanelForButton;
	
	
	//Option 5: Show users 
	private JFrame showUserFrame;
	private JPanel showUserPanel;
	private JButton showExitButton;
	private JTextArea showUserTextArea;
	
	
	
	//Option 6: Adding user
	private JFrame AddUserFrame;
	private JPanel AddUserPanel;
	private JButton CustomerOption;
	private JButton EmployeeOption;
	private JButton ExitAddUser;
	private JFrame AddCustomerFrame;
	private JPanel AddCustomerTextPanel;
	private JPanel AddCustomerTextAreaPanel;
	private JPanel AddCustomerButton;
	private JTextField CustomerFname;
	private JTextField CustomerLname;
	private JTextField CustomerNumber;
	private JTextField CustomerAddress;
	private JLabel cFname;
	private JLabel cLname;
	private JLabel number;
	private JLabel address;
	private JButton addCustomerButton;
	private JButton ExitCustomerButton;
	private JFrame AddEmployeeFrame;
	private JPanel AddEmployeeTextPanel;
	private JPanel AddEmployeeTextAreaPanel;
	private JPanel AddEmployeeButtonPanel;
	private JTextField EmployeeFname;
	private JTextField EmployeeLname;
	private JTextField EmployeeSSN;
	private JTextField EmployeeMS;
	private JLabel eFname;
	private JLabel eLname;
	private JLabel SSN;
	private JLabel MS;
	private JButton addEmployeeButton;
	private JButton exitEmployeeButton;
	
	//Option 7: Updating User
	private JFrame UpdateUserFrame;
	private JPanel UpdateUserPanel;
	private JPanel UpdateButtonPanel;
	private JLabel UpdateLabel;
	private JButton searchButton;
	private JButton updateExitButton;
	private JTextField idToBeSearched;
	
	//Option 8: Complete a Sale
	
	
	
	public MainApp(){
		
		try
        {
        	FileHandler loggingFile = new FileHandler("shippingStore_GUI_logging.txt");
        	SimpleFormatter formatter = new SimpleFormatter();
        	loggingFile.setFormatter(formatter);
        	logger.addHandler(loggingFile);
        }
        catch (IOException ioe)
        {
        	JOptionPane.showMessageDialog(null, "Error occurred in opening file for logging functionality.");
        }
		
		//HardwareStore hs = new HardwareStore();
		JFrame.setDefaultLookAndFeelDecorated(true);
		mainFrame = new JFrame("Hardware Store");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout(0,1));
		
		createMenu();
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		
	}
	private void createMenu(){
		
		b1 = new JButton("1. Show all existing items records in the database (sorted by ID number).");
		b2 = new JButton("2. Add a new item (or quantity) to the database.");
		b3 = new JButton("3. Delete an item from a database.");
		b4 = new JButton("4. Search for an item given its name.");
		b5 = new JButton("5. Show a list of users in the database.");
		b6 = new JButton("6. Add new user to the database.");
		b7 = new JButton("7. Update user info (given their id)");
		b8 = new JButton("8. Complete a sale transaction.");
		b9 = new JButton("9. Show a completed sale transaction.");
		exit = new JButton("10. Exit program.");
		titleSelection = new JTextField("Please make a selection");
		titleSelection.setHorizontalAlignment(0);
		
		mainFrame.add(titleSelection);
		mainFrame.add(b1);
		mainFrame.add(b2);
		mainFrame.add(b3);
		mainFrame.add(b4);
		mainFrame.add(b5);
		mainFrame.add(b6);
		mainFrame.add(b7);
		mainFrame.add(b8);
		mainFrame.add(b9);
		mainFrame.add(exit);
		
		
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				logger.log(Level.INFO, "User selected showALLItems ");
				showAllItems();
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addItem();
			}
		});
		b3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteItem();
			}
			
		});
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				searchItem();
			}
		});
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showUsers();
			}
		});
		
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addUser();
			}
		});
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				updateUser();
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	public void showAllItems(){
		itemFrame = new JFrame();
		itemFrame.setTitle("INVENTORY OF ALL ITEMS IN DATABASE.");
		itemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		itemPanel = new JPanel(new BorderLayout());
		returnButton = new JButton("Return");
		textArea = new JTextArea();
		//String getItems = hs.getAllItemFormatted();
		itemScroller = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		itemPanel.add(itemScroller, BorderLayout.CENTER);
		itemPanel.add(returnButton,BorderLayout.SOUTH);
		itemFrame.add(itemPanel);
		itemFrame.pack();
		itemFrame.setLocationRelativeTo(this);
		itemFrame.setVisible(true);
		
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				itemFrame.dispose();
				
			}
		});
			
	}
	public void addItem(){
		addItemFrame = new JFrame();
		addItemFrame.setTitle("Add Item to Database");
		addItemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addItemFrame.setLayout(new BorderLayout());
		
		
		addItemPanelForText = new JPanel();
		addItemPanelForText.setLayout(new GridLayout(0,1));
		addItemFrame.add(addItemPanelForText, BorderLayout.EAST);
		addItemId = new JTextField(20);
		addItemName = new JTextField(20);
		addItemCat = new JTextField(20);
		addItemQuant = new JTextField(20);
		addItemPrice = new JTextField(20);
		addItemPanelForText.add(addItemId);
		addItemPanelForText.add(addItemName);
		addItemPanelForText.add(addItemCat);
		addItemPanelForText.add(addItemQuant);
		addItemPanelForText.add(addItemPrice);
		
		
		itemId = new JLabel("Item id: ");
		itemName = new JLabel("Name: ");
		itemCat = new JLabel("Category: ");
		itemQuant = new JLabel("Quantity: ");
		itemPrice = new JLabel("Price: ");
		
		addItemPanelLabel = new JPanel();
		addItemPanelLabel.setLayout(new GridLayout(0,1));
		addItemFrame.add(addItemPanelLabel,BorderLayout.WEST);
		
		addItemPanelLabel.add(itemId);
		addItemPanelLabel.add(itemName);
		addItemPanelLabel.add(itemCat);
		addItemPanelLabel.add(itemQuant);
		addItemPanelLabel.add(itemPrice);
		
		
		addItemPanelButtons = new JPanel();
		addItemPanelButtons.setLayout(new GridLayout(1,1));
		addItemFrame.add(addItemPanelButtons, BorderLayout.SOUTH);
		addButton = new JButton("Add Item");
		addItemBackButton = new JButton("Exit");
		addItemPanelButtons.add(addButton);
		addItemPanelButtons.add(addItemBackButton);
		
		
		addItemFrame.pack();
		addItemFrame.setVisible(true);
		
		
		//Need to add button for adding the item
		
		addItemBackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addItemFrame.dispose();
			}
	});	
	}
	public void deleteItem(){
		
		dItemFrame = new JFrame();
		dItemFrame.setTitle("Delete Item");
		dItemFrame.setLayout(new BorderLayout());
		dItemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dItemPanel = new JPanel();
		dItemFrame.add(dItemPanel, BorderLayout.CENTER);
		
		deleteLabel = new JLabel("Item you want to delete? (Search by id number) ");
		dItemFrame.add(deleteLabel, BorderLayout.EAST);
		
		itemToBeDeleted = new JTextField(5);
		dItemFrame.add(itemToBeDeleted,BorderLayout.NORTH);
		
		deleteItem = new JButton("Delete Item");
		goBack = new JButton("Return");
		dItemPanel.add(deleteItem);
		dItemPanel.add(goBack);
		dItemFrame.pack();
		dItemFrame.setVisible(true);
		
		deleteItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//add deleteItem functionality
				}
		});
		goBack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					dItemFrame.dispose();
				}
		});
	}
	public void searchItem(){

		searchFrame = new JFrame();
		searchFrame.setTitle("Search for an Item");
		searchFrame.setLayout(new BorderLayout());
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		searchPanelForText = new JPanel();
		searchPanelForText.setLayout(new GridLayout(2,1));
		searchFrame.add(searchPanelForText, BorderLayout.NORTH);
		
		searchPanelForButton = new JPanel();
		searchPanelForText.setLayout(new GridLayout(0,1));
		searchFrame.add(searchPanelForButton, BorderLayout.SOUTH);
		
		itemToBeSearched = new JTextField(15);
		itemSearchTitle = new JLabel("Search by id: ");
		
		
		searchPanelForText.add(itemSearchTitle);
		searchPanelForText.add(itemToBeSearched);
		
		
		searchItem = new JButton("Search");
		searchExit = new JButton("Exit");
		
		searchPanelForButton.add(searchItem);
		searchPanelForButton.add(searchExit);
		
		searchFrame.pack();
		searchFrame.setVisible(true);
		
		
		searchItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//if item exist 
				//else print error message
			}
		});
		searchExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				searchFrame.dispose();
			}
		});
	}
	public void showUsers(){
		showUserFrame = new JFrame();
		showUserPanel = new JPanel();
		showUserPanel.setLayout(new BorderLayout());
		showExitButton = new JButton("Exit");
		showUserTextArea = new JTextArea();
		showUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		showUserPanel.add(showExitButton, BorderLayout.SOUTH);
		showUserPanel.add(showUserTextArea, BorderLayout.CENTER);
		
		showUserFrame.add(showUserPanel);
		
		showUserFrame.pack();
		showUserFrame.setVisible(true);
		//need to add space for the textarea to show users
		showExitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showUserFrame.dispose();
			}
		});
	
	}
	public void addUser(){
		AddUserFrame = new JFrame();
		AddUserFrame.setTitle("Adding User");
		AddUserPanel = new JPanel();
		AddUserPanel.setLayout(new BorderLayout());
		AddUserFrame.add(AddUserPanel);
		CustomerOption = new JButton("Customer");
		EmployeeOption = new JButton("Employee");
		ExitAddUser = new JButton("Exit");
		AddUserPanel.add(CustomerOption, BorderLayout.WEST);
		AddUserPanel.add(EmployeeOption, BorderLayout.EAST);
		AddUserPanel.add(ExitAddUser, BorderLayout.SOUTH);
		AddUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		CustomerOption.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddCustomerFrame = new JFrame();
				AddCustomerFrame.setTitle("Adding Customer");
				AddCustomerTextPanel = new JPanel();
				AddCustomerTextAreaPanel = new JPanel();
				AddCustomerButton = new JPanel();
				AddCustomerFrame.setLayout(new BorderLayout());
				AddCustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				ExitCustomerButton = new JButton("Exit");
				addCustomerButton = new JButton("Add Customer");
				
				CustomerFname = new JTextField(10);
				CustomerLname = new JTextField(10);
				CustomerNumber = new JTextField(10);
				CustomerAddress = new JTextField(10);
				
				cFname = new JLabel("First name: ");
				cLname = new JLabel("Last name: ");
				number = new JLabel("Phone Number: ");
				address = new JLabel("Address: ");
				
				AddCustomerFrame.add(AddCustomerTextPanel, BorderLayout.WEST);
				AddCustomerFrame.add(AddCustomerTextAreaPanel, BorderLayout.EAST);
				AddCustomerFrame.add(AddCustomerButton, BorderLayout.SOUTH);
				
				AddCustomerTextPanel.setLayout(new GridLayout(4,1));
				AddCustomerTextPanel.add(cFname);
				AddCustomerTextPanel.add(cLname);
				AddCustomerTextPanel.add(number);
				AddCustomerTextPanel.add(address);
				
				AddCustomerTextAreaPanel.setLayout(new GridLayout(4,1));
				AddCustomerTextAreaPanel.add(CustomerFname);
				AddCustomerTextAreaPanel.add(CustomerLname);
				AddCustomerTextAreaPanel.add(CustomerNumber);
				AddCustomerTextAreaPanel.add(CustomerAddress);
				
				AddCustomerButton.setLayout(new BorderLayout());
				AddCustomerButton.add(ExitCustomerButton, BorderLayout.EAST);
				AddCustomerButton.add(addCustomerButton, BorderLayout.WEST);
				AddCustomerFrame.pack();
				AddCustomerFrame.setVisible(true);
				
				ExitCustomerButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						AddCustomerFrame.dispose();
					}
				});
				//add action listener for adding customer
				
			}
		});
		EmployeeOption.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddEmployeeFrame = new JFrame();
				AddEmployeeFrame.setTitle("Adding Employee");
				AddEmployeeFrame.setLayout(new BorderLayout());
				AddEmployeeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				AddEmployeeTextPanel = new JPanel();
				AddEmployeeTextAreaPanel = new JPanel();
				AddEmployeeButtonPanel = new JPanel();
				
				exitEmployeeButton = new JButton("Exit");
				addEmployeeButton = new JButton("Add Employee");
				
				eFname = new JLabel("First name: ");
				eLname = new JLabel("Last name: ");
				SSN = new JLabel("SSN: ");
				MS = new JLabel("Monthly Salary: ");
				
				EmployeeFname = new JTextField(10);
				EmployeeLname = new JTextField(10);
				EmployeeSSN = new JTextField(10);
				EmployeeMS = new JTextField(10);
				
				AddEmployeeFrame.add(AddEmployeeTextPanel, BorderLayout.WEST);
				AddEmployeeFrame.add(AddEmployeeTextAreaPanel, BorderLayout.EAST);
				AddEmployeeFrame.add(AddEmployeeButtonPanel, BorderLayout.SOUTH);
				
				AddEmployeeTextPanel.setLayout(new GridLayout(4,1));
				AddEmployeeTextPanel.add(eFname);
				AddEmployeeTextPanel.add(eLname);
				AddEmployeeTextPanel.add(SSN);
				AddEmployeeTextPanel.add(MS);
				
				AddEmployeeTextAreaPanel.setLayout(new GridLayout(4,1));
				AddEmployeeTextAreaPanel.add(EmployeeFname);
				AddEmployeeTextAreaPanel.add(EmployeeLname);
				AddEmployeeTextAreaPanel.add(EmployeeSSN);
				AddEmployeeTextAreaPanel.add(EmployeeMS);
				
				AddEmployeeButtonPanel.setLayout(new BorderLayout());
				AddEmployeeButtonPanel.add(exitEmployeeButton, BorderLayout.EAST);
				AddEmployeeButtonPanel.add(addEmployeeButton, BorderLayout.WEST);
				
				AddEmployeeFrame.pack();
				AddEmployeeFrame.setVisible(true);
				
				//add actionlistener for adding employee
				exitEmployeeButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						AddEmployeeFrame.dispose();
					}
				});
				
			}
		});
		
		ExitAddUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddUserFrame.dispose();
			}
		});
		
		AddUserFrame.pack();
		AddUserFrame.setVisible(true);
	}
	public void updateUser(){
		
		UpdateUserFrame = new JFrame();
		UpdateUserFrame.setTitle("Update User");
		UpdateUserFrame.setLayout(new BorderLayout());
		UpdateUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UpdateUserPanel = new JPanel();
		UpdateButtonPanel = new JPanel();
		
		UpdateLabel = new JLabel("Id number to be searched for: ");
		idToBeSearched = new JTextField(10);
		
		UpdateUserPanel.setLayout(new GridLayout(1,1));
		UpdateUserPanel.add(UpdateLabel);
		UpdateUserPanel.add(idToBeSearched);
		
		searchButton = new JButton("Search");
		updateExitButton = new JButton("Exit");
		
		UpdateButtonPanel.setLayout(new BorderLayout());
		UpdateButtonPanel.add(searchButton, BorderLayout.WEST);
		UpdateButtonPanel.add(updateExitButton, BorderLayout.EAST);
		
		UpdateUserFrame.add(UpdateUserPanel,BorderLayout.NORTH);
		UpdateUserFrame.add(UpdateButtonPanel,BorderLayout.SOUTH);
		
		UpdateUserFrame.pack();
		UpdateUserFrame.setVisible(true);
		//need to add search actionevents.
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainApp m = new MainApp();
	}

}
