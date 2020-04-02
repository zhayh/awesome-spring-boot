package soft.spring.data.declarativetransactiondemo;

import java.sql.SQLTransactionRollbackException;

/**
 * @author : zhayh
 * @Date : 2020-2-8 14:56
 * @Description: Foo的service接口
 */
public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
}
