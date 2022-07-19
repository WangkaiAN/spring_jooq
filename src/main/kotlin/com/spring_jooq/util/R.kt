package com.spring_jooq.util;

import java.io.Serializable


/**
 * 全局统一返回结果类
 */


class R<T> : Serializable {
    private var code = 0
    private var msg: String? = null
    private var data: T? = null
    override fun toString(): String {
        val var10000 = getCode()
        return "R(code=" + var10000 + ", msg=" + getMsg() + ", data=" + getData() + ")"
    }

    constructor() {}
    constructor(code: Int, msg: String?, data: T) {
        this.code = code
        this.msg = msg
        this.data = data
    }

    fun getCode(): Int {
        return this.code
    }

    fun setCode(code: Int): R<T> {
        this.code = code
        return this
    }

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String?): R<T> {
        this.msg = msg
        return this
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T): R<T> {
        this.data = data
        return this
    }

    companion object {
        private const val serialVersionUID = 1L

        fun <T> ok(data: T): R<T?> {
            return restResult(data, 200, null as String?)
        }

        fun <T> ok(data: T, msg: String?): R<T?> {
            return restResult(data, 200, msg)
        }

        fun <T> failed(data: T): R<T?> {
            return restResult(data, 400, null as String?)
        }

        fun <T> failed(data: T, msg: String?): R<T?> {
            return restResult(data, 400, msg)
        }


        private fun <T> restResult(data: T, code: Int, msg: String?): R<T?> {
            val apiResult: R<T?> = R<T?>()
            apiResult.setCode(code)
            apiResult.setData(data)
            apiResult.setMsg(msg)
            return apiResult
        }
    }
}