package cn.lzm.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lzm.domain.Customer;
import cn.lzm.domain.User;
import cn.lzm.service.CustomerService;
import cn.lzm.service.UserService;
import cn.lzm.util.PageBean;


public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	//微不足道，不用spring
	private Customer customer= new Customer();
	private CustomerService customerservice;
	
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	//属性驱动
	private Integer currentPage;
	private Integer pageSize;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub

		return customer;
	}

	public String list() throws Exception {
		
		//封装离线查询对象
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if(StringUtils.isNoneBlank(customer.getCust_name()))
		{
			dCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//1 调用Service查询分页数据(PageBean)
		PageBean pb =customerservice.getPageBean(dCriteria,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}





	
	

}
