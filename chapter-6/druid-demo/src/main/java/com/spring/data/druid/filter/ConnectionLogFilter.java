package soft.spring.data.druiddemo;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @author : zhayh
 * @date : 2020-2-8 09:25
 * @description : 定制Druid Filter
 */

@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {
    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("Before Connection!");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("After Connection");
    }
}
