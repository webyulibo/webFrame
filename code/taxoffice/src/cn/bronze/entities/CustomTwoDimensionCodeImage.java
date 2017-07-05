package cn.bronze.entities;

import java.awt.image.BufferedImage;  

import jp.sourceforge.qrcode.data.QRCodeImage;  
  
public class CustomTwoDimensionCodeImage implements QRCodeImage {  
  
    BufferedImage bufImg;  
      
    public CustomTwoDimensionCodeImage(BufferedImage bufImg) {  
        this.bufImg = bufImg;  
    }  
      
    @Override  
    public int getHeight() {  
        return bufImg.getHeight();  
    }  
  
    @Override  
    public int getPixel(int x, int y) {  
        return bufImg.getRGB(x, y);  
    }  
  
    @Override  
    public int getWidth() {  
        return bufImg.getWidth();  
    }  
  
}  