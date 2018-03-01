package com._520it.crm.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.TransferRecord;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.TransferRecordQuery;
import com._520it.crm.service.ITransferRecordService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class TransferRecordController extends BaseController {

	@Autowired
	private ITransferRecordService service;

	
	@RequestMapping("/transferrecord")
	@RequiresPermissions("transferrecord:view")
	@PermissionName("客户移交主页")
	public String index() {
		return "transferrecord";
	}

	@RequestMapping("/transferrecord_list")
	@ResponseBody
	@RequiresPermissions("transferrecord:list")
	@PermissionName("客户移交列表")
	public PageResult list(TransferRecordQuery qo) {
		return service.queryList(qo);
	}
	
	@RequestMapping("/transferrecord_insert")
	@ResponseBody
	@RequiresPermissions("transferrecord:insert")
	@PermissionName("客户移交")
	public AjaxResult insert(TransferRecord record){
		try {
			service.insert(record);
			return new AjaxResult(true,"移交成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(true,"移交失败!");
		}
	}
	
}
