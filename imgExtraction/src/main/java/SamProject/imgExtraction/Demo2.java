package SamProject.imgExtraction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

//this have few issues in logics so doesn't work fine for all cases.
public class Demo2 {
	public static void main(String[] args) {

		 System.out.println( "Extracting Image Data :\n" );
	      
	        String inputFilePath="F:/Screenshot3.png";
	        Tesseract tsi=new Tesseract();
	        tsi.setDatapath("F:/ExtractDataFromImage-Java/imgExtraction/Tesseract");
	        try {
	        	String dataFromImage=tsi.doOCR(new File(inputFilePath)).toLowerCase();
	        	System.out.println("All Data from Image :");
	        	System.out.println(dataFromImage);
	        	System.out.println("\n\n\n");
	        	String d=dataFromImage.replaceAll("[!-.:-@{-}a-zA-Z]", "");
	        	d=d.trim(); 
	        	
	        	String[] oneMore=d.split("[ \n]");
	        	
	        	List<String> li=new ArrayList<String>();
	        	for (String string : oneMore) {
	        		String demo=string.trim();
					if(demo.contains("/"))
						li.add(demo);
				}
	        	
	        	System.out.println("------------ OUTPUT ------------");
	        	if(li.isEmpty())
	        		System.out.println("Please input more Clear image !");
	        	else {
	        		System.out.println("final List object ");
	        		System.out.println(li);
	        	}
		} catch (TesseractException e) {
			System.out.println("Issues in image format or file"); }


	}

}
