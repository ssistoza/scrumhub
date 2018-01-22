package com.revature.ScrumHub.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ScrumHub.Service.SwimlaneService;
import com.revature.ScrumHub.bean.Swimlane;

@RestController
public class SwimlaneCtrl {

	@Autowired
	SwimlaneService swimlaneService;

	@GetMapping("/swimlane/{id}")
	public Swimlane getSwimlane(@PathVariable int id) {
		System.out.println("SwimlaneCtrl -get");
		return swimlaneService.getSwimlane(id);
	}
		
		@PostMapping("/createSwimlane")
		public ResponseEntity<Swimlane> createSwimlane(@RequestBody Swimlane sl){
			System.out.println("SwimlaneCtrl -createSwimlane");
			sl = swimlaneService.createSwimlane(sl);
					return new ResponseEntity<Swimlane>(sl, HttpStatus.CREATED);		
		}
}