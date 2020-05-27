package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.shop.domain.ProColorVO;
import com.biz.shop.domain.ProOptionsVO;
import com.biz.shop.domain.ProSizeVO;
import com.biz.shop.persistance.DDL_Dao;
import com.biz.shop.persistance.ProOptionsDao;
import com.biz.shop.persistance.sql.CreateTableSQL;
import com.biz.shop.service.ProOptionsService;

@Transactional
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

	@Override
	public int getProSize(ProSizeVO proSizeVO) {
		// TODO Auto-generated method stub
		return proOPTDao.getProSize(proSizeVO);
	}
	
	@Override
	public int insert_size(ProSizeVO proSizeVO) {
		// TODO Auto-generated method stub
		return proOPTDao.insert_size(proSizeVO);
	}

	@Override
	public int insert_color(ProColorVO proColorVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete_size(ProSizeVO proSizeVO) {
		// TODO Auto-generated method stub
		return proOPTDao.delete_size(proSizeVO);
	}

}
