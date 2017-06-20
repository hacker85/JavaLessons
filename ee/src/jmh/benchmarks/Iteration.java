package jmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class Iteration {
    @Param({"10000"})
    public int items;

    private ArrayList<Integer> entities;

    @Setup
    public void setup() {
        entities = new ArrayList<>(items);
        String name = "foo";
        for (int i = 0; i < items; i++) {
            entities.add(i);
        }
    }

    @Benchmark
    public void usingIteration(final Blackhole bh) {
        for (Integer i : entities) {
            bh.consume(i);
        }
    }

    @Benchmark
    public void usingLambda(final Blackhole bh) {
        entities.forEach(i -> bh.consume(i));
    }

    @Benchmark
    public void usingMethodRef(final Blackhole bh) {
        entities.forEach(bh::consume);
    }
}