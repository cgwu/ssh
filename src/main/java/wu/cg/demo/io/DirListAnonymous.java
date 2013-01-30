package wu.cg.demo.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirListAnonymous {

    static Logger log = LoggerFactory.getLogger(DirListAnonymous.class);

    public static FilenameFilter filter(final String regex) {

	final Pattern pattern = Pattern.compile(regex);
	//Creation of anonymous inner class. 
	return new FilenameFilter() {
	    @Override
	    public boolean accept(File paramFile, String filename) {
		log.debug("try to match: {}",filename);
		return pattern.matcher(filename).matches();
	    }
	}; // End of anonymous inner class
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	log.debug("{}", File.pathSeparator);
	log.debug("{}", File.separator);

	File dir = new File("c:\\");
	log.debug("{}", dir.getAbsoluteFile());
	log.debug("{}", dir.getAbsolutePath());

	String[] fileNames = dir.list(filter(".*"));
	
	Arrays.sort(fileNames,String.CASE_INSENSITIVE_ORDER);
	
	for (String file : fileNames) {
	    log.debug(file);
	}
	boolean b = Pattern.matches("a*.", "aaaaab");
	System.out.println(b);

    }
}
