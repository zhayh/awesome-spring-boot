package com.spring.order.repository;

import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author : zhayh
 * @Date : 2020-4-3 13:54
 * @Description:
 */
public interface OrderDao {
    List<Order> selectAll();
}
