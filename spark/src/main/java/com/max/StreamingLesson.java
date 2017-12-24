package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;

public class StreamingLesson {
    public static void main(String[] args) throws InterruptedException {
//        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
//        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
//        JavaDStream<String> lines = jssc.socketTextStream("localhost", 7777);
//        JavaDStream<String> errorLines = lines.filter(x -> x.contains("error"));
//        errorLines.print();
//        jssc.start();
//        jssc.awaitTermination();

        SparkConf conf = new SparkConf().setMaster("local").setAppName("NetworkWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);
//        JavaDStream<String> logData = jssc.textFileStream("dirrectory");
        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s, 1));
        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((i1, i2) -> i1 + i2);
        wordCounts.print();
//        lines.foreachRDD(x -> System.out.println(x.collect()));
        jssc.start();
        jssc.awaitTermination();
    }
}
