package cn.lzm.web.action;

import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lzm.domain.User;
import cn.lzm.service.UserService;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	//微不足道，不用spring
	private User user= new User();
	private UserService userService;

	@Test
	public String login() throws Exception {
		// TODO Auto-generated method stub
	   User u=userService.getUserByCodePassWord(user);
	   ActionContext.getContext().getSession().put("user", u);
        return "toHome";
		
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}


	
	

}
