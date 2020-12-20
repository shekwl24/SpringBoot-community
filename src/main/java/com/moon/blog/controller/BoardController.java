package com.moon.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.moon.blog.auth.PrincipalDetail;

@Controller
public class BoardController {

	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤러에서 세션을 어떻게 찾는지?
		// /WEB-INF/views/index.jsp
		return "index";
	}
}
