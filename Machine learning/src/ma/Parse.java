package ma;

import java.io.*;
import java.net.*;

import java.util.ArrayList;





public class Parse {
    public static ArrayList<String> parseURL(int number_of_movies) throws IOException {

        InputStream is = null;
        BufferedReader br;
        String line;
        URL url;
 ArrayList<String> urls = new ArrayList<String>();
        try {
        	
            url = new URL("http://www.imdb.com/search/title?sort=num_votes,desc&start=1&title_type=feature&year=2015&view=simple&count="+number_of_movies+"&page=1");
//            System.out.println(url);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                if(line.contains("<a href=\"/title/")	&&line.contains("ref_=adv_li_tt")){
                	urls.add("http://www.omdbapi.com/?i="+line.substring(20,29)+"&plot=full&r=json");
//                	System.out.println(line.substring(20,29));

                }       
            }
        } catch (MalformedURLException mue) {
             mue.printStackTrace();
        } catch (IOException ioe) {
             ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                //exception
            }
        }
		return urls;
    }
}