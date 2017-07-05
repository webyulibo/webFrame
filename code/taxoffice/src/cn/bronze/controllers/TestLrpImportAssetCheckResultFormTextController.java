package cn.bronze.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomAssetCheckResult;
import cn.bronze.services.FileTextReaderService;

@RequestMapping("/testlrpimportassetcheckresultfromtext")
@Controller
public class TestLrpImportAssetCheckResultFormTextController {

	@Autowired
	FileTextReaderService fileTextReaderService;
	
	@RequestMapping("/importtext")
	public ModelAndView importText() throws IOException{
		ModelAndView modelAndView = new ModelAndView();
	
//		CustomAssetCheckResult customAssetCheckResult = new CustomAssetCheckResult();
//		customAssetCheckResult = fileTextReaderService.importAssetCheckResultFromText();
//		System.out.println("lrp输出AssetsChecked：" + customAssetCheckResult.getAssetsChecked().size());
//		System.out.println("lrp输出AssetsNotChecked：" + customAssetCheckResult.getAssetsNotChecked().size());
//		System.out.println("lrp输出SelectTerms：" + customAssetCheckResult.getSelectTerms().size());
		
		return modelAndView;
	}
	
}
