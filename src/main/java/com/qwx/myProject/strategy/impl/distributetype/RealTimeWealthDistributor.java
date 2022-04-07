package com.qwx.myProject.strategy.impl.distributetype;

import com.qwx.myProject.bo.DistributeBo;
import com.qwx.myProject.pojo.InputTaskRecord;
import com.qwx.myProject.pojo.InputTaskRecordDetail;
import com.qwx.myProject.strategy.AbstractDistributor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 实时财富-分配器
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/4/7 22:57
 */
@Service
@Slf4j
public class RealTimeWealthDistributor extends AbstractDistributor {
	static final String strategyMethod="aumManageStaff,starManageStaff4Wealth,currentOrgCustManager4Wealth,currentOrgHzOrFhz";
	static final String doudiMethod="doudiMethod";
	@Override
	public DistributeBo distribute() {
		//TODO
		return null;
	}
}
