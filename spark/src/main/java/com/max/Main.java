package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkApp");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(2));
        JavaReceiverInputDStream<String> locahost = jssc.socketTextStream("localhost", 9999);
        locahost.foreachRDD(x -> System.out.println(x.collect()));
        jssc.start();
        jssc.awaitTermination();
    }
}