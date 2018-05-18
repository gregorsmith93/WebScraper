package com.webscraper.service;

import org.springframework.stereotype.Service;

@Service
public interface JsonService {

	String prettyPrint(Object object);
}
