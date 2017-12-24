package com.max;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class FileSystem {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> textFile = sc.textFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/test.txt");
        JavaPairRDD<String, String> wholeTextFiles = sc.wholeTextFiles("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/test.txt");
        textFile.saveAsTextFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/test2.txt");
        wholeTextFiles.saveAsTextFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/test3.txt");
        JavaRDD<String> textFile2 = sc.textFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/test2.txt");
        System.out.println(textFile2.collect());

        textFile2.saveAsObjectFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/object");
        JavaRDD<Object> objectJavaRDD = sc.objectFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/object");
        System.out.println(objectJavaRDD.collect());

        JavaPairRDD<Text, IntWritable> sequence = textFile2.mapToPair(record -> new Tuple2(new Text(record), new IntWritable()));
        sequence.saveAsHadoopFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/haddop",
                Text.class, IntWritable.class, SequenceFileOutputFormat.class);

        JavaPairRDD<Text, IntWritable> sequenceFile = sc.sequenceFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/haddop",
                Text.class, IntWritable.class);
        sequenceFile.map(f -> f._1().toString()).foreach(x -> System.out.println(x));

//        sequence.saveAsNewAPIHadoopFile("/home/max/IdeaProjects/JavaLessons/spark/src/main/resources/haddop",
//                Text.class, IntWritable.class, KeyValueTextInputFormat.class);
//        sc.hadoopFile("", KeyValueTextInputFormat.class, IntWritable.class);

        sc.textFile("file://test.txt");
        sc.textFile("s3n://test.txt");
        sc.textFile("hdfs://test.txt");


    }
}
