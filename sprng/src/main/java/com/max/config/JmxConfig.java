package com.max.config;

import com.max.MyMBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@ComponentScan("com.max")
public class JmxConfig {
    @Bean
    public MBeanExporter mbeanExporter(MyMBean myMBean) {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("myBean:name=MyMBean", myMBean);
        exporter.setBeans(beans);
        return exporter;
    }
}
