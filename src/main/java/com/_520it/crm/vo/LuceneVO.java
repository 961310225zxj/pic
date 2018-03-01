package com._520it.crm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LuceneVO {
	private String title;
	private String content;
	private String highLight;
}
