package com.krsto.pathfinder;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;
import com.krsto.pathfinder.model.CharacterClassFactory.CharacterClassEnum;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToCharacterClassConverter());
	}
	
	
	public class StringToCharacterClassConverter implements Converter<String, CharacterClassEnum> {
	    @Override
	    public CharacterClassEnum convert(String source) {
	        return CharacterClassEnum.valueOf(source.toUpperCase());
	    }
	}
	
	public class StringToAbilityConverter implements Converter<String, AbilityEnum> {
	    @Override
	    public AbilityEnum convert(String source) {
	        return AbilityEnum.valueOf(source.toUpperCase());
	    }
	}
}
