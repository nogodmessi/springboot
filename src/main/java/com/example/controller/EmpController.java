package com.example.controller;

import com.example.controller.pojo.Emp;
import com.example.controller.pojo.Result;
import com.example.service.EmpService;
import com.example.service.impl.EmpServiceA;
import com.example.util.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 杨帆
 */

@RestController
public class EmpController {
    @Autowired //运行时，IOC容器会提供该类型的bean对象，并赋值给该变量 - 依赖注入
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> empList = empService.listEmp();


        //3. 响应数据
        return Result.success(empList);
    }
}
