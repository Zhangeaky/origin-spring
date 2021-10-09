package com.alipay.workspace;

import com.alipay.workspace.di.pojo.Card;
import com.alipay.workspace.di.pojo.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.alipay.workspace.di.marker;
import java.util.Map;

public class test {
    public static void lazyLookup(BeanFactory beanFactory) {

        ObjectFactory<Person> objectbean = (ObjectFactory<Person>)beanFactory.getBean("objectBean");
        Person person = objectbean.getObject();
        System.out.println("lazylookup" + " "  + person);

    }
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring.xml");
        boolean isExist = context.containsBean("zhangeaky");
        System.out.println(isExist);

        //通过id寻找对应的bean
        Person zhangeaky = (Person)context.getBean("zhangeaky");
        System.out.println(zhangeaky);
         // 延迟查找
        lazyLookup(context);

        lookupByType(context);

        //BeanFactory beanFactory = new DefaultListableBeanFactory();

        lookupCollectionBean(context);

        lookupByAnnotaion(context);


        Card card = (Card) context.getBean(Card.class);
        System.out.println(card);

        BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
        boolean isDefinationExist =  registry.containsBeanDefinition("zhangeaky");
        System.out.println(isDefinationExist);




    }

    private static void lookupByAnnotaion(ClassPathXmlApplicationContext context) {
        //context.getBeansWithAnnotation()
        Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(marker.class);
        System.out.println("lookupwithAnnotation" +" "+beansWithAnnotation);
    }

    private static void lookupCollectionBean(ClassPathXmlApplicationContext context) {
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory
                    = (ListableBeanFactory) context;

            Map<String, Person> persons = listableBeanFactory.getBeansOfType(Person.class);
            System.out.print("查找到的所有对象" + " " + persons);
        }



    }

    private static void lookupByType(ClassPathXmlApplicationContext context) {

        Person bean = context.getBean(Person.class);
        System.out.println("" +" " + bean );

    }
}
