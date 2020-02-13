package com.johnny.jshop.provider.service;

import com.johnny.jshop.provider.domain.UmsAdmin;
import javax.annotation.Resource;
import com.johnny.jshop.provider.mapper.UmsAdminMapper;
import com.johnny.jshop.provider.api.UmsAdminService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * 用户管理服务
 * <p>
 * Description:
 * </p>
 *
 * @class UmsAdminServiceImpl
 * @author JohnnyHao
 * @date 2020-02-11
 */
@Service(version = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService{

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 新增用户
     * @Param umsAdmin:
     * @return: int
     * @author: JohnnyHao
     * @date: 2020-02-12
     */
    @Override
    public int insert(UmsAdmin umsAdmin) {
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    /**
     * 获取用户
     * @Param username:
     * @return: com.johnny.jshop.provider.domain.UmsAdmin
     * @author: JohnnyHao
     * @date: 2020-02-12
     */
    @Override
    public UmsAdmin get(String username) {
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username", username);
        return umsAdminMapper.selectOneByExample(example);
    }

    /**
     * 获取用户
     * @Param umsAdmin:
     * @return: com.johnny.jshop.provider.domain.UmsAdmin
     * @author: JohnnyHao
     * @date: 2020-02-12
     */
    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    @Override
    public int update(UmsAdmin umsAdmin) {
        // 获取原始用户信息
        UmsAdmin oldAdmin = get(umsAdmin.getUsername());

        // 仅更新 邮箱、昵称、备注、状态
        oldAdmin.setEmail(umsAdmin.getEmail());
        oldAdmin.setNickName(umsAdmin.getNickName());
        oldAdmin.setNote(umsAdmin.getNote());
        oldAdmin.setStatus(umsAdmin.getStatus());

        return umsAdminMapper.updateByPrimaryKey(oldAdmin);
    }

    /**
     * 初始化用户对象
     * @Param umsAdmin:
     * @return: void
     * @author: JohnnyHao
     * @date: 2020-02-12
     */
    private void initUmsAdmin(UmsAdmin umsAdmin) {
        // 初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());

        // 初始化状态
        if (umsAdmin.getStatus() == null) {
            umsAdmin.setStatus(0);
        }

        // 密码加密
        umsAdmin.setPassword(bCryptPasswordEncoder.encode(umsAdmin.getPassword()));
    }
}
