package xx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.service.xx.WareHouseService;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:spring.xml")
public class TestController {
	
	@Resource 
	private WareHouseService whs;
	@Test 
	@Transactional
	@Rollback
	public void testSelectAllWare(){
		System.out.println(whs.SelectAllWare());
	}
}
