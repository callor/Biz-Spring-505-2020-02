package com.biz.naver.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NaverVO {

	// 뉴스
	private String title ;// ": "평택시, 공사장 현장점검 및 간담회 실시",
	private String originallink; //": "http://www.m-i.kr/news/articleView.html?idxno=692573",
	private String link; //": "http://www.m-i.kr/news/articleView.html?idxno=692573",
	private String description;// ": "<b>코로나</b>19로 침체된 지역경제 활성화를 위한 간담회를 열고 있다.  평택시(시장 정장선)는 17일, 본격 공사가 추진되는 시기를 맞아 수해상습지 개선공사 현장을 점검했으며, <b>코로나</b>19로 침체된 지역경제 활성화를 위한... ",
	private String pubDate; // ": "Wed, 18 Mar 2020 13:27:00 +0900"
	
	// 영화
	private String image;//": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1604/160441_P01_144910.jpg",
	private String subtitle;//": "Lost Cat Corona",
	private String director;//": "안토니 타르시타노|",
	private String actor;//": "숀 영|지나 거손|랄프 마치오|데이빗 제야스|아담 페라라|제프 코버|폴 소르비노|톰 우팻|",
	private String userRating;// ": "6.00"

	// 도서
	private String author;//": "윌 <b>코로나</b> 필그림",
	private String price;//": "12000",
	private String discount;//": "10800",
	private String publisher;//": "시공사",
	private String pubdate;//": "20180425",
	private String isbn;//": "8952790677 9788952790675",
	
}
