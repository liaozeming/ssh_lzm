package cn.lzm.service.Implement;







import cn.lzm.dao.UserDao;
import cn.lzm.domain.User;
import cn.lzm.service.UserService;

public class UserServiceImplement implements UserService {
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	private UserDao userdao;

	
	@Override
	public User getUserByCodePassWord(User u) {
		User user= userdao.getByUserCode(u.getUser_code());
		if(user==null)
		{
			throw new RuntimeException("用户名不存在");
		}
		if(!user.getUser_password().equals(u.getUser_password()))
		{
			throw new RuntimeException("密码错误");
		}
		return user;
	}

	@Override
	public void test() {
		
		System.out.println("测试成功");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userdao.saveUser(user);
		
	}
	
	

}
