package com.junjie.secdracore.annotations

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Auth(val needCode: Boolean = false)