package com.example.service.impl;

import com.example.controller.pojo.Emp;
import com.example.dao.EmpDao;
import com.example.dao.impl.EmpDaoA;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 杨帆
 */
@Component
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empdao ;
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empdao.listEmp();
        //2. 对数据进行处理
        empList.stream().forEach(emp -> {
            //处理 gender 1：男，2： 女
            String gender = emp.getGender();
            if ("1".equals(gender)){
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            String job = emp.getJob();
            if ("1".equals(job)){
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });

        return empList;
    }
}
