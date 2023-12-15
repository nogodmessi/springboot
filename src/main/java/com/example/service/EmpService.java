package com.example.service;

import com.example.controller.pojo.Emp;

import java.util.List;

/**
 * @author 杨帆
 */
public interface EmpService {
    //获取员工列表数据
    public List<Emp> listEmp();
}
