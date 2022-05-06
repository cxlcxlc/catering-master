package com.cxl.controller;

import com.cxl.entity.AddressBook;
import com.cxl.service.AddressBookService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<AddressBookService, AddressBook> {
}
