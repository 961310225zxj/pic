package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.TransferRecord;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.TransferRecordQuery;

public interface ITransferRecordService {
	
	int deleteByPrimaryKey(Long id);

	int insert(TransferRecord record);

	TransferRecord selectByPrimaryKey(Long id);

	List<TransferRecord> selectAll();

	int updateByPrimaryKey(TransferRecord record);

	PageResult queryList(TransferRecordQuery qo);
	
}
