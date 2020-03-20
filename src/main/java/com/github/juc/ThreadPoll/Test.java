package com.github.juc.ThreadPoll;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> list=new ArrayList<>();
        for (int i = 1; i <=15000 ; i++) {
            list.add(i+"");
        }

        // 线程切割代码
        int size=list.size();
        // 按每1000条记录处理
        int count=1000;
       // 线程数
        int num = (size) % count == 0 ? (size / count) : (size / count + 1);
        int start=0;
        int end  =0;


        List<CompletableFuture<List<String>>>  listThead=new ArrayList<>();
        for (int i = 1; i <=num ; i++) {
            start=(i-1)*count;
            end=(i*count)> size ? size :(i*count);
            int finalStart = start;
            int finalEnd = end;
            System.out.println(finalStart+"--"+finalEnd);
            // 创建线程处理
            listThead.add(CompletableFuture.supplyAsync(()-> list.subList(finalStart,finalEnd)));
        }

        List<String> newList = new ArrayList<String>();
        for (int i = 0; i <listThead.size() ; i++) {
                List<String> data= listThead.get(i).get();
                newList.addAll(data);
        }
        System.out.println("总数处理完："+newList.size());
        System.out.println("总数处理完："+newList.toString());
    }
}
