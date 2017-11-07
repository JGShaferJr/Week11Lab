import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 * 
 */

/**
 * @author jgsha
 *
 */
public class Lab11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// folder path C:\Users\jgsha\Desktop\Backup\APOLLO
		// folder path C:\Users\jgsha\Desktop\Backup\SPEED

		Path p1 = Paths.get("C:\\Users\\jgsha\\Desktop\\Backup\\SPEED\\SPEED_20171102_1of10.txt");

		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt*");

		File folder = new File("C:\\Users\\jgsha\\Desktop\\Backup\\SPEED");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (matcher.matches(Paths.get(listOfFiles[i].getPath()).getFileName()))
				System.out.println("Kept: " + Paths.get(listOfFiles[i].getPath()));
			else {
				System.out.println("Deleted: " + Paths.get(listOfFiles[i].getPath()));
				Files.delete(Paths.get(listOfFiles[i].getPath()));
			}
		}
		
		checkApolloFiles();
	}

	private static void checkApolloFiles() {
		File folder = new File("C:\\Users\\jgsha\\Desktop\\Backup\\APOLLO");
		File[] listOfFiles = folder.listFiles();
		
		Path filename = Paths.get(listOfFiles[0].getPath()).getFileName();
		System.out.println(filename);
		System.out.println("Folder contains: " + listOfFiles.length + " files");
		System.out.println("Missing 1 of 4.");
	}

}
