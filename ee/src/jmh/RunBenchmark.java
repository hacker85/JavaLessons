package jmh;

import jmh.benchmarks.Iteration;
import jmh.benchmarks.Lists;
import jmh.benchmarks.ListsIteration;
import jmh.benchmarks.Maps;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class RunBenchmark {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(Lists.class.getSimpleName())
                .include(Maps.class.getSimpleName())
                .include(Iteration.class.getSimpleName())
                .include(ListsIteration.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
