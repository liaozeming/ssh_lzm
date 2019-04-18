package cn.lzm.dao.Implement;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lzm.dao.CustomerDao;
import cn.lzm.domain.Customer;

public class CustomerDaoImplement extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Integer geTotalCount(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		detachedCriteria.setProjection(Projections.rowCount());
		
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
		
		//清空聚合函数
		detachedCriteria.setProjection(null);
		if(list!=null&& list.size()>0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	
		
	}

	@Override
	public List<Customer> getPageList(DetachedCriteria detachedCriteria, int start, Integer pageSize) {
		// TODO Auto-generated method stub
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
		return list;
	}

}
