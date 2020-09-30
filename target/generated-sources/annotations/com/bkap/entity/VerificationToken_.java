package com.bkap.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VerificationToken.class)
public abstract class VerificationToken_ {

	public static volatile SingularAttribute<VerificationToken, Date> expiryDate;
	public static volatile SingularAttribute<VerificationToken, Long> id;
	public static volatile SingularAttribute<VerificationToken, Users> user;
	public static volatile SingularAttribute<VerificationToken, String> token;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String TOKEN = "token";

}

