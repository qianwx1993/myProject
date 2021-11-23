package com.qwx.beanAutoload1;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * bean的动态装载之importSelector - 自定义类=
 * @author Qian
 * @Since JDK1.8
 * @Date 2021/11/23 23:44
 */
public class HelloImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("ZswImportSelector ============== selectImports");
		return new String[] { HelloImportSelectorConfiguration.class.getName() };
	}
}
