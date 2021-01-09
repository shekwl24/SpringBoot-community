package com.moon.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
//@DynamicInsert // insert시에 null인 필드를 제외시켜준다.
public class User {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 시퀀스 , auto_increment
	
	@Length(min = 2, message = "아이디 최소 길이는 2자입니다.")
	@Length(max = 15, message = "아이디 최대 길이는 15자입니다.")
	@Pattern(regexp = "^[가-힣0-9a-zA-Z]*$", message = "아이디는 공백없는 영문, 한글 숫자로 구성된 2~15자로 구성")
	@Column(nullable = false, length = 15, unique = true)
	private String username; // 아이디
	
	@Length(min = 4, message = "비밀번호 최소 길이는 4자입니다.")
	@Column(nullable = false, length = 100) // 123456 =>해쉬 (비밀번호 암호화)
	private String password;
	
	@Email
	@Column(nullable = false, length = 50)
	private String email;
	
	// @ColumnDefault("user")
	// DB는 RoleType이라는 게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. ADMIN, USER
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다. (난 FK가 아니다) DB에 컬럼을 만들지 말라
	@JsonIgnoreProperties({"user"})
	private List<Board> boards;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다. (난 FK가 아니다) DB에 컬럼을 만들지 말라
	@JsonIgnoreProperties({"user"})
	private List<Reply> replys;
}