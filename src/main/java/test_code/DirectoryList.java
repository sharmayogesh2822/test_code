package test_code;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DirectoryList {
	public static void main(String[] args) {
		File path=new File("/home/pixel");
		String []list;
		Scanner in=new Scanner(System.in);
		String s=in.next();
		list=path.list(new directoryFilter(s));
		for(int i=0;i<list.length;i++)
			System.out.println(list[i]);
		in.close();
	}
}
class directoryFilter implements FilenameFilter {
	private Pattern pattern;	
	public directoryFilter(String regex) {
		pattern=Pattern.compile(regex);
	}
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}