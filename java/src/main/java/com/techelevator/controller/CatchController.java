package com.techelevator.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.CatDAO;
import com.techelevator.model.Cat;

//@PreAuthorize("IsAuthenticated()")
@RestController
public class CatchController {
	
	private CatDAO catDao;
	
	public CatchController(CatDAO catDao) {
		this.catDao = catDao;
	}
	
//	@RequestMapping (path= "/cats/{account_id}", method = RequestMethod.GET)
//	public Account getAccountById(@PathVariable long account_id) throws AccountNotFoundException{
//		
//		if(accountDao.getAccountById(account_id) == null) {
//			throw new AccountNotFoundException();
//		}
//		return accountDao.getAccountById(account_id);
//	}
	
	@RequestMapping (path ="/cats", method=RequestMethod.GET)
	public List<Cat> getCatz() {
		
		return catDao.listCats();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/cats/addCat", method = RequestMethod.POST)
	public int cat (@RequestBody Cat cat) {
		return catDao.createCat(cat);
	}
}
