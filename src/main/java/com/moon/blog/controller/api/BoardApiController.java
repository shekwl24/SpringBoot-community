package com.moon.blog.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moon.blog.auth.PrincipalDetail;
import com.moon.blog.dto.ReplySaveRequestDto;
import com.moon.blog.dto.ResponseDto;
import com.moon.blog.model.Board;
import com.moon.blog.model.Reply;
import com.moon.blog.model.RoleType;
import com.moon.blog.model.User;
import com.moon.blog.service.BoardService;
import com.moon.blog.service.UserService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto save(@RequestBody @Valid Board board, @AuthenticationPrincipal PrincipalDetail principal, BindingResult bindingResult) { 
		boardService.글쓰기(board, principal.getUser());
		return new ResponseDto(HttpStatus.OK.value(), "글 쓰기가 완료되었습니다.");
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto deleteById(@PathVariable int id) {
		boardService.글삭제하기(id);
		return new ResponseDto(HttpStatus.OK.value(), "글 삭제가 완료되었습니다.");
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto update(@PathVariable int id, @RequestBody @Valid Board board) {
		boardService.글수정하기(id, board);
		return new ResponseDto(HttpStatus.OK.value(), "글 수정이 완료되었습니다.");
	}
	
	// 데이터 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.
	// dto 사용하지 않은 이유는!!
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto replySave(@RequestBody @Valid ReplySaveRequestDto replySaveRequestDto) {
		boardService.댓글쓰기(replySaveRequestDto);
		return new ResponseDto(HttpStatus.OK.value(), "댓글 작성이 완료되었습니다.");
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto replyDelete(@PathVariable int replyId, @PathVariable int boardId) {
		boardService.댓글삭제(replyId, boardId);
		return new ResponseDto(HttpStatus.OK.value(), "댓글 삭제가 완료되었습니다.");
	}
}





