package com.itheima.console.controller;

import com.itheima.common.Result;
import com.itheima.entity.Star;
import com.itheima.service.StarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/stars")
public class StarController {

    @Autowired
    private StarService starService;

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        log.info("删除的ID为：{}", id);
        Boolean flag = starService.deleteById(id);
        return flag ? Result.success("删除成功") : Result.error("删除失败");
    }

    @PostMapping
    public String insert(@RequestBody Star star) {
        log.info("添加的球星信息为：{}", star);
        Boolean flag = starService.insert(star);
        return flag ? Result.success("添加成功") : Result.error("添加失败");
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id,@RequestBody Star star) {
        log.info("修改的球星信息为：{}", star);
        star.setId(id);
        Boolean flag = starService.update(star);
        return flag ? Result.success("修改成功") : Result.error("修改失败");
    }
}