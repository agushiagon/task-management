import java.io.*;
import javax.swing.JOptionPane;

public class Task implements Serializable
{
	private String description;
	private Date startDate;
	private Date dueDate;
	private int estimatedHours;
	private int priority;
	private String category;
	private boolean completeness;

	Task()
	{
		description = null;
		startDate = null;
		dueDate = null;
		estimatedHours = 0;
		priority = 0;
		category = null;
		completeness = false;
	}

	Task(String dec, int eh, Date sd, Date dd, int p, String cat) throws MonthException, FebruaryException
	{
		setDescription(dec);
		setEstimatedHours(eh);

		try
		{
			setStartDate(sd);
		}
		catch (MonthException e)
		{
			throw e;
		}

		catch (FebruaryException e)
		{
			throw e;
		}

		try
		{
			setDueDate(dd);
		}

		catch (MonthException e)
		{
			throw e;
		}

		catch (FebruaryException e)
		{
			throw e;
		}

		setPriority(p);
		setCategory(cat);
		completeness = false;
	}

	public Boolean finishTask()
	{
		return completeness = true;
	}


	//SET METHODS

	public void setDescription(String dec)
	{
		description = dec;
	}

	public void setStartDate(Date sd) throws FebruaryException, MonthException
	{

		if ("February".equals(sd.getMonth()) && sd.getDay() >29)
		{
			throw new FebruaryException();
		}

		if (("September".equals(sd.getMonth()) && sd.getDay() >30) || ("April".equals(sd.getMonth()) && sd.getDay()>30) || ("June".equals(sd.getMonth()) && sd.getDay()>30) || ("November".equals(sd.getMonth()) && sd.getDay()>30))
		{
			throw new MonthException();
		}
		else
		{
			startDate = sd;
		}
	}

	public void setDueDate(Date dd) throws FebruaryException, MonthException
	{
		if ("February".equals(dd.getMonth()) && dd.getDay() >29)
		{
			throw new FebruaryException();
		}

		if (("September".equals(dd.getMonth()) && dd.getDay() >30) || ("April".equals(dd.getMonth()) && dd.getDay()>30) || ("June".equals(dd.getMonth()) && dd.getDay()>30) || ("November".equals(dd.getMonth()) && dd.getDay()>30))

		{
			throw new MonthException();
		}
		else
		{
			dueDate = dd;
		}
	}

	public void setEstimatedHours(int eh)
	{
		estimatedHours = eh;
	}

	public void setPriority(int p)
	{
		priority = p;
	}

	public void setCategory(String cat)
	{
		category = cat;
	}

	public void setCompleteness(Boolean comp)
	{
		completeness = comp;
	}



	//GET METHODS

	public String getDescription()
	{
		return description;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public Date getDueDate()
	{
		return dueDate;
	}

	public int getEstimatedHours()
	{
		return estimatedHours;
	}

	public int getPriority()
	{
		return priority;
	}

	public String getCategory()
	{
		return category;
	}

	public Boolean getCompleteness()
	{
		return completeness;
	}

	// TOSTRING METHOD

	public String toString()
	{
		return "\nDescription:\t"+ description + "\nEst Hours:\t" +estimatedHours+"\nStart Date:\t" + startDate + "\nDue Date:\t" + dueDate + "\nPriority:\t" +priority+"\nCategory:\t" +category+"\ncompleteness:\t"+completeness+ "\n";
	}


}