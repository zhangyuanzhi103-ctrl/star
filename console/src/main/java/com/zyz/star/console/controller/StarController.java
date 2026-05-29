package com.zyz.star.console.controller;




import com.zyz.star.module.entity.Star;
import com.zyz.star.module.service.StarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/star")
public class StarController {

    @Autowired
    private StarService starService;

    @DeleteMapping
    public String deleteById(@RequestParam Integer id) {
        log.info("删除的ID为：{}", id);
        Boolean flag = starService.deleteById(id);
        return flag ? "删除成功" : "删除失败";
    }

    @PostMapping
    public String insert(@RequestBody Star star) {
        log.info("添加的球星信息为：{}", star);
        Boolean flag = starService.insert(star);
        return flag ? "添加成功" : "添加失败";
    }

    @PutMapping
    public String update(@RequestBody Star star) {
        log.info("修改的球星信息为：{}", star);
        Boolean flag = starService.update(star);
        return flag ? "修改成功" : "修改失败";
    }
}