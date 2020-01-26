package SamProject.imgExtraction;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Extracting Image Data :" );
        System.out.println();
        
        String inputFilePath="F:/Screenshot1.png";
        
        Tesseract tsi=new Tesseract();
        tsi.setDatapath("F:/ExtractDataFromImage-Java/imgExtraction/Tesseract");
        try {
			
        	String code=tsi.doOCR(new File(inputFilePath));
        	System.out.println(code);
        	String demo="Hello hay this 01/10/1997 a format of date..1245 sjdbhagdca hsbahhs shb c ma";
        	//demo=demo.replaceAll("^[0-9]","");
        	//System.out.println(demo.replaceAll("[0-9/]",""));
        	char a[]=demo.toCharArray();
        	StringBuffer m=new StringBuffer();
        	for(char c:a)
        		if(c==48||c==49||c==50||c==51|c==52||c==53||c==54||c==55||c==56||c==57||c==47)
        			m.append(c);
        	System.out.println(m);
        	
		} catch (TesseractException e) {
			e.printStackTrace();
		}
    }
}
