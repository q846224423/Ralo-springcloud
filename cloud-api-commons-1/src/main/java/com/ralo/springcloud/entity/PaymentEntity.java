package com.ralo.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Ralo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity implements Serializable {
    private long id;
    private String serial;

}
