package com.bkap.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PasswordResetToken.class)
public abstract class PasswordResetToken_ {

	public static volatile SingularAttribute<PasswordResetToken, Date> expiryDate;
	public static volatile SingularAttribute<PasswordResetToken, Long> id;
	public static volatile SingularAttribute<PasswordResetToken, Users> user;
	public static volatile SingularAttribute<PasswordResetToken, String> token;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String TOKEN = "token";

}

