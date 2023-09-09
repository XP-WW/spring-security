package com.xp.json.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 12:22
 * @since 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResult {
    private Integer code;
    private String msg;
    private Object data;
    public HttpResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
