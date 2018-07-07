package com.util.test;


import org.junit.Test;

import com.util.SendJMail;

public class TestSendJMail {
	@Test
	public void testSendJMail() {
		String emailMsg = "注册成功，请<a href='http://localhost:8080/bookstore?activeCode=ffddff14'>激活</a>后登录";
		SendJMail.sendMail("xinzixiaoyao@163.com", emailMsg );
		System.out.println("successful");
	}
}
