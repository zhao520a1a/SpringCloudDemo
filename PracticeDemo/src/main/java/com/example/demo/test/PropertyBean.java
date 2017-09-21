package com.example.demo.test;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author 赵金鑫
 * @date 2017年09月20日
 */

@Component
@Data
public class PropertyBean {
    private String url;
    private String userName;
}
