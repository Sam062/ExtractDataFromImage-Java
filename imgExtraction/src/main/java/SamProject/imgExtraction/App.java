package SamProject.imgExtraction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Extracting Image Data :\n" );
      
        String inputFilePath="F:/Screenshot4.png";
        Tesseract tsi=new Tesseract();
        tsi.setDatapath("F:/ExtractDataFromImage-Java/imgExtraction/Tesseract");
        try {
        	String dataFromImage=tsi.doOCR(new File(inputFilePath)).toLowerCase();
        	System.out.println("------- Complete Data from Image -------");
        	//String dataFromImage="01878/21548Hello hay this 01/10/2020 a format 01/10//2220 of date..1245 sjdbhagdca hsbahhs shb c ma hay thisncfnjhj dnjbcjsadbkd 01/10/4800";   
        	System.out.println(dataFromImage.trim());
        	System.out.println("----------------------------------------");
        	
        	char[] stringToArray=dataFromImage.toCharArray();
        	StringBuffer numberAndSlashData=new StringBuffer();
        	for(char c:stringToArray)
        		if(c>=47 && c<=57)
        			numberAndSlashData.append(c);
        	
        //	System.out.println(numberAndSlashData);
        	System.out.println();
        			
        	List<String> datesList=new ArrayList<String>();
        	for (int i = 0; i < numberAndSlashData.length(); i++) {
        		if(i<numberAndSlashData.length()-9)
        			datesList.add(numberAndSlashData.substring(i, i+10));
			}
        	//System.out.println(datesList);
        	
        	System.out.println("\n----------OUTPUT AS---------------");
        	ListIterator<String> itr=datesList.listIterator();
        	List<String> li=new ArrayList<String>();
        	while(itr.hasNext()) {
        		String test=itr.next();
        		char[] c=test.toCharArray();
        		int count=0;
        		boolean b=false;
        		for (int i = 0; i < test.length(); i++) {
        			if(c[2]=='/' && c[5]=='/')
        				b=true;
					if(c[i]=='/')
						count++;
				}
        		if(count==2 && b==true)
        			li.add(test);
        	}
        	if(li.isEmpty())
        		System.out.println("No Date Patterns Found");
        	else
        		System.out.println(li);
		  } 
        catch (TesseractException e) {
		  System.out.println("Issues in image format or file"); 
		  }
    }
}