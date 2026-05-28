package com.itheima.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Object list;

    public static String success(String msg) {
        return msg;
    }

    public static Result success(Object list) {
        return new Result(list);
    }

    public static String error(String msg) {
        return msg;
    }
}