package com.ychs.lawfirmsys;

import cn.hutool.core.lang.Validator;
import cn.hutool.extra.pinyin.PinyinUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LawFirmSysApplicationTests {

    // 拼音全拼
    @Test
    void contextLoads() {
        System.out.println(PinyinUtil.getPinyin("李晓亚","")); // lixiaoya
        System.out.println(PinyinUtil.getPinyin("李晓亚")); // li xiao ya
    }

    // 手机号验证
    @Test
    void checkMobile(){
        System.out.println(Validator.isMobile("18102351542"));
        System.out.println(Validator.isMobile("03513558953"));
    }
}
