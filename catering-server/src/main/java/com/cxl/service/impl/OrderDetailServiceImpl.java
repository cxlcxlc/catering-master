package com.cxl.service.impl;

import com.cxl.dao.OrderDetailDao;
import com.cxl.entity.OrderDetail;
import com.cxl.service.OrderDetailService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetailDao, OrderDetail> implements OrderDetailService {
}
