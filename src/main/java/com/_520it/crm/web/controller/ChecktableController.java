package com._520it.crm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Checktable;
import com._520it.crm.service.IChecktableService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class ChecktableController extends BaseController {

	@Autowired
	private IChecktableService service;

	@RequiresPermissions("check:view")
	@PermissionName("考勤主页")
	@RequestMapping("/checktable")
	public String checktable() {
		return "checktable";
	}
	
	
	@RequiresPermissions("check:list")
	@PermissionName("考勤列表")
	@RequestMapping("/check_list")
	@ResponseBody
	public List<Checktable> check() {
		return service.selectAll();
	}

	
	@RequestMapping("/check_signIn")
	@ResponseBody
	public AjaxResult signIn(Checktable ct) {
		try {
			if (service.insert(ct) != 0) {
				return new AjaxResult(true, "签到成功");
			} else {
				return new AjaxResult(false, "请勿重新签到");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "签到失败");
		}
	}

	@RequestMapping("/check_signOut")
	@ResponseBody
	public AjaxResult signOut(Checktable ct) {
		try {
			if (service.updateByPrimaryKey(ct) == 0) {
				return new AjaxResult(false, "请先签到");
			}
			return new AjaxResult(true, "签退成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "签退失败");
		}
	}
	
	@RequiresPermissions("check:checked")
	@PermissionName("考勤补签")
	@RequestMapping("/check_checked")
	@ResponseBody
	public AjaxResult checked(Checktable ct) {
		try {
			//			if (ct.getSignintime() == null || ct.getSignouttime() == null) {
			//				return new AjaxResult(true, "补签成功");
			//			}
			service.checkedTable(ct);
			return new AjaxResult(true, "补签成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "补签失败");
		}
	}

	@RequestMapping("/check_export")
	@ResponseBody
	@RequiresPermissions("check:export")
	@PermissionName("导出考勤列表")
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
		sheet.addCell(new Label(0, 0, "员工姓名"));
		sheet.addCell(new Label(1, 0, "签到IP"));
		sheet.addCell(new Label(2, 0, "签到时间"));
		sheet.addCell(new Label(3, 0, "签退时间"));
		sheet.addCell(new Label(4, 0, "状态"));
		sheet.addCell(new Label(5, 0, "补签人"));
		sheet.addCell(new Label(6, 0, "补签时间"));

		// 把员工的数据填充到工作簿中
		List<Checktable> list = service.exportChecktable();

		for (int i = 0, j = 1; i < list.size(); i++, j++) {
			Checktable checktable = list.get(i);
			System.out.println(checktable);
			sheet.addCell(new Label(0, j, checktable.getEmployee().getRealname()));
			sheet.addCell(new Label(1, j, checktable.getEmployeeip()));
			// 时间格式的转换
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (checktable.getSignintime() == null) {
				System.err.println("==============");
				sheet.addCell(new Label(2, j, " "));
			} else {
				Date signintime = checktable.getSignintime();
				String date = sdf.format(signintime);
				sheet.addCell(new Label(2, j, date));
			}
			if (checktable.getSignouttime() == null) {
				sheet.addCell(new Label(3, j, " "));
			} else {
				String date1 = sdf.format(checktable.getSignouttime());
				sheet.addCell(new Label(3, j, date1));
			}

			if (checktable.getState() == 0) {
				sheet.addCell(new Label(4, j, "正常"));
			} else if (checktable.getState() == 1) {
				sheet.addCell(new Label(4, j, "请假"));
			} else {
				sheet.addCell(new Label(4, j, "补签"));
			}
			if (checktable.getChecked() == null) {

				sheet.addCell(new Label(5, j, " "));
				sheet.addCell(new Label(6, j, " "));
			} else {
				sheet.addCell(new Label(5, j, checktable.getChecked().getRealname()));
				String date2 = sdf.format(checktable.getSignouttime());
				sheet.addCell(new Label(6, j, date2));
			}
		}
		// 写入数据
		workbook.write();
		// 关闭资源
		workbook.close();
	}

}
