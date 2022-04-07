package com.qwx.myProject.strategy;

import com.qwx.myProject.bo.DistributeBo;
import com.qwx.myProject.pojo.InputTaskRecord;
import com.qwx.myProject.pojo.InputTaskRecordDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 抽象分配器
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/4/7 22:53
 */
@Slf4j
public abstract class AbstractDistributor {
	static final String strategyMethod="aumManageStaff,starManageStaff4Wealth,currentOrgCustManager4Wealth,currentOrgHzOrFhz";
	static final String doudiMethod="doudiMethod";
	/**
	 * 分配任务
	 */
	public DistributeBo distribute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
		String[] methodArr = strategyMethod.split(",");
		InputTaskRecord record=new InputTaskRecord();
		InputTaskRecordDetail detail=new InputTaskRecordDetail();
		DistributeBo bo=new DistributeBo();
		for (String methodName : methodArr) {

			//Method method = this.getClass().getDeclaredMethod(methodName, InputTaskRecord.class, InputTaskRecordDetail.class);
			Method method = this.getClass().getSuperclass().getDeclaredMethod(methodName, InputTaskRecord.class, InputTaskRecordDetail.class);
			//getSuperclass,getDeclaredMethod
			method.setAccessible(true);
			bo = (DistributeBo) method.invoke(this, record, detail);

			if (Objects.nonNull(bo)){
				break;
			}
		}
		System.out.println(bo);
		if (Objects.isNull(bo)){
			log.info("通过配置的流程未找到对应的管护，使用兜底方案");
			//Method method = this.getClass().getDeclaredMethod(doudiMethod, InputTaskRecord.class, InputTaskRecordDetail.class);
			Method method = this.getClass().getSuperclass().getDeclaredMethod(doudiMethod, InputTaskRecord.class, InputTaskRecordDetail.class);
			method.setAccessible(true);
			bo = (DistributeBo) method.invoke(this, record, detail);
		}
		log.info("最终确定的管护信息：{}",bo.toString());
		return bo;
	}

	/**
	 * aum用户
	 * @return
	 */
	DistributeBo aumManageStaff(InputTaskRecord record, InputTaskRecordDetail detail){
		log.info("进入了{}方法","aumManageStaff");
		return null;
	}

	/**
	 * 财富星标用户
	 * @return
	 */
	DistributeBo starManageStaff4Wealth(InputTaskRecord record, InputTaskRecordDetail detail){
		log.info("进入了{}方法","starManageStaff4Wealth");
		return null;
	}

	/**
	 * 当前机构客户经理，随机
	 * @return
	 */
	DistributeBo currentOrgCustManager4Wealth(InputTaskRecord record, InputTaskRecordDetail detail){
		log.info("进入了{}方法","currentOrgCustManager4Wealth");
		return null;
	}

	/**
	 * 当前机构，行长或副行长
	 * @return
	 */
	DistributeBo currentOrgHzOrFhz(InputTaskRecord record, InputTaskRecordDetail detail){
		log.info("进入了{}方法","currentOrgHzOrFhz");
		return null;
	}

	/**
	 * 当前机构，行长或副行长
	 * @return
	 */
	DistributeBo doudiMethod(InputTaskRecord record, InputTaskRecordDetail detail){
		log.info("进入了{}方法","doudiMethod");
		return new DistributeBo("test","1001");
	}
}
