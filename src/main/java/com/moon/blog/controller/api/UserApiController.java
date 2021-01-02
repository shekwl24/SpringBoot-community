package com.moon.blog.controller.api;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moon.blog.auth.PrincipalDetail;
import com.moon.blog.dto.ResponseDto;
import com.moon.blog.model.RoleType;
import com.moon.blog.model.User;
import com.moon.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto save(@RequestBody @Valid User user) { // username, password, email
		userService.회원가입(user);
		return new ResponseDto(HttpStatus.OK.value(), "회원가입이 성공하였습니다."); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	
	@PutMapping("/user")
	public ResponseDto update(@RequestBody @Valid User user) { // key=value, x-www-form-urlencoded
		userService.회원수정(user);
		// 여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음
		// 하지만 세션값은 변경되지 않은 상태이기 때문에 직접 세션값을 변경해야함
		// 세션 등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto(HttpStatus.OK.value(), "회원수정이 완료되었습니다."); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
	
	@PostMapping("/auth/api/user/{username}")
	public ResponseDto checkUsername(@PathVariable String username) {
		if(userService.이름중복검사(username)) return new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "이름이 중복되었습니다.");
		else return new ResponseDto(HttpStatus.OK.value(), "사용가능한 이름입니다.");
	}
	
	@DeleteMapping("/api/user/{id}")
	public ResponseDto deleteById(@PathVariable int id) { 
		userService.회원탈퇴(id);
		return new ResponseDto(HttpStatus.OK.value(), "회원탈퇴가 완료되었습니다."); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
}





