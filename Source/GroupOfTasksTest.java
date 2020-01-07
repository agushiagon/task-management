import javax.swing.JOptionPane;

public class GroupOfTasksTest
{
	public static void main(String args[])
	{
		GroupOfTasks timeframe = new GroupOfTasks();

		//Adding the first task

		Task t1 = new Task();
		timeframe.addTask(t1);
		(timeframe.list).add(t1);

		// Non-default Constructors

		//Adding the second task

		Task t2 = null;
		try
		{
			String dec = "Programming practical";
			int eh = 40;
			Date sd = new Date("September",10,2013);
			Date dd = new Date("September",30,2013);
			int p = 4;
			String cat = "CITY";

			t2 = new Task(dec, eh, sd, dd, p, cat);

			timeframe.addTask(t2);
			(timeframe.list).add(t2);
		}

		catch (FebruaryException fe)
		{
			JOptionPane.showMessageDialog(null,"February only has 28 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
		}

		catch (MonthException me)
		{
			JOptionPane.showMessageDialog(null,"This month has only 30 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
		}

		//Adding the third task

		Task t3 = null;
		try
		{
			String dec = "MORNING RUN";
			int eh = 90;
			Date sd = new Date("September",1,2013);
			Date dd = new Date("January",2,2014);
			int p = 2;
			String cat = "PERSONAL";

			t3 = new Task(dec, eh, sd, dd, p, cat);
			t3.finishTask();
			timeframe.addTask(t3);
			(timeframe.list).add(t3);
		}

		catch (FebruaryException fe)
		{
			JOptionPane.showMessageDialog(null,"February only has 28 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
		}

		catch (MonthException me)
		{
			JOptionPane.showMessageDialog(null,"This month has only 30 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
		}

		//Showing the tasks using the methods from the GroupOfTasks

		timeframe.displayCompleteness();

		timeframe.displayPriority();




	}
}