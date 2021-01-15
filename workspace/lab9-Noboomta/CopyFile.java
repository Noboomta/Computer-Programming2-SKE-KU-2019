import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Copy a source file to a destination file.
 * Works with any kind of file, not just text files.
 *
 * Usage: java Copyfile sourcefile destfile
 * 
 * The sourcefile must exist, be readable, and
 * be a regular file (not a directory, link, etc), 
 * and the destfile must *not* exist.
 */
public class CopyFile {
	
	/**
	 * Print a help message and exit.
	 */
	private static void usage() {
		String name = CopyFile.class.getName();
		System.out.printf("Usage: java %s sourcefile destfile\n", name);
		System.exit(0);
	}
	
	/**
	 * Print an error message and exit with exit code 1.
	 * @param message the error text to print
	 */
	private static void error(String message) {
		System.out.println(message);
		System.exit(1);
	}
	
	/**
	 * Copy a source file to a destination file
	 * @param source name of the source file to copy
	 * @param dest name of the destination file to receive copy
	 */
	private static void copyfile(String source, String dest) {
		// Source to read from
		File sourcefile = new File(source);
		if (! sourcefile.exists() || ! sourcefile.isFile()) error(source+" does not exist or is not a regular file.");
		if (! sourcefile.canRead()) error(source+" is not readable");
		// Destination to receive copy
		File destfile = new File(dest);
		if (destfile.exists()) error("Destination "+dest+" already exists, not overwriting it.");
		try {
			if (! destfile.createNewFile()) error("Could not create destination file "+dest);
		} catch (IOException ex) {
			error("I/O Error creating destination file "+dest);
		}
		// Must define InputStream and OutputStream here so that their
		// "scope" includes the finally block
		try (InputStream in = new FileInputStream(sourcefile);
		OutputStream out = new FileOutputStream(destfile);){
			int expectByte = 1024;
			byte[] buff = new byte[expectByte];	
			// int c = in.read(buff);
			// int allByte = c.read(byte);
			// int leftByte = allByte%expectByte;
			while(true){
				int c = in.read(buff);
				if(c<=0) break;
				out.write(buff, 0, c);
			} 
		} 
		catch (FileNotFoundException fne) {
			error( fne.getMessage() );
		} 
		catch (IOException ioe) {
			error( ioe.getMessage() );
		}
	}

	/**
	 * Run the CopyFile application.
	 * @param args contain the name of source file (exists) and 
	 *    destination file (to create).
	 */
	public static void main(String[] args) {
		double start = System.nanoTime();
		if (args.length != 2) usage();
		copyfile(args[0], args[1]);
		double stop = System.nanoTime();
		double elapse = (stop-start)/1_000_000_000;
		System.out.println(elapse);
	}
}
