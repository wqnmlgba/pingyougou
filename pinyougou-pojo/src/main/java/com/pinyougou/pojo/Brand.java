package com.pinyougou.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 品牌实体类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-09-17<p>
 */
@Data
@Table(name="tb_brand")
public class Brand implements Serializable{
    /** 主键ID */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /** 品牌名称 */
    @Column(name="name")
    private String name;
    /** 品牌首字母 */
    @Column(name="first_char")
    private String firstChar;
}
