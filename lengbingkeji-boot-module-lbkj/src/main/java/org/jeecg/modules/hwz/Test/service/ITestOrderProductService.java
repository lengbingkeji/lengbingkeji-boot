package org.jeecg.modules.hwz.Test.service;

import org.jeecg.modules.hwz.Test.entity.TestOrderProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 订单产品明细
 * @Author: lengbingkeji-boot
 * @Date:   2022-12-12
 * @Version: V1.0
 */
public interface ITestOrderProductService extends IService<TestOrderProduct> {

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<TestOrderProduct>
   */
	public List<TestOrderProduct> selectByMainId(String mainId);
}
