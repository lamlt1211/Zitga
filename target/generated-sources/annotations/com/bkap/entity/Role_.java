package com.bkap.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, Long> id;
	public static volatile ListAttribute<Role, Users> users;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USERS = "users";

}

