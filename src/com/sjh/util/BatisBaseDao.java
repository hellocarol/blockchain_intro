package com.sjh.util;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据库操作父�?
* @ClassName: BatisBaseDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author fjn
*
*
 */
public interface BatisBaseDao extends Serializable
{
    int addReturn(String sqlId, Object obj) throws Exception;
   
    /**
     * 添加对象
     * 
     * @param sqlId IBatis SQL Id
     * @param obj �?��添加的对�?
     * 
     * @throws AKSQLException SQL异常
     */
    Integer add(String sqlId, Object obj) throws Exception;
    
    int addGetId(String sqlId, Object obj) throws Exception;
    /**
     * 删除对象
     * 
     * @param sqlId IBatis SQL Id
     * @param params 删除参数
     * 
     * @throws AKSQLException SQL异常
     */
    Integer del(String sqlId, Object params) throws Exception;

    /**
     * 查询条件数据信息
     * 
     * @param sqlId IBatis SQL Id
     * @param params 查询参数
     * 
     * @throws AKSQLException SQL异常
     * 
     * @return List<Object> 查询结果集合
     */
    List<?> query(String sqlId, Object params) throws Exception;

    /**
     * 根据条件查询数据 (未实�?
     * 
     * @param sqlId IBatis SQL Id
     * @param params 查询参数
     * 
     * @throws AKSQLException SQL异常
     * 
     * @return List<Object> 查询结果集合
     */
    List<?> queryPagination(String sqlId, Object params) throws Exception;

    /**
     * 根据条件查询数据记录�?用于分页
     * 
     * @param sqlId IBatis SQL Id
     * @param params 查询参数
     * 
     * @throws AKSQLException SQL异常
     * 
     * @return List<Object> 查询结果集合
     */
    int queryCount(String sqlId, Object params) throws Exception;

    /**
     * 查询�?��记录
     * 
     * @param sqlId IBatis SQL Id
     * @param params 查询参数
     * 
     * @throws AKSQLException SQL异常
     * 
     * @return List<Object> 查询结果集合
     */
    Object queryOneModel(String sqlId, Object params) throws Exception;

    /**
     * 查询�?��数据 (未实�?
     * 
     * @param sqlId IBatis SQL Id
     * @param params 查询参数
     * 
     * @throws AKSQLException SQL异常
     * 
     * @return List<Object> 查询结果集合
     */
    List<?> queryAll(String sqlId) throws Exception;

    /**
     * 更新对象
     * 
     * @param sqlId IBatis SQL Id
     * @param updateObj �?��更新的对�?
     * 
     * @throws AKSQLException SQL异常
     */
    Integer upd(String sqlId, Object updateObj) throws Exception;
    
    void beginTrans() throws SQLException;

    void endTrans() throws SQLException;

    void commitTrans() throws SQLException;
    void rollBack() throws SQLException;
}
