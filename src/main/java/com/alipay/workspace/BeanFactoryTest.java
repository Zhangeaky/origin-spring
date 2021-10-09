package com.alipay.workspace;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class BeanFactoryTest {

    public static void main(String[] args) {

        final String CLASS_PATH = "META_INFO";
        ClassPathResource resource = new ClassPathResource(CLASS_PATH);

        BeanFactory container = new XmlBeanFactory(resource);


    }
}
