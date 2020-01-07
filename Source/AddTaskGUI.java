
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddTaskGUI extends JFrame implements ActionListener
{
	private JPanel contentPanel;
	private JPanel centerPanel;
	private JPanel descriptionPanel;
	private JPanel hoursPanel;
	private JPanel startDatePanel;
	private JPanel dueDatePanel;
	private JPanel priorityPanel;
	private JPanel categoryPanel;
	private JPanel buttonPanel;
	private JPanel buttonPanel2;

	private JTextField descriptionTf;
	private JTextField hoursTf;

	private JLabel descriptionLb;
	private JLabel hoursLb;
	private JLabel startDateLb;
	private JLabel dueDateLb;
	private JLabel priorityLb;
	private JLabel categoryLb;

	private JButton addBt;
	private JButton saveBt;
	private JButton loadBt;
	private JButton newBt;
	private JButton nextBt;
	private JButton previousBt;
	private JButton editBt;
	private JButton finishBt;
	private JButton deleteBt;
	private JButton comTask;
	private JButton priTask;
	private JButton runTask;

	private ButtonGroup priorityBg;
	private ButtonGroup categoryBg;

	private JRadioButton priorityRb1;
	private JRadioButton priorityRb2;
	private JRadioButton priorityRb3;
	private JRadioButton priorityRb4;
	private JRadioButton priorityRb5;
	private JRadioButton categoryRb6;
	private JRadioButton categoryRb7;
	private JRadioButton categoryRb8;
	private JRadioButton categoryRb9;

	private JComboBox startDateCb1;
	private JComboBox startDateCb2;
	private JComboBox startDateCb3;
	private JComboBox dueDateCb4;
	private JComboBox dueDateCb5;
	private JComboBox dueDateCb6;

	private GroupOfTasks timeframe;
	private GroupOfTasks t1;
	private int nowDisplaying;

	AddTaskGUI()
	{

		timeframe = new GroupOfTasks();
		t1 = new GroupOfTasks();
		nowDisplaying = -1 ;

		// PANNELS

		setTitle("Add a new Task");
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(new BorderLayout());

		centerPanel = new JPanel(new GridLayout(7,1));

		descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

		hoursPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

		startDatePanel = new JPanel();
		startDatePanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		dueDatePanel = new JPanel();
		dueDatePanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		priorityPanel = new JPanel();
		priorityPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		categoryPanel = new JPanel();
		categoryPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(8,1,5,5));

		buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new FlowLayout());

		centerPanel.setBorder(BorderFactory.createTitledBorder("Fill the Information"));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


		//RadioButton Groups

		priorityBg = new ButtonGroup();
		categoryBg = new ButtonGroup();

		//Textfields

		descriptionTf = new JTextField ("", 18);
		hoursTf = new JTextField ("", 18);

		//Labels

		descriptionLb = new JLabel ("           Description:");
		hoursLb = new JLabel (" Estimated Hours:");
		startDateLb = new JLabel ("             Start Date:");
		dueDateLb = new JLabel ("               Due Date:");
		priorityLb = new JLabel ("                Priority:");
		categoryLb = new JLabel ("            Category:");

		//Buttons

		addBt = new JButton ("Add");
		saveBt = new JButton ("Save");
		loadBt = new JButton ("Load");
		newBt = new JButton ("New Task");
		nextBt = new JButton (">>");
		previousBt = new JButton( "<<");
		editBt = new JButton ("Edit");
		finishBt = new JButton ("Finish");
		deleteBt = new JButton("Delete");
		comTask = new JButton("Completed Tasks");
		priTask = new JButton("Prioritized Tasks");
		runTask = new JButton("Running Tasks");

		//ComboBoxes

		String[] monthStrings = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		startDateCb1 = new JComboBox(monthStrings);

		String[] dayStrings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		startDateCb2 = new JComboBox(dayStrings);

		String[] yearStrings = {"2013", "2014", "2015"};
		startDateCb3 = new JComboBox(yearStrings);

		dueDateCb4 = new JComboBox(monthStrings);
		dueDateCb5 = new JComboBox(dayStrings);
		dueDateCb6 = new JComboBox(yearStrings);

		//RadioButtons

		priorityRb1 = new JRadioButton("1");
		priorityBg.add(priorityRb1);

		priorityRb2 = new JRadioButton("2");
		priorityBg.add(priorityRb2);

		priorityRb3 = new JRadioButton("3");
		priorityBg.add(priorityRb3);

		priorityRb4 = new JRadioButton("4");
		priorityBg.add(priorityRb4);

		priorityRb5 = new JRadioButton("5");
		priorityBg.add(priorityRb5);


		categoryRb6 = new JRadioButton("CITY");
		categoryBg.add(categoryRb6);

		categoryRb7 = new JRadioButton("WORK");
		categoryBg.add(categoryRb7);

		categoryRb8 = new JRadioButton("PERSONAL");
		categoryBg.add(categoryRb8);

		categoryRb9 = new JRadioButton("OTHER");
		categoryBg.add(categoryRb9);

		//ADDING THE COMPONENTS

	    descriptionPanel.add(descriptionLb);
		descriptionPanel.add(descriptionTf);
		hoursPanel.add(hoursLb);
		hoursPanel.add(hoursTf);

		startDatePanel.add(startDateLb);
		startDatePanel.add(startDateCb1);
		startDatePanel.add(startDateCb2);
		startDatePanel.add(startDateCb3);
		dueDatePanel.add(dueDateLb);
		dueDatePanel.add(dueDateCb4);
		dueDatePanel.add(dueDateCb5);
		dueDatePanel.add(dueDateCb6);

		priorityPanel.add(priorityLb);
		priorityPanel.add(priorityRb1);
		priorityPanel.add(priorityRb2);
		priorityPanel.add(priorityRb3);
		priorityPanel.add(priorityRb4);
		priorityPanel.add(priorityRb5);
		categoryPanel.add(categoryLb);
		categoryPanel.add(categoryRb6);
		categoryPanel.add(categoryRb7);
		categoryPanel.add(categoryRb8);
		categoryPanel.add(categoryRb9);

		buttonPanel.add(saveBt);
		buttonPanel.add(loadBt);
		buttonPanel.add(editBt);
		buttonPanel.add(finishBt);
		buttonPanel.add(deleteBt);
		buttonPanel.add(comTask);
		buttonPanel.add(priTask);
		buttonPanel.add(runTask);

		buttonPanel2.add(previousBt);
		buttonPanel2.add(addBt);
		buttonPanel2.add(newBt);
		buttonPanel2.add(nextBt);

		centerPanel.add(descriptionPanel);
		centerPanel.add(hoursPanel);
		centerPanel.add(startDatePanel);
		centerPanel.add(dueDatePanel);
		centerPanel.add(priorityPanel);
		centerPanel.add(categoryPanel);
		centerPanel.add(buttonPanel2);

		contentPanel.add(centerPanel, BorderLayout.CENTER);
		contentPanel.add(buttonPanel, BorderLayout.EAST);

		// Adding Action Listeners for each button

		addBt.addActionListener(this);
		saveBt.addActionListener(this);
		loadBt.addActionListener(this);
		newBt.addActionListener(this);
		nextBt.addActionListener(this);
		previousBt.addActionListener(this);
		editBt.addActionListener(this);
		finishBt.addActionListener(this);
		deleteBt.addActionListener(this);
		comTask.addActionListener(this);
		priTask.addActionListener(this);
		runTask.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();

		if (action.equals("Add"))
		{
			// retrieving the information from the textfields

			String description = descriptionTf.getText();

			int estimatedHours = 0;

			try
			{
				estimatedHours = Integer.parseInt((String) hoursTf.getText());
			}
			catch (NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(null,"Please write the estimated hours with numbers not letters!","Wrong Number Input",JOptionPane.ERROR_MESSAGE);
			}

			// retrieving the selected values from the combo boxes

			String startingMonth = (String) startDateCb1.getSelectedItem();
			int startingDay = Integer.parseInt((String) startDateCb2.getSelectedItem());
			int startingYear = Integer.parseInt((String) startDateCb3.getSelectedItem());

			Date startingDate = new Date(startingMonth, startingDay, startingYear);

			String endingMonth = (String) dueDateCb4.getSelectedItem();
			int endingDay = Integer.parseInt((String) dueDateCb5.getSelectedItem());
			int endingYear = Integer.parseInt((String) dueDateCb6.getSelectedItem());

			Date endingDate = new Date(endingMonth, endingDay, endingYear);

			// retrieving the selected value from the Priority radiobuttons

			int priority = 0;

			if (priorityRb1.isSelected())
			{
				priority = Integer.parseInt(priorityRb1.getText());
			}

			if (priorityRb2.isSelected())
			{
				priority = Integer.parseInt(priorityRb2.getText());
			}

			if (priorityRb3.isSelected())
			{
				priority = Integer.parseInt(priorityRb3.getText());
			}

			if (priorityRb4.isSelected())
			{
				priority = Integer.parseInt(priorityRb4.getText());
			}

			if (priorityRb5.isSelected())
			{
				priority = Integer.parseInt(priorityRb5.getText());
			}

			// retrieving the selected value from the category radiobuttons


			String category = "";

			if (categoryRb6.isSelected())
			{
				category = categoryRb6.getText();
			}

			if (categoryRb7.isSelected())
			{
				category = categoryRb7.getText();
			}

			if (categoryRb8.isSelected())
			{
				category = categoryRb8.getText();
			}

			if (categoryRb9.isSelected())
			{
				category = categoryRb9.getText();
			}

			// adding a new task

			try
			{
				Task task = new Task(description,estimatedHours, startingDate, endingDate, priority, category);

				try
				{
					timeframe.addTask(task);
					(timeframe.list).add(task);
					System.out.println(task);
					System.out.println(timeframe);
					addBt.setEnabled(false);
				}

				catch ( ArrayIndexOutOfBoundsException exc)
				{
					JOptionPane.showMessageDialog(null, "No space to add more students","No space to add more students", JOptionPane.ERROR_MESSAGE);
				}
			}

			catch (FebruaryException fe)
			{
				JOptionPane.showMessageDialog(null,"February only has 28 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
			}

			catch (MonthException me)
			{
				JOptionPane.showMessageDialog(null,"This month has only 30 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
			}

			nowDisplaying = timeframe.getNumberOfTasks() - 1;
		}

		else if (action.equals("Load"))
		{

			addBt.setEnabled(false);

			loadBaseFromFile("timeframe.dat");

			Task t = new Task();

			for(int i=0; i<((t1.getArray()).length); i++)
			{
				t = t1.getTask(i);
				descriptionTf.setText(t.getDescription());
				hoursTf.setText(""+t.getEstimatedHours());
				startDateCb1.setSelectedItem((t.getStartDate()).getMonth());
				startDateCb2.setSelectedItem(""+(t.getStartDate()).getDay());
				startDateCb3.setSelectedItem(""+(t.getStartDate()).getYear());
				dueDateCb4.setSelectedItem((t.getDueDate()).getMonth());
				dueDateCb5.setSelectedItem(""+(t.getDueDate()).getDay());
				dueDateCb6.setSelectedItem(""+(t.getDueDate()).getYear());

				//setting the radio buttons for priority
				int priority1 = Integer.parseInt(priorityRb1.getText());
				if ( priority1 == t.getPriority())
				{
					priorityRb1.setSelected(true);
				}

				int priority2 = Integer.parseInt(priorityRb2.getText());
				if ( priority2 == t.getPriority())
				{
					priorityRb2.setSelected(true);
				}

				int priority3 = Integer.parseInt(priorityRb3.getText());
				if ( priority3 == t.getPriority())
				{
					priorityRb3.setSelected(true);
				}

				int priority4 = Integer.parseInt(priorityRb4.getText());
				if ( priority4 == t.getPriority())
				{
					priorityRb4.setSelected(true);
				}

				int priority5 = Integer.parseInt(priorityRb5.getText());
				if ( priority5 == t.getPriority())
				{
					priorityRb5.setSelected(true);
				}

				//setting the radio buttons for category
				String category1 = categoryRb6.getText();
				if ( category1.equals(t.getCategory()))
				{
					categoryRb6.setSelected(true);
				}

				String category2 = categoryRb7.getText();
				if ( category2.equals(t.getCategory()))
				{
					categoryRb7.setSelected(true);
				}

				String category3 = categoryRb8.getText();
				if ( category3.equals(t.getCategory()))
				{
					categoryRb8.setSelected(true);
				}

				String category4 = categoryRb9.getText();
				if ( category4.equals(t.getCategory()))
				{
					categoryRb9.setSelected(true);
				}

				try
				{
					timeframe.addTask(t);
					(timeframe.list).add(t);
				}
				catch ( ArrayIndexOutOfBoundsException exc)
				{
					JOptionPane.showMessageDialog(null, "No space to add more students","No space to add more students", JOptionPane.ERROR_MESSAGE);
				}
				nowDisplaying = timeframe.getNumberOfTasks() - 1;
			}
		}

		else if (action.equals("Save"))
		{
			saveBaseToFile("timeframe.dat");
			JOptionPane.showMessageDialog(null, "The tasks have been saved!","SAVE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (action.equals("New Task"))
		{
			clearDisplay();
			addBt.setEnabled(true);
		}
		else if (action.equals("<<"))
		{
			Task t = timeframe.getTask(nowDisplaying - 1);
			nowDisplaying--;
			descriptionTf.setText(t.getDescription());
			hoursTf.setText(""+t.getEstimatedHours());
			startDateCb1.setSelectedItem((t.getStartDate()).getMonth());
			startDateCb2.setSelectedItem(""+(t.getStartDate()).getDay());
			startDateCb3.setSelectedItem(""+(t.getStartDate()).getYear());
			dueDateCb4.setSelectedItem((t.getDueDate()).getMonth());
			dueDateCb5.setSelectedItem(""+(t.getDueDate()).getDay());
			dueDateCb6.setSelectedItem(""+(t.getDueDate()).getYear());

			//setting the radio buttons for priority
			int priority1 = Integer.parseInt(priorityRb1.getText());
			if ( priority1 == t.getPriority())
			{
				priorityRb1.setSelected(true);
			}

			int priority2 = Integer.parseInt(priorityRb2.getText());
			if ( priority2 == t.getPriority())
			{
				priorityRb2.setSelected(true);
			}

			int priority3 = Integer.parseInt(priorityRb3.getText());
			if ( priority3 == t.getPriority())
			{
				priorityRb3.setSelected(true);
			}

			int priority4 = Integer.parseInt(priorityRb4.getText());
			if ( priority4 == t.getPriority())
			{
				priorityRb4.setSelected(true);
			}

			int priority5 = Integer.parseInt(priorityRb5.getText());
			if ( priority5 == t.getPriority())
			{
				priorityRb5.setSelected(true);
			}

			//setting the radio buttons for category
			String category1 = categoryRb6.getText();
			if ( category1.equals(t.getCategory()))
			{
				categoryRb6.setSelected(true);
			}

			String category2 = categoryRb7.getText();
			if ( category2.equals(t.getCategory()))
			{
				categoryRb7.setSelected(true);
			}

			String category3 = categoryRb8.getText();
			if ( category3.equals(t.getCategory()))
			{
				categoryRb8.setSelected(true);
			}

			String category4 = categoryRb9.getText();
			if ( category4.equals(t.getCategory()))
			{
				categoryRb9.setSelected(true);
			}

			///

			if (nowDisplaying == 0)
			{
				previousBt.setEnabled(false);
			}

			if (nowDisplaying == timeframe.getNumberOfTasks() -2)
			{
				nextBt.setEnabled(true);
			}
		}

		else if (action.equals(">>"))
		{
			Task t = timeframe.getTask(nowDisplaying + 1);
			nowDisplaying++;
			descriptionTf.setText(t.getDescription());
			hoursTf.setText(""+t.getEstimatedHours());
			startDateCb1.setSelectedItem((t.getStartDate()).getMonth());
			startDateCb2.setSelectedItem(""+(t.getStartDate()).getDay());
			startDateCb3.setSelectedItem(""+(t.getStartDate()).getYear());
			dueDateCb4.setSelectedItem((t.getDueDate()).getMonth());
			dueDateCb5.setSelectedItem(""+(t.getDueDate()).getDay());
			dueDateCb6.setSelectedItem(""+(t.getDueDate()).getYear());

			int priority1 = Integer.parseInt(priorityRb1.getText());
			if ( priority1 == t.getPriority())
			{
				priorityRb1.setSelected(true);
			}

			int priority2 = Integer.parseInt(priorityRb2.getText());
			if ( priority2 == t.getPriority())
			{
				priorityRb2.setSelected(true);
			}

			int priority3 = Integer.parseInt(priorityRb3.getText());
			if ( priority3 == t.getPriority())
			{
				priorityRb3.setSelected(true);
			}

			int priority4 = Integer.parseInt(priorityRb4.getText());
			if ( priority4 == t.getPriority())
			{
				priorityRb4.setSelected(true);
			}

			int priority5 = Integer.parseInt(priorityRb5.getText());
			if ( priority5 == t.getPriority())
			{
				priorityRb5.setSelected(true);
			}

			//setting the radio buttons for category

			String category1 = categoryRb6.getText();
			if ( category1.equals(t.getCategory()))
			{
				categoryRb6.setSelected(true);
			}

			String category2 = categoryRb7.getText();
			if ( category2.equals(t.getCategory()))
			{
				categoryRb7.setSelected(true);
			}

			String category3 = categoryRb8.getText();
			if ( category3.equals(t.getCategory()))
			{
				categoryRb8.setSelected(true);
			}

			String category4 = categoryRb9.getText();
			if ( category4.equals(t.getCategory()))
			{
				categoryRb9.setSelected(true);
			}

			//

			if (nowDisplaying == 1)
			{
				previousBt.setEnabled(true);
			}

			if (nowDisplaying == timeframe.getNumberOfTasks()-1)
			{
				nextBt.setEnabled(false);
			}
		}

		else if (action.equals("Edit"))
		{
			Task t = timeframe.getTask(nowDisplaying);

			// changing the values
			t.setDescription(descriptionTf.getText());
			t.setEstimatedHours(Integer.parseInt(hoursTf.getText()));

			String startingMonth = (String) startDateCb1.getSelectedItem();
			int startingDay = Integer.parseInt((String) startDateCb2.getSelectedItem());
			int startingYear = Integer.parseInt((String) startDateCb3.getSelectedItem());
			Date startingDate = new Date(startingMonth, startingDay, startingYear);

			try
			{
				t.setStartDate(startingDate);
			}

			catch (FebruaryException fe)
			{
				JOptionPane.showMessageDialog(null,"February only has 28 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
			}

			catch (MonthException me)
			{
				JOptionPane.showMessageDialog(null,"This month has only 30 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
			}

			String endingMonth = (String) dueDateCb4.getSelectedItem();
			int endingDay = Integer.parseInt((String) dueDateCb5.getSelectedItem());
			int endingYear = Integer.parseInt((String) dueDateCb6.getSelectedItem());
			Date endingDate = new Date(endingMonth, endingDay, endingYear);

			try
			{
				t.setDueDate(endingDate);
			}

			catch (FebruaryException fe)
			{
				JOptionPane.showMessageDialog(null,"February only has 28 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
			}

			catch (MonthException me)
			{
				JOptionPane.showMessageDialog(null,"This month has only 30 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
			}

			int priority = 0;

			if (priorityRb1.isSelected())
			{
				priority = Integer.parseInt(priorityRb1.getText());
			}

			if (priorityRb2.isSelected())
			{
				priority = Integer.parseInt(priorityRb2.getText());
			}

			if (priorityRb3.isSelected())
			{
				priority = Integer.parseInt(priorityRb3.getText());
			}

			if (priorityRb4.isSelected())
			{
				priority = Integer.parseInt(priorityRb4.getText());
			}

			if (priorityRb5.isSelected())
			{
				priority = Integer.parseInt(priorityRb5.getText());
			}

			t.setPriority(priority);

			String category = "";

			if (categoryRb6.isSelected())
			{
				category = categoryRb6.getText();
			}

			if (categoryRb7.isSelected())
			{
				category = categoryRb7.getText();
			}

			if (categoryRb8.isSelected())
			{
				category = categoryRb8.getText();
			}

			if (categoryRb9.isSelected())
			{
				category = categoryRb9.getText();
			}

			t.setCategory(category);

			JOptionPane.showMessageDialog(null, "Your changes have been saved!","EDIT", JOptionPane.INFORMATION_MESSAGE);

			System.out.println(t);
			System.out.println(timeframe);
		}
		else if (action.equals("Finish"))
		{
			Task t = timeframe.getTask(nowDisplaying);
			t.finishTask();
			System.out.println(t);
			JOptionPane.showMessageDialog(null, "You finished the task "+t.getDescription()+"\nCongratulations!!","FINISH", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (action.equals("Delete"))
		{
			Task t1 = timeframe.getTask(nowDisplaying);
			timeframe.deleteTask(nowDisplaying);
			clearDisplay();
			System.out.println(timeframe);

			JOptionPane.showMessageDialog(null, "The task "+t1.getDescription()+"was deleted!","DELETE", JOptionPane.INFORMATION_MESSAGE);

			Task t = null;
			if ( timeframe.getNumberOfTasks() == 0)
			{
				JOptionPane.showMessageDialog(null, "There are no more tasks in the list!","DELETE", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (nowDisplaying == 0)
			{
				t = timeframe.getTask(nowDisplaying + 1);
				nowDisplaying--;
				descriptionTf.setText(t.getDescription());
				hoursTf.setText(""+t.getEstimatedHours());
				startDateCb1.setSelectedItem((t.getStartDate()).getMonth());
				startDateCb2.setSelectedItem(""+(t.getStartDate()).getDay());
				startDateCb3.setSelectedItem(""+(t.getStartDate()).getYear());
				dueDateCb4.setSelectedItem((t.getDueDate()).getMonth());
				dueDateCb5.setSelectedItem(""+(t.getDueDate()).getDay());
				dueDateCb6.setSelectedItem(""+(t.getDueDate()).getYear());

				//setting the radio buttons for priority
				int priority1 = Integer.parseInt(priorityRb1.getText());
				if ( priority1 == t.getPriority())
				{
					priorityRb1.setSelected(true);
				}

				int priority2 = Integer.parseInt(priorityRb2.getText());
				if ( priority2 == t.getPriority())
				{
					priorityRb2.setSelected(true);
				}

				int priority3 = Integer.parseInt(priorityRb3.getText());
				if ( priority3 == t.getPriority())
				{
					priorityRb3.setSelected(true);
				}

				int priority4 = Integer.parseInt(priorityRb4.getText());
				if ( priority4 == t.getPriority())
				{
					priorityRb4.setSelected(true);
				}

				int priority5 = Integer.parseInt(priorityRb5.getText());
				if ( priority5 == t.getPriority())
				{
					priorityRb5.setSelected(true);
				}

				//setting the radio buttons for category
				String category1 = categoryRb6.getText();
				if ( category1.equals(t.getCategory()))
				{
					categoryRb6.setSelected(true);
				}

				String category2 = categoryRb7.getText();
				if ( category2.equals(t.getCategory()))
				{
					categoryRb7.setSelected(true);
				}

				String category3 = categoryRb8.getText();
				if ( category3.equals(t.getCategory()))
				{
					categoryRb8.setSelected(true);
				}

				String category4 = categoryRb9.getText();
				if ( category4.equals(t.getCategory()))
				{
					categoryRb9.setSelected(true);
				}
			}
			else
			{
				t = timeframe.getTask(nowDisplaying - 1);
				nowDisplaying--;
				descriptionTf.setText(t.getDescription());
				hoursTf.setText(""+t.getEstimatedHours());
				startDateCb1.setSelectedItem((t.getStartDate()).getMonth());
				startDateCb2.setSelectedItem(""+(t.getStartDate()).getDay());
				startDateCb3.setSelectedItem(""+(t.getStartDate()).getYear());
				dueDateCb4.setSelectedItem((t.getDueDate()).getMonth());
				dueDateCb5.setSelectedItem(""+(t.getDueDate()).getDay());
				dueDateCb6.setSelectedItem(""+(t.getDueDate()).getYear());

				//setting the radio buttons for priority
				int priority1 = Integer.parseInt(priorityRb1.getText());
				if ( priority1 == t.getPriority())
				{
					priorityRb1.setSelected(true);
				}

				int priority2 = Integer.parseInt(priorityRb2.getText());
				if ( priority2 == t.getPriority())
				{
					priorityRb2.setSelected(true);
				}

				int priority3 = Integer.parseInt(priorityRb3.getText());
				if ( priority3 == t.getPriority())
				{
					priorityRb3.setSelected(true);
				}

				int priority4 = Integer.parseInt(priorityRb4.getText());
				if ( priority4 == t.getPriority())
				{
					priorityRb4.setSelected(true);
				}

				int priority5 = Integer.parseInt(priorityRb5.getText());
				if ( priority5 == t.getPriority())
				{
					priorityRb5.setSelected(true);
				}

				//setting the radio buttons for category
				String category1 = categoryRb6.getText();
				if ( category1.equals(t.getCategory()))
				{
					categoryRb6.setSelected(true);
				}

				String category2 = categoryRb7.getText();
				if ( category2.equals(t.getCategory()))
				{
					categoryRb7.setSelected(true);
				}

				String category3 = categoryRb8.getText();
				if ( category3.equals(t.getCategory()))
				{
					categoryRb8.setSelected(true);
				}

				String category4 = categoryRb9.getText();
				if ( category4.equals(t.getCategory()))
				{
					categoryRb9.setSelected(true);
				}
			}

			if (nowDisplaying == 1)
			{
				previousBt.setEnabled(false);
			}

			if (nowDisplaying == timeframe.getNumberOfTasks() -2)
			{
				nextBt.setEnabled(true);
			}

		}

		else if (action.equals("Running Tasks"))
		{
			timeframe.displayTasks();
		}

		else if (action.equals("Prioritized Tasks"))
		{
			timeframe.displayPriority();
		}

		else if (action.equals("Completed Tasks"))
		{
			timeframe.displayCompleteness();
		}

	}

	public void clearDisplay()
	{
		descriptionTf.setText("");
		hoursTf.setText("");
		priorityBg.clearSelection();
		categoryBg.clearSelection();
		startDateCb1.setSelectedItem(null);
		startDateCb2.setSelectedItem(null);
		startDateCb3.setSelectedItem(null);
		dueDateCb4.setSelectedItem(null);
		dueDateCb5.setSelectedItem(null);
		dueDateCb6.setSelectedItem(null);
	}


	public void loadBaseFromFile(String filename)
	{
		TaskListFileReader reader = new TaskListFileReader(filename);

		try
		{
			t1 = reader.getTaskListFromFile();
		}

		catch(EOFException e)
		{
			JOptionPane.showMessageDialog (null,
			"Songs Are Loaded from File to the playlist successfully",
			"File Loading Finished", JOptionPane.INFORMATION_MESSAGE );
			reader.close();
		}

	}

	public void saveBaseToFile(String filename)
	{
		TaskListFileWriter writer = new TaskListFileWriter(filename, timeframe);
		writer.close();
	}
}