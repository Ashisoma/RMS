package com.rms.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tenants", produces = MediaType.APPLICATION_JSON_VALUE)
public class TenantController {
}
