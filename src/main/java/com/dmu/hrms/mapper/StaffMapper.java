package com.dmu.hrms.mapper;

import com.dmu.hrms.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    Staff selectByPrimaryKey(Integer id);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);

    List<Staff> selectByDept(Integer deptId);

    List<Staff> selectByPost(Integer postId);

    List<Staff> selectByStatus(String status);
    Staff selectBySname(String sname);

    void updateStatus(@Param("id") Integer id, @Param("param") String param);


}