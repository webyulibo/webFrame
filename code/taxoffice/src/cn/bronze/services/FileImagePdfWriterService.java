package cn.bronze.services;

import org.apache.poi.hssf.record.Margin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.entities.Asset;
import cn.bronze.log.Log;

import com.lowagie.text.Document;
import com.lowagie.text.Cell;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import com.thoughtworks.xstream.alias.ClassMapper.Null;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class FileImagePdfWriterService {
	
	private static final String CHINESE_NAME = "资产名称";
	private static final String CHINESE_CODE = "编号";
	private static final String CHINESE_TYPE = "分类";
	private static final String CHINESE_VALUE = "原值";
	private static final String CHINESE_MODEL= "规格型号";
	private static final String CHINESE_STARTUSETIME = "启用日期";
	private static final String CHINESE_USEDEPARTMENT = "使用部门";
	private static final String CHINESE_USER = "使用人";
	private static final String CHINESE_MAKECARDTIME = "制卡日期";
	private static final String CHINESE_GHOSTYEAR = "报废年度";
		
	@Test
	public void testPrintAssetToPdfDocument()  throws IOException, DocumentException{
		Asset asset = new Asset();
		asset.setName("办公椅");  //资产名称
		asset.setCode("030400000001819"); //编号
		asset.setType("椅类"); //分类
		asset.setValue(1966.8); //原值
		//asset.setModel(""); //规格型号
		asset.setStartusetime(new Date()); //启用日期
		asset.setUsedepartment("局领导"); //使用部门
		asset.setUser("刘耀民"); //使用人
		asset.setMakecardtime(new Date()); //制卡日期
		asset.setGhostyear("2019");  //报废年度
		
		//String result = printAssetToPdfDocument(asset);
		//System.out.println("lrp输出result：" + result);
		
	}
	
	/**
	 * akg修改参数为list
	 * 将资产类型打印成标签pdf文件
	 * @param asset
	 * @return 生成的pdf文件路径
	 * @throws IOException
	 * @throws DocumentException
	 */
	@Log(descrp="执行生成标签操作",type="系统管理权限，资产管理权限")
	public String printAssetToPdfDocument(List<Asset> assetList) throws IOException, DocumentException{
		
		/*Asset asset = new Asset();
		asset.setName("办公椅");  //资产名称
		asset.setCode("030400000001819"); //编号
		asset.setType("椅类"); //分类
		asset.setValue(1966.8); //原值
		//asset.setModel(""); //规格型号
		asset.setStartusetime(new Date()); //启用日期
		asset.setUsedepartment("局领导"); //使用部门
		asset.setUser("刘耀民"); //使用人
		asset.setMakecardtime(new Date()); //制卡日期
		asset.setGhostyear("2019");  //报废年度
*/		
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

		//Create Document Instance
		Document document=new Document();
		//Create Writer associated with document
		//result = getWebRootPath() + "/Image/Label/" + UUID.randomUUID().toString() + ".PDF";
		result=UUID.randomUUID().toString() + ".PDF";
		PdfWriter.getInstance(document, new FileOutputStream(new File(result)));

		document.open();
		
		
		for(Asset asset :assetList)				
		{
			
			
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

			document.newPage();

			BaseFont bfChinese=BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			
			Font keyfont=new Font(bfChinese,22,Font.BOLD);
			
			//create  image
			FileImageTwoDimensionCodeWriterService fileImageTwoDimensionCodeWriterService = new FileImageTwoDimensionCodeWriterService();
			Image pngImg=Image.getInstance(fileImageTwoDimensionCodeWriterService.printAssetToTwoDimensionCode(asset));
			pngImg.setAlignment(Image.ALIGN_CENTER);
			pngImg.scaleAbsolute(420, 400);
			document.add(pngImg);

			//create  table
			Table table = new Table(4);
			table.setBorderWidth(1);
			table.setBorderColor(new Color(255, 255, 255));
			table.setPadding(1);
			table.setSpacing(1);

			Cell cell = new Cell(new Paragraph("秦皇岛市国税局固定资产标签",keyfont));
			cell.setHeader(true);
			cell.setColspan(4);
			table.addCell(cell);
			table.endHeaders();  //表头结束
			table.addCell(new Paragraph(CHINESE_NAME,keyfont));
			table.addCell(new Paragraph(nameStr,keyfont));
			table.addCell(new Paragraph(CHINESE_CODE,keyfont));
			table.addCell(new Paragraph(codeStr,keyfont));
			table.addCell(new Paragraph(CHINESE_TYPE,keyfont));
			table.addCell(new Paragraph(typeStr,keyfont));
			table.addCell(new Paragraph(CHINESE_VALUE,keyfont));
			table.addCell(new Paragraph(valueStr,keyfont));
			table.addCell(new Paragraph(CHINESE_MODEL,keyfont));
			table.addCell(new Paragraph(modelStr,keyfont));
			table.addCell(new Paragraph(CHINESE_STARTUSETIME,keyfont));
			table.addCell(new Paragraph(startUseTimeStr,keyfont));
			table.addCell(new Paragraph(CHINESE_USEDEPARTMENT,keyfont));
			table.addCell(new Paragraph(useDepartmentStr,keyfont));
			table.addCell(new Paragraph(CHINESE_USER,keyfont));
			table.addCell(new Paragraph(userStr,keyfont));
			table.addCell(new Paragraph(CHINESE_MAKECARDTIME,keyfont));
			table.addCell(new Paragraph(makeCardTimeStr,keyfont));
			table.addCell(new Paragraph(CHINESE_GHOSTYEAR,keyfont));
			table.addCell(new Paragraph(ghostYearStr,keyfont));
			document.add(table);
		}
		document.close();
		
		return result;
		
		
		/*//建立com.lowagie.text.Document对象的实例
		Document document = new Document(); 
		
		//建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
		PdfWriter.getInstance(document, new FileOutputStream(getWebRootPath() + "/attached/Image/Label/" + UUID.randomUUID().toString() + ".PDF"));
		
		// 打开文档
		document.open();  
		
		//向文档中添加内容
		document.add(new Paragraph("Hello World"));  
		
		//关闭文档
		document.close(); */
		
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
	
}
