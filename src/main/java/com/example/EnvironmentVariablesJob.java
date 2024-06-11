package com.example;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class EnvironmentVariablesJob {
    public static void main(String[] args) throws Exception {
        // 创建执行环境
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 创建一个数据流，包含所有环境变量
        env.fromElements(System.getenv().entrySet().toArray(new java.util.Map.Entry[0]))
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .print();

        // 启动作业
        env.execute("Print Environment Variables Job");
    }
}
