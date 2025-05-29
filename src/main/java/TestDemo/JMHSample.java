package TestDemo;

import org.openjdk.jmh.annotations.*;
import TestDemo.Sortings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.nio.file.*;
import java.util.Arrays;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHSample {

    @Param({"1000", "10000", "50000", "100000", "500000"})
    public int size;

    private int[] data;

    @Setup(Level.Invocation)
    public void setup() {
        Random rand = new Random(42);
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(1_000_000);
        }
    }

    @Benchmark
    public int[] builtInSort() {
        int[] copy = data.clone();
        Sortings c = new Sortings();
        c.builtInSort(copy);
        return copy;
    }

    @Benchmark
    public int[] bubbleSort() {
        int[] copy = data.clone();
        Sortings c = new Sortings();
        c.bubbleSort(copy);
        return copy;
    }
    @Benchmark
    public int[] heapSort() {
        int[] copy = data.clone();
        Sortings c = new Sortings();
        c.Heapsort(copy);
        return copy;
    }

//
//    @Benchmark
//    public String stringConcat(){
//        String result = "";
//        for (int i=0; i<1000; i++){
//            result += String.valueOf(i);
//        }
//        return result;
//    }
//
//    @Benchmark
//    public  String concatUsingStringBuilder(){
//        StringBuilder result = new StringBuilder();
//        for (int i=0; i<1000;i++){
//            result.append(i);
//        }
//        return result.toString();
//    }
}
