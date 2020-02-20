package com.biz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value="/number")
@Controller
public class NumController {

	@Autowired
	NumService nService;
	
	@ResponseBody
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	public String add() {
		
		// NumService num = new NumService();
		// int ret = num.add(30, 40);
		
		int ret = nService.add(30, 40);
		return "두수의 덧셈: " + ret;
	}
	
	/*
	 * 사용자가 /number/even 이라고 요청을 하면
	 * 1~100까지 숫자 중에서 짝수의 덧셈만 수행하여 결과를 알려주겠다
	 */
	@ResponseBody
	@RequestMapping(value="/even",produces = "text/html;charset=UTF-8")
	public String even() {
		
		int start  = 1;
		int end = 100;
		
		// service에게 요청을 해서 짝수 덧셈을 수행해달라라고 할것
		int even = nService.even(start,end);
		
		String res = 
				String.format("%d 부터 %d까지의 "
						+ "숫자중 짝수의 합 : %d",start,end,even );
		return res;
		
	}

	/*
	 * 사용자가 요청한 변수=값의 형태는 무조건 값이 문자열이다
	 * 만약 매개변수 type int 형으로 선언을 하면
	 * spring은 사용자의 변수를 수신한 후 
	 * Integer.valueOf(변수) 코드를 실행하여
	 * 문자열을 숫자로 변환 시키려 시도를 한다.
	 * 
	 *  그런데 수신한 값이 숫자로 변환이 불가능하면
	 *  사용자에게 400 오류를 전송
	 */
	@ResponseBody
	@RequestMapping(value="/num2even",produces = "text/html;charset=UTF-8")
	public String even(String start, String end) {
		
		int intStart = 0;
		int intEnd = 0;
		try {
			 intStart = Integer.valueOf(start);
			 intEnd = Integer.valueOf(end);
		} catch (Exception e) {
			return "전송된 값을 숫자로 변환할 수 없습니다" ;
		}

		int even = nService.even(intStart,intEnd);
		String res = 
				String.format("%d 부터 %d까지의 "
						+ "숫자중 짝수의 합 : %d",intStart,intEnd,even );
		return res;
		
	}
	
	/*
	 * 국어, 영어, 수학, 과학, 음악 점수를 
	 * 		request로 받아서
	 * 총점과 평균을 계산한 후
	 * 		response 하고자 한다.
	 */

	
	@ResponseBody
	@RequestMapping(value="/score")
	public String score() {
		
		return null;
	}
	
	
	
}



