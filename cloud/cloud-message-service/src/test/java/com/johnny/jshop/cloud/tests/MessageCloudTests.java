package com.johnny.jshop.cloud.tests;
import java.util.Date;

import com.johnny.jshop.cloud.feign.dto.UmsAdminLoginLogDTO;
import com.johnny.jshop.commons.utils.MapperUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageCloudTests {

    @Test
    public void testPrintln() throws Exception {
        UmsAdminLoginLogDTO dto = new UmsAdminLoginLogDTO();
        dto.setAdminId(1L);
        dto.setCreateTime(new Date());
        dto.setIp("0.0.0.0");
        dto.setAddress("0.0.0.0");
        dto.setUserAgent("0.0.0.0");
        System.out.println(MapperUtils.obj2json(dto));
    }

}
