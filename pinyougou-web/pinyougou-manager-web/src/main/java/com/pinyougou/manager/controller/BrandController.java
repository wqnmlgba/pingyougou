package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 品牌控制器
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-09-17<p>
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference(timeout = 10000)
    private BrandService brandService;

    /** 查询全部品牌 */
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        System.out.println("brandService = " + brandService);
        return brandService.findAll();
    }
}
