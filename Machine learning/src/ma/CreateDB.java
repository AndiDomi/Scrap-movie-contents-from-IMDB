package ma;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


import org.apache.commons.io.IOUtils;

public class CreateDB {

	static URL url;
	static int count=0;
	public static void parseURLForDB(ArrayList<String> urls) throws IOException {
		FileWriter fr = new FileWriter("movie_database.json");
		 
		if(!urls.isEmpty()){
			fr.write("[");
			for(String urlt:urls){
				url=new URL(urlt);
				URLConnection con = url.openConnection();
				InputStream in = con.getInputStream();
				String encoding = con.getContentEncoding(); 
				encoding = encoding == null ? "UTF-8" : encoding;
				String body = IOUtils.toString(in, encoding);
				System.out.println(count++);
		          fr.write(System.lineSeparator());
		          
		          fr.write(body);
		          fr.write(",");
				// in the very last loop well see , in the very end just remove it near ] 
			}
		}
		 fr.write("]");
		 
		fr.close();
    }
}
