package com.qa.HWAProject.utils;

public interface Mapper<E, D> {
	
	D mapToDTO(E entity);
	
	E mapFromDTO(D dto);

}
