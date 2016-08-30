package com.homefun.wpj.damain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Name：BaseDamain
 * Time：2016/8/25 9:01
 * author：WPJ587
 * description：
 **/
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
public class BaseDamain implements Serializable {
    private static final long serialVersionUID = 784470277529538627L;
}
