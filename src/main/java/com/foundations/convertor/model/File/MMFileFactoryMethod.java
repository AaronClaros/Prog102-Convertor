/*
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 * This class is the father to create the MMFile
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
package com.foundations.convertor.model.File;
import com.foundations.convertor.common.Criteria;

public interface MMFileFactoryMethod {

  /**
   * The method factory of MMFile
   * @param criteria the key to search
   * @return new object type MMFile
   */
  public MMFile createMMFile(Criteria criteria);
}
