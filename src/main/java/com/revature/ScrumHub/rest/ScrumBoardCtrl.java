package com.revature.ScrumHub.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ScrumHub.bean.ScrumBoard;
import com.revature.ScrumHub.service.ScrumBoardService;

@RestController
@RequestMapping("/board/")
public class ScrumBoardCtrl {

	@Autowired
	ScrumBoardService sbService;

	/**
	 * Purpose:
	 *  - Create a new ScrumBoard.
	 * 
	 * @author     Shane Avery Sistoza
	 *
	 * @param      sb    The new scrum board, created by user.
	 *
	 * @return     Persist scrum board to database and return itself.
	 * - If the board is null, return the BAD_REQUEST.
	 * - If the board is not null, return ACCEPTED.
	 */
	@PostMapping("/create")
	public ResponseEntity<ScrumBoard> createNewBoard(@RequestBody ScrumBoard sb){
		if (sb == null ) return new ResponseEntity<ScrumBoard>(sb, HttpStatus.BAD_REQUEST);
		sb = sbService.createNewBoard(sb);
		return new ResponseEntity<ScrumBoard>(sb, HttpStatus.ACCEPTED);
	}

	/**
	 * Purpose:
	 *  - Rename the board.
	 * @author     Shane Avery Sistoza
	 *
	 * @param      bId      The current board id.
	 * @param      newName  The new name changing it to.
	 *
	 * @return     Persist name to db and return status code.
	 *  - If board is null, return BAD_REQUEST
	 *  - If board is not null, return ACCEPTED
	 */
	@PostMapping("/rename")
	public ResponseEntity<Object> renameBoard(int bId, String newName){
		if ( bId > 0 ) { 
			ScrumBoard sb = sbService.updateName(bId, newName);
			if ( sb != null ) return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}