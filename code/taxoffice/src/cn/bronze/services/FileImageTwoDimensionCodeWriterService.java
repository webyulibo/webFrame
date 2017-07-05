package cn.bronze.services;

import java.awt.Color;  
import java.awt.Graphics2D;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
  



import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.imageio.ImageIO;  
  









import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.sourceforge.qrcode.QRCodeDecoder;  
import jp.sourceforge.qrcode.exception.DecodingFailedException;  
  





import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomTwoDimensionCodeImage;

import com.swetake.util.Qrcode;  

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class FileImageTwoDimensionCodeWriterService {

	public String printAssetToTwoDimensionCode(Asset asset){
		
		System.out.println("lrp输出asset.getCode()：" + asset.getCode());
		
		String result = "";
		
		String nameStr = "";
		String codeStr = "";
		String typeStr = "";
		String valueStr = "";
		String modelStr = "";
		String startUseTimeStr = "";
		String useDepartmentStr = "";
		String userStr = "";
		String makeCardTimeStr = "";
		String ghostYearStr = "";
		
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		
		nameStr = asset.getName() == null || asset.getName().length() <=0 ? " " : asset.getName();
		codeStr = asset.getCode() == null || asset.getCode().length() <= 0 ? " ":asset.getCode();
		typeStr = asset.getType() == null || asset.getType().length() <= 0 ? " " : asset.getType();
		valueStr = asset.getValue() == null || asset.getValue() <= 0? " ": asset.getValue().toString();
		modelStr = asset.getModel() == null || asset.getModel().length() <= 0 ? " " : asset.getModel();
		startUseTimeStr = asset.getStartusetime() == null ? " " : df2.format(asset.getStartusetime()); 
		useDepartmentStr = asset.getUsedepartment() == null || asset.getUsedepartment().length() <= 0 ? " " : asset.getUsedepartment();
		userStr = asset.getUser() == null || asset.getUser().length() <= 0 ? " " : asset.getUser();
		makeCardTimeStr = asset.getMakecardtime() == null ? " " : df2.format(asset.getMakecardtime());
		ghostYearStr = asset.getGhostyear() == null || asset.getGhostyear().length() <= 0 ? " " : asset.getGhostyear();
		
		String content = nameStr + "!"
				+ codeStr + "!"
				+ typeStr + "!"
				+ valueStr + "!"
				+ modelStr + "!"
				+ startUseTimeStr + "!"
				+ useDepartmentStr + "!"
				+ userStr + "!"
				+ makeCardTimeStr + "!"
				+ ghostYearStr;
		
		result = getWebRootPath() + "Image/TwoDimensionCode/" + UUID.randomUUID().toString() + ".png";
		
		System.out.println("lrp输出content：" + content);
		System.out.println("lrp输出result：" + result);
		
		encoderQRCode(content,result);
		
		return result;
	}
	
	@Test
	public void testEncoderQRCode(){
		String content = "茶几!030400000000089!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018";
		String imgPath = getWebRootPath() + "Image/TwoDimensionCode/" + UUID.randomUUID().toString() + ".png";
		System.out.println("lrp输出imgPath：" + imgPath);
		encoderQRCode(content,imgPath);     
	}
	
	public String getWebRootPath(){
		/*
		//获得路径/WebRoot/WEB-INF/classes/的绝对路径
		String path=Class.class.getClass().getResource("/").getPath() ;
		//将%20换成空格（如果文件夹的名称带有空格的话，会在取得的字符串上变成%20）
		path=path.replaceAll("%20", " ");  
		//查找“WebRoot”在该字符串的位置
		int num = path.indexOf("WebRoot");
		//截取
		path=path.substring(0, num+"WebRoot".length());  

		return path;
		*/
		String path=getClass().getResource("/").getPath() ;
		path=path.replaceAll("%20", " ");  
		return path;
	}
	
    /** 
     * 生成二维码(QRCode)图片 
     * @param content 存储内容 
     * @param imgPath 图片路径 
     */  
    public void encoderQRCode(String content, String imgPath) {  
        this.encoderQRCode(content, imgPath, "png", 7);  
    }  
      
    /** 
     * 生成二维码(QRCode)图片 
     * @param content 存储内容 
     * @param output 输出流 
     */  
    public void encoderQRCode(String content, OutputStream output) {  
        this.encoderQRCode(content, output, "png", 7);  
    }  
      
    /** 
     * 生成二维码(QRCode)图片 
     * @param content 存储内容 
     * @param imgPath 图片路径 
     * @param imgType 图片类型 
     */  
    public void encoderQRCode(String content, String imgPath, String imgType) {  
        this.encoderQRCode(content, imgPath, imgType, 7);  
    }  
      
    /** 
     * 生成二维码(QRCode)图片 
     * @param content 存储内容 
     * @param output 输出流 
     * @param imgType 图片类型 
     */  
    public void encoderQRCode(String content, OutputStream output, String imgType) {  
        this.encoderQRCode(content, output, imgType, 7);  
    }  
  
    /** 
     * 生成二维码(QRCode)图片 
     * @param content 存储内容 
     * @param imgPath 图片路径 
     * @param imgType 图片类型 
     * @param size 二维码尺寸 
     */  
    public void encoderQRCode(String content, String imgPath, String imgType, int size) {  
        try {  
            BufferedImage bufImg = this.qRCodeCommon(content, imgType, size);  
              
            File imgFile = new File(imgPath);  
            // 生成二维码QRCode图片  
            ImageIO.write(bufImg, imgType, imgFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 生成二维码(QRCode)图片 
     * @param content 存储内容 
     * @param output 输出流 
     * @param imgType 图片类型 
     * @param size 二维码尺寸 
     */  
    public void encoderQRCode(String content, OutputStream output, String imgType, int size) {  
        try {  
            BufferedImage bufImg = this.qRCodeCommon(content, imgType, size);  
            // 生成二维码QRCode图片  
            ImageIO.write(bufImg, imgType, output);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 生成二维码(QRCode)图片的公共方法 
     * @param content 存储内容 
     * @param imgType 图片类型 
     * @param size 二维码尺寸 
     * @return 
     */  
    private BufferedImage qRCodeCommon(String content, String imgType, int size) {  
        BufferedImage bufImg = null;  
        try {  
            Qrcode qrcodeHandler = new Qrcode();  
            // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小  
            qrcodeHandler.setQrcodeErrorCorrect('M');  
            qrcodeHandler.setQrcodeEncodeMode('B');  
            // 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大  
            qrcodeHandler.setQrcodeVersion(size);  
            // 获得内容的字节数组，设置编码格式  
            byte[] contentBytes = content.getBytes("utf-8");  
            // 图片尺寸  
            int imgSize = 67 + 12 * (size - 1);  
            bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);  
            Graphics2D gs = bufImg.createGraphics();  
            // 设置背景颜色  
            gs.setBackground(Color.WHITE);  
            gs.clearRect(0, 0, imgSize, imgSize);  
  
            // 设定图像颜色> BLACK  
            gs.setColor(Color.BLACK);  
            // 设置偏移量，不设置可能导致解析出错  
            int pixoff = 2;  
            // 输出内容> 二维码  
            if (contentBytes.length > 0 && contentBytes.length < 800) {  
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
                for (int i = 0; i < codeOut.length; i++) {  
                    for (int j = 0; j < codeOut.length; j++) {  
                        if (codeOut[j][i]) {  
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
                        }  
                    }  
                }  
            } else {  
                throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");  
            }  
            gs.dispose();  
            bufImg.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bufImg;  
    }  
      
    /** 
     * 解析二维码（QRCode） 
     * @param imgPath 图片路径 
     * @return 
     */  
    public String decoderQRCode(String imgPath) {  
        // QRCode 二维码图片的文件  
        File imageFile = new File(imgPath);  
        BufferedImage bufImg = null;  
        String content = null;  
        try {  
            bufImg = ImageIO.read(imageFile);  
            QRCodeDecoder decoder = new QRCodeDecoder();  
            content = new String(decoder.decode(new CustomTwoDimensionCodeImage(bufImg)), "utf-8");   
        } catch (IOException e) {  
            System.out.println("Error: " + e.getMessage());  
            e.printStackTrace();  
        } catch (DecodingFailedException dfe) {  
            System.out.println("Error: " + dfe.getMessage());  
            dfe.printStackTrace();  
        }  
        return content;  
    }  
      
    /** 
     * 解析二维码（QRCode） 
     * @param input 输入流 
     * @return 
     */  
    public String decoderQRCode(InputStream input) {  
        BufferedImage bufImg = null;  
        String content = null;  
        try {  
            bufImg = ImageIO.read(input);  
            QRCodeDecoder decoder = new QRCodeDecoder();  
            content = new String(decoder.decode(new CustomTwoDimensionCodeImage(bufImg)), "utf-8");   
        } catch (IOException e) {  
            System.out.println("Error: " + e.getMessage());  
            e.printStackTrace();  
        } catch (DecodingFailedException dfe) {  
            System.out.println("Error: " + dfe.getMessage());  
            dfe.printStackTrace();  
        }  
        return content;  
    }  
  
    public static void main(String[] args) {  
        String imgPath = "G:/TDDOWNLOAD/Michael_QRCode.png";  
        String encoderContent = "Hello 大大、小小,welcome to QRCode!" + "\nMyblog [ http://sjsky.iteye.com ]" + "\nEMail [ sjsky007@gmail.com ]";  
        FileImageTwoDimensionCodeWriterService handler = new FileImageTwoDimensionCodeWriterService();  
        handler.encoderQRCode(encoderContent, imgPath, "png");  
//      try {  
//          OutputStream output = new FileOutputStream(imgPath);  
//          handler.encoderQRCode(content, output);  
//      } catch (Exception e) {  
//          e.printStackTrace();  
//      }  
        System.out.println("========encoder success");  
          
          
        String decoderContent = handler.decoderQRCode(imgPath);  
        System.out.println("解析结果如下：");  
        System.out.println(decoderContent);  
        System.out.println("========decoder success!!!");  
    }  
	
}
