package juc;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class CompletableFutureTest {

    public static void main(String[] args) {

        // 描述串行关系..................
        // 主要是thenApply、thenAccept、thenRun和thenCompose这四个系列的接口
        CompletableFuture<String>	f0	=
                CompletableFuture.supplyAsync(()	->	"Hello	World")						//①
                        .thenApply(s	->	s	+	"	QQ")		//②
                        .thenApply(String::toUpperCase);            //③
        System.out.println(f0.join());


        // 描述AND汇聚关系
        // 描述AND汇聚关系，主要是thenCombine、thenAcceptBoth和runAfterBoth
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(()->{ return 3; });
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(()->{ return 6; });
        CompletableFuture<Integer> result = a.thenCombine(b, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer t, Integer u) {
                return t+u;
            }
        });
        System.out.println(result.join());


        // 描述OR汇聚关系
        // 主要是applyToEither、acceptEither和runAfterEither系列的
        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(()->{
                    int t = 3;

                    return String.valueOf(t);
                });
            CompletableFuture<String> f2 =
                    CompletableFuture.supplyAsync(()->{
                        int t = 6;

                        return String.valueOf(t);
                    });

        CompletableFuture<String> f3 = f1.applyToEither(f2,s -> s);
        System.out.println(f3.join());
    }
}
