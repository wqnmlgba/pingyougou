package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 品牌服务接口实现类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-09-17<p>
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public List<Brand> findAll() {
        // 开始分页
        PageInfo<Brand> pageInfo = PageHelper.startPage(1, 5)
                .doSelectPageInfo(new ISelect() {
                    @Override
                    public void doSelect() {
                        brandMapper.selectAll();
                    }
                });
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        return pageInfo.getList();

    }

    @Override
    public void update(Brand brand){
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void save(Brand brand){
        brandMapper.insertSelective(brand);
    }

    @Override
    public PageResult findByPage(Brand brand, int page, int rows) {
        try {
            // 开始分页
            PageInfo<Brand> pageInfo = PageHelper.startPage(page, rows)
                    .doSelectPageInfo(new ISelect() {
                        @Override
                        public void doSelect() {
                            brandMapper.findAll(brand);
                        }
                    });
            return new PageResult(pageInfo.getPages(), pageInfo.getList());
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteAll(Serializable[] ids) {
        Example example=new Example(Brand.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids));
        brandMapper.deleteByExample(example);
    }


}
