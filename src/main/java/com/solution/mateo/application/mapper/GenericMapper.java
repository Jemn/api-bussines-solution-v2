package com.solution.mateo.application.mapper;

public interface GenericMapper<D, E> {
	
	public D toDto(E e);
	public E toEntity(D d);

}
