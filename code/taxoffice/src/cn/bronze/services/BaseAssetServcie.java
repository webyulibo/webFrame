package cn.bronze.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class BaseAssetServcie extends GenernicServiceImpl<Asset,AssetExample> {

	@Autowired
	private AssetMapper assetMapper;
	
	@PostConstruct
	public void post(){
		if(assetMapper!=null){
			super.setDao(assetMapper);
			System.err.println("已经注入了"+assetMapper.getClass().getName());
		}
	}
	
}
