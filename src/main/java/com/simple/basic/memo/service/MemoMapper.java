package com.simple.basic.memo.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVO;

@Mapper
public interface MemoMapper {

	public void MemoRegist(MemoVO vo);
	public ArrayList<MemoVO> getList();
	public void MemoDelete(int index);
}
