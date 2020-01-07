//The TaskList File Reader Manager
//by George Eleftherakis

import java.io.*;
import javax.swing.JOptionPane;

public class TaskListFileReader {

	private ObjectInputStream _input;


    TaskListFileReader(String filename) {

		try {
        	_input = new ObjectInputStream(new FileInputStream(filename) );

        }
        catch (IOException e) {
        	JOptionPane.showMessageDialog (null, "Invalid File Name (Read)", "File " + filename + " Not Found", JOptionPane.ERROR_MESSAGE );
        }

	}

	public GroupOfTasks getTaskListFromFile () throws EOFException {

		GroupOfTasks c = null;
		try {
			c = (GroupOfTasks) _input.readObject();
		}
		catch (ClassNotFoundException e) {
         	JOptionPane.showMessageDialog (null, "Unable to create Object while reading from file", e.getMessage(), JOptionPane.ERROR_MESSAGE );
 		}
		catch (IOException e) {
         	if (e instanceof EOFException) throw (EOFException) e;
         	else JOptionPane.showMessageDialog (null, e.getMessage(), "Abnormal situation while reading the MP3Playlists from the file", JOptionPane.ERROR_MESSAGE );
 		}
 		return c;

   	}

   	public void close() {

		try {
			_input.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog (null, "Error closing file", "File Error", JOptionPane.ERROR_MESSAGE );
		}
	}

}

