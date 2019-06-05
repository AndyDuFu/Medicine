package com.medicine.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

@SuppressWarnings("deprecation")
@Configuration
public class JsonConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
	    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	    ObjectMapper objectMapper = new ObjectMapper();

	    // 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
	    // Include.Include.ALWAYS 默认
	    // Include.NON_DEFAULT 属性为默认值不序列化
	    // Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
	    // Include.NON_NULL 属性为NULL 不序列化
	    //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

	    // 字段保留，将null值转为""
	    objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
	        @Override
	        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
	            jsonGenerator.writeString("");
	        }
	    });
	    mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
	    //设置中文编码格式
	    List<MediaType> list = new ArrayList<>();
	    list.add(MediaType.APPLICATION_JSON_UTF8);
	    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
	    return mappingJackson2HttpMessageConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    converters.add(getMappingJackson2HttpMessageConverter());
	}
}
