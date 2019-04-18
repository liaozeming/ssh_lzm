package cn.lzm.dao.Implement;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lzm.dao.UserDao;
import cn.lzm.domain.User;

//为HibernateDaoSupport注入sessionFactory,该类中封装了模板。
public class UserDaoImplement extends HibernateDaoSupport implements UserDao  {


	@Override
	public User getByUserCode(final String Usercode) {
		//hql
	return	getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql="from User where user_code=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, Usercode);
		User user = (User) query.uniqueResult();			
				return user;
			}
		});
		
		//Criteria
		/*DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		
		dc.add(Restrictions.eq("user_code", usercode));
		
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
			
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}*/
		
		
		
	
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
		return null;
	}

	

}
