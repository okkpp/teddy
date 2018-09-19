package okkpp.test;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;

public class PathMatchTest {

	public static void main(String[] args) {
		PatternMatcher matcher = new AntPathMatcher();
		boolean isMatch = matcher.matches("/**", "/okkpp/88");
		System.out.println(isMatch);
	}

}
