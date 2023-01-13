package org.jeecg.modules.yunzhian.company.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.yunzhian.company.entity.LbkjCompanylistType;
import org.jeecg.modules.yunzhian.company.service.ILbkjCompanylistTypeService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 监管对象类型
 * @Author: lengbingkeji-boot
 * @Date:   2022-09-28
 * @Version: V1.0
 */
@Api(tags="监管对象类型")
@RestController
@RequestMapping("/company/lbkjCompanylistType")
@Slf4j
public class LbkjCompanylistTypeController extends JeecgController<LbkjCompanylistType, ILbkjCompanylistTypeService> {
	@Autowired
	private ILbkjCompanylistTypeService lbkjCompanylistTypeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param lbkjCompanylistType
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "监管对象类型-分页列表查询")
	@ApiOperation(value="监管对象类型-分页列表查询", notes="监管对象类型-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LbkjCompanylistType>> queryPageList(LbkjCompanylistType lbkjCompanylistType,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<LbkjCompanylistType> queryWrapper = QueryGenerator.initQueryWrapper(lbkjCompanylistType, req.getParameterMap());
		Page<LbkjCompanylistType> page = new Page<LbkjCompanylistType>(pageNo, pageSize);
		IPage<LbkjCompanylistType> pageList = lbkjCompanylistTypeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param lbkjCompanylistType
	 * @return
	 */
	@AutoLog(value = "监管对象类型-添加")
	@ApiOperation(value="监管对象类型-添加", notes="监管对象类型-添加")
	//@RequiresPermissions("org.jeecg.modules.yunzhian:lbkj_companylist_type:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LbkjCompanylistType lbkjCompanylistType) {
		lbkjCompanylistTypeService.save(lbkjCompanylistType);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param lbkjCompanylistType
	 * @return
	 */
	@AutoLog(value = "监管对象类型-编辑")
	@ApiOperation(value="监管对象类型-编辑", notes="监管对象类型-编辑")
	//@RequiresPermissions("org.jeecg.modules.yunzhian:lbkj_companylist_type:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LbkjCompanylistType lbkjCompanylistType) {
		lbkjCompanylistTypeService.updateById(lbkjCompanylistType);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "监管对象类型-通过id删除")
	@ApiOperation(value="监管对象类型-通过id删除", notes="监管对象类型-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.yunzhian:lbkj_companylist_type:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		lbkjCompanylistTypeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "监管对象类型-批量删除")
	@ApiOperation(value="监管对象类型-批量删除", notes="监管对象类型-批量删除")
	//@RequiresPermissions("org.jeecg.modules.yunzhian:lbkj_companylist_type:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.lbkjCompanylistTypeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "监管对象类型-通过id查询")
	@ApiOperation(value="监管对象类型-通过id查询", notes="监管对象类型-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LbkjCompanylistType> queryById(@RequestParam(name="id",required=true) String id) {
		LbkjCompanylistType lbkjCompanylistType = lbkjCompanylistTypeService.getById(id);
		if(lbkjCompanylistType==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(lbkjCompanylistType);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param lbkjCompanylistType
    */
    //@RequiresPermissions("org.jeecg.modules.yunzhian:lbkj_companylist_type:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LbkjCompanylistType lbkjCompanylistType) {
        return super.exportXls(request, lbkjCompanylistType, LbkjCompanylistType.class, "监管对象类型");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("lbkj_companylist_type:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LbkjCompanylistType.class);
    }

}
