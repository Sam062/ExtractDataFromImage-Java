package SamProject.imgExtraction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Extracting Image Data :\n" );
      
        String inputFilePath="F:/Screenshot5.jpg";
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
        	
        	System.out.println("-----OUTPUT-----");
        	if(li.isEmpty())
        		System.out.println("Please input more Clear image !");
        	else {
        		System.out.println("final List object ");
        		System.out.println(li);
        	}
        		
        	
        	
        	
        	
//        	System.out.println("Iterator :>>>>");
//        	ListIterator<String> itr=li.listIterator();
//        	while(itr.hasNext())
//        		System.out.println(itr.next());
        	
        	
        	
        	
        	
//        	String demo="01878/21548Hello hay this 01/10/1997 a format of date..1245 sjdbhagdca hsbahhs shb c ma hay thisncfnjhj dnjbcjsadbkd 01/10/1548";
//        	System.out.println(demo);
//        	
//        	String myData=demo.replaceAll("[!-.:-@{-}a-zA-Z]", "");
//        	myData.trim();
//
//        	String[] oneMore=myData.split(" ");
//        	
//        	List<String> li=new ArrayList<String>();
//        	for (String string : oneMore) {
//				if(string.contains("/"))
//					li.add(string);
//			}
//        	System.out.println(li);
        	
        	
        	
        	//demo=demo.replaceAll("^[0-9]","");
        	//System.out.println(demo.replaceAll("[0-9/]",""));
        	
        	
//        	char a[]=demo.toCharArray();
//        	StringBuffer m=new StringBuffer();
//        	for(char c:a)
//        		if(c==48||c==49||c==50||c==51|c==52||c==53||c==54||c==55||c==56||c==57||c==47)
//        			m.append(c);
//        	System.out.println(m);
        	
        	
		} catch (TesseractException e) {
			System.out.println("Issues in image format or file");
		}
    }
}
