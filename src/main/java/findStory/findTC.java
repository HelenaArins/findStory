package findStory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import findStory.searchStory;

public class findTC {

	public static void main(String[] args) throws IOException {	    
        int i;
        ArrayList<String> testCase = new ArrayList<String>();
        
        ArrayList<String> listaDeArquivos = new ArrayList();
		
		Scanner scanner = new Scanner(new File("test.txt"));
		scanner.useDelimiter(";");

		while(scanner.hasNext()) {
		    String key = scanner.next();			
		    System.out.println(key);
	        listaDeArquivos = searchStory.arquivosQueContemAPalavra("D:\\Users\\Helena\\Documents\\TEST", key);
		    
	        for(i=0; i<listaDeArquivos.size(); i++) {
	            System.out.println(listaDeArquivos.get(i));	

	        
	        
			  try{
				  FileWriter fstream = new FileWriter("output.txt",true);
				  BufferedWriter out = new BufferedWriter(fstream);
				  out.write(key + ";" + listaDeArquivos.get(i) +"\n");
				  out.close();
			  }catch (Exception e){
				 System.err.println("Error while writing to file: " +
			          e.getMessage());
			  }
	        }
	        
	        
		    if(scanner.hasNextLine())
		    scanner.nextLine();
		}		

		
//		Files.lines(new File("test.txt").toPath())
//		.map(s -> s.trim()) 
//		.filter(s -> !s.isEmpty()) 
//		.forEach(System.out::println);		
//		
		
		
//        try (FileReader reader = new FileReader("test.txt");
//                BufferedReader br = new BufferedReader(reader)) {
//
//               // read line by line
//               String line;
//               while ((br.readLine()) != null) {
//                   System.out.println(line);
//               }
//
//           } catch (IOException e) {
//               System.err.format("IOException: %s%n", e);
//           }	
	}
		
	
//	    String filePath = "test.txt";
//	    HashMap<String, String> map = new HashMap<String, String>();
//
//	    String line;
//	    BufferedReader reader = new BufferedReader(new FileReader(filePath));
//	    while ((line = reader.readLine()) != null)
//	    {
//	        String[] parts = line.split(":", 2);
//	        if (parts.length >= 2)
//	        {
//	            String key = parts[0];
//	            String value = parts[1];
//	            map.put(key, value);
//	        } else {
//	            System.out.println("ignoring line: " + line);
//	        }
//	    }
//
//	    for (String key : map.keySet())
//	    {
//	        System.out.println(key + ":" + map.get(key));
//	    }
//	    reader.close();			
//	}

}
