package wu.cg.other;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStringUtils {

    static final Logger LOG = LoggerFactory.getLogger(TestStringUtils.class);
    
    @Test
    public void test() {
	String s=null;
		
	boolean bIsEmpty = StringUtils.isEmpty(s);
	LOG.info("is empty? {}",bIsEmpty);
	
	s = "yes";
	bIsEmpty = StringUtils.isEmpty(s);
	LOG.info("is empty? {}",bIsEmpty);
	
	String sProcessed =  StringUtils.leftPad(s, 10,'0');
	System.out.println(sProcessed);
	
	String sRPad =  StringUtils.rightPad(s, 20,'#');
	
	String sPRadAbbrev = StringUtils.abbreviate(sRPad,10);
	System.out.println(sPRadAbbrev);
	
    }

}
