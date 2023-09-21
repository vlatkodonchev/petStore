package com.petStore.controller.mapper;

public interface GeneralMapper<Entity, Dto> {
    public Dto entityToDto(Entity entity);
    public Entity dtoToEntity(Dto dto);
}
