package com.pinyougou.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌实体类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-09-17<p>
 */
@Data
public class Brand implements Serializable{

    private Long id;
    private String name;
    private String firstChar;

}
