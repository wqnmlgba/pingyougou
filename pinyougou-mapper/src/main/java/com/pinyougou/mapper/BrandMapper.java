package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * BrandMapper接口
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-09-17<p>
 */
public interface BrandMapper extends Mapper<Brand> {
    List<Brand>findAll(Brand brand);
}
