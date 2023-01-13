package org.jeecg.modules.kaifacourse.courselist.controller;

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
import org.jeecg.modules.kaifacourse.courselist.entity.LbkjCourseList;
import org.jeecg.modules.kaifacourse.courselist.service.ILbkjCourseListService;

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
 * @Description: 课程列表
 * @Author: lengbingkeji-boot
 * @Date:   2022-12-18
 * @Version: V1.0
 */
@Api(tags="课程列表")
@RestController
@RequestMapping("/courselist/lbkjCourseList")
@Slf4j
public class LbkjCourseListController extends JeecgController<LbkjCourseList, ILbkjCourseListService> {
	@Autowired
	private ILbkjCourseListService lbkjCourseListService;
	
	/**
	 * 分页列表查询
	 *
	 * @param lbkjCourseList
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "课程列表-分页列表查询")
	@ApiOperation(value="课程列表-分页列表查询", notes="课程列表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LbkjCourseList>> queryPageList(LbkjCourseList lbkjCourseList,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<LbkjCourseList> queryWrapper = QueryGenerator.initQueryWrapper(lbkjCourseList, req.getParameterMap());
		Page<LbkjCourseList> page = new Page<LbkjCourseList>(pageNo, pageSize);
		IPage<LbkjCourseList> pageList = lbkjCourseListService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param lbkjCourseList
	 * @return
	 */
	@AutoLog(value = "课程列表-添加")
	@ApiOperation(value="课程列表-添加", notes="课程列表-添加")
	//@RequiresPermissions("org.jeecg.modules.kaifacourse:lbkj_course_list:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LbkjCourseList lbkjCourseList) {
		lbkjCourseListService.save(lbkjCourseList);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param lbkjCourseList
	 * @return
	 */
	@AutoLog(value = "课程列表-编辑")
	@ApiOperation(value="课程列表-编辑", notes="课程列表-编辑")
	//@RequiresPermissions("org.jeecg.modules.kaifacourse:lbkj_course_list:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LbkjCourseList lbkjCourseList) {
		lbkjCourseListService.updateById(lbkjCourseList);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "课程列表-通过id删除")
	@ApiOperation(value="课程列表-通过id删除", notes="课程列表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.kaifacourse:lbkj_course_list:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		lbkjCourseListService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "课程列表-批量删除")
	@ApiOperation(value="课程列表-批量删除", notes="课程列表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.kaifacourse:lbkj_course_list:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.lbkjCourseListService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "课程列表-通过id查询")
	@ApiOperation(value="课程列表-通过id查询", notes="课程列表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LbkjCourseList> queryById(@RequestParam(name="id",required=true) String id) {
		LbkjCourseList lbkjCourseList = lbkjCourseListService.getById(id);
		if(lbkjCourseList==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(lbkjCourseList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param lbkjCourseList
    */
    //@RequiresPermissions("org.jeecg.modules.kaifacourse:lbkj_course_list:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LbkjCourseList lbkjCourseList) {
        return super.exportXls(request, lbkjCourseList, LbkjCourseList.class, "课程列表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("lbkj_course_list:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LbkjCourseList.class);
    }

}
