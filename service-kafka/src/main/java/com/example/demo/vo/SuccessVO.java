package com.example.demo.vo;


import lombok.*;

/**
 * 操作成功与否对象
 * <br>创建者： 刘江平
 * 创建时间：2016年6月27日下午3:56:17
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class SuccessVO {
    /**
     * 操作是否成功!true成功；flase失败
     */
    protected boolean success;
    /**
     * 成功信息或者失败信息
     */
    protected String msg;
}
