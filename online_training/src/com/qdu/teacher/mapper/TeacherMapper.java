package com.qdu.teacher.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qdu.teacher.bean.Teacher;
import com.qdu.teacher.bean.TeacherExample;

public interface TeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int countByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int deleteByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int deleteByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int insert(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int insertSelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    List<Teacher> selectByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    Teacher selectByPrimaryKey(String tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated Tue Nov 28 21:50:35 CST 2017
     */
    int updateByPrimaryKey(Teacher record);
}