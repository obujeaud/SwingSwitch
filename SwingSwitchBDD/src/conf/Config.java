package conf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Config {
	private String choice;
	private static Config con = null;
	private String firstLineText, secondLineText, firstLineClass, secondLineClass;
	
	public String getFirstLineText() {
		return firstLineText;
	}

	public void setFirstLineText(String firstLineText) {
		this.firstLineText = firstLineText;
	}

	public String getSecondLineText() {
		return secondLineText;
	}

	public void setSecondLineText(String secondLineText) {
		this.secondLineText = secondLineText;
	}

	public String getFirstLineClass() {
		return firstLineClass;
	}

	public void setFirstLineClass(String firstLineClass) {
		this.firstLineClass = firstLineClass;
	}

	public String getSecondLineClass() {
		return secondLineClass;
	}

	public void setSecondLineClass(String secondLineClass) {
		this.secondLineClass = secondLineClass;
	}

	private Config() {
		
	}
	
	public static Config getInstance() {
		if(con == null) {
			con = new Config();
		}
		return con;
	}
	
	public String getChoice() {
		return choice;
	}

	public void setChoice(String c) {
		choice = c;
	}
	
	public void openBDD() throws FileNotFoundException {
		
	}
	
	public void getText() throws IOException  {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("file/conf.txt")));
			String first = br.readLine();
			setFirstLineText(first.substring(0, first.indexOf(",")));
			setFirstLineClass(first.substring(first.indexOf(",")+1));
			String second = br.readLine();
			setSecondLineText(second.substring(0, second.indexOf(",")));
			setSecondLineClass(second.substring(second.indexOf(",")+1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}