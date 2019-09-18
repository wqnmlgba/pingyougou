package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

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



    /** 多条件分页查询品牌 */
    @GetMapping("/findByPage")
    public PageResult findByPage(Brand brand, Integer page,
                                 @RequestParam(defaultValue = "10")Integer rows){
        /** GET请求中文转码 */
        if (StringUtils.isNoneBlank(brand.getName())) {
            try {
                brand.setName(new String(brand.getName()
                        .getBytes("ISO8859-1"), "UTF-8"));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return brandService.findByPage(brand, page, rows);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Brand brand){
              try{
                  brandService.save(brand);
                  return  true;
              }catch(Exception ex){
                  ex.printStackTrace();
              }

              return false;
    }
    @PostMapping("/update")
    public boolean update(@RequestBody Brand brand){
        try{
            brandService.update(brand);
            return  true;
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    @GetMapping("/delete")
    public boolean delete(Long[] ids){
          try{
              brandService.deleteAll(ids);
              return true;
          }catch (Exception ex){
              ex.printStackTrace();
          }
          return false;
    }





}
