package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.shop.domain.ProOptionsVO;
import com.biz.shop.persistance.DDL_Dao;
import com.biz.shop.persistance.ProOptionsDao;
import com.biz.shop.persistance.sql.CreateTableSQL;
import com.biz.shop.service.ProOptionsService;

@Service
public class ProOptionServiceImpl implements ProOptionsService{

	private final ProOptionsDao proOPTDao;
	private final DDL_Dao ddl_Dao;
	
	public ProOptionServiceImpl(ProOptionsDao proOPTDao,DDL_Dao ddl_Dao ) {
		
		this.proOPTDao = proOPTDao;
		this.ddl_Dao = ddl_Dao;
		
		ddl_Dao.create_table(CreateTableSQL.drop_options_table);
		ddl_Dao.create_table(CreateTableSQL.create_options_table);
		ddl_Dao.create_table(CreateTableSQL.insert_options_item);
	}
	
	@Override
	public List<ProOptionsVO> getColorList() {
		// TODO Auto-generated method stub
		return proOPTDao.getColorList();
	}

	@Override
	public List<ProOptionsVO> getSizeList() {
		// TODO Auto-generated method stub
		return proOPTDao.getSizeList();
	}

}
