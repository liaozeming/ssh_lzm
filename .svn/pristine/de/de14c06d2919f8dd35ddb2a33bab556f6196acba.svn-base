package cn.lzm.service.Implement;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import cn.lzm.dao.CustomerDao;
import cn.lzm.domain.Customer;
import cn.lzm.service.CustomerService;
import cn.lzm.util.PageBean;

public class CustomerServiceImplement implements CustomerService {

	private CustomerDao customerdao;
	public void setCustomerdao(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
//		1.调用dao查询总记录数
		Integer totalCount=customerdao.geTotalCount(detachedCriteria);
//		2.创建PageBean对象
				PageBean pBean=new PageBean(currentPage, totalCount, pageSize);
		//3.调用dao查询分页列表数据
		List<Customer> list=customerdao.getPageList(detachedCriteria,pBean.getStart(),pBean.getPageSize());
//		4.放入pageBean中，并返回
		pBean.setList(list);
		return pBean;
	}

}
