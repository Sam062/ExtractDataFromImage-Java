package homePackege;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Extracting Image Data :\n" );

		String inputFilePath="F:/Screenshot3.png";
		Tesseract tsi=new Tesseract();
		tsi.setDatapath("F:/ExtractDataFromImage-Java/imgExtraction/Tesseract");
		try {
			String dataFromImage=tsi.doOCR(new File(inputFilePath)).toLowerCase();
			System.out.println("------- Complete Data from Image -------");
			System.out.println(dataFromImage.trim());

			dataFromImage=dataFromImage.replaceAll("[^0-9/]", " ");			
			System.out.println("____________________________________________________________\n");
			System.out.println("-----------Extracted Dates are------------");
			
			StringTokenizer tokenString=new StringTokenizer(dataFromImage);
			List<String> li=new ArrayList<String>();
			
			while(tokenString.hasMoreTokens()) {
				String temp=tokenString.nextToken();
				int count=0;
				boolean b=false;
				if(temp.length()==10 || temp.length()==9) {
					for (int i = 0; i < temp.length(); i++) {
						if(temp.length()==10) {
							if(temp.charAt(2)=='/' && temp.charAt(5)=='/')
								b=true;
							if(temp.charAt(i)=='/')
								count++;
						}
						else {
							if(temp.charAt(1)=='/' && temp.charAt(4)=='/')
								b=true;
							if(temp.charAt(i)=='/')
								count++;
						}	
					}
				}
				
				if(count==2 && b==true)
					li.add(temp);
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