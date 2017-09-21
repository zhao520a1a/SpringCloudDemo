package com.example.demo.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询请求对象
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryVO {
    /**
     * 请求时间
     */
    private long requestTime;
    /**
     * 发起请求的用户
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 请求ID,与请求的用户组成复合唯一键
     */
    private String jobId;
    /**
     * 请求类型
     */
    private String requestType;
    /**
     * 要执行的sql
     */
    private String sql;
    /**
     * sql结果集存储的kafka topic
     */
    private String kafkaTopic;
    /**
     * sql转换类
     */
    private String sqlTransforClass;
}
