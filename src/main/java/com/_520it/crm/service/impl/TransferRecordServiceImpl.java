package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Client;
import com._520it.crm.domain.Employee;
import com._520it.crm.domain.TransferRecord;
import com._520it.crm.mapper.ClientMapper;
import com._520it.crm.mapper.TransferRecordMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.TransferRecordQuery;
import com._520it.crm.service.ITransferRecordService;

@Service
public class TransferRecordServiceImpl implements ITransferRecordService {

	@Autowired
	private TransferRecordMapper trMapper;
	
	@Autowired
	private ClientMapper  clientMapper;
	

	@Override
	public int deleteByPrimaryKey(Long id) {

		return trMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TransferRecord record) {
		
		Employee marketList = record.getMarketList();
		
		Client client = record.getClient();
		
		clientMapper.transferCustomer(client.getId(), marketList.getId());
		
		return trMapper.insert(record);
	}

	@Override
	public TransferRecord selectByPrimaryKey(Long id) {

		return trMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TransferRecord> selectAll() {

		return trMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(TransferRecord record) {

		return trMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryList(TransferRecordQuery qo) {
		Long totalCount = trMapper.queryPageCount(qo);
		if(totalCount==0){
			return new PageResult(totalCount, Collections.emptyList());
		}
		
		return new PageResult(totalCount, trMapper.queryPageData(qo));
	}

}
