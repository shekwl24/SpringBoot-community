package com.moon.blog.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplySaveRequestDto {
	private int userId;
	
	private int boardId;
	
	@NotBlank(message = "댓글을 입력하시오.")
	@Length(max = 300, message = "댓글 최대 길이는 300자입니다.")
	private String content;
}
