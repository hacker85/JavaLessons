package jmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class Maps {
    @Param({"1000", "1000000"})
    public int items;

    @Benchmark
    public int hashMapPut() {
        HashMap<Integer, String> data = new HashMap<>();
        String value = "foo";
        for (int i = 0; i < items; i++) {
            data.put(i, value);
        }
        return data.size();
    }

    @Benchmark
    public int treeMapPut() {
        TreeMap<Integer, String> data = new TreeMap<>();
        String value = "foo";
        for (int i = 0; i < items; i++) {
            data.put(i, value);
        }
        return data.size();
    }
}
