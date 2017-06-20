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
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class ListsIteration {
    @Param({"10", "1000", "1000000"})
    public int items;

    private LinkedList<Integer> ll;
    private ArrayList<Integer> al;

    @Setup
    public void setup() {
        ll = new LinkedList<>();
        al = new ArrayList<>(items);
        for (int i = 0; i < items; i++) {
            ll.add(i);
            al.add(i);
        }
    }

    @Benchmark
    public void iterateArrayList(Blackhole bh) {
        for (Integer i : al) {
            bh.consume(i);
        }
    }

    @Benchmark
    public void iterateLinkedList(Blackhole bh) {
        for (Integer i : ll) {
            bh.consume(i);
        }
    }
}
