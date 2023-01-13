package org.jeecg.modules.hwz.Test.service;

import org.jeecg.modules.hwz.Test.entity.TestOrderProduct;
import org.jeecg.modules.hwz.Test.entity.TestOrderMain;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 测试订单主表
 * @Author: lengbingkeji-boot
 * @Date:   2022-12-12
 * @Version: V1.0
 */
public interface ITestOrderMainService extends IService<TestOrderMain> {

	/**
	 * 添加一对多
	 *
	 * @param testOrderMain
	 * @param testOrderProductList
	 */
	public void saveMain(TestOrderMain testOrderMain,List<TestOrderProduct> testOrderProductList) ;
	
	/**
	 * 修改一对多
	 *
	 * @param testOrderMain
	 * @param testOrderProductList
	 */
	public void updateMain(TestOrderMain testOrderMain,List<TestOrderProduct> testOrderProductList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
