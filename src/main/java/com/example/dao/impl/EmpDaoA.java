package com.example.dao.impl;

import com.example.controller.pojo.Emp;
import com.example.dao.EmpDao;
import com.example.util.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 杨帆
 */
@Component
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
