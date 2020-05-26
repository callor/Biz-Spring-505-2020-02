package com.biz.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProOptionsVO {
	
	private long o_seq;
	private String o_division;
	private String o_standard;
	private String o_name;

}
