package okkpp.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUserRole<M extends BaseUserRole<M>> extends JbootModel<M> implements IBean {

    public static final String ACTION_ADD = "UserRole:add";
    public static final String ACTION_DELETE = "UserRole:delete";
    public static final String ACTION_UPDATE = "UserRole:update";


    @Override
    public String addAction() {
        return ACTION_ADD;
    }

    @Override
    public String deleteAction() {
        return ACTION_DELETE;
    }

    @Override
    public String updateAction() {
        return ACTION_UPDATE;
    }


	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	public void setUserId(java.lang.Long userId) {
		set("user_id", userId);
	}
	
	public java.lang.Long getUserId() {
		return getLong("user_id");
	}

	public void setRoleId(java.lang.Long roleId) {
		set("role_id", roleId);
	}
	
	public java.lang.Long getRoleId() {
		return getLong("role_id");
	}

	public void setCreated(java.util.Date created) {
		set("created", created);
	}
	
	public java.util.Date getCreated() {
		return get("created");
	}

	public void setEnable(java.lang.Integer enable) {
		set("enable", enable);
	}
	
	public java.lang.Integer getEnable() {
		return getInt("enable");
	}

}