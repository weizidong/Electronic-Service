package com.wzd.dao;

import com.wzd.entity.Letter;
import com.wzd.entity.LetterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LetterDao {
    int countByExample(LetterExample example);

    int deleteByExample(LetterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Letter record);

    int insertSelective(Letter record);

    List<Letter> selectByExample(LetterExample example);

    Letter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Letter record, @Param("example") LetterExample example);

    int updateByExample(@Param("record") Letter record, @Param("example") LetterExample example);

    int updateByPrimaryKeySelective(Letter record);

    int updateByPrimaryKey(Letter record);
}