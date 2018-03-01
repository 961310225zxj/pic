package com._520it.crm.mapper;

import com._520it.crm.domain.Recognizee;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecognizeeMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Recognizee record);
    Recognizee selectByPrimaryKey(Long id);
    List<Recognizee> selectAll();
    int updateByPrimaryKey(Recognizee record);
	Long queryPageCount(QueryObject qo);
	List<Recognizee> queryPageData(QueryObject qo);
}