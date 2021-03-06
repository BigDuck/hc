/*
 * ©2016 wupjhy.cn.  All rights reserved.
 */

package com.homefun.wpj.db;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
