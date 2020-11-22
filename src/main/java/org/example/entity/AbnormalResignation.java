package org.example.entity;

import java.util.Date;

public class AbnormalResignation {
    private  Integer id;
    private Integer empId;
    private Date resignData;
    private String reason;
    // private Integer status;
    private Integer createBy;
    private Date createTime;
    private Integer updateBy;
    private Date updateTime;

    // 代表当前登记离职异常的属于哪个员工
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getResignData() {
        return resignData;
    }

    public void setResignData(Date resignData) {
        this.resignData = resignData;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AbnormalResignation{" +
                "id=" + id +
                ", empId=" + empId +
                ", resignData=" + resignData +
                ", reason='" + reason + '\'' +
                // ", status=" + status +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", employee=" + employee +
                '}';
    }
}



