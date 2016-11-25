package sadowski;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Class used to write something to text file
 * @author szymon
 *
 */
public class FileWriter {
	/**
	 * This method writes /lines/ to file located ad relative /path/, and separate them by /lineSeparator/ 
	 * @see System#lineSeparator()
	 * @param path
	 * Relative path to file, which will be saved
	 * @param lines
	 * Lines that will be written to file
	 * @throws IOException
	 */
	static void writeLines(String path, String[] lines) throws IOException {
		File outputFile = new File(path);
		outputFile.createNewFile();
		OutputStream os = new FileOutputStream(outputFile);
		Writer w = new OutputStreamWriter(os, "UTF-8");
		
		for(String line : lines) {
			w.write(line);
			w.write(System.lineSeparator());
		}
		
		w.close();
	}
	
	static void writeLinesAndShowMapping(String path, String[] lines, String[] pre, String mappingSymbol) throws IOException {
		File outputFile = new File(path);
		outputFile.createNewFile();
		OutputStream os = new FileOutputStream(outputFile);
		Writer w = new OutputStreamWriter(os, "UTF-8");
		
		int it = 0;
		for(String line : lines) {
			w.write(pre[it++]);
			w.write(mappingSymbol);
			w.write(line);
			w.write(System.lineSeparator());
		}
		
		w.close();
	}
}