

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'SondeoPrecios.Usuario'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'SondeoPrecios.UsuarioRol'
grails.plugin.springsecurity.authority.className = 'SondeoPrecios.Rol'
grails.plugin.springsecurity.securityConfigType="InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/home/**',        access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/prueba/**',      access: ['ROLE_ADMIN']],
	[pattern: '/usuario/**',     access: ['ROLE_ADMIN']],
	[pattern: '/rol/**',     	 access: ['ROLE_ADMIN']],
	[pattern: '/rolusuario/**',  access: ['ROLE_ADMIN']],
	[pattern: '/admin/**',   	 access: ['ROLE_ADMIN']],
	[pattern: '/login/**',       access: ['permitAll']],
	[pattern: '/logout/**',      access: ['permitAll']],
	[pattern: '/dbconsole/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

