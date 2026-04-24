package com.zee.ebs.annotations;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ZeeComponent {
}
