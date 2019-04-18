package cn.lzm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lzm.domain.Customer;

public interface CustomerDao {

	public Integer geTotalCount(DetachedCriteria detachedCriteria);

	public List<Customer> getPageList(DetachedCriteria detachedCriteria, int start, Integer pageSize);

}
