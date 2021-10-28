package com.personal.financial.mapper;

import com.personal.financial.document.Document;
import com.personal.financial.resource.request.Request;
import com.personal.financial.resource.response.Response;

public interface Mapper <I extends Request,D extends Document, O extends Response>{

    O toResponse(D input);
    D toDocument(I input);
}
