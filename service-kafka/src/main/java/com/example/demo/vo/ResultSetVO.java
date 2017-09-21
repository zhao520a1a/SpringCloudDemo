package com.example.demo.vo;


import lombok.*;

/**
 * 向kafka里发送的数据对象
 */
@ToString
@Builder(builderMethodName = "buildResultSetVO")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ResultSetVO extends ResponseVO {
    /**
     * 请求时间
     */
    private long requestTime;
    /**
     * 发起请求的用户
     */
    private String username;
    /**
     * 请求ID,与请求用户组成复合唯一键
     */
    private String jobId;
    /**
     * 请求类型
     */
    private String requestType;
    /**
     * 批量向kafka推送结果集的结束表示
     */
    private boolean finished = false;
    /**
     * 一个jobId查询到的数据批量发送到kafka的批次号,开始批次为1,顺序递增
     */
    private int batchNum;
}
