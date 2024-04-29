package com.eloyleonardo.javet.javetlab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.interop.V8Host;
import com.caoccao.javet.interop.V8Runtime;

@RestController
@RequestMapping("/javet-v8")
public class JavetV8Controller {

    @GetMapping("/say-hello")
    public String sayHello() throws JavetException {
        try (V8Runtime v8Runtime = V8Host.getV8Instance().createV8Runtime()) {
            return v8Runtime.getExecutor("'Hello Javet'").executeString(); // Hello Javet
        }
    }

}
