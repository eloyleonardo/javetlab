package com.eloyleonardo.javet.javetlab;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import com.google.common.reflect.ClassPath;

public class AspectRuntimeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerType(com.caoccao.javet.interop.loader.JavetLibLoader.class, builder -> builder.withMembers(MemberCategory.values()));
        hints.reflection().registerType(com.caoccao.javet.interop.V8Host.class, builder -> builder.withMembers(MemberCategory.values()));
        hints.reflection().registerType(com.caoccao.javet.values.reference.IV8Module.class, builder -> builder.withMembers(MemberCategory.values()));

        hints.reflection().registerTypeIfPresent(classLoader, "com.caoccao.javet.interop.loader.JavetLibLoader", MemberCategory.values());
        hints.reflection().registerTypeIfPresent(classLoader, "com.caoccao.javet.interop.NodeNative", MemberCategory.values());
        hints.reflection().registerTypeIfPresent(classLoader, "com.caoccao.javet.interop.V8Native", MemberCategory.values());

        Set<Class<?>> allJavetClasses = null;
        try {
            allJavetClasses = ClassPath.from(classLoader).getAllClasses().stream().filter(clazz -> clazz.getPackageName().startsWith("com.caoccao")).map(clazz -> clazz.load()).filter(c -> c != null).collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Class<?> clazz : allJavetClasses) {
            hints.reflection().registerType(clazz, builder -> builder.withMembers(MemberCategory.values()));
        }
    }
}
