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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class Lists {
    @Param({"10", "1000", "1000000"})
    public int items;

    @Benchmark
    public int arrayListAdd() {
        ArrayList<String> data = new ArrayList<>();
        String value = "foo";
        for (int i = 0; i < items; i++) {
            data.add(value);
        }
        return data.size();
    }

    @Benchmark
    public int arrayListPredefAdd() {
        ArrayList<String> data = new ArrayList<>(items);
        String value = "foo";
        for (int i = 0; i < items; i++) {
            data.add(value);
        }
        return data.size();
    }


    @Benchmark
    public int linkedListAdd() {
        LinkedList<String> data = new LinkedList<>();
        String value = "foo";
        for (int i = 0; i < items; i++) {
            data.add(value);
        }
        return data.size();
    }
}

