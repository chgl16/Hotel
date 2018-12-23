package com.lusr.dao;

/**
 * Created by ownlove on 2018/12/19.
 */
public interface ITbMemberDao<T> extends IBaseDao<T>{
    void a();
}
/*
    public <T extends BaseModel> void insert(T baseModel) throws AppException;

	public <T extends BaseModel> void deleteByModel(T baseModel) throws AppException;

	public <T extends BaseModel> void update(T baseModel) throws AppException;

	public <T extends BaseModel> T searchById(String id, T baseModel) throws AppException;

	public <T extends BaseModel> Integer count(T baseModel) throws AppException;

	public <T extends BaseModel> List<T> search(T baseModel, Integer startIndex, Integer pageRows) throws AppException;

	public <T extends BaseModel> List<T> search(T baseModel) throws AppException;

 */