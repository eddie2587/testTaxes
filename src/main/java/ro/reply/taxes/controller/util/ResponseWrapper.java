package ro.reply.taxes.controller.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonInclude(Include.NON_NULL)
public class ResponseWrapper<T> {

	@JsonProperty(value = "success", required = true)
	private Boolean success;

	@JsonProperty(value = "data", required = true)
	private T data;

	@JsonCreator
	public ResponseWrapper() {
	}

	public ResponseWrapper(Boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static class ErrorWrapper extends ResponseWrapper<String> {

		public ErrorWrapper() {
			this.setSuccess(false);
		}

		public ErrorWrapper(@JsonProperty("data") String data) {
			this.setSuccess(false);
			this.setData(data);
		}
	}

	public static class ErrorMessagesWrapper extends ResponseWrapper<List<String>> {

		public ErrorMessagesWrapper() {
			this.setSuccess(false);
			this.setData(new ArrayList<String>());
		}

		public void addMessage(String message) {
			getData().add(message);
		}

	}
}
