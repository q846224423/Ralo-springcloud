package com.ralo.springcloud.service.impl;

import com.ralo.springcloud.dao.PaymentDao;
import com.ralo.springcloud.entity.PaymentEntity;
import com.ralo.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: com.ralo.springcloud.service.impl
 * @author: Ralo
 * @DATE: 2020/7/21
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    /**
     *insert
     * */
    @Override
    public int insert(PaymentEntity paymentEntity){
        return paymentDao.insert(paymentEntity);
    }

    /**
     * getid
     * */
    @Override
    public PaymentEntity getId(Long id){

        return paymentDao.getId(id);
    }

}
