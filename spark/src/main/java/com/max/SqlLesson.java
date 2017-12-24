package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

import static org.apache.spark.sql.functions.col;

public class SqlLesson {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local")
                .appName("Java Spark SQL basic example")
                .getOrCreate();
        Dataset<Row> df = spark.read().json("spark/src/main/resources/users.json");
        df.show();
        df.printSchema();
        df.select("name").show();
        df.select(col("name"), col("age").plus(1)).show();
        df.filter(col("age").gt(25)).show();
        df.groupBy("age").count().show();

        df.createOrReplaceTempView("people");

        Dataset<Row> sqlDF = spark.sql("SELECT * FROM people");
        sqlDF.show();

        JavaRDD<Person> peopleRDD = spark.read().textFile("spark/src/main/resources/users.txt")
                .javaRDD()
                .map(line -> {
                    String[] parts = line.split(",");
                    Person person = new Person();
                    person.setName(parts[0]);
                    person.setAge(Integer.parseInt(parts[1].trim()));
                    return person;
                });
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<Person> peopleRDD2 = sc.parallelize(Arrays.asList(new Person("Max", 22), new Person("Mike", 33)));
        Dataset<Row> peopleDF = spark.createDataFrame(peopleRDD, Person.class);
        peopleDF.show();
    }
}
