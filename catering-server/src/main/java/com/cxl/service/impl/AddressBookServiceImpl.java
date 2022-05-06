package com.cxl.service.impl;

import com.cxl.dao.AddressBookDao;
import com.cxl.entity.AddressBook;
import com.cxl.service.AddressBookService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressBookServiceImpl extends BaseServiceImpl<AddressBookDao,AddressBook> implements AddressBookService {
}
