package cn.bronze.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.CheckResultDetailMapper;
import cn.bronze.entities.CheckResultDetail;
import cn.bronze.entities.CheckResultDetailExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class BaseCheckResultDetailService extends GenernicServiceImpl<CheckResultDetail,CheckResultDetailExample> {

	@Autowired
	private CheckResultDetailMapper checkResultDetailMapper;
	
}
