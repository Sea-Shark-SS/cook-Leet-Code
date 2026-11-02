package LZ77;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
     public static void main (String[] args) throws Exception{
		L77 compress ;
		int window=8;
		int buffer=4;
		File file = new File("Zipping.txt");
		File file2 = new File("Zipping2.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file2.getAbsolutePath());
		boolean b =file.exists();
		System.out.println(b);
		BufferedReader br = new BufferedReader(new FileReader("E:\\java-2023-06\\DSadvance\\Zipping.txt")); 
	            String line;
	            int count=0;
	            String s="";
	            // Read the file line by line
	            while ((line = br.readLine()) != null) {
	            	 s =s.concat(line) ;
	            	 count++;
	            }
	            System.out.println(s.length());
	            
	    		compress = new L77(s,window,buffer);
	    		List<Lz> t= compress.compress();
	    		for(Lz tup : t) {
		    		  System.out.println(tup.toString());
		    	   }
	    		List<Lz> data =new ArrayList();
		        for(Lz t2 : t) {
		         data.add(new Lz(t2.offset,t2.length,t2.next));
		        }
		        String l=compress.decompress(data);
		        System.out.println(l.length());
	    		ArrayList<String> str = new ArrayList<>();
	    	   
	    	   
	    	   
    		//for huffman coding::
	    	   ArrayList<Character> c = new ArrayList<>();
	    	   for(Lz tuple : t) {
	    		   c.add(tuple.next);
	    	   }
	    	   StringBuilder sb = new StringBuilder();
	           for (Character ch : c) {
	               sb.append(ch);
	           }
	           String result=sb.toString();
	    	   System.out.println(result.length());
	    	 //write in file each code after compress
		}	
     
}
