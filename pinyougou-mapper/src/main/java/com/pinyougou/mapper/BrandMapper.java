package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * BrandMapper接口
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-09-17<p>
 */
public interface BrandMapper {

    @Select("select id,name,first_char from tb_brand")
    List<Brand> findAll();

}
