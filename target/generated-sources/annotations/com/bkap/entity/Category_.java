package com.bkap.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile ListAttribute<Category, News> news;
	public static volatile SingularAttribute<Category, Date> createdAt;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile SingularAttribute<Category, String> description;
	public static volatile SingularAttribute<Category, Long> id;
	public static volatile SingularAttribute<Category, Date> updatedAt;
	public static volatile SingularAttribute<Category, Integer> status;

	public static final String NEWS = "news";
	public static final String CREATED_AT = "createdAt";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String UPDATED_AT = "updatedAt";
	public static final String STATUS = "status";

}

