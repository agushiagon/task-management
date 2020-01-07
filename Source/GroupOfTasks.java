import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GroupOfTasks implements Serializable
{
	private Task tasks[];
	private int numberOfTasks = 0;
	private final int MAX_VALUE = 6;
	ArrayList<Task> list = new ArrayList<Task>();

	GroupOfTasks()
	{
		tasks = new Task[MAX_VALUE];
		numberOfTasks = 0;
	}

	public void addTask(Task t) throws ArrayIndexOutOfBoundsException
	{
		if (numberOfTasks > MAX_VALUE )
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		else
		{
			tasks[numberOfTasks] = t;
			numberOfTasks = numberOfTasks + 1;
		}

	}

	public Task getTask(int position)
	{
		return tasks[position];
	}

	public int getNumberOfTasks()
	{
		return numberOfTasks;
	}

	public void deleteTask(int nowDisplaying)
	{
		list.remove(nowDisplaying);
		numberOfTasks--;
	}

	public void displayCompleteness()
	{
		for (int i=0; i<list.size(); i++)
		{
			if (((list.get(i)).getCompleteness()) == true )
			{
				JOptionPane.showMessageDialog(null,"The completed tasks are:\t"+list.get(i).getDescription());
			}
		}
	}

	public void displayTasks()
	{
		StringBuilder builder = new StringBuilder(tasks.length);
		for (int i=0;i<tasks.length;builder.append(tasks[i++])) builder.append("\n");
		{
			JOptionPane.showMessageDialog(null, builder.toString(), "Printing results", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void displayPriority()
	{
		for (int i=0; i<list.size(); i++)
		{
			if (((list.get(i)).getPriority()) > 3)
			{
				JOptionPane.showMessageDialog(null,"The prioritized tasks are:\t"+list.get(i).getDescription());
			}
		}
	}

	public Task[] getArray()
	{
		return tasks;
	}

	public String toString()
	{
		return "\nNumber Of Tasks:\t"+ getNumberOfTasks();
	}

}