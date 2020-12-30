package com.moon.blog;

import java.util.HashMap;

import org.junit.Test;

import com.moon.blog.model.Reply;

public class ReplyObjectTest {
	
	@Test
	public void 투스트링테스트() {
		Reply reply = Reply.builder()
				.id(1)
				.user(null)
				.board(null)
				.content("안녕")
				.build();
		System.out.println(reply); // 오브젝트 출력시에 toString이 자동 호출됨.
	}
	
	@Test
	public void 해쉬테스트() {
		String s1 = "";
		String s2 = null;
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
	}
}
