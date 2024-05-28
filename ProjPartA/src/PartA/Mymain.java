package PartA;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

/**
 * 
 */

/**
 * @author 7054610
 *
 */

public class Mymain {

    public static short [][] grayImage;
    public static int width;
    public static int height;
    private static BufferedImage image;
    
       public static void main(String[] args) {
    	    String fileNameInp="Template.jpg";
    	    String fileNameOut="TemplateG4.jpg";
    	   readColourImage(fileNameInp);
    	    /*
    	    short xCoord=100;
            short yCoord=100;
            short rectWidth=100;
            short rectHeight=100;
            
            writeColourImage(fileNameOut,xCoord,yCoord,rectWidth,rectHeight);
            
            System.out.println(">> Completed! Check the rectangle at the left top corner of the generated "+ fileNameOut+ "image under this project folderr");
            */
       }   
       
      
   
    /**
     *    
     * @param fileName
     */
    public static void readColourImage(String fileName) {
          
            try
            {
             // RGB pixel values
             byte[] pixels;
  
             File inp=new File("TenCardG.jpg");
             image = ImageIO.read(inp);
             width = image.getWidth();
             height = image.getHeight();          
            
             
             pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
             System.out.println("Dimension of the image: WxH= " + width + " x "+height+" "+ "| num of pixels: "+ pixels.length);
         
         
        
             //rgb2gray in a 2D array grayImage                 
             int pr;// red
             int pg;//  green
             int pb;// blue     
   
            grayImage =new short [height][width];
            int coord;
            for (int i=0; i<height;i++)
         	   for(int j=0;j<width;j++)
         	   {        		     
         		   coord= 3*(i*width+j);
         		   pr= ((short) pixels[coord] & 0xff); // red
                    pg= (((short) pixels[coord+1] & 0xff));//  green
                    pb= (((short) pixels[coord+2] & 0xff));// blue                
                    
         		   grayImage[i][j]=(short)Math.round(0.299 *pr + 0.587 * pg  + 0.114 * pb);         
         		   
         	   }  
            }
            catch (IOException e) {
                e.printStackTrace();
                } 

    }
}


