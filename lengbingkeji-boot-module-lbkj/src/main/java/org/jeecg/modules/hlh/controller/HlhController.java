package org.jeecg.modules.hlh.controller;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lengbing
 * @CreateDate: 2022-09-14 11:27
 * @Description: org.jeecg.modules.hlh.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("lbkj/hlh/hwz")
@Slf4j
public class HlhController {
    @GetMapping(value = "/hlhtohwz")
    public Result<String> hlhtohwz(){
        Result<String> result = new Result<String>();
        result.setResult("Hlh To Hwz");
        result.setSuccess(true);
        return result;
    }
}
