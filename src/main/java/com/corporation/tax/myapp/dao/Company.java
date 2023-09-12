package com.corporation.tax.myapp.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Company", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(IdentityCompany.class)
public class Company implements Serializable {

  /** */
  private static final long serialVersionUID = 2036691114437930947L;

  @Id private int siret;
  private String designation;

  @Column(name = "HQaddress")
  private String hqadress;

  private int type;
  private int totalvalue;

  private double tax;
  
  private String currency;
}
