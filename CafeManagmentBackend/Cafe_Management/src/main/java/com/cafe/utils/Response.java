package com.cafe.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Response {
	private String key;
	private String msg;
	private String userName;
}
