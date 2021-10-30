package com.personal.financial.resource;

import com.personal.financial.document.Document;
import com.personal.financial.mapper.Mapper;
import com.personal.financial.resource.request.Request;
import com.personal.financial.resource.response.Response;
import com.personal.financial.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

public class Resource<I extends Request, O extends Response, M extends Mapper, S extends Service> {

    private final M mapper;
    private final S service;

    public Resource(M mapper, S service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<O> save(@RequestBody I request, Principal principal) {
        Document document = mapper.toDocument(request);
        document.setUser(principal);
        Response response = mapper.toResponse(service.save(document));
        return (ResponseEntity<O>) ResponseEntity.ok(response);
    }

    @PostMapping("list")
    public ResponseEntity<?> save(@RequestBody List<I> request, Principal principal) {

        List<Response> response = request.stream().map(mapper::toDocument).map(document -> {
                    document.setUser(principal);
                    return service.save(document);
                }).map(mapper::toResponse)
                .collect(Collectors.toList());

        return  ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<O> get(@PathVariable("id") String id) {
        Document document = service.get(id);
        Response response = mapper.toResponse(document);
        return (ResponseEntity<O>) ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<O> update(I request) {
        Document update = service.update(this.mapper.toDocument(request));
        Response response = this.mapper.toResponse(update);
        return (ResponseEntity<O>) ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
