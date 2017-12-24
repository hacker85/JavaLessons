package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class PairRddLesson {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkApp");
        JavaSparkContext sc = new JavaSparkContext(conf);

//        Tuple2 tuple2 = new Tuple2("one", "two");
//        System.out.println(tuple2._1());
//        System.out.println(tuple2._2());

        //reduceByKey
        List<Tuple2<String, String>> list = Arrays.asList(new Tuple2("one", "two"), new Tuple2("three", "four"));
        JavaPairRDD<String,String> listMapPair = sc.parallelizePairs(list);

        JavaRDD<String> lines = sc.parallelize(Arrays.asList("one", "two", "three", "four"));
        JavaPairRDD<String, String> mapPair = lines.mapToPair(s -> new Tuple2(s, s));

        System.out.println(listMapPair.collect());
        System.out.println(mapPair.collect());

        JavaPairRDD<String, String> notOne = listMapPair.filter((x) -> !x._1().equals("one"));
        System.out.println(notOne.collect());

        JavaPairRDD<String,String> reducePairMap = sc.parallelizePairs(Arrays.asList(new Tuple2("one", "1"), new Tuple2("one", "2"), new Tuple2("two", "3")));
        JavaPairRDD<String, String> reduceByKey = reducePairMap.reduceByKey((x,y) -> x + y, 5);
        System.out.println(reduceByKey.collect());

        JavaPairRDD<String, Iterable<String>> groupByKey = reducePairMap.groupByKey();
        System.out.println(groupByKey.collect());

        JavaPairRDD<String,String> join1 = sc.parallelizePairs(Arrays.asList(new Tuple2("one", "1"), new Tuple2("two", "2")));
        JavaPairRDD<String,String> join2 = sc.parallelizePairs(Arrays.asList(new Tuple2("one", "3")));
        JavaPairRDD<String, Tuple2<String, String>> join = join1.join(join2);
        System.out.println(join.collect());

        JavaPairRDD<String,String> sort = sc.parallelizePairs(Arrays.asList(new Tuple2("a", "1"), new Tuple2("c", "3"), new Tuple2("b", "2")));
        JavaPairRDD<String, String> sortByKey = sort.sortByKey();
        System.out.println(sortByKey.collect());
    }
}
