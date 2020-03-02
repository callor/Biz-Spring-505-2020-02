package com.biz.bbs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.FileReaderService;

public class Main {
	
	// 진입점, endpoint method
	public static void main(String[] args) {
		
		FileReaderService fService = new FileReaderService();
		List<BBsVO> bbsList = fService.getBBsData();
	
		Collections.sort(bbsList,new Comparator<BBsVO>() {
			@Override
			public int compare(BBsVO o1, BBsVO o2) {
				int s = (int)(o1.getB_id() - o2.getB_id());
				return s;
			}
		});
		
		// 람다코드
		// sort() method의 정의에 
		// 첫번째 매개변수는 정렬할 List
		// 두번째 매개변수는 Comparator인터페이스를 이용한
		// 구현체가 오도록 되어있기 때문에 가능하다
		Collections.sort(bbsList,(o1,o2)->
			(int)(o1.getB_id() - o2.getB_id())
		);
		
		// 부모id(b_p_id)가 0인 리스트만 추출
		List<BBsVO> pList = new ArrayList<BBsVO>();
				
		
		for(BBsVO vo : bbsList) {
			System.out.println(vo.toString());
		}
	}

}
