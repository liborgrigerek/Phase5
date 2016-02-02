package cz.morosystems.phase5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import cz.morosystems.phase5.entity.UserEntity;
import cz.morosystems.phase5.entity.BookEntity;
import cz.morosystems.phase5.entity.AccountEntity;

import cz.morosystems.phase5.exception.UserNotFoundException;

import cz.morosystems.phase5.service.UserManager;
import cz.morosystems.phase5.service.BookManager;
import cz.morosystems.phase5.service.AccountManager;

@Controller
public class ShowUserController {

	@Autowired
	private UserManager userManager;
	@Autowired
	private BookManager bookManager;
	@Autowired
	private AccountManager accountManager;

	@RequestMapping("/")
	public String showUser(Model model) {
		model.addAttribute("users", userManager.getAllUsers());
		return "showusers";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, params = { "id" })
	public String showUser(@RequestParam("id") int id, Model model) {
		UserEntity user = userManager.getUser(id);
		if (user == null) {
			throw new UserNotFoundException(id);
		}
		List<BookEntity> books = bookManager.getAllBooks(id);
		List<AccountEntity> accounts = accountManager.getAllAccounts(id);
		
		model.addAttribute("user", user);
		model.addAttribute("bookList", books);
		model.addAttribute("accountList", accounts);
		return "showuser";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleError(UserNotFoundException exception, Model model) {
		model.addAttribute("invalidUserId", exception.getUserId());
		model.addAttribute("exception", exception);
		//model.addAttribute("url", req.getRequestURL() + "?" + req.getQueryString());
		return "error";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
