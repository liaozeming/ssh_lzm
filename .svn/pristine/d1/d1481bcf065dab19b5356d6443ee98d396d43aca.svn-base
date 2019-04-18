package cn.lzm.test;
import org.hibernate.cfg.Configuration;

import javax.annotation.Resource;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lzm.dao.UserDao;
import cn.lzm.domain.User;
import cn.lzm.service.UserService;

//为了让测试在Spring容器环境下执行。
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
	@Resource(name="sessionFactory")
	private  SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Test
	public void test1()
	{
		
//		Configuration configuration=new Configuration().configure();
//		sFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		User user=new User();
		
		user.setUser_code("lzms");
		user.setUser_name("ts");
		user.setUser_password("ss");
		
		
		session.save(user);
		transaction.commit();
		session.close();
	
	}
	
	
	@Resource(name="userdao")
	private UserDao ud;
	@Test
	//测试dao管理heibernate模板，模板中封装了sessionfactory
	public void test2()
	{
		User user = ud.getByUserCode("lzm");
		System.out.println(user);
		
	}
	
	@Resource(name="userService")
	private UserService us;
	//测试事务
	@Test
	public void test3()
	{
       User user=new User();
		user.setUser_code("lzms哈哈");
		user.setUser_name("ts");
		user.setUser_password("sssss");
		us.saveUser(user);

	}

}
