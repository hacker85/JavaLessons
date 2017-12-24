package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class RddLesson {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> input = sc.textFile("spark/src/main/resources/test.txt");
        JavaRDD<String> parallelize = sc.parallelize(Arrays.asList("hello", "world"));
        JavaRDD<String> world = input.filter(s -> s.contains("world"));
        System.out.println(parallelize.count());
        System.out.println(input.count());
        System.out.println(world.count());
        System.out.println(input.first());
    }
}
