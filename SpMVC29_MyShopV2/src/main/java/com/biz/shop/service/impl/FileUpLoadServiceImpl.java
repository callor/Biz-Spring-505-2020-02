package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.shop.domain.ProFileVO;
import com.biz.shop.persistance.DDL_Dao;
import com.biz.shop.persistance.FileUpDao;
import com.biz.shop.persistance.sql.CreateTableSQL;
import com.biz.shop.service.FileUploadService;

@Service
public class FileUpLoadServiceImpl implements FileUploadService{

	private final FileUpDao fileUpDao;
	private final DDL_Dao  ddl_dao;
	
	public FileUpLoadServiceImpl(FileUpDao fileUpDao, DDL_Dao ddl_dao) {
		
		this.fileUpDao = fileUpDao;
		this.ddl_dao = ddl_dao;
		ddl_dao.create_table(CreateTableSQL.create_fileup_table);
		
	}
	
	
	
	@Override
	public List<ProFileVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProFileVO> findByPCode(String file_p_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProFileVO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ProFileVO profileVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String file_p_code) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
