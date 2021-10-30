package com.personal.financial.mapper;


import com.personal.financial.document.Statement;
import com.personal.financial.resource.request.StatementRequest;
import com.personal.financial.resource.response.StatementResponse;

@org.mapstruct.Mapper(componentModel = "spring")
public interface StatementMapper extends Mapper<StatementRequest, Statement, StatementResponse> {
}
