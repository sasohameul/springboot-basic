package com.simple.basic.memo.service;

import java.util.ArrayList;

import com.simple.basic.command.MemoVO;

public interface MemoService {

	public void MemoRegist(MemoVO vo);
	public ArrayList<MemoVO> getList();
	public void MemoDelete(int index);
	
	
}
