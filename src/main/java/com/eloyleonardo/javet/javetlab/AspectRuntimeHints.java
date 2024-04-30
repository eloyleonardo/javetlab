package com.eloyleonardo.javet.javetlab;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class AspectRuntimeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerType(com.caoccao.javet.interop.loader.JavetLibLoader.class, builder -> builder.withMembers(MemberCategory.values()));
        hints.reflection().registerType(com.caoccao.javet.interop.V8Host.class, builder -> builder.withMembers(MemberCategory.values()));
        hints.reflection().registerType(com.caoccao.javet.values.reference.IV8Module.class, builder -> builder.withMembers(MemberCategory.values()));
    }
}
