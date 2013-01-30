package wu.cg.demo.io;

import java.io.File;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirList {

    static Logger log = LoggerFactory.getLogger(DirList.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

	log.debug("{}", File.pathSeparator);
	log.debug("{}", File.separator);

	File dir = new File("c:\\");
	log.debug("{}", dir.getAbsoluteFile());
	log.debug("{}", dir.getAbsolutePath());

	String[] fileNames = dir.list(new DirFilter(".*\\.bat"));
	for (String file : fileNames) {
	    log.debug(file);
	}
	boolean b = Pattern.matches("a*.", "aaaaab");
	System.out.println(b);

    }
}
