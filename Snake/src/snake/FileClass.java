package snake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FileClass {
	
	// Attributes
	File f;
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	
	// Methods
	
	public void changeCurrentUser(String userIn) {
		openCurrentUserFile();
		openFileWriters();
		writeToFile(userIn);
		closeWritingStream();
	}
	
	public String getCurrentUser() {
		openCurrentUserFile();
		openFileReaders();
		String currentUser = readLineFromFile();
		closeReadingStream();
		return currentUser;
	}
	
	public Color getSnakeColour(String userIn) {
		openUserFile(userIn);
		openFileReaders();
		readLineFromFile();
		readLineFromFile();
		String redString = readLineFromFile();
		int red = (int) (Double.parseDouble(redString)*255);
		String greenString = readLineFromFile();
		int green = (int) (Double.parseDouble(greenString)*255);
		String blueString = readLineFromFile();
		int blue = (int) (Double.parseDouble(blueString)*255);
		closeReadingStream();
		return Color.rgb(red, green, blue);
	}

	
	public Color getFruitColour(String userIn) {
		openUserFile(userIn);
		openFileReaders();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		String redString = readLineFromFile();
		int red = (int) (Double.parseDouble(redString)*255);
		String greenString = readLineFromFile();
		int green = (int) (Double.parseDouble(greenString)*255);
		String blueString = readLineFromFile();
		int blue = (int) (Double.parseDouble(blueString)*255);
		closeReadingStream();
		return Color.rgb(red, green, blue);
	}
	
	public String getSpeed(String userIn) {
		openUserFile(userIn);
		openFileReaders();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		String string = readLineFromFile();
		closeReadingStream();
		return string;
	}
	
	public String getUpControl(String userIn) {
		openUserFile(userIn);
		openFileReaders();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		String control = readLineFromFile();
		closeReadingStream();
		return control;
	}
	
	public String getLeftControl(String userIn) {
		openUserFile(userIn);
		openFileReaders();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		String control = readLineFromFile();
		closeReadingStream();
		return control;
	}
	
	public String getRightControl(String userIn) {
		openUserFile(userIn);
		openFileReaders();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		String control = readLineFromFile();
		closeReadingStream();
		return control;
	}
	
	public String getDownControl(String userIn) {
		openUserFile(userIn);
		openFileReaders();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		readLineFromFile();
		String control = readLineFromFile();
		closeReadingStream();
		return control;
	}
	
	public String getCurrentUserHighScore() {
		openUserFile(getCurrentUser());
		openFileReaders();
		readLineFromFile();
		String highScore = readLineFromFile();
		closeReadingStream();
		return highScore;
	}
	
	public String getUserHighScore(String userNameIn) {
		openUserFile(userNameIn);
		openFileReaders();
		readLineFromFile();
		String userHighScore = readLineFromFile();
		closeReadingStream();
		return userHighScore;
	}
	
	public ArrayList<String> getUserList() {
		ArrayList<String> userList = new ArrayList<>();
		openUserListFile();
		openFileReaders();
		String line = readLineFromFile();
		while (line != null) {
			userList.add(line);
			line = readLineFromFile();
		}
		closeReadingStream();
		return userList;
	}
	
	public void openCurrentUserFile() {
		f = new File("currentUser.txt");
	}
	
	public void openUserFile(String userNameIn) {
		f = new File(userNameIn + "UserName.txt");
	}
	
	public void openUserListFile() {
		f = new File("userListFile.txt");
	}
	
	public void openFileWriters() {
		try {
			fw = new FileWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		
	}
	
	public void writeToFile(String stringToWrite) {
		try {
			bw.write(stringToWrite);
			bw.write("\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeWritingStream() {
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openFileReaders() {
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch(FileNotFoundException e) {
		e.printStackTrace();
		}
	}
	
	public void closeReadingStream() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readLineFromFile() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "NIL";
		}
	}
	
	public void deleteFile() {
		f.delete();
	}
	
	public void createUserFile(UserClass string) {
		openUserFile(string.getUserName());
		openFileWriters();
		writeToFile(string.getUserName());
		writeToFile("" + string.getHighScore());
		writeToFile("" + string.getSnakeRed());
		writeToFile("" + string.getSnakeGreen());
		writeToFile("" + string.getSnakeBlue());
		writeToFile("" + string.getFruitRed());
		writeToFile("" + string.getFruitGreen());
		writeToFile("" + string.getFruitBlue());
		writeToFile("" + string.getSnakeSpeed());
		writeToFile("" + string.getUpControl());
		writeToFile("" + string.getDownControl());
		writeToFile("" + string.getLeftControl());
		writeToFile("" + string.getRightControl());
		closeWritingStream();
	}
	
	public void rewriteUserSnakeColour(String userNameIn, Color colourIn) {
		rewriteLineInUserFile(userNameIn, 2, "" + colourIn.getRed());
		rewriteLineInUserFile(userNameIn, 3, "" + colourIn.getGreen());
		rewriteLineInUserFile(userNameIn, 4, "" + colourIn.getBlue());
	}
	
	public void rewriteUserFruitColour(String userNameIn, Color colourIn) {
		rewriteLineInUserFile(userNameIn, 5, "" + colourIn.getRed());
		rewriteLineInUserFile(userNameIn, 6, "" + colourIn.getGreen());
		rewriteLineInUserFile(userNameIn, 7, "" + colourIn.getBlue());
	}
	
	public void rewriteUserSpeed(String userNameIn, String speedIn) {
		rewriteLineInUserFile(userNameIn, 8, speedIn);
	}
	
	public void rewriteUserUpControl(String userNameIn, String controlIn) {
		rewriteLineInUserFile(userNameIn, 9, controlIn);
	}
	
	public void rewriteUserDownControl(String userNameIn, String controlIn) {
		rewriteLineInUserFile(userNameIn, 10, controlIn);
	}
	
	public void rewriteUserLeftControl(String userNameIn, String controlIn) {
		rewriteLineInUserFile(userNameIn, 11, controlIn);
	}
	
	public void rewriteUserRightControl(String userNameIn, String controlIn) {
		rewriteLineInUserFile(userNameIn, 12, controlIn);
	}
	
	public void rewriteUserHighScore(String userNameIn, String highScoreIn) {
		rewriteLineInUserFile(userNameIn, 1, highScoreIn);
	}
	
	public void rewriteLineInUserFile(String userNameIn, int lineToRewrite, String replacementLine) {
		
		openUserFile(userNameIn);
		
		openFileReaders();
		ArrayList<String> a = new ArrayList<>();
		int i = 0;
		String line = readLineFromFile();
		while (line != null) {
			a.add(line);
			i++;
			line = readLineFromFile();
		}
		closeReadingStream();
		
		deleteFile();
		openUserFile(userNameIn);
		
		openFileWriters();
		for (int j=0; j < a.size(); j++) {
			if (j != lineToRewrite) {
				writeToFile(a.get(j));
			} else {
				writeToFile(replacementLine);
			}
		}
		closeWritingStream();
	}
	
	public void deleteLineInUserListFile(int lineToDelete) {
		
		openUserListFile();
		
		openFileReaders();
		ArrayList<String> a = new ArrayList<>();
		String line = readLineFromFile();
		while (line != null) {
			a.add(line);
			line = readLineFromFile();
		}
		closeReadingStream();
		
		deleteFile();
		openUserListFile();
		
		openFileWriters();
		for (int j=0; j < a.size(); j++) {
			if (j != lineToDelete) {
				writeToFile(a.get(j));
			}
		}
		closeWritingStream();
		
	}	
	
	public void addUserToUserListFile(String userNameIn) {
		

		
		openUserListFile();
		
		openFileReaders();
		ArrayList<String> a = new ArrayList<>();
		String line = readLineFromFile();
		while (line != null) {
			a.add(line);
			line = readLineFromFile();
		}
		closeReadingStream();
		
		deleteFile();

		a.add(userNameIn);
		
		openUserListFile();
		
		openFileWriters();
		for (int j=0; j < a.size(); j++) {
			writeToFile(a.get(j));
		}
		closeWritingStream();
	}	
	
	public void deleteUserFromUserListFile(String userNameIn) {
		
		ArrayList<String> a = new ArrayList<>();
		
		openUserListFile();
		
		openFileReaders();
		String line = readLineFromFile();
		while (line != null) {
			if (!line.equals(userNameIn)) {
				a.add(line);
			}
			line = readLineFromFile();
		}
		closeReadingStream();
		
		openFileWriters();
		for (String item : a) {
			writeToFile(item);
		}
		closeWritingStream();
	}
}
