package sample04;

import java.io.FileWriter;
import java.io.IOException;

//파일로 출력
public class FileOutputter implements Outputter {
	private String fileName, filePath;
	
	
	public void setFileName(String fileName) {
		System.out.println("setFileName(String fileName)");
		this.fileName = fileName;
	}


	public void setFilePath(String filePath) {
		System.out.println("setFilePath(String filePath)");
		this.filePath = filePath;
	}


	@Override
	public void output(String message) {
		try {
			FileWriter fileWriter = new FileWriter(filePath + fileName);
			fileWriter.write(message);
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
