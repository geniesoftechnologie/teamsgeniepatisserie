/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bureau
 */
public class Myfun {
      ImageIcon myImg;
     public ImageIcon resizePic(String picPath,byte[] BLOBpic, int wdth, int hgt ){
        if(picPath!=null){
          myImg = new ImageIcon(picPath);
     }else{
             myImg = new ImageIcon(BLOBpic);
        }
        
        Image img = myImg.getImage().getScaledInstance(wdth, hgt, Image.SCALE_SMOOTH );
        ImageIcon myPicture = new ImageIcon(img);
        
        return myPicture;
    }
     
     public String browseImage(JLabel lbl){
         String path = null;
         JFileChooser filec = new JFileChooser ();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        // file extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.image","jpg" , "png", "gif");
        filec.addChoosableFileFilter(fileFilter);
        
        int fileState = filec.showSaveDialog(null);
        
        // if the file is selected 
        if(fileState == JFileChooser.APPROVE_OPTION){
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            //imagePath = path;
            // display the image int jlabel using resize image 
            
            lbl.setIcon(resizePic(path,null, lbl.getWidth(), lbl.getHeight()));
           
            //label_pic.setIcon(new ImageIcon(path));
                     
        }
        else if(fileState == JFileChooser.CANCEL_OPTION){
            System.out.println("No image selected ....");
        }
        
        return path;
     }
    
}
