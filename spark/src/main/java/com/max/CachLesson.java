package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;

import java.util.Arrays;

public class CachLesson {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Integer> list = sc.parallelize(Arrays.asList(1, 2, 3));
        list.persist(StorageLevel.MEMORY_ONLY());
        list.persist(StorageLevel.MEMORY_ONLY_SER());
        list.persist(StorageLevel.MEMORY_AND_DISK());
        list.persist(StorageLevel.MEMORY_AND_DISK_SER());
        list.persist(StorageLevel.DISK_ONLY());
        System.out.println(list.count());
        System.out.println(list.collect());
        list.unpersist();
        System.out.println(list.count());
    }
}
