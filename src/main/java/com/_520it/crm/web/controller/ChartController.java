package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.ChartQueryObject;
import com._520it.crm.service.IChartService;
import com._520it.crm.util.ExportExcelUtil;
import com._520it.crm.util.PermissionName;
import com._520it.crm.vo.ChartVO;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class ChartController extends BaseController {

	@Autowired
	private IChartService chartService;
	List<ChartVO> rows = new ArrayList<>();
	//真实报表页面
	@RequestMapping("/realChart")
	@RequiresPermissions("realChart:view")
	@PermissionName("正式客户主页")
	public String realChart(){
		return "chart_real";
	}
	//潜在报表页面
	@RequestMapping("/potentialChart")
	@RequiresPermissions("potentialChart:view")
	@PermissionName("潜在客户主页")
	public String potentialChart(){
		return "chart_potential";
	}
	//车险产品报表页面
	@RequestMapping("/carInsuranceChart")
	@RequiresPermissions("carInsuranceChart:view")
	@PermissionName("车险产品主页")
	public String carInsuranceChart(){
		return "carInsuranceChart";
	}
	
	@RequestMapping("/realChart_list")
	@RequiresPermissions("realChart_list:list")
	@PermissionName("正式客户列表")
	@ResponseBody
	public PageResult realList(ChartQueryObject qo){
		PageResult pageResult = chartService.queryRealChart(qo);
		return pageResult;
	}
	@RequestMapping("/potentialChart_list")
	@RequiresPermissions("potentialChart_list:list")
	@PermissionName("潜在客户列表")
	@ResponseBody
	public PageResult realPotential(ChartQueryObject qo){
		PageResult pageResult = chartService.queryPotentialChart(qo);
		return pageResult;
	}
	
	@RequestMapping("/carInsuranceChart_list")
	@RequiresPermissions("carInsuranceChart_list:list")
	@PermissionName("车险产品列表")
	@ResponseBody
	public PageResult carInsuranceChart(ChartQueryObject qo){
		PageResult pageResult = chartService.queryCarChart(qo);
		return pageResult;
	}
	
	//柱状图
	@RequestMapping("/chartForBar")
	@RequiresPermissions("chartForBar:chartBar")
	@PermissionName("柱状图")
	public ModelAndView chartForBar(String state){
		ChartQueryObject qo = new ChartQueryObject();
		PageResult result = null;
		//判断是正式客户还是潜在客户
		if("real".equals(state)){
			result = chartService.queryRealChart(qo);
		}else if("potential".equals(state)){
			result = chartService.queryPotentialChart(qo);
		}
		System.out.println(result);
		//List<ChartVO> rows = (List<ChartVO>) result.getRows();
		rows = (List<ChartVO>) result.getRows();
		List<Integer> count = new ArrayList<>();
		List<String> realname = new ArrayList<>();
		for (ChartVO vo : rows) {
			count.add(vo.getCount());
			realname.add(vo.getRealname());
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("realname", JSON.toJSONString(realname));
		mv.addObject("count", JSON.toJSONString(count));
		mv.setViewName("chartByBar");
		return mv;
	}
	//线性图
	@RequestMapping("/chartForLine")
	@RequiresPermissions("chartForLine:chartLine")
	@PermissionName("折线图")
	public ModelAndView chartForLine(String state){
		ChartQueryObject qo = new ChartQueryObject();
		PageResult result = null;
		//判断是正式客户还是潜在客户
		if("real".equals(state)){
			result = chartService.queryRealChart(qo);
		}else if("potential".equals(state)){
		    result = chartService.queryPotentialChart(qo);
		}
		System.out.println(result);
		//List<ChartVO> rows = (List<ChartVO>) result.getRows();
		rows = (List<ChartVO>) result.getRows();
		List<Integer> count = new ArrayList<>();
		List<String> realname = new ArrayList<>();
		for (ChartVO vo : rows) {
			count.add(vo.getCount());
			realname.add(vo.getRealname());
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("realname",JSON.toJSONString(realname));
		mv.addObject("count", JSON.toJSONString(count));
		mv.setViewName("chartByLine");
		return mv;
	}
	//饼状图
	@RequestMapping("/chartForPie")
	@RequiresPermissions("chartForPie:chartPie")
	@PermissionName("饼状图")
	public ModelAndView chartForPie(){
		ChartQueryObject qo = new ChartQueryObject();
		PageResult result = null;
		result = chartService.queryCarChart(qo);
		rows = (List<ChartVO>) result.getRows();
		Integer maxAmount = 0;
		List<Map<String,Object>> map = new ArrayList<>();
		List<String> productName = new ArrayList<>();
		for (ChartVO vo : rows) {
			productName.add(vo.getProductName());
			Map<String,Object> dataMap = new HashMap<>();
			map.add(dataMap);
			dataMap.put("name", vo.getProductName());
			dataMap.put("value", vo.getCount());
			//显示最大值
			Integer integer = vo.getCount();
			if(maxAmount.compareTo(integer)<=0){
				maxAmount = integer;
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("productName",JSON.toJSONString(productName));
		mv.addObject("dataMap", JSON.toJSONString(map));
		mv.addObject("maxAmount", maxAmount);
		mv.setViewName("chartByPie");
		return mv;
	}
	//漏斗图
	@RequestMapping("/chartByFunnel")
	@RequiresPermissions("chartByFunnel:chartFunnel")
	@PermissionName("漏斗图")
	public ModelAndView chartByFunnel(){
		ChartQueryObject qo = new ChartQueryObject();
		PageResult result = null;
		result = chartService.queryCarChart(qo);
		rows = (List<ChartVO>) result.getRows();
		Integer maxAmount = 0;
		List<Map<String,Object>> map = new ArrayList<>();
		List<String> productName = new ArrayList<>();
		for (ChartVO vo : rows) {
			productName.add(vo.getProductName());
			Map<String,Object> dataMap = new HashMap<>();
			map.add(dataMap);
			dataMap.put("name", vo.getProductName());
			dataMap.put("value", vo.getCount());
			//显示最大值
			Integer integer = vo.getCount();
			if(maxAmount.compareTo(integer)<=0){
				maxAmount = integer;
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("productName",JSON.toJSONString(productName));
		mv.addObject("dataMap", JSON.toJSONString(map));
		mv.addObject("maxAmount", maxAmount);
		mv.setViewName("chartByFunnel");
		return mv;
	}
	
	//导出
	@RequestMapping("/printExcel")
	@RequiresPermissions("printExcel:export")
	@PermissionName("导出报表列表")
	public void printExcel(HttpServletResponse resp){
		ExportExcelUtil.ExportExcel(ChartVO.class, resp, rows, "client", "客户报表");
	}
	
}
