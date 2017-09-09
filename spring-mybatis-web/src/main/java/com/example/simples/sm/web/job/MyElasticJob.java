package com.example.simples.sm.web.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                System.err.println("0");
                break;
            case 1:
                // do something by sharding item 1
                System.err.println("1");
                break;
            case 2:
                // do something by sharding item 2
                System.err.println("2");
                break;
            // case n: ...
        }
    }
}
