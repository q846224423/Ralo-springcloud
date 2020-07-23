package com.ralo.springcloud.dao;

import com.ralo.springcloud.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @PACKAGE_NAME: com.ralo.springcloud.dao
 * @author: Ralo
 * @DATE: 2020/7/21
 */
/**
 * 测试
 * */
@Mapper
public interface PaymentDao {
    /**
     *insert
     * */
    int insert(PaymentEntity paymentEntity);

    /**
     * getid
     * */
    PaymentEntity getId(@Param("id") Long id);


}
