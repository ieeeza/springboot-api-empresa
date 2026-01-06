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

  public ServiceResponse() {
    this.resTimeStamp = OffsetDateTime.now();
  }

  public static <T> ServiceResponse<T> success(T data, String message, int httpCode) {
    ServiceResponse<T> res = new ServiceResponse<>();
    res.setSuccess(true);
    res.setData(data);
    res.setMessage(message);
    res.setHttpCode(httpCode);
    return res;
  }

  public static <T> ServiceResponse<T> error(String message, int httpCode) {
    ServiceResponse<T> res = new ServiceResponse<>();
    res.setSuccess(false);
    res.setMessage(message);
    res.setHttpCode(httpCode);
    return res;
  }
}