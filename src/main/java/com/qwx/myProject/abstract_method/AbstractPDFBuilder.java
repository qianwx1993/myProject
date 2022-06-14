package com.qwx.myProject.abstract_method;

import com.qwx.myProject.abstract_method.entity.SalesEntity;
import com.qwx.myProject.abstract_method.entity.SalesEntityItem;
import com.qwx.myProject.abstract_method.entity.SalesEntityResponse;
import org.dom4j.Document;
import org.dom4j.DocumentException;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/6/15 0:50
 */
public abstract class AbstractPDFBuilder<T extends SalesEntity, U extends SalesEntityItem, V extends SalesEntityResponse<T, U>> {
	protected abstract void addItems(Document document, V entityResponse) throws DocumentException;
}
