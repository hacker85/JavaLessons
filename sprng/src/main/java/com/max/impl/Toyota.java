package com.max.impl;

import com.max.interfaces.Car;
import com.max.interfaces.Radio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//("toyota")
//@Resource
//@Service
//@Repo
//@Controller
//@Named
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//@PropertySource("classpath:my.properties")
//InitializingBean, DisposableBean, BeanPostProcessor, ApplicationContextAware {
public class Toyota implements Car {
    @Autowired
//    @Resource
//    @Inject
//    @Required
    Radio radio;

    @Value("{'one','two','three'}")
    List<String> list;// = Arrays.asList(new String[]{"one", "two", "three"});

//        @Value("#{1}")
//    @Value("#{radio.name}")
//    @Value("#{radio.getName()}")
//    @Value("#{radio.getName().toUpperCase()}")
//    @Value("#{radio.getName()?.toUpperCase()}")
//    @Value("#{systemProperties['java.home']}")
//    @Value("#{3.14159}")
//    @Value("#{'Hello'}")
//    @Value("#{'Hello World'.concat('!')}")
//    @Value("#{'Hello World'.bytes.length}")
//    @Value("#{true}")
//    @Value("#{T(java.lang.Math).PI}")
//    @Value("#{radio.name + 2}")
//    @Value("#{1 < 2}")
//    @Value("#{true and false or true and 1 < 5}")
//    @Value("#{1 eq 2}")
//    @Value("#{1 == 2}")
//    @Value("#{radio.name eq 'best'}")
//    @Value("#{radio.name == 'best'}")
//    @Value("#{radio.name == 'best' ? 'this is true' : 'this is false'}")
//    @Value("#{radio.name matches '[a-z]*'}")
//    @Value("#{radio.name matches '[0-9]*'}")
//    @Value("#{toyota.list[0]}")
    @Value("#{'This is a test'[3]}")
//    @Value("#{radio.name}")
//    @Value("Max")
    String name;

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public Radio getRadio() {
        return radio;
    }

    public void drive() {
        radio.listenMusic();
        System.out.println("driving by " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }
}
