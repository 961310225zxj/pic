package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.TransferRecord;
import com._520it.crm.query.TransferRecordQuery;

public interface TransferRecordMapper {
	
	int deleteByPrimaryKey(Long id);

	int insert(TransferRecord record);

	TransferRecord selectByPrimaryKey(Long id);

	List<TransferRecord> selectAll();

	int updateByPrimaryKey(TransferRecord record);

	Long queryPageCount(TransferRecordQuery qo);

	List<TransferRecord> queryPageData(TransferRecordQuery qo);
}