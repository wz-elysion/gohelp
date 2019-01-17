package wz_ling1991.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	private StringUtil() {}
	
	/**
	 * 获取string中reg第n次出现的index
	 * @param string
	 * @param reg
	 * @param n
	 * @return
	 */
	public static int getCharacterPosition(String string,String reg,int n){
	    Matcher slashMatcher = Pattern.compile(reg).matcher(string);
	    int mIdx = 0;
	    while(slashMatcher.find()) {
	    	if(mIdx>string.length()){
	    		return -1;
	    	}
	       mIdx++;
	       if(mIdx == n){
	          break;
	       }
	    }
	    return slashMatcher.start();
	 }

}
