//The TaskList File Writer Manager
//by George Eleftherakis

import java.io.*;
import javax.swing.JOptionPane;

public class TaskListFileWriter {

	private ObjectOutputStream output;

    TaskListFileWriter(String filename, Object c) {

		try {
        	output = new ObjectOutputStream(new FileOutputStream(filename) );
        	putTaskListToFile (c);

        }
        catch (IOException e) {
        	JOptionPane.showMessageDialog (null, "File " + filename + " Not Found", "Invalid File Name (Write)", JOptionPane.ERROR_MESSAGE );
        }

	}

	public void putTaskListToFile (Object c) {

		try {
			output.writeObject(c);
			output.flush();
		}
		catch (IOException e) {
         	JOptionPane.showMessageDialog (null, e.getMessage(), "Unable to write Object while writing to file", JOptionPane.ERROR_MESSAGE );
 		}

   	}

   	public void close() {

		try {
			output.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog (null, "Error closing file", "File Error", JOptionPane.ERROR_MESSAGE );
		}
	}


}

