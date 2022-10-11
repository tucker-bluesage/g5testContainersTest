import rest.docs.RestAccessDeniedHandler
import rest.docs.RestAwareAuthenticationEntryPoint
import rest.docs.UserPasswordEncoderListener

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)

    securityContextRepository(org.springframework.security.web.context.NullSecurityContextRepository)

    authenticationEntryPoint(RestAwareAuthenticationEntryPoint) {
        messageSource = ref('messageSource')
        jsonTemplateService = ref('jsonTemplateService')
    }

    accessDeniedHandler(RestAccessDeniedHandler) {
        jsonTemplateService = ref('jsonTemplateService')
    }
}
