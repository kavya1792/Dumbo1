package Utils;

import java.io.File;

public class FilePath {
	
		
		public static String get_path(String fileName) {
			File f=new File(fileName);
		return f.getAbsolutePath();	
		}
}
