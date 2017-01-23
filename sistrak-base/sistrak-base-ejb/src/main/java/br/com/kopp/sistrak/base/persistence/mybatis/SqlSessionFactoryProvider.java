package br.com.kopp.sistrak.base.persistence.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public interface SqlSessionFactoryProvider {

    SqlSessionFactory produceFactory() throws IOException;
    
}
