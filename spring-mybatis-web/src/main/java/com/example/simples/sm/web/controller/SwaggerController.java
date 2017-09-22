/**
 * Copyright (C), 2017-2017, 帮5采
 * FileName: SwaggerController
 * Author:   tianyi
 * Date:     2017/9/22 18:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.simples.sm.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author tianyi
 * @create 2017/9/22
 * @since 1.0.0
 */
@Controller("/rest")
public class SwaggerController {

    @ApiOperation(value = "教程", httpMethod = "GET", notes = "教程")
    @RequestMapping(value = "/swagger", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String swagger(@ApiParam(required = false, name = "test", value = "教程入参") String test) {
        return "test";
    }

}