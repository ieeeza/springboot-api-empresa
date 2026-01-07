package com.apispring.demo.dtos.response;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse<T> {
  
  private T data;
  private String message;
  private boolean success;
  private Integer httpCode;
  private OffsetDateTime resTimeStamp;

  public static <T> ServiceResponse<T> success(T data, String message, int httpCode) {
    ServiceResponse<T> res = new ServiceResponse<>();
    res.setData(data);
    res.setMessage(message);
    res.setSuccess(true);
    res.setHttpCode(httpCode);
    res.setResTimeStamp(OffsetDateTime.now());
    return res;
  }

  public static <T> ServiceResponse<T> error(String message, int httpCode) {
    ServiceResponse<T> res = new ServiceResponse<>();
    res.setMessage(message);
    res.setSuccess(false);
    res.setHttpCode(httpCode);
    res.setResTimeStamp(OffsetDateTime.now());
    return res;
  }
}