package com.qwx.myProject.abstract_method;

import com.qwx.myProject.abstract_method.entity.SalesOrder;
import com.qwx.myProject.abstract_method.entity.SalesOrderEntityResponse;
import com.qwx.myProject.abstract_method.entity.SalesOrderItem;
import org.dom4j.Document;
import org.dom4j.DocumentException;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/6/15 0:55
 */
public class SalesOrderPDFBuilder extends AbstractPDFBuilder<SalesOrder, SalesOrderItem, SalesOrderEntityResponse>{
	@Override
	protected void addItems(Document document, SalesOrderEntityResponse entityResponse) throws DocumentException {
		entityResponse.getTestName();
	}
}
