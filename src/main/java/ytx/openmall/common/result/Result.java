package ytx.openmall.common.result;

import lombok.Data;

import java.io.Serializable;


@Data
public class Result<T> implements Serializable {
    private Integer code;       //状态码 1成功，0失败
    private String message;     //信息
    private T data;             //返回数据


    public static <T> Result<T> success(){
        Result<T> result = new Result<T>();
        result.code=1;
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result=new Result<T>();
        result.code=1;
        result.data=data;
        return result;
    }

    public static <T> Result<T> error(String message){
        Result<T> result=new Result<T>();
        result.code=0;
        result.message=message;
        return result;
    }



}
