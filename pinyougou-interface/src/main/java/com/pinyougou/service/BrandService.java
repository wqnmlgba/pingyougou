package com.pinyougou.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;

import java.io.Serializable;
import java.util.List;

/**
 * BrandService接口
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-09-17<p>
 */
public interface BrandService {
    List<Brand> findAll();

    void update(Brand brand);

    void save(Brand brand);

    PageResult findByPage(Brand brand, int page, int rows);

    void deleteAll(Serializable[] ids);
}
