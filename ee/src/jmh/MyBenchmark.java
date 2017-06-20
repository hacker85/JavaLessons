package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@CompilerControl(CompilerControl.Mode.EXCLUDE)
@Fork(1)
@Measurement(iterations = 2)
@Warmup(iterations = 2)
@State(Scope.Thread)
//@Threads(4)
public class MyBenchmark {

    @Param({"1000", "100000"})
    public static int count;

    @State(Scope.Thread)
    public static class MyState {
        List<Integer> arrayList = new ArrayList<>(count);
        List<Integer> linkedList = new LinkedList<>();
        @Setup(Level.Trial)
        public void setUp() {
//            System.out.println("setUp");
        }
        @TearDown(Level.Trial)
        public void tearDown(){
//            System.out.println("teraDown");
        }
    }

    @Benchmark
    public void addArrayList(MyState myState, Blackhole blackhole) {
        for (int i = 0; i < count; i++) {
            myState.arrayList.add(i);
        }
//        int a = 1;
//        int b = 2;
//        int sum = a + b;
//        blackhole.consume(sum);
    }

    @Benchmark
    public void addLinbkedList(MyState myState, Blackhole blackhole) {
        for (int i = 0; i < count; i++) {
            myState.linkedList.add(i);
        }
    }

}
