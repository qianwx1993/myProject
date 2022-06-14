package com.qwx.myProject.abstract_method.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/6/15 0:51
 */
@Data
public class SalesEntityResponse<T extends SalesEntity, U extends SalesEntityItem> {
	public T salesEntity;
	public List<U> salesEntityItems;
}
