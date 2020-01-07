import java.io.*;

public class Date implements Serializable
{
	private String month;
	private int day;
	private int year;

	Date()
	{
		month = null;
		day = 0;
		year = 0;
	}

	Date(String m, int d, int y)
	{
		month = m;
		day = d;
		year = y;
	}

	//SET METHODS

	public void setMonth(String m)
	{
		month = m;
	}

	public void setDay(int d)
	{
		day = d;
	}

	public void setYear(int y)
	{
			year = y;
	}

	//GET METHODS

	public String getMonth()
	{
		return month;
	}

	public int getDay()
	{
		return day;
	}

	public int getYear()
	{
			return year;
	}

	//TOSTRING

	public String toString()
	{
		return month+"."+day+"."+year;
	}
}