package com.qdu.student.bean;

public class Student {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sid
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    private String sid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sname
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    private String sname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.spassword
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    private String spassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.csid
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    private String csid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sid
     *
     * @return the value of student.sid
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public String getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sid
     *
     * @param sid the value for student.sid
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sname
     *
     * @return the value of student.sname
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public String getSname() {
        return sname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sname
     *
     * @param sname the value for student.sname
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.spassword
     *
     * @return the value of student.spassword
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public String getSpassword() {
        return spassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.spassword
     *
     * @param spassword the value for student.spassword
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public void setSpassword(String spassword) {
        this.spassword = spassword == null ? null : spassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.csid
     *
     * @return the value of student.csid
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public String getCsid() {
        return csid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.csid
     *
     * @param csid the value for student.csid
     *
     * @mbggenerated Tue Nov 28 22:09:34 CST 2017
     */
    public void setCsid(String csid) {
        this.csid = csid == null ? null : csid.trim();
    }
}