package com.johnny.jshop.business.feign;

import com.johnny.jshop.business.dto.params.IconParam;
import com.johnny.jshop.business.dto.params.PasswordParam;
import com.johnny.jshop.business.dto.params.ProfileParam;
import com.johnny.jshop.business.feign.fallback.ProfileFeignFallback;
import com.johnny.jshop.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 个人信息管理Feign接口
 * <p>
 * Description:
 * </p>
 *
 * @class ProfileFeign
 * @author JohnnyHao
 * @date 2020-02-13
 */
@FeignClient(value = "business-profile", path = "profile", configuration = FeignRequestConfiguration.class, fallback = ProfileFeignFallback.class)
public interface ProfileFeign {

    @GetMapping(value = "/info/{username}")
    String info(@PathVariable String username);

    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

    @PostMapping(value = "modify/password")
    String modifyPassword(@RequestBody PasswordParam passwordParam);

    @PostMapping(value = "modify/icon")
    String modifyIcon(@RequestBody IconParam iconParam);

}
