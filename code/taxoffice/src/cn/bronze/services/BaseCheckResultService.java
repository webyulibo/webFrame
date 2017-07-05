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

import cn.bronze.daos.CheckResultMapper;
import cn.bronze.entities.CheckResult;
import cn.bronze.entities.CheckResultExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class BaseCheckResultService extends GenernicServiceImpl<CheckResult,CheckResultExample> {

	@Autowired
	private CheckResultMapper checkResultMapper;
	
}
