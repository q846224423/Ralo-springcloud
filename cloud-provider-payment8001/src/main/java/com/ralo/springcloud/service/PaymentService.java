package com.ralo.springcloud.service;

import com.ralo.springcloud.entity.PaymentEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @PACKAGE_NAME: com.ralo.springcloud.service
 * @NAME: PaymentService
 * @USER: Ralo
 * @DATE: 2020/7/21
 */
public interface PaymentService {
    /**
     *insert
     * */
    int insert(PaymentEntity paymentEntity);

    /**
     * getid
     * */
    PaymentEntity getId(@Param("id") Long id);
}
