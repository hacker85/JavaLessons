package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class BasicActions {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Integer> list = sc.parallelize(Arrays.asList(1, 2, 3));
        System.out.println(list.reduce((x,y) -> x + y));
        System.out.println(list.fold(0, (x,y) -> x + y));
//        System.out.println(list.aggregate(0, (x,y) -> x + y));
        System.out.println(list.collect());
        System.out.println(list.take(2));
        System.out.println(list.top(2));
        System.out.println(list.takeSample(false, 2));
        list.foreach(x -> System.out.print(x));
        System.out.println(list.count());
        System.out.println(list.countByValue());
    }
}
