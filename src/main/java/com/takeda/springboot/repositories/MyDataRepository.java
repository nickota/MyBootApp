package com.takeda.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeda.springboot.MyData;

@Repository  //自動的に実装クラスが作成され、インスタンスがBeanとして登録される
//新たにリポジトリ作成する時の土台
//MyDataがエンティティ、そのプライマリーキーがLong型
public interface MyDataRepository extends JpaRepository<MyData, Long>{

}
