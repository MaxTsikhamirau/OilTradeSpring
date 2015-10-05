package by.academy.tikhomirov.springmvc.controller;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Model;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import by.academy.tikhomirov.servise.interf.OfferServise;
import by.academy.tikhomirov.servise.interf.UserServise;
import by.academy.tikhomirov.vo.OfferVO;
import by.academy.tikhomirov.vo.UserVO;
@Controller
@RequestMapping("/")
public class MainController {
	private static final Logger logger = Logger.getLogger(MainController.class.getName());
	@Autowired
	private OfferServise offerServise;
	@Autowired
	private UserServise userServise;
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String start(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = { "/newUser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		UserVO userVO = new UserVO();
		model.addAttribute("user", userVO);
		return "newUser";
	}

//	@RequestMapping(value = { "/newUser" }, method = RequestMethod.POST)
//	public String saveUser(@ModelAttribute("user") UserVO userVO, BindingResult result, SessionStatus status) {
//
//		userServise.add(userVO);
//		return "redirect:/listUsers";
//	}

	

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute("user") UserVO userVO,
                                   BindingResult result, SessionStatus status) {
      
        if (result.hasErrors()) {
            return new ModelAndView("newUser", "user", userVO);
        } else {
            status.setComplete();
            userServise.add(userVO);
                    }
        return new ModelAndView("redirect:/newUser", "user", userVO);
    }
	
	
	
	
	
	
	@RequestMapping(value = { "/offersListPage" }, method = RequestMethod.GET)
	public String offersList(ModelMap model) {

		List<OfferVO> offers = offerServise.getAll();
		model.addAttribute("offers", offers);

		return "offersListPage";
	}

	@RequestMapping(value = { "/listUsers" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<UserVO> users = userServise.getAll();
		model.addAttribute("users", users);

		return "listUsers";
	}
}
