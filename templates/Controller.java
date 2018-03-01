package ${packageName}.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ${packageName}.domain.${className};
import ${packageName}.util.AjaxResult;
import ${packageName}.page.PageResult;
import ${packageName}.query.${className}QueryObject;
import ${packageName}.service.I${className}Service;

@Controller
public class ${className}Controller {
	@Autowired
	I${className}Service ${objectName}Service;

	@RequestMapping("/${objectName}")
	@RequiresPermissions("${objectName}:view")
	@PermissionName("xx主页")
	public String index(){
		return "${objectName}";
	}
	@RequestMapping("/${objectName}_list")
	@ResponseBody
	@RequiresPermissions("${objectName}:list")
	@PermissionName("xx列表")
	public PageResult list(${className}QueryObject qo){
		PageResult pageResult = null;
		pageResult = ${objectName}Service.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/${objectName}_save")
	@ResponseBody
	@RequiresPermissions("${objectName}:save")
	@PermissionName("保存xx")
	public AjaxResult save(${className} ${objectName}){
		AjaxResult result = null;
		try{
			${objectName}Service.insert(${objectName});
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/${objectName}_update")
	@ResponseBody
	@RequiresPermissions("${objectName}:update")
	@PermissionName("更新xx")
	public AjaxResult update(${className} ${objectName}){
		AjaxResult result = null;
		try{
			${objectName}Service.updateByPrimaryKey(${objectName});
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/${objectName}_delete")
	@ResponseBody
	@RequiresPermissions("${objectName}:delete")
	@PermissionName("删除xx")
	public AjaxResult delete(Long ${objectName}Id){
		AjaxResult result = null;
		try{
			${objectName}Service.deleteByPrimaryKey(${objectName}Id);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
