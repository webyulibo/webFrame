package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomAssetCheckData;
import cn.bronze.services.FileTextWriterService;
import cn.bronze.util.json.JsonResponse;

@RequestMapping("/testlrpassetcheckdataimportontroller")
@Controller
public class TestLrpAssetCheckDataImportController {

	@Autowired
	FileTextWriterService fileTextWriterService;
	
	@RequestMapping("/importassettotext")
	public void importassettotext(HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		
		Asset asset1 = new Asset();
		asset1.setCode("030400000000066");
		Asset asset2 = new Asset();
		asset2.setCode("030400000000077");
		List<Asset> assetList = new ArrayList<>();
		assetList.add(asset1);
		assetList.add(asset2);
		String selectTerm1 = "资产类型：保险柜";
		String selectTerm2 = "使用状态：在用";
		String selectTerm3 = "状态：正常";
		List<String> selectTermsList = new ArrayList<>();
		selectTermsList.add(selectTerm1);
		selectTermsList.add(selectTerm2);
		selectTermsList.add(selectTerm3);
		CustomAssetCheckData assets = new CustomAssetCheckData();
		assets.setAssets(assetList);
		assets.setSelectTerms(selectTermsList);
		
		//int exportResult = fileTextWriterService.exportAssetCheckDataToText(assets);
		//1:成功
		//0:失败
		
		
		//jsonObject.put("status", exportResult);
		
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	
}
