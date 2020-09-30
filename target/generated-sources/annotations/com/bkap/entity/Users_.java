package com.bkap.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, Date> createdAt;
	public static volatile SingularAttribute<Users, String> password;
	public static volatile SingularAttribute<Users, String> address;
	public static volatile SingularAttribute<Users, String> phone;
	public static volatile ListAttribute<Users, Role> roles;
	public static volatile SingularAttribute<Users, String> fullName;
	public static volatile SingularAttribute<Users, Long> id;
	public static volatile SingularAttribute<Users, String> email;
	public static volatile SingularAttribute<Users, Boolean> enabled;
	public static volatile SingularAttribute<Users, String> username;
	public static volatile SingularAttribute<Users, Date> updatedAt;
	public static volatile SingularAttribute<Users, Integer> status;

	public static final String CREATED_AT = "createdAt";
	public static final String PASSWORD = "password";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String ROLES = "roles";
	public static final String FULL_NAME = "fullName";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String ENABLED = "enabled";
	public static final String USERNAME = "username";
	public static final String UPDATED_AT = "updatedAt";
	public static final String STATUS = "status";

}

