
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'rest.docs.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'rest.docs.UserRole'
grails.plugin.springsecurity.authority.className = 'rest.docs.Role'
grails.plugin.springsecurity.auth.ajaxLoginFormUrl = null

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/actuator/**', access: ['permitAll']]
]

grails.plugin.springsecurity.password.algorithm = 'bcrypt'
grails.plugin.springsecurity.password.bcrypt.logrounds = 10

grails.plugin.springsecurity.rest.token.storage.jwt.secret="12345678901234567890123456789012"  // has to be at least 256 bits long (32 chars)
grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 1800


grails.plugin.springsecurity.auth.loginFormUrl = '/'
grails.plugin.springsecurity.auth.useForward = true
grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = true
grails.plugin.springsecurity.rest.login.endpointUrl = '/api/login'
grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = false
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
    [pattern: '/login/**', access: ['permitAll']],

]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/login/authfail', filters: 'none'],
	[pattern: '/api/**', filters:  'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],
	[pattern: '/**', filters:  'JOINED_FILTERS,-restAuthenticationFilter,-restTokenValidationFilter,-restExceptionTranslationFilter,-restLogoutFilter,-rememberMeAuthenticationFilter']       // session-based chain
]