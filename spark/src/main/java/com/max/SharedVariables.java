package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.LongAccumulator;

import java.util.Arrays;

public class SharedVariables {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

//        Broadcast<int[]> broadcastVar = sc.broadcast(new int[] {1, 2, 3});
//        System.out.println(broadcastVar.value());

        LongAccumulator accum = sc.sc().longAccumulator();
//        sc.parallelize(Arrays.asList(1, 2, 3, 4)).foreach(x -> accum.add(x));
        sc.parallelize(Arrays.asList(1, 2, 3, 4)).map(x -> {accum.add(x);return x * 2;}).collect();
        System.out.println(accum.value());
    }
}
