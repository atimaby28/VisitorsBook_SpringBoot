package com.visitor.visitorsbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visitor.visitorsbook.model.VisitorDto;
import com.visitor.visitorsbook.model.service.VisitorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
@Api("어드민 컨트롤러  API V1")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private VisitorService visitorService;

	@ApiOperation(value = "회원목록", notes = "회원의 <big>전체 목록</big>을 반환해 줍니다.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "회원목록 OK!!"),
		@ApiResponse(code = 404, message = "페이지없어!!"),
		@ApiResponse(code = 500, message = "서버에러!!")
	})
	@GetMapping(value = "/visitor")
	public ResponseEntity<List<VisitorDto>> visitorList() throws Exception {
		List<VisitorDto> list = visitorService.listVisitor();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<VisitorDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "회원등록", notes = "회원의 정보를 받아 처리.")
	@PostMapping(value = "/visitor")
	public ResponseEntity<List<VisitorDto>> visitorRegister(@RequestBody VisitorDto visitorDto) throws Exception {
		visitorService.registerVisitor(visitorDto);
		List<VisitorDto> list = visitorService.listVisitor();
		return new ResponseEntity<List<VisitorDto>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원정보", notes = "회원한명에 대한 정보.")
	@GetMapping(value = "/visitor/{visitorid}")
	public ResponseEntity<VisitorDto> visitorInfo(@PathVariable("visitorid") String visitorid) throws Exception {
		logger.debug("파라미터 : {}", visitorid);
		VisitorDto visitorDto = visitorService.getVisitor(visitorid);
		if(visitorDto != null)
			return new ResponseEntity<VisitorDto>(visitorDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원정보수정", notes = "회원정보를 수정합니다.")
	@PutMapping(value = "/visitor")
	public ResponseEntity<List<VisitorDto>> visitorModify(@RequestBody VisitorDto visitorDto) throws Exception {
		visitorService.updateVisitor(visitorDto);
		List<VisitorDto> list = visitorService.listVisitor();
		return new ResponseEntity<List<VisitorDto>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원정보삭제", notes = "회원정보를 삭제합니다.")
	@DeleteMapping(value = "/visitor/{visitorid}")
	public ResponseEntity<List<VisitorDto>> visitorDelete(@PathVariable("visitorid") String visitorid) throws Exception {
		visitorService.deleteVisitor(visitorid);
		List<VisitorDto> list = visitorService.listVisitor();
		return new ResponseEntity<List<VisitorDto>>(list, HttpStatus.OK);
	}

}
