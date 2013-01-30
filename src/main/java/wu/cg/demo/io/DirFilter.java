package wu.cg.demo.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
	this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File file, String name) {
	return pattern.matcher(name).matches();
	// return filename.indexOf(".bat") != -1;
    }
}
