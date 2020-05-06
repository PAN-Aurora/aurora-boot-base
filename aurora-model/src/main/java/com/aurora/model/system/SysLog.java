package com.aurora.model.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 日志实体
 * @author PHQ
 * @create 2020-05-01 23:18
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_LOG")
public class SysLog implements Serializable {

      @TableId(value = "LOG_ID", type = IdType.AUTO)
      private int id;

      @TableField("LOG_USER")
      private String logUser;

      @TableField("LOG_ROLE")
      private String logRole;

        @TableField("LOG_MODULE")
        private String logModule;

        @TableField("LOG_METHOD")
        private String logMothod;

        @TableField("LOG_URL")
        private String logUrl;

        @TableField("LOG_IP")
        private String logIp;

        @TableField("LOG_DESC")
        private String logDesc;

        @TableField("LOG_CREATE_TIME")
        private Timestamp logCreateTime;

        @TableField("LOG_TYPE")
        private int logType;



}
