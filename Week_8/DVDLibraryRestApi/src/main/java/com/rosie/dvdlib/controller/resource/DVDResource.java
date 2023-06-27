package com.rosie.dvdlib.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rosie.dvdlib.dto.DVD;
import com.rosie.dvdlib.dto.DVDList;
import com.rosie.dvdlib.model.businesslogic.BusinessLogicImpl;

@CrossOrigin
@RestController
public class DVDResource {

	
	@Autowired
	BusinessLogicImpl dvdService;
	
	@CrossOrigin
	@GetMapping(path = "/DVDLibrary/{title}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DVD> searchDVDResource(@PathVariable("title") String title) {
		DVD dvd=dvdService.searchDVDs(title);
		ResponseEntity response=null;
		if(dvd!=null)
			response=new ResponseEntity<DVD>(dvd, HttpStatus.FOUND);
		else
			response=new ResponseEntity<DVD>(dvd,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@CrossOrigin
	@GetMapping(path="/DVDLibrary",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<DVDList> getAllDVDs() {
		DVDList dvdList= new DVDList(dvdService.getAllDVDs());
		if(dvdList.getDVDs().size()>0)
			return new ResponseEntity<DVDList>(dvdList,HttpStatus.OK);
		else
			return new ResponseEntity<DVDList>(dvdList,HttpStatus.NO_CONTENT);
	}
}
