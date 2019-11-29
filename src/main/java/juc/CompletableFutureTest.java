package juc;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class CompletableFutureTest {

    public static void main(String[] args) {
//
//        // 描述串行关系..................
//        // 主要是thenApply、thenAccept、thenRun和thenCompose这四个系列的接口
//        CompletableFuture<String>	f0	=
//                CompletableFuture.supplyAsync(()	->	"Hello	World")						//①
//                        .thenApply(s	->	s	+	"	QQ")		//②
//                        .thenApply(String::toUpperCase);            //③
//        System.out.println(f0.join());
//
//
//        // 描述AND汇聚关系
//        // 描述AND汇聚关系，主要是thenCombine、thenAcceptBoth和runAfterBoth
//        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(()->{ return 3; });
//        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(()->{ return 6; });
//        CompletableFuture<Integer> result = a.thenCombine(b, new BiFunction<Integer, Integer, Integer>() {
//            @Override
//            public Integer apply(Integer t, Integer u) {
//                return t+u;
//            }
//        });
//        System.out.println(result.join());
//
//
//        // 描述OR汇聚关系
//        // 主要是applyToEither、acceptEither和runAfterEither系列的
//        CompletableFuture<String> f1 =
//                CompletableFuture.supplyAsync(()->{
//                    int t = 3;
//
//                    return String.valueOf(t);
//                });
//            CompletableFuture<String> f2 =
//                    CompletableFuture.supplyAsync(()->{
//                        int t = 6;
//
//                        return String.valueOf(t);
//                    });
//
//        CompletableFuture<String> f3 = f1.applyToEither(f2,s -> s);
//        System.out.println(f3.join());


        test6();
    }

    /**
     * 全不相干的 CompletableFuture 对象的结果整合起来，而且你也不希望等到第一个任务完全结
     束才开始第二项任务。
     * @throws Exception
     */
    public static void test6()   {

        CompletableFuture<List<Map>> a = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            List<Map>   list =new ArrayList<>();
            for (int i = 0; i <5 ; i++) {
                Map m=new HashMap();
                m.put("id",1);
                list.add(m);
            }
            return list;
        });

        CompletableFuture<List<Map>> b = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            List<Map>   list =new ArrayList<>();
            for (int i = 5; i <10 ; i++) {
                Map m=new HashMap();
                m.put("id",1);
                list.add(m);
            }
            return list;
        });

        CompletableFuture<List<Map>> result = a.thenCombine(b, new BiFunction<List<Map>, List<Map>, List<Map>>() {
            @Override
            public List<Map> apply(List<Map> t, List<Map> u) {
                List<Map>  result=new ArrayList<>();
                result.addAll(t);
                result.addAll(u);
                return   result;
            }
        });

        List<Map> list=result.join();
        System.out.println(list.size());

    }
}
