package org.jeecg.modules.hwz.Test.service.impl;

import org.jeecg.modules.hwz.Test.entity.TestOrderProduct;
import org.jeecg.modules.hwz.Test.mapper.TestOrderProductMapper;
import org.jeecg.modules.hwz.Test.service.ITestOrderProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 订单产品明细
 * @Author: lengbingkeji-boot
 * @Date:   2022-12-12
 * @Version: V1.0
 */
@Service
public class TestOrderProductServiceImpl extends ServiceImpl<TestOrderProductMapper, TestOrderProduct> implements ITestOrderProductService {
	
	@Autowired
	private TestOrderProductMapper testOrderProductMapper;
	
	@Override
	public List<TestOrderProduct> selectByMainId(String mainId) {
		return testOrderProductMapper.selectByMainId(mainId);
	}
}
