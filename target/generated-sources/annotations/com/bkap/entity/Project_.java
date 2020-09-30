package com.bkap.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Project.class)
public abstract class Project_ {

	public static volatile SingularAttribute<Project, Date> createdAt;
	public static volatile SingularAttribute<Project, Date> publish;
	public static volatile SingularAttribute<Project, String> name;
	public static volatile SingularAttribute<Project, String> description;
	public static volatile SingularAttribute<Project, Long> id;
	public static volatile SingularAttribute<Project, String> url;
	public static volatile SingularAttribute<Project, Date> updatedAt;
	public static volatile SingularAttribute<Project, Integer> status;

	public static final String CREATED_AT = "createdAt";
	public static final String PUBLISH = "publish";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String URL = "url";
	public static final String UPDATED_AT = "updatedAt";
	public static final String STATUS = "status";

}

