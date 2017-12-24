package com.max;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class JdbcLesson {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local")
                .appName("Java Spark SQL basic example")
                .getOrCreate();
        Dataset<Row> jdbcDF = spark.read()
                .format("jdbc")
                .option("driver", "com.mysql.jdbc.Driver")
                .option("url", "jdbc:mysql://localhost:3306/Lessons")
                .option("dbtable", "user")
                .option("user", "root")
                .option("password", "1")
                .load();
        jdbcDF.show();
    }
}
