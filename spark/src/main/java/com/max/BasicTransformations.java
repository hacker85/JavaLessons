package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicTransformations {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Integer> list = sc.parallelize(Arrays.asList(1, 2, 3));
        System.out.println("list");
        list.foreach(f -> System.out.println(f));
        JavaRDD<Integer> map = list.map(i -> i * i);
        System.out.println("map");
        map.foreach(f -> System.out.println(f));
        JavaRDD<Integer> filter = map.filter(i -> i != 1);
        System.out.println("filter");
        filter.foreach(f -> System.out.println(f));
        JavaRDD<Object> flatMap = filter.flatMap(s -> new ArrayList<Object>(Arrays.asList(s, s + s)).iterator());
        System.out.println("flatMap");
        flatMap.foreach(f -> System.out.println(f));

        JavaRDD<Integer> list1 = sc.parallelize(Arrays.asList(1, 1, 2, 3));
        JavaRDD<Integer> list2 = sc.parallelize(Arrays.asList(3, 4));
        list1.distinct().foreach(x -> System.out.println(x));
        list1.union(list2).foreach(x -> System.out.println(x));
        list1.intersection(list2).foreach(x -> System.out.println(x));
        list1.subtract(list2).foreach(x -> System.out.println(x));
    }
}
