package com.tkgroupbd.pusti.api;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import com.tkgroupbd.pusti.api.data.repositories.salesOrder.SalesOrderDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PustiApiApplicationTests {
	@Autowired
	private SalesOrderDetailsRepository salesOrderDetailsRepository;
	@Test
	void contextLoads() {
		String a="";
		while (a.length() !=2)
			a+="a";
		System.out.println(a);




	}


}
