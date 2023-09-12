package com.corporation.tax.myapp.dao;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdentityCompany implements Serializable {

  /** */
  private static final long serialVersionUID = -5741578490885618124L;

  private int siret;
}
