package com.jroslav.app.converter;

public interface Converter {
    // FIXME: 13.03.2024 выглядит, будто этот интерфейс здесь избыточен
	
    String convert(String value)throws RuntimeException;
}
