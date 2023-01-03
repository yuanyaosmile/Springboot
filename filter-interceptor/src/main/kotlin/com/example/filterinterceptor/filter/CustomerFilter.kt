package com.example.filterinterceptor.filter

import org.apache.catalina.connector.RequestFacade
import java.io.IOException
import javax.servlet.*
import javax.servlet.annotation.WebFilter

@WebFilter(urlPatterns = ["/test/*"])
class RootCustomerFilter : Filter {
    @Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        println(servletRequest.localAddr)
        (servletRequest as RequestFacade).requestURI
        filterChain.doFilter(servletRequest, servletResponse)
    }

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {
        super.init(filterConfig)
    }

    override fun destroy() {
        super.destroy()
    }
}