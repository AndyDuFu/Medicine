package com.medicine.util;

/**
 * 返回值
 * @param <T>
 */
public class JsonResult<T> {

    private final boolean success;

    private final T data;

    private final String error;

    private final Integer status;


    private JsonResult(JsonResultBuilder<T> builder) {
        this.success = builder.success;
        this.data = builder.data;
        this.error = builder.error;
        this.status = builder.status;
    }

    public static <T> JsonResult.JsonResultBuilder<T> builder(){
        return new JsonResultBuilder<>();
    }

    public Integer getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }

    public static final class JsonResultBuilder<T> {

        private boolean success;

        private T data;

        private String error;

        private Integer status = 200;

        private JsonResultBuilder() {

        }

        public JsonResultBuilder error(String error) {
            this.error = error;
            this.success = false;
            this.status = 500;
            return this;
        }

        public JsonResultBuilder error(String error, Integer status) {
            this.error = error;
            this.success = false;
            this.status = status;
            return this;
        }

        public JsonResultBuilder data(T data) {
            this.data = data;
            this.success = true;
            this.status = 200;
            return this;
        }

        public JsonResult build() {
            return new JsonResult<>(this);
        }
    }

    public static void main(String[] args) {
        System.out.print(JsonResult.<String>builder().data("asd").build().toString());
    }

}
