package com.personal.financial.mapper;

public interface Mapper <REQUEST,DOC, RESPONSE>{

    RESPONSE toResponse(DOC input);
    DOC toDocument(REQUEST input);
}
