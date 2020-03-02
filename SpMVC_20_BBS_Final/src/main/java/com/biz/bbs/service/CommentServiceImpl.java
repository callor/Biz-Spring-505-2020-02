package com.biz.bbs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.domain.CommentVO;
import com.biz.bbs.repository.CommentDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentDao cmtDao;
	
	@Override
	public List<CommentVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentVO findById(long c_id) {

		CommentVO cmtVO = cmtDao.findById(c_id);
		return cmtVO;
	
	}

	@Override
	public List<CommentVO> findByPId(long c_p_id) {
		List<CommentVO> cmtList = cmtDao.findByPId(c_p_id); 
		return cmtList;
	}

	/*
	 * 게시판 원글에 대한 코멘트 리스트 가져오기
	 */
	@Override
	public List<CommentVO> findByBId(long c_b_id) {
		List<CommentVO> cmtList = cmtDao.findByBId(c_b_id); 
		return cmtList;
	}

	
	@Override
	public int insert(CommentVO commentVO) {
		if(commentVO.getC_id() > 0) {
		
			int ret = cmtDao.update(commentVO);
			return ret;
		
		} else {
			
			// 작성일자를 현재 저장하는 날짜로 세팅을 하자
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter df 
				= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			commentVO.setC_date_time(ldt.format(df));
			int ret = cmtDao.insert(commentVO);
			return ret;
			
		}
	}

	@Override
	public int update(CommentVO commentVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long c_id) {
		int ret = cmtDao.delete(c_id);
		return ret;
	}
}
