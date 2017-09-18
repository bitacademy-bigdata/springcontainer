package com.bigdata2017.springcontainer;

import org.springframework.stereotype.Component;

@Component
public class User {
	private Long no;
	private String name;
	
	public User() {
	}
	
	public User( Long no, String name ) {
		this.no = no;
		this.name = name;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + "]";
	}
}
