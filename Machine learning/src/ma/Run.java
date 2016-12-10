package ma;

import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {

	//input here how many movies would you like to download in a file called
   // movie_database.json
		
 // in the very last line of the file (open it with a gooood text editor like sublimetext) well see ",]" ,replace it with  "]"
		
		int NrMovies=6000;
		
//p.s more movies means more time more cpu more possible failures 

		CreateDB.parseURLForDB(Parse.parseURL(NrMovies));
	
	}

}
