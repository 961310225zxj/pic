package com._520it.crm.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Checktable;
import com._520it.crm.domain.Employee;
import com._520it.crm.mapper.ChecktableMapper;
import com._520it.crm.service.IChecktableService;
import com._520it.crm.util.ThreadUtil;

@Service
public class ChecktableServiceImpl implements IChecktableService {
	@Autowired
	private ChecktableMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int insert(Checktable ct) {

		//获取当前登录的用户
		Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
		//当前日期
		Date date = new Date();
		//根据用户id获取到该用户的所有签到信息
		List<Checktable> cts = mapper.selectByEmpId(employee.getId());
		//判断有无信息,没有则新增
		//有则循环迭代,对比签到时间有没有和当天日期一样的
		//有,重复签到
		//没有,签到
		if (cts.size() > 0) {
			for (Checktable checktable : cts) {
				if (checktable.getSignintime() != null && checktable.getSignintime().getDay() == date.getDay()) {
					//重复签到
					return 0;
				}
			}
			//有签到的情况下判断日期后的签到信息
			ct = new Checktable();
			ct.setEmployee(employee);
			//获取与当前线程绑定在一起请求对象
			HttpServletRequest request = ThreadUtil.getRequest();
			if (request != null) {
				//设置ip
				ct.setEmployeeip(request.getRemoteHost());
			}
			ct.setSignintime(date);
			ct.setState(0);
			return mapper.insert(ct);

		} else {
			//没有任何签到信息下的新增签到
			ct = new Checktable();
			ct.setEmployee(employee);
			//获取与当前线程绑定在一起请求对象
			HttpServletRequest request = ThreadUtil.getRequest();
			if (request != null) {
				//设置ip
				ct.setEmployeeip(request.getRemoteHost());
			}
			ct.setSignintime(date);
			ct.setState(0);
			return mapper.insert(ct);
		}

	}

	/*@Override
	public Checktable selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}*/

	@Override
	public List<Checktable> selectAll() {
		return mapper.selectAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public int updateByPrimaryKey(Checktable ct) {
		//签退
		Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
		//获取该用户的所有签到信息
		List<Checktable> cts = mapper.selectByEmpId(employee.getId());
		//当前日期
		Date date = new Date();
		if (cts.size() > 0) {
			//有多条签到信息,对当天的进行签退
			for (Checktable checktable : cts) {
				if (checktable.getSignintime() != null && checktable.getSignintime().getDay() == date.getDay()) {
					checktable.setSignouttime(date);
					return mapper.updateByPrimaryKey(checktable);
				}
			}
		}

		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int checkedTable(Checktable ct) {
		//判断ct中的签到员工在数据库中的签到日期和ct中的签到日期是否相同
		//相同,删除原签到,新增
		//不同,新增签到
		List<Checktable> cts = mapper.selectByEmpId(ct.getEmployee().getId());

		if (cts.size() > 0) {
			for (Checktable checktable : cts) {
				//已经签到了,删除原签到信息
				if (ct.getSignintime() != null && ct.getSignouttime() != null && checktable.getSignintime() != null
						&& checktable.getSignintime().getDay() == ct.getSignintime().getDay()) {
					mapper.deleteByPrimaryKey(checktable.getId());
				}
			}
		}
		//获取与当前线程绑定在一起请求对象
		HttpServletRequest request = ThreadUtil.getRequest();
		if (request != null) {
			//设置ip
			ct.setEmployeeip(request.getRemoteHost());
		}
		Employee checked = (Employee) SecurityUtils.getSubject().getPrincipal();
		ct.setChecked(checked);
		ct.setCheckedTime(new Date());
		return mapper.insert(ct);
	}

	@Override
	public List<Checktable> exportChecktable() {
		return mapper.exportChecktable();
	}

}
