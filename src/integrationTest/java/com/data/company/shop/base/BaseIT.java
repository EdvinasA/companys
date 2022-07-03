package com.data.company.shop.base;

import com.data.company.CompanyApplication;
import com.data.company.shop.utils.TestFileUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = {CompanyApplication.class, TestFileUtils.class,})
public class BaseIT {
}
