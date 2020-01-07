import javax.swing.JOptionPane;

public class TaskTest
{
	public static void main(String args[])
	{
		// Default Constructor

		Task t1 = new Task();

		// Non-default Constructor

		String dec = "Programming practical";
		int eh = 40;
		Date sd = new Date("September",10,2013);
		Date dd = new Date("September",30,2013);
		int p = 4;
		String cat = "CITY";

		Task t2 = null;
		try
		{
			t2 = new Task(dec, eh, sd, dd, p, cat);
		}

		catch (FebruaryException fe)
		{
			JOptionPane.showMessageDialog(null,"February only has 28 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
		}

		catch (MonthException me)
		{
			JOptionPane.showMessageDialog(null,"This month has only 30 days!\n Please write a valid date","Wrong Date Input",JOptionPane.ERROR_MESSAGE);
		}

		//Printing the tasks

		System.out.println(t1);
		System.out.println(t2);
	}
}