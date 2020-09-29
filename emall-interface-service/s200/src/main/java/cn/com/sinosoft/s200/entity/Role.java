package cn.com.sinosoft.s200.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/9/28 17:38
 * @Version 1.0
 */

@TableName(value="role")
public class Role {

    @TableId
    private String roleId;

    private String name;

    private String note;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
