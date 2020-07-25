package com.inter.api.technicalTest.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
	
	@Getter @Setter private int code;
	@Getter @Setter private T body;
	@Getter @Setter private String detail;
	
	public Response(int code) {
		this.code = code;
	}
	
	public Response(int code, String detail) {
		this.code = code;
		this.detail = detail;
	}
	
	public Response(int code, T body) {
		this.code = code;
		this.body = body;
	}
	
}
