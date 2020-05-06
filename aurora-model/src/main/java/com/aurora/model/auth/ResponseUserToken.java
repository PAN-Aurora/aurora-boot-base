package com.aurora.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author PHQ
 * @create 2020-05-03 12:26
 **/
@Data
@AllArgsConstructor
public class ResponseUserToken {
    private String token;
    private User user;
}
