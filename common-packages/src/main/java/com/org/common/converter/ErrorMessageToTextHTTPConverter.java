package com.org.common.converter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.StreamUtils;

import com.org.common.exception.dto.ErrorMessage;

public class ErrorMessageToTextHTTPConverter extends AbstractHttpMessageConverter<ErrorMessage> {
	
	public static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

	
	public ErrorMessageToTextHTTPConverter() {
//    super(MediaType.TEXT_PLAIN);
    super(DEFAULT_CHARSET, MediaType.TEXT_PLAIN);
  }

	
	@Override
	public boolean supports(Class<?> clazz) {
		return ErrorMessage.class == clazz;
	}


	@Override
	protected ErrorMessage readInternal(Class<? extends ErrorMessage> clazz, HttpInputMessage inputMessage) throws IOException {
		return new ErrorMessage();
	}

	@Override
	protected void writeInternal(ErrorMessage errorMsg, HttpOutputMessage outputMessage) throws IOException {

		Charset charset = getContentTypeCharset(outputMessage.getHeaders().getContentType());
		StreamUtils.copy(errorMsg.toString(), charset, outputMessage.getBody());
	}
	
	private Charset getContentTypeCharset(MediaType contentType) {
		if (contentType != null && contentType.getCharset() != null) {
			return contentType.getCharset();
		}
		else {
			return getDefaultCharset();
		}
	}
}