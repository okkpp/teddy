package okkpp.model;

import io.jboot.db.annotation.Table;
import okkpp.model.base.BaseUser;

/**
 * Generated by Jboot.
 */
@Table(tableName = "t_user", primaryKey = "id")
public class User extends BaseUser<User> {

	private static final long serialVersionUID = 1L;

	public static final String table = "t_user";

	
}
