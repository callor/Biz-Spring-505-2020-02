package com.biz.shop.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.biz.shop.domain.DeptVO;
import com.biz.shop.repository.DeptDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeptService {

	private final DeptDao deptDao;

	public List<DeptVO> selectAll() {
		List<DeptVO> deptList = deptDao.findAll();
		return deptList;
	}

	public DeptVO save(DeptVO deptVO) {
		DeptVO ret = deptDao.save(deptVO);
		
		return ret;
	}

	public DeptVO search(String d_code) {

		// return deptDao.findByD_Code(d_code);
		return null;
	}
	
}
