package neu.his.temp;

import neu.his.bean.User;
import neu.his.service.UserService;
import neu.his.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class test7 {
    private final Logger LOGGER = Logger.getLogger(test7.class);

    /**
     * apache-log4j 日志输出
     */
    @Test
    public void testLog4j(){
        LOGGER.info("普通信息");
        LOGGER.error("普通错误");
        LOGGER.trace("堆栈信息");
        LOGGER.fatal("致命错误");
        LOGGER.warn("警告信息");
        LOGGER.debug("调试信息");
    }

}
