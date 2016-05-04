package com.gmail.ichglauben.fileretriever;

import com.gmail.ichglauben.fileretriever.core.concretes.FileRetriever;
import com.gmail.ichglauben.fileretriever.core.utils.abstracts.CustomClass;

public class App extends CustomClass {
	public static void main(String[] args) {
		String file = FileRetriever.retrieveFile();
		print("Chosen File: " + file);
		
		file = FileRetriever.retrieveFile("Jpegs", new String[] {"jpg"});
		print("Chosen File: " + file); 
		
		file = FileRetriever.retrieveFile("Text Files", new String[] {"txt"});
		print("Chosen File: " + file); 
	}
}
