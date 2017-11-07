package com.lanou.service;

import com.lanou.dao.PersonDaoImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/24.
 */
@Service("personService")
public class PersonServiceImp {
    /**
     * Resource 按照名称去加载,默认不指定具体名称时按属性名收索
     * 如果使用Resource注解完成属性装载时建议不要指定name
     * 但是如果使用AutoWired建议和Qualifier提起搭配使用
     */
    @Resource(name = "personDao")
    private PersonDaoImpl personDao;
    public boolean login(String name,String psw){
        return personDao.login(name,psw);
    }
}
