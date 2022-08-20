package com.data.company.shop.base;

import com.data.company.CompanyApplication;
import com.data.company.shop.utils.TestFileUtils;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.RefreshMode;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = {
		CompanyApplication.class,
		TestFileUtils.class
})
@AutoConfigureEmbeddedDatabase(provider = DatabaseProvider.ZONKY, refresh = RefreshMode.AFTER_EACH_TEST_METHOD)
public class MvcTest {

	protected MockMvc mvc;

	@Autowired
	protected WebApplicationContext context;

	@Autowired
	protected TestFileUtils testFileUtils;

	@BeforeEach
	void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
	}

}
