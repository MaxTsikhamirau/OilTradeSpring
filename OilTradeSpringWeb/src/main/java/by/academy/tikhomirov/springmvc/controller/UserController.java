package by.academy.tikhomirov.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import by.academy.tikhomirov.servise.interf.UserServise;
import by.academy.tikhomirov.vo.UserVO;

@Controller
@RequestMapping("/")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class.getName());
	@Autowired
	private UserServise userServise;
	
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUserForm(ModelMap model) {
		UserVO userVO = new UserVO();
		model.addAttribute("user", userVO);
		return "newUser";
	}
	

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute("user") UserVO userVO,
                                   BindingResult result, SessionStatus status) {
      
        if (result.hasErrors()) {
            return new ModelAndView("newUser", "user", userVO);
        } else {
            status.setComplete();
            //Add Validation!
            userServise.add(userVO);
                    }
        return new ModelAndView("redirect:/usersList", "user", userVO);
    }
}
