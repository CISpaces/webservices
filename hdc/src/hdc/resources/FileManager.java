/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * 
 * 
 * @author      Wentao Ouyang  
 * @version     1.0  
 * @since 		September 2014           
 *   
 */

package hdc.resources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	
	public FileManager(){
	
	}
	
	// method
	public void createFolder(String folderName){
	File file = new File(folderName);
	if (!file.exists()) {
		if (file.mkdir()) {
			System.out.println("Directory is created!");
		} else {
			System.out.println("Directory also exists!");
		}
		}
	}
	
	// method
    public void writeToFileAndClear(String fileName, String str)
    {
    	  BufferedWriter bw;
    		try {
    			bw = new BufferedWriter(new FileWriter(new File(fileName)));
    			bw.write(str);
    		    bw.close();
    	
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    }
    public void writeToFile(String fileName, String str)
    {
    	  BufferedWriter bw;
    		try {
    			bw = new BufferedWriter(new FileWriter(new File(fileName), true));
    			bw.write(str);
    		    bw.close();
    	
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    }
    
    // method
    public int getNumLine(String fileName) throws IOException{
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        int numLine = 0;
        while ((br.readLine()) != null) {
            numLine += 1;
        }
        return numLine;
    }
    
    // method
    public String[] readFromFile(String fileName) throws IOException{
	    String strLine;
	    //Read File Line By Line
	    List<String> lines = new ArrayList<String>();
	    
    	try {
	    FileInputStream fstream = new FileInputStream(fileName);
	    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	    while ((strLine = br.readLine()) != null) {
	        // Print the content on the console
	//        System.out.println(strLine);
	        lines.add(strLine);
	    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return lines.toArray(new String[lines.size()]);
    }
    
    //method
    public String[] getFileNames(String pathName, String ext){
	List<String> results = new ArrayList<String>();
	File[] files = new File(pathName).listFiles();

	for (File file : files) {
	    if (file.isFile() & file.getName().toLowerCase().endsWith(ext)) {
	        results.add(file.getName());
	    }
	}
	return results.toArray(new String[results.size()]);
    }
	
    // method
    public String deleteFile(String fileName){
    	String response = null;
    	try{
    		File file = new File(fileName);
     		if(file.delete()){
     			response = "success";
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			response = "fail";
    			System.out.println("Delete operation is failed.");
    		}
 
    	}catch(Exception e){
 
    		e.printStackTrace();
    	}
    	return response;
    }
}
