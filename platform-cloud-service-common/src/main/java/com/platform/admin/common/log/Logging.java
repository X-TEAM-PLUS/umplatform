package com.platform.admin.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xinleisong on 2018/1/6.
 */
public class Logging {
    private Logger logger_;

    /**
     * 获取 类名
     *
     * @return
     */
    protected String getLogName() {
        return getClass().getName();
    }

    /**
     * 获取 Logger
     *
     * @return
     */
    protected Logger getLogger() {
        if (logger_ == null) {
            logger_ = LoggerFactory.getLogger(getLogName());
        }
        return logger_;
    }

    /**
     * 是否打开TRACE模式
     *
     * @return
     */
    protected boolean isTraceEnabled() {
        return logger_.isTraceEnabled();
    }

    /**
     * 是否打开DEBUG模式
     *
     * @return
     */
    protected boolean isDebugEnabled() {
        return logger_.isTraceEnabled();
    }


    /**
     * 打印 Debug 日志
     *
     * @param msg
     */
    protected void logDebug(String msg) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(msg);
        }
    }

    /**
     * 打印 Debug 日志
     *
     * @param msg
     * @param throwable
     */
    protected void logDebug(String msg, Throwable throwable) {
        if (getLogger().isDebugEnabled()) {
            getLogger().debug(msg, throwable);
        }
    }

    /**
     * 打印 Trace 日志
     *
     * @param msg
     */
    protected void logTrace(String msg) {
        if (getLogger().isTraceEnabled()) {
            getLogger().trace(msg);
        }
    }

    /**
     * 打印 Trace 日志
     *
     * @param msg
     * @param throwable
     */
    protected void logTrace(String msg, Throwable throwable) {
        if (getLogger().isTraceEnabled()) {
            getLogger().trace(msg, throwable);
        }
    }


    /**
     * 打印 info日志
     *
     * @param msg
     */
    protected void logInfo(String msg) {
        if (getLogger().isInfoEnabled()) {
            getLogger().info(msg);
        }
    }

    /**
     * 打印 info日志
     *
     * @param msg
     * @param throwable
     */
    protected void logInfo(String msg, Throwable throwable) {
        if (getLogger().isInfoEnabled()) {
            getLogger().info(msg, throwable);
        }
    }


    /**
     * 打印 warning日志
     *
     * @param msg
     */
    protected void logWarning(String msg) {
        if (getLogger().isWarnEnabled()) {
            getLogger().warn(msg);
        }
    }

    /**
     * 打印 warning日志
     *
     * @param msg
     * @param throwable
     */
    protected void logWarning(String msg, Throwable throwable) {
        if (getLogger().isWarnEnabled()) {
            getLogger().warn(msg, throwable);
        }
    }

    /**
     * 打印 Error日志
     *
     * @param msg
     */
    protected void logError(String msg) {
        if (getLogger().isErrorEnabled()) {
            getLogger().error(msg);
        }
    }

    /**
     * 打印 Error日志
     *
     * @param msg
     * @param throwable
     */
    protected void logError(String msg, Throwable throwable) {
        if (getLogger().isErrorEnabled()) {
            getLogger().error(msg, throwable);
        }
    }
}
