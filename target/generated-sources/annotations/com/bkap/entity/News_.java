package com.bkap.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(News.class)
public abstract class News_ {

	public static volatile SingularAttribute<News, String> image;
	public static volatile SingularAttribute<News, Date> createdAt;
	public static volatile SingularAttribute<News, String> name;
	public static volatile SingularAttribute<News, Long> id;
	public static volatile SingularAttribute<News, String> shortDescription;
	public static volatile SingularAttribute<News, Category> category;
	public static volatile SingularAttribute<News, String> content;
	public static volatile SingularAttribute<News, Date> updatedAt;
	public static volatile SingularAttribute<News, Integer> status;

	public static final String IMAGE = "image";
	public static final String CREATED_AT = "createdAt";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SHORT_DESCRIPTION = "shortDescription";
	public static final String CATEGORY = "category";
	public static final String CONTENT = "content";
	public static final String UPDATED_AT = "updatedAt";
	public static final String STATUS = "status";

}

