package com._520it.crm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Controller
public class EmployeeController extends BaseController {

	@Autowired
	private IEmployeeService service;

	@RequestMapping("/employee")
	@RequiresPermissions("employee:view")
	@PermissionName("员工主页")
	public String index() {
		return "employee";
	}

	@RequestMapping("/employee_list")
	@ResponseBody
	@RequiresPermissions("employee:list")
	@PermissionName("员工列表")
	public PageResult list(EmployeeQuery qo) {
		// 获取当前登录的员工对象
		Subject subject = SecurityUtils.getSubject();
		Employee employee = (Employee) subject.getPrincipal();
		// 数据权限控制
		// 如果是经理则可以查询所有数据
		if (!subject.hasRole("admin")) {
			// 如果不是,则只能查询自己的数据
			
			qo.setId(employee.getId());
		}
		return service.queryPageResult(qo);
	}

	@RequestMapping("/employee_listAll")
	@ResponseBody
	public List<Employee> listAll() {

		return service.selectAll();
	}

	@RequestMapping("/employee_save")
	@ResponseBody
	@RequiresPermissions("employee:save")
	@PermissionName("新增员工")
	public AjaxResult save(Employee emp) {
		// 默认是在职状态
		emp.setState(true);
		try {
			service.insert(emp);
			return new AjaxResult(true, "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(false, "保存失败!");
	}

	@RequestMapping("/employee_update")
	@ResponseBody
	@PermissionName("更新员工")
	@RequiresPermissions("employee:update")
	public AjaxResult update(Employee emp) {
		try {
			service.updateByPrimaryKey(emp);
			return new AjaxResult(true, "更新成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(false, "更新失败!");
	}

	@RequestMapping("/employee_changeState")
	@ResponseBody
	@PermissionName("设置离职")
	@RequiresPermissions("employee:changeState")
	public AjaxResult changeState(Long id) {
		try {
			service.changeState(id);
			return new AjaxResult(true, "设置成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(false, "设置失败!");
	}

	@RequestMapping("/employee_export")
	@ResponseBody
	@RequiresPermissions("employee:export")
	@PermissionName("导出员工列表")
	public void export(HttpServletResponse response) throws Exception {
		// 文件下载响应头
		response.setHeader("Content-Disposition", "attachment;filename=a.xls");
		// 响应到浏览器
		WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());

		// 创建本地xls文件
		// WritableWorkbook workbook = Workbook.createWorkbook(new
		// File("F:/a.xls"));
		// 创建工作簿sheet
		WritableSheet sheet = workbook.createSheet("day01", 0);

		/*
		 * //创建文本格式单元格 Label cell = new Label(0,0,"hello"); //把单元格添加到工作簿中
		 * sheet.addCell(cell); //创建日期格式单元格 DateTime dateTime = new DateTime(1,
		 * 0, new Date()); //把单元格添加到工作簿中 sheet.addCell(dateTime);
		 */

		// 设置列标题
		sheet.addCell(new Label(0, 0, "用户名"));
		sheet.addCell(new Label(1, 0, "真实姓名"));
		sheet.addCell(new Label(2, 0, "电话"));
		sheet.addCell(new Label(3, 0, "邮箱"));
		sheet.addCell(new Label(4, 0, "入职时间"));
		sheet.addCell(new Label(5, 0, "部门"));
		sheet.addCell(new Label(6, 0, "状态"));
		sheet.addCell(new Label(7, 0, "管理员"));

		// 把员工的数据填充到工作簿中
		List<Employee> list = service.exportEmployee();

		for (int i = 0, j = 1; i < list.size(); i++, j++) {
			Employee employee = list.get(i);
			System.out.println(employee);
			sheet.addCell(new Label(0, j, employee.getUsername()));
			sheet.addCell(new Label(1, j, employee.getRealname()));
			sheet.addCell(new Label(2, j, employee.getTel()));
			sheet.addCell(new Label(3, j, employee.getEmail()));
			// 时间格式的转换
			Date inputtime = employee.getInputtime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(inputtime);
			sheet.addCell(new Label(4, j, date));

			sheet.addCell(new Label(5, j, employee.getDept().getName()));
			sheet.addCell(new Label(6, j, employee.getState() ? "在职" : "离职"));
			sheet.addCell(new Label(7, j, employee.getAdmin() ? "是" : "否"));
		}
		// 写入数据
		workbook.write();
		// 关闭资源
		workbook.close();
	}

	@RequestMapping("/employee_import")
	@ResponseBody
	@RequiresPermissions("employee:import")
	@PermissionName("导入员工列表")
	public void importFile(MultipartFile file) throws Exception {
		// 获取用户上传的文件
		Workbook workbook = Workbook.getWorkbook(file.getInputStream());
		// 获取工作簿sheet
		Sheet sheet = workbook.getSheet(0);
		/*
		 * //获取总列数 int columns = sheet.getColumns(); //获取单元格内容 for (int i = 0; i
		 * < rows; i++) { for (int j = 0; j < columns; j++) { Cell cell =
		 * sheet.getCell(j, i); System.out.println(cell.getContents()); } }
		 */
		// 获取总行数
		int rows = sheet.getRows();
		for (int i = 1; i < rows; i++) {
			Employee employee = new Employee();
			employee.setUsername(sheet.getCell(0, i).getContents());
			employee.setRealname(sheet.getCell(1, i).getContents());
			employee.setTel(sheet.getCell(2, i).getContents());
			employee.setEmail(sheet.getCell(3, i).getContents());
			// 添加到数据库中
			service.insert(employee);
		}
		// 关闭资源
		workbook.close();
	}

	@RequestMapping("/emp_delete")
	@ResponseBody
	@RequiresPermissions("employee:delete")
	@PermissionName("员工删除")
	public AjaxResult delete(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(true, "删除失败!");
	}
	
	
		//修改密码
		@RequestMapping("/employee_changepwd")
		@ResponseBody
		public AjaxResult update(String password,String newpwd,String rNewpwd) {
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			//获取数据库中的密码 和 用户输入的密码 
			String oldPassword = employee.getPassword();
			if(!oldPassword.equals(password)){
				return new AjaxResult(false, "密码错误");
			}
			if(!newpwd.equals(rNewpwd)){
				return new AjaxResult(false, "两次密码不一致");
			}
			
			service.updateByEmpPwd(newpwd,employee.getId());
			return new AjaxResult(true, "修改成功");
			
		}
		
		@RequestMapping("/clearSession")
	    @ResponseBody
	    public AjaxResult clearSession(HttpSession session){
			//请求session
	        session.invalidate();

	        return new AjaxResult(true, "请重新登录");
	    }
	
}
